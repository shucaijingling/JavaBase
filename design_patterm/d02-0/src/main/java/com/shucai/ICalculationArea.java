package com.shucai;

public interface ICalculationArea {

    /**
     * 长方形
     * @param x
     * @param y
     * @return
     */
    double rectangle(double x, double y);

    /**
     * 三角形
     * @param x
     * @param y
     * @param z
     * @return
     */
    double triangle(double x, double y, double z);


    /**
     * 圆形
     * @param r
     * @return
     */
    double circular(double r);
}
