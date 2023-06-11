package com.shucai.simplefactory;

public class ComputerFactory {

    public static Compute create(String type) {
        Compute compute = null;
        switch (type) {
            case "lenovo":
                compute = new LenovoCompute();
                break;
            case "hp":
                compute = new HpComputer();
                break;
            default:
                System.out.println("error !!!");
                break;
        }
        return compute;
    }
}
