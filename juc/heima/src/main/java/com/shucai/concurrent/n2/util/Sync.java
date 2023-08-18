package com.shucai.concurrent.n2.util;


import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 同步等待
 */
@Slf4j(topic = "c.Sync")
public class Sync {


    public static void main(String[] args) throws IOException, InterruptedException {
        fileRead();

        log.debug("do something...");
    }

    private static void fileRead() throws IOException, InterruptedException {
        log.debug("[sleep],start...");
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        long cost = end - start;
        log.debug("[sleep],cost:{}ms", cost);
    }
}
