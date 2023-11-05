package com.shucai.designpattern.proxy.dynamicproxy;

public class JdkProxy {

    public static void main(String[] args) {

        IRentingHouse rentingHouse = new RentingHouseImpl();

        IRentingHouse jdkProxy = (IRentingHouse) ProxyFactory.getInstance().getJdkProxy(rentingHouse);

        jdkProxy.rentHouse();
    }
}
