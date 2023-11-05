package com.shucai.designpattern.proxy.dynamicproxy;

public class CglibProxy {

    public static void main(String[] args) {

        RentingHouseImpl rentingHouse = new RentingHouseImpl();

        IRentingHouse cglibProxy = (IRentingHouse) ProxyFactory.getInstance().getCglibProxy(rentingHouse);

        cglibProxy.rentHouse();
    }
}
