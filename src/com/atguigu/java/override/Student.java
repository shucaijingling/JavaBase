package com.atguigu.java.override;

public class Student extends Person {
    String major;

    public Student() {

    }

    public Student(String major) {
        this.major = major;
    }

    public void study() {
        System.out.println("学习,专业是：" + major);
    }

    @Override
    public void eat() {
        super.eat(); //实现父类方法
        System.out.println("重写方法：v2" ); //子类特有方法
    }
}
