package com.shucai.interface1;

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);
//        Flyable.MAX_SPEED = 2;
    }
}

interface Flyable {
    //全局常量
    public static final int MAX_SPEED = 7900; //第一宇宙速度

    int MIN_SPEED = 1;
}
