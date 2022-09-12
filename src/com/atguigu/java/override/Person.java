package com.atguigu.java.override;

public class Person {
    String name;
    int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("吃饭");
    }

    public void walk(int distance) {
        System.out.println("走了" + distance + "公里");
    }
}
