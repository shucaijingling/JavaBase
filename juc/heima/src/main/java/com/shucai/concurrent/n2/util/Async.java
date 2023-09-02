package com.shucai.concurrent.n2.util;

import lombok.extern.slf4j.Slf4j;

/**
 * 异步
 */
@Slf4j(topic = "Async")
public class Async {
    public static void main(String[] args) {

        new Thread(() ->{
            try {
                log.info("[sleep] start");
                long start = System.currentTimeMillis();
                Thread.sleep(1000);
                long end = System.currentTimeMillis();
                log.info("[sleep],cost={}ms", (end - start));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        log.info("do something...");

    }
}
