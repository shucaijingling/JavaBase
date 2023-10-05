package com.shucai;

/**
 * 线程安全的单例模式
 * dcl singleton  = double check lock
 *
 * 并发情况下 防止线程不安全  和  提高执行效率
 */
public class DCL_Singleton {

    private static volatile DCL_Singleton instance;

    private DCL_Singleton() {

    }

    public static DCL_Singleton getInstance() {
        if (null != instance) return instance;

        synchronized (DCL_Singleton.class) {
            if (null == instance) {
                instance = new DCL_Singleton();
            }
        }
        return instance;
    }
}
