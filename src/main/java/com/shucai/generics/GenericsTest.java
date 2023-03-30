package com.shucai.generics;

import java.util.Arrays;

public class GenericsTest {
    public static void main(String[] args) {
        Generics.method1("generics method!!");
        System.out.println(2);
        Integer[] i = new Integer[]{1, 2, 3, 4, 5, 6, 6, 2, 2, 2, 2, 2, 2, 2, 2, 99};
        //泛型指定一定要是引用类型的
        String s = Generics.method2(i);
        System.out.println(s);
    }
}

class Generics {
    public static <T> void method1(T t) {
        System.out.println("output:" + t);
    }

    public static <T> String method2(T[] t) {

        return Arrays.asList(t).toString();
    }

}
