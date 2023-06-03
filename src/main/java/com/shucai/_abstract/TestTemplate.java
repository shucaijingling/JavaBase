package com.shucai._abstract;

public abstract class TestTemplate {

    abstract void running() throws InterruptedException;

    public void calculate() throws InterruptedException {
        long start = System.currentTimeMillis();
        running();
        long end = System.currentTimeMillis();
        System.out.println("cost: " + (end - start));
    }
}
