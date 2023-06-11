package com.shucai.simplefactory;

public class SimpleFactoryTest {
    public static void main(String[] args) {

        ComputerFactory computerFactory = new ComputerFactory();
        Compute hp = computerFactory.create("hp");
        hp.start();


        System.out.println("=========================================");

        Compute lenovo = computerFactory.create("lenovo");
        lenovo.start();

    }
}
