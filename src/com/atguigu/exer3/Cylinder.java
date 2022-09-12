package com.atguigu.exer3;

/** 圆柱
 * @author: xu
 * @email: xxx@xx.com
 * @date: 2022/9/12 08:30
 */
public class Cylinder extends Circle{
    private double length;

    public Cylinder() {
        length = 1;
    }

    public Cylinder(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findVolume() {
        return findArea() * length;
    }
}
