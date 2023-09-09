package com.shucai.concurrent.atomicarray;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArray1 {

    public static void main(String[] args) {

        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(intArray);

        assert atomicIntegerArray.addAndGet(1, 10) == 12;

        assert atomicIntegerArray.get(1) == 12;

    }
}
