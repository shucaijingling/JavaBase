package com.atguigu.exer2;

/**
 * @author: xu
 * @email: xxx@xx.com
 * @date: 2022/9/12 08:16
 */
public class Kids extends ManKind{

    private int yearsOld;

    public Kids() {
    }


    public Kids(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void printAge() {
        System.out.println("I am " + yearsOld + "yearsOld.");
    }
}
