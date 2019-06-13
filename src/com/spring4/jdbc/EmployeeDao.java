package com.spring4.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author mt
 * @title: EmployeeDao
 * @projectName Spring
 * @description: TODO yewenbo
 * @date 2019/6/12  17:51
 */
@Repository
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee get(Integer id){
            String sql = "SELECT id,user_name userName,password FROM user_t WHERE id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
            Employee employee = jdbcTemplate.queryForObject(sql,rowMapper,id);
            return employee;
    }
}
