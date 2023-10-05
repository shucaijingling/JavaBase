package com.xuyi.springframework.util;


public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;

        try {
            cl = Thread.currentThread().getContextClassLoader();
        }catch (Throwable ex) {
            //
        }
        if (null == cl) {
            cl = ClassUtils.class.getClassLoader();
        }

        return cl;
    }
}
