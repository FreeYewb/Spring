package com.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: SatticCarFactroy
 * @Description: TODO(静态工厂方法：直接调用某一个类的静态方法就可以返回bean的实例)
 * @author yewenbo
 * @date 2019年5月27日 上午12:28:07
 *
 */
public class StaticCarFactroy {

    private static Map<String, Car> cars = new HashMap<String, Car>();
    private static Map<Integer, Car> cars1 = new HashMap<Integer, Car>();
    static {
        cars.put("audi", new Car("audi", 300000));
        cars.put("fute", new Car("fute", 400000));
        cars1.put(50, new Car("xfl", 500000));
    }

    // 静态工厂方法 一定要有static，不然不走此方法
    public static Car getCar(String name) {
        return cars.get(name);
    }

    // 静态工厂方法
    public static Car getprice(int price) {
        return cars1.get(price);
    }

}
