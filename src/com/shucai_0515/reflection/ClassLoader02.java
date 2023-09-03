package com.shucai_0515.reflection;

/**
 * 类加载，链接-准备阶段
 */
public class ClassLoader02 {
    public static void main(String[] args) {

    }
}
class A {
    //n1 是属性变量，不是静态变量，因此在准备阶段是不分配内存的
    //n2 是静态变量，分配内存，默认初始化0，到初始化阶段才是20
    //n3 是static final 是常量，一旦赋值就不变 n3 = 30
    public int n1 = 10;
    public static int n2 = 20;

    public static final int n3 = 30;
}
