package com.shucai_0515.reflection;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Arrays;

public class Homework02 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        long count = Arrays.stream(declaredConstructors).count();
        System.out.println(count);
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        //public java.io.File(java.lang.String)
        Constructor<?> constructor = cls.getConstructor(String.class);
        String path = "/Users/x/Documents/mine/CODE/JavaBase/mynew.txt";
        Object o = constructor.newInstance(path);
        boolean newFile = ((File) o).createNewFile();
        System.out.println("success");
    }
}
