package com.atguigu.java.boygirl;

/**
 * @author: xu
 * @email: xxx@xx.com
 * @date: 2022/9/9 23:46
 */
public class BoyGirlTest {

    public static void main(String[] args) {
        Boy boy = new Boy("罗密欧",21);
        Girl girl = new Girl("朱丽叶",22);
        Girl girl2 = new Girl("朱丽叶",26);

        System.out.println("boy name：" + boy.getName());
        System.out.println("boy age：" + boy.getAge());
        System.out.println("1======================================");
        System.out.println("girl name:" + girl.getName());
        System.out.println("girl age:" + girl.getAge());
        boy.marry(girl);
        boy.shout();
        System.out.println("2=============================================");
        girl.marry(boy);
        System.out.println(girl.compare(girl2));
        String compare = girl.compare(girl2) > 0 ? "big" : "small";
        System.out.println(compare);
    }

}
