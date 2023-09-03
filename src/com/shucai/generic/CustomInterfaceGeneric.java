package com.shucai.generic;

public class CustomInterfaceGeneric {
    public static void main(String[] args) {

    }
}
interface IUsb<U, R> {
    R get(U u);

    void hi(R r);

    void run(R r1, R r2, U u1, U u2);

    default R method(U u) {
        return null;
    }
}
