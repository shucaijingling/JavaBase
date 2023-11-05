package com.shucai.designpattern.proxy.staticproxy;

public class RentingHouseProxy implements IRentingHouse {

    private IRentingHouse rentingHouse;

    public RentingHouseProxy(IRentingHouse rentingHouse) {
        this.rentingHouse = rentingHouse;
    }

    @Override
    public void rentHouse() {
        rentingHouse.rentHouse();
        System.out.println("想不到吧， 我收了5个点的回扣...");
    }
}
