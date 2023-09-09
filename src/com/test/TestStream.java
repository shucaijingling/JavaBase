package com.test;

import lombok.NonNull;

import java.util.stream.IntStream;

public class TestStream {
    static class test1 {
        @NonNull
        private String name;

        public test1(@NonNull String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "test1{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        int[] ints = IntStream.range(1, 11).toArray();
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        int[] ints2 = IntStream.rangeClosed(1, 11).toArray();
        for (int i : ints2) {
            System.out.println(i);
        }

//        test1 test1 = new test1(null);
//        System.out.println(test1);
    }
}
