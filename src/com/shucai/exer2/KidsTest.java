package com.shucai.exer2;

/**
 * @author: xu
 * @email: xxx@xx.com
 * @date: 2022/9/12 08:24
 */
public class KidsTest {
    public static void main(String[] args) {
        Kids kids = new Kids(12);
        kids.printAge();

        kids.setSex(1);
        kids.setSalary(0);
        kids.manOrWoman();
        kids.employeed();

    }
}
