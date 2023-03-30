package com.shucai.java;

public class PersonTest {
    public static void main(String[] args) {
        //创建对象，实例化类
        Person p1 = new Person();
        //调用结构：属性、方法
        p1.name = "Tom";
        p1.isMale = true;
        System.out.println(p1.name);
        p1.eat();
        p1.sleep();
        p1.talk("Chinese");
    }

}
class Person {
    //属性
    String name;
    int age = 1;
    boolean isMale;
    //方法
    public void eat(){
        System.out.println("吃");
    }
    public void sleep(){
        System.out.println("睡");
    }
    public void talk(String language){
        System.out.println("说" + language);
    }
}
