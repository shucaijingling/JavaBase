package com.atguigu.java.boygirl;

/**
 * @author: xu
 * @email: xxx@xx.com
 * @date: 2022/9/9 23:13
 */
public class Girl {

    private String name;

    private int age;

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String age) {
        this.name = age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public void marry(Boy boy) {
        System.out.println("jia" + boy.getName());
        boy.marry(this);
    }

    public int compare(Girl girl) {
        //正数：当前对象大  负数：当前对象小  0 当前对象和形参对象一样大
        return this.age - girl.age;
    }
}
