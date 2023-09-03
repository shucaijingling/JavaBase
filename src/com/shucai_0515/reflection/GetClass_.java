package com.shucai_0515.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GetClass_ {
    public static void main(String[] args) throws Exception{

        //1.通过全路径获取
        String classAllPath = "com.shucai_0515.reflection.Cat";
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);

        //2.通过 类.class
        Class<Cat> cls2 = Cat.class;
        System.out.println(cls2);

        //3.对象.getClass
        Cat cat = new Cat();
        Class<? extends Cat> cls3 = cat.getClass();
        System.out.println(cls3);

        //4.类加载器获取
        ClassLoader classLoader = cat.getClass().getClassLoader();
        Class<?> carClass = classLoader.loadClass("com.shucai_0515.reflection.Car");
        Method method = carClass.getMethod("print");
        Object o = carClass.newInstance();
        Field brand = carClass.getDeclaredField("brand");
        brand.setAccessible(true);
        brand.set(o, "宝宝巴士");
        Field price = carClass.getDeclaredField("price");
        price.setAccessible(true);
        price.set(o,1000);
        method.invoke(o);

        //5.基本数据类型
        Class<Integer> cls5 = int.class;
        System.out.println(cls5);

        //6.基本数据类型对应的包装类
        Class<Integer> cls6 = Integer.TYPE;
        System.out.println(cls6);
    }
}
