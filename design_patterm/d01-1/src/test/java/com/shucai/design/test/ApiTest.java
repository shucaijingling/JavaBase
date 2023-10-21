package com.shucai.design.test;

import com.shucai.design.IVideoUserService;
import com.shucai.design.impl.GuestVideoUserService;
import com.shucai.design.impl.OrdinaryVideoUserService;
import com.shucai.design.impl.VipVideoUserService;

public class ApiTest {

    public static void main(String[] args) {
        IVideoUserService service1 = new GuestVideoUserService();
        IVideoUserService service2 = new OrdinaryVideoUserService();
        IVideoUserService service3 = new VipVideoUserService();
        service1.definition();
        service2.definition();
        service3.definition();
        service1.advertisement();
        service2.advertisement();
        service3.advertisement();
    }
}
