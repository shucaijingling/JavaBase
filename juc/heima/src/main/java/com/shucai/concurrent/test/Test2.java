package com.shucai.concurrent.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test2")
public class Test2 {
    public static void main(String[] args) {

        Runnable r = () -> log.info("running...");

        Thread t2 = new Thread(r, "t2");
        t2.start();

        Thread t3 = new Thread(() -> log.info("t3, running"), "t3");
        t3.start();
    }
}
