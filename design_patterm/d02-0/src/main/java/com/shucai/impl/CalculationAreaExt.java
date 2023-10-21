package com.shucai.impl;

public class CalculationAreaExt extends CalculationArea{

    public static final double π = 3.1415926535D;

    @Override
    public double circular(double r) {
        return π * r * r;
    }
}
