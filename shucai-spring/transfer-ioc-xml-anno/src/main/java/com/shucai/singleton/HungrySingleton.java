package com.shucai.singleton;

/**
 * 饿汉单例
 */
public class HungrySingleton {

    //私有化构造器
    private HungrySingleton() {

    }

    //static final 修饰， 加载时就创建对象
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    //使用静态方法返回实例
    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
