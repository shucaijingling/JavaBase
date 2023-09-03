package com.shucai.exer;

public class Person {

    private int age;


    public void setAge(int i) {
        if (i > 0 && i < 130) {
            this.age = i;
        }else {
            System.out.println("妖怪？");
            System.exit(0);
        }
    }
    public int getAge() {
        return age;
    }
}
