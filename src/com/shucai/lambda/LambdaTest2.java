package com.shucai.lambda;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaTest2 {
    @Test
    public void test1() {
        happyTime(200, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("buy CPU use " + aDouble);
            }
        });

        happyTime(2000, m -> System.out.println("use " + m));
    }
    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("111","222","123","12414","500");
        List<String> res = filterList(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("2");
            }
        });
        System.out.println(res);
        //lambda表达式
        filterList(list, s -> s.contains("2"));
    }

    public List<String> filterList(List<String> list, Predicate<String> pre) {
        ArrayList<String> res = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                res.add(s);
            }
        }
        return res;
    }
}
