package com.shucai.interface2;

public class InterfaceTest2 {
    public static void main(String[] args) {
        Computer c = new Computer();
        //1、创建了接口的非匿名实现类的非匿名对象
        Flash f = new Flash();
        System.out.println(1);
        c.transferData(f);

        //2、创建了接口的非匿名实现类的匿名对象
        System.out.println(2);
        c.transferData(new Printer());

        //3、创建了接口的匿名实现类的非匿名对象
        System.out.println(3);
        USB u = new USB() {
            @Override
            public void start() {
                System.out.println("usb的匿名实现类  start");
            }

            @Override
            public void stop() {
                System.out.println("usb的匿名实现类   stop");
            }
        };
        c.transferData(u);

        //4、创建了接口的匿名实现类的匿名对象
        System.out.println(4);
        c.transferData(new USB() {
            @Override
            public void start() {
                System.out.println("usb的匿名实现类的匿名对象   start");
            }

            @Override
            public void stop() {
                System.out.println("usb的匿名实现类的匿名对象   stop");
            }
        });
    }



}

interface USB {
    void start();
    void stop();
}
class Computer {
    //传输数据
    public void transferData(USB usb) {
        usb.start();
        System.out.println("transfer data on Computer");
        usb.stop();
    }
}

class Flash implements USB {

    @Override
    public void start() {
        System.out.println("flash start");
    }

    @Override
    public void stop() {
        System.out.println("flash stop");
    }
}

class Printer implements USB {
    @Override
    public void start() {
        System.out.println("printer start");
    }

    @Override
    public void stop() {
        System.out.println("printer stop");
    }
}
