package com.shucai._abstract;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {

        Default aDefault = new Default();
        aDefault.calculate();

        Sleep sleep = new Sleep();
        sleep.calculate();
    }
}
