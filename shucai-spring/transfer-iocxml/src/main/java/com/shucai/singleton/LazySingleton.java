package com.shucai.singleton;

/**
 * 懒汉单例
 */
public class LazySingleton {

    //设置私有静态属性、
    private static LazySingleton instance;

    //私有化构造器
    private LazySingleton() {

    }

    //static修饰，用synchronized保证同步
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance =  new LazySingleton();
        }
        return instance;
    }
}
