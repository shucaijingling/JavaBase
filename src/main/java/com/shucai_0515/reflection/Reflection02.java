package main.java.com.shucai_0515.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 直接调用和反射调用性能比较
 */
@SuppressWarnings({"all"})
public class Reflection02 {

    public static void main(String[] args) throws Exception{

        m1();
        m2();
        m3();
    }
    //直接调用
    public static void m1() {
        com.shucai_0515.reflection.Cat c = new com.shucai_0515.reflection.Cat();
        long strat = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            c.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("m1耗时： " + (end - strat));
    }
    //反射调用
    public static void m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> cls = Class.forName("com.shucai_0515.reflection.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("m2耗时 ： " + (end - start));
    }

    //反射优化，取消访问检查
    public static void m3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> cls = Class.forName("com.shucai_0515.reflection.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        hi.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("m2耗时 ： " + (end - start));
    }

}
