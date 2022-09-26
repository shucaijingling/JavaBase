package com.atguigu.factory;

/**
 * 工厂模式
 */
public class FactoryTest {
    public static void main(String[] args) {
        AudiFactory audiFactory = new AudiFactory();
        Audi audi = audiFactory.getCar();
        audi.run();
        BYDFactory BYDFactory = new BYDFactory();
        BYD byd = BYDFactory.getCar();
        byd.run();
    }
}
//car接口
interface Car {
    void run();
}
//实现car
class Audi implements Car {
    @Override
    public void run() {
        System.out.println(1);
        System.out.println("Audi");
    }
}
class BYD implements Car {
    @Override
    public void run() {
        System.out.println(2);
        System.out.println("BYD");
    }
}
//工厂接口
interface CarFactory {
    Car getCar();
}
//工厂类，实现工厂
//要什么对象就创建什么工厂类去实现工厂接口生产对象
//实现开闭原则
class AudiFactory implements CarFactory {
    @Override
    public Audi getCar() {
        return new Audi();
    }
}

class BYDFactory implements CarFactory {

    @Override
    public BYD getCar() {
        return new BYD();
    }
}


