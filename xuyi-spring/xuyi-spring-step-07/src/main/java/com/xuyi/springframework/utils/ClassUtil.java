package com.xuyi.springframework.utils;

public class ClassUtil {

    public static ClassLoader getDefaultClassLoader() {

        ClassLoader cl = null;

        try {
            cl = Thread.currentThread().getContextClassLoader();
        }catch (Throwable ex) {
            //

        }
        if (null == cl) {
            cl = ClassUtil.class.getClassLoader();
        }

        return cl;
    }
}
