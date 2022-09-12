package com.atguigu.exer3;

/**
 * @author: xu
 * @email: xxx@xx.com
 * @date: 2022/9/12 08:28
 */
public class Circle {
    private double radius;

    public Circle() {
        radius = 1;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea() {
        return radius * radius * Math.PI;
    }
}
