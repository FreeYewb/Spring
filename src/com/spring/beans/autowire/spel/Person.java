package com.spring.beans.autowire.spel;



public class Person {
    private String name;
    private String city;// 引用address bean的city属性
    private String info;// 根据car的price确定info，car的price>=300000：金额，否则为白领
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", city=" + city + ", info=" + info + ", car=" + car + "]";
    }

}
