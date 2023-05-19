package com.shucai_0515.reflection.proxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        ClothFactory clothFactory = new NickFactory();
        ProxyFactory proxyFactory = new ProxyFactory(clothFactory);
        proxyFactory.produceCloth();
        //produce Nick > ...
        //proxy do something
    }
}


interface ClothFactory {
    void produceCloth();
}

//代理类
class ProxyFactory implements ClothFactory{

    private ClothFactory clothFactory;

    public ProxyFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("do before " + clothFactory.getClass().getSimpleName());
        clothFactory.produceCloth();
        System.out.println("proxy do something");
    }
}

//被代理类
class NickFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("produce Nick > ...");
    }
}