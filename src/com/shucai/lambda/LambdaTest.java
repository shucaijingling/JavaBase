package com.shucai.lambda;

import org.testng.annotations.Test;

import java.util.Comparator;

public class LambdaTest {

    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };

        r1.run();

        //方法引用
        Runnable r2 = () -> System.out.println("Hello World by Lambda");
        r2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        //Lambda 1
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1, o2);
        int compare2 = com2.compare(21,12);
        System.out.println(compare2);

        //Lambda 2
        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com3.compare(12,21);
        System.out.println(compare3);
     }

}
