package com.shucai_0515.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> cls = Class.forName("com.shucai_0515.reflection.PrivateTest");
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        Object o = cls.newInstance();
        name.set(o, "new value");
        Method getName = cls.getMethod("getName");
        Object invoke = getName.invoke(o);
        System.out.println(invoke);
    }
}

class PrivateTest {
    private String name = "hellokitty";
    public String getName() {
        return name;
    }
}