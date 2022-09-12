package com.atguigu.exer2;

/**
 * @author: xu
 * @email: xxx@xx.com
 * @date: 2022/9/12 08:11
 */
public class ManKind {
    private int sex;
    private int salary;

    public ManKind() {
    }

    public ManKind(int sex, int salary) {
        this.sex = sex;
        this.salary = salary;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void manOrWoman() {
        if (sex == 1) {
            System.out.println("man");
        } else if (sex == 0) {
            System.out.println("woman");
        }
    }

    public void employeed() {
//        if (salary == 0) {
//            System.out.println("no job");
//        } else  {
//            System.out.println("job");
//        }
        String s = salary == 0 ? "no job" : "job";
        System.out.println(s);
    }
}
