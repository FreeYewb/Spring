package com.spring4.jdbc;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * 
* @Title: testDataSource  
* @Description: TODO(SPRING JDBC)  
* @param @throws SQLException    参数  
* @return void    返回类型  
* @throws
 */
public class JDBCTest {

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	private EmployeeDao employeeDao;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext4.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		employeeDao = ctx.getBean(EmployeeDao.class);
		namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
	}

	/**
	 * 使用具名参数时，可以使用update(String sql, paramSource) 方法进行更新操作
	 * 1.SQL 语句中的参数名和类的属性一致
	 * 2.使用SqlParameterSource 的 BeanPropertySqlParameterSource 实现类作为参数
	 */
	@Test
	public void testNamedParameterJdbcTemplate2(){
		String sql = "insert into user_t(user_name,password,afe) values(:userName,:password,:afe)";
		Employee employee = new Employee();
		employee.setUserName("sqw");
		employee.setPassword("ewew");
		employee.setAfe(34);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
		namedParameterJdbcTemplate.update(sql,paramSource);

	}

	/**
	 * 可以为参数起名字
	 * 1好处：若有多个参数，则不用再去对应位置，直接对应参数名，便于维护
	 * 2缺点：较为麻烦
	 */
	@Test
	public void testNamedParameterJdbcTemplate(){
		String sql = "insert into user_t(user_name,password,afe) values(:user_name,:password,:afe)";
		Map<String,Object> parpMap = new HashMap<>();
		parpMap.put("user_name","ss");
		parpMap.put("password","qwe");
		parpMap.put("afe",5);

		namedParameterJdbcTemplate.update(sql,parpMap);
	}

	@Test
	public void testEmployeeDao(){
		System.out.println(employeeDao.get(1));
	}

	@Test
	public void testQueryForObject2(){
		String sql = "SELECT count(id) from user_t";
		long count = jdbcTemplate.queryForObject(sql,Long.class);

		System.out.println(count);
	}

	/**
	 * 查看实体类的集合
	 * 使用 queryForObject(String sql, Class<Long> requiredType)
	 */
	@Test
	public void testQueryForlist(){
		String sql = "SELECT id,user_name userName,password FROM user_t WHERE id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List<Employee> employees = jdbcTemplate.query(sql,rowMapper,1);

		System.out.println(employees);
	}
	/**
	 * 从数据库中获取一条记录，实际得到对应的一个对象
	 * 注意不是调用 queryForObject(String sql, Class<Employee> requiredType, Object... args) 方法!
	 *  而需要调用 queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args)
	 *  1. 其中的 RowMapper 指定如何去映射结果集的行, 常用的实现类为 BeanPropertyRowMapper
	 *  2. 使用 SQL 中列的别名完成列名和类的属性名的映射. 例如 user_name userName
	 *  3. 不支持级联属性. JdbcTemplate 到底是一个 JDBC 的小工具, 而不是 ORM 框架
	 */
	@Test
	public void testQueryForObject(){
	String sql = "SELECT id,user_name userName,password FROM user_t WHERE id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
	Employee employee = jdbcTemplate.queryForObject(sql,rowMapper,1);
	System.out.println(employee);
	}

	/**
	 *  执行批量更新：执行INSERT,UPDATE,DELETE
	 *  最后一个参数是Object[] 的list类型，因为修改一条记录需要一个Object的数组，那么多条不就需要多贵Object的数组
	 */
	//@Test
	public void testBatchUpdate(){
		String sql = "INSERT INTO USER_T(user_name,password,afe)VALUES(?,?,?)";
		List<Object[]> list = new ArrayList<>();

		list.add(new Object[]{"a","a",3});
		list.add(new Object[]{"b","b",4});
		list.add(new Object[]{"c","c",5});
		list.add(new Object[]{"d","d",6});
		list.add(new Object[]{"e","e",7});

		jdbcTemplate.batchUpdate(sql,list);
	}

	/**
	 * 执行INSERT,UPDATE,DELETE
	 */
	@Test
	public void testUpdate() throws DataAccessException {
		String sql = "UPDATE user_t SET afe = ? WHERE ID = ?";
		
		jdbcTemplate.update(sql,7,1);
	}
	
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}





