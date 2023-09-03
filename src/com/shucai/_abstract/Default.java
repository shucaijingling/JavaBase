package com.shucai._abstract;

public class Default extends TestTemplate{

    @Override
    void running() {
        for (int i = 0, sum = 0; i < 1000*1000; i++) {
            sum += i;
        }
    }
}
