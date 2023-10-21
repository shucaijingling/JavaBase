package com.shucai.design.impl;

import com.shucai.design.IVideoUserService;

public class GuestVideoUserService implements IVideoUserService {
    @Override
    public void definition() {
        System.out.println("访客用户，视频480P高清");
    }

    @Override
    public void advertisement() {
        System.out.println("访客用户，广告60秒");
    }
}
