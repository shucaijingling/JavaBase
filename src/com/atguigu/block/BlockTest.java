package com.atguigu.block;

public class BlockTest {

    public static void main(String[] args) {
        String desc = Person.desc;
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();

    }
}

class Person {
    String name;
    int age;
    static String desc = "我是一个人";

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //静态代码块
    static {
        System.out.println("hello,static block");
    }
    //代码块
    {
        System.out.println("hello,block");
    }

    //方法
    public void eat() {
        System.out.println("吃饭");
    }

    public static void info() {
        System.out.println("static method info");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}