package com.spring4.jdbc;

/**
 * @author mt
 * @title: Employee
 * @projectName Spring
 * @description: TODO yewenbo
 * @date 2019/6/12  15:41
 */
public class Employee {
        private Integer id;
        private String userName;
        private String password;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", afe=" + afe +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Afe getAfe() {
        return afe;
    }

    public void setAfe(Afe afe) {
        this.afe = afe;
    }

    private  Afe afe;


}
