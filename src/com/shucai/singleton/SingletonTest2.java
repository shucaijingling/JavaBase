package com.shucai.singleton;

public class SingletonTest2 {

    public static void main(String[] args) {
        Order o1 = Order.getInstance();
        Order o2 = Order.getInstance();
        System.out.println(o1);
        System.out.println(o2);
    }
}

class Order {
    //1.私有化构造器
    private Order() {

    }
    //2.创建对象，不进行初始化
    private static Order instance = null;

    //3.创建公共方法获取对象，为空就创建，不为空就返回当前实例
    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }
}
