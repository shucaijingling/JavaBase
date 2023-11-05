package com.shucai.designpattern.proxy.dynamicproxy;

public class RentingHouseImpl implements IRentingHouse{
    @Override
    public void rentHouse() {
        System.out.println("我要租个一室一厅的房子");
    }
}
