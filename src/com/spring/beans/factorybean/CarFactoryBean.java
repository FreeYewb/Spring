package com.spring.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 
 * @ClassName: CarFactoryBean
 * @Description: TODO(用到IOC里面的其他bean，用FactoryBean是最合适的) 自定义的FactoryBean 需要实现
 *               FactoryBean接口
 * @author yewenbo
 * @date 2019年5月27日 下午11:17:18
 *
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;
    private double price;
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // 返回bean的对象
    @Override
    public Car getObject() throws Exception {
        // TODO Auto-generated method stub
        return new Car(brand, price);
    }

    // 返回的bean的类型 
    @Override
    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return null;
    }

    // 返回的bean是不是单例
    @Override
    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return true;
    }

}
