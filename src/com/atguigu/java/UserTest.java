package com.atguigu.java;

public class UserTest {

    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.name);
        System.out.println(user.age);
        System.out.println(user.isMale);
        user.talk("中文");
    }
}
class User {

    //成员变量（属性）
    String name;
    int age;
    boolean isMale;

    void talk(String language) {//局部变量
        System.out.println("用"+ language + "交流");
    }
}
