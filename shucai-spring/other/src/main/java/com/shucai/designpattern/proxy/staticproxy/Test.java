package com.shucai.designpattern.proxy.staticproxy;

public class Test {


    public static void main(String[] args) {

        IRentingHouse rentingHouse = new RentingHouseImpl();
        rentingHouse.rentHouse();

        RentingHouseProxy rentingHouseProxy = new RentingHouseProxy(rentingHouse);
        rentingHouseProxy.rentHouse();
    }
}
