package com.atguigu.lambda;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest1 {
    //语法格式一： 无参，无返回值
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("语法格式一： 无参，无返回值");
            }
        };
        r1.run();

        Runnable r2 = () -> System.out.println("语法格式一： 无参，无返回值");
        r2.run();
    }

    //语法格式二： 需要一个参数，但没有返回值
    @Test
    public void test2() {
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("语法格式二： 需要一个参数，但没有返回值");

        Consumer<String> con2 = (String s) -> System.out.println(s);
        con2.accept("语法格式二： 需要一个参数，但没有返回值");
        //方法引用
        Consumer<String> con3 = System.out::println;
        con3.accept("语法格式二： 需要一个参数，但没有返回值");
    }

    //语法格式三： 数据类型可以省略，因为可由编译器推断得出，称为"类型维护"
    @Test
    public void test3() {
        Consumer<String> con2 = (s) -> System.out.println(s);
        con2.accept("语法格式三： 数据类型可以省略，因为可由编译器推断得出，称为\"类型维护\"");
    }

    //语法格式四： lambda若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test4() {
        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("语法格式四： lambda若只需要一个参数时，参数的小括号可以省略");
    }
    //语法格式五： lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12,33));

        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(22,33));;
    }

    //当lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void test6() {
        Comparator<Integer> com1 = (o1,o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(22,33));

        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com1.compare(55,33));
    }
}
