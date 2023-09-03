package com.shucai._abstract;

public class Sleep extends TestTemplate{
    @Override
    void running() throws InterruptedException {
        Thread.sleep(3 * 1000);
    }
}
