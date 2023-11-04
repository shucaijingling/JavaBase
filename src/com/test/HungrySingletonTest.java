package com.test;

import com.test.singleton.Hungry;

public class HungrySingletonTest {


    public static void main(String[] args) {

        Hungry h1 = Hungry.getInstance();
        System.out.println(h1);

        Hungry h2 = Hungry.getInstance();
        System.out.println(h2);

        for (int i = 0; i < 10; i++) {
            Hungry instance = Hungry.getInstance();
            System.out.println(instance);
        }
    }
}
