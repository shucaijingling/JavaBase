package com.shucai.design.impl;

import com.shucai.design.IVideoUserService;

public class OrdinaryVideoUserService implements IVideoUserService {
    @Override
    public void definition() {
        System.out.println("普通用户，视频720超清");
    }

    @Override
    public void advertisement() {
        System.out.println("普通用户，广告30秒");
    }
}
