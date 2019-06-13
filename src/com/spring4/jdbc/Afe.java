package com.spring4.jdbc;

/**
 * @author mt
 * @title: Afe
 * @projectName Spring
 * @description: TODO yewenbo
 * @date 2019/6/12  15:42
 */
public class Afe {
    private  Integer id;
    private  String name;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
