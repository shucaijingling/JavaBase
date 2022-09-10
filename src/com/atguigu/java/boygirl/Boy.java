package com.atguigu.java.boygirl;

/**
 * @author: xu
 * @email: xxx@xx.com
 * @date: 2022/9/9 23:12
 */
public class Boy {

    private String name;

    private int age;

    public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
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


    public void marry(Girl girl) {
        System.out.println("qu" + girl.getName());
    }

    public void shout() {
        if (age >= 22) {
            System.out.println("可以登记结婚");
        }else {
            System.out.println("先谈谈恋爱");
        }
    }
}
