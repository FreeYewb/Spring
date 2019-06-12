package com.spring4.jdbc;


import java.sql.SQLException;

import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
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
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext4.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	}
	@Test
	public void testUpdate() {
		String sql = "UPDATE user_t SET afe = ? WHERE ID = ?";
		
		jdbcTemplate.update(sql,8,1);
	}
	
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}





