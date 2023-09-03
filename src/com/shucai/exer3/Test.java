package com.shucai.exer3;

/**
 * @author: xu
 * @email: xxx@xx.com
 * @date: 2022/9/12 08:32
 */
public class Test {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        cylinder.setRadius(2.1);
        cylinder.setLength(3.4);
        double volume = cylinder.findVolume();
        System.out.println(cylinder.findArea());
        System.out.println(volume);
    }
}
