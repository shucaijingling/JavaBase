package com.atguigu.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 整个应用系统中，只能存在一个对象实例
 */
public class SingletonTest1 {
    public static void main(String[] args) {
//        Bank bank1 = new Bank();
//        Bank bank2 = new Bank();
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1);
        System.out.println(bank2);

        Class<Bank> bankClass = Bank.class;
        System.out.println(bankClass);
        Constructor<?>[] constructors = bankClass.getConstructors();
        System.out.println(Arrays.toString(constructors));

//        for (Field declaredField : bankClass.getDeclaredFields()) {
//            declaredField.
//        }

    }
}

/**
 * 饿汉式
 */
class  Bank {

    //1.构造私有化
    private Bank() {

    }
    //2.内部创建对象
    private static Bank instance = new Bank();

    //3.提供公共方法获取对象
    public static Bank getInstance() {
        return instance;
    }
}