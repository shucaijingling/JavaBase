package com.shucai.designpattern.proxy.staticproxy;

public class RentingHouseImpl implements IRentingHouse{
    @Override
    public void rentHouse() {
        System.out.println("我要租一个一室一厅的房子");
    }
}
