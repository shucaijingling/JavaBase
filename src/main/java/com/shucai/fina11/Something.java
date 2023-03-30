package com.shucai.fina11;

public class Something {

    public int addOne(final int x) {
//        return x++;    //编译报错
        return x+1;   //可以实现
    }

    public static void main(String[] args) {
        Something someThing = new Something();
        int i = someThing.addOne(1);
        System.out.println(i);// 2
    }
}
