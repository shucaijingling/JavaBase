package com.atguigu.java.bank;

/**
 * @author: xu
 * @email: xxx@xx.com
 * @date: 2022/9/10 07:34
 */
public class Account {

    private double balance;

    public Account(double init_balance) {
        this.balance = init_balance;
    }

    public double getBalance() {
        return balance;
    }

    //存
    public void deposit(double amt) {
        if (amt < 0) {
            System.out.println("can not do it");
            return;
        }
        balance += amt;
        System.out.println("withdraw : " + amt);
        System.out.println("balance : " + balance);

    }

    //取
    public void withdraw(double amt) {
        if (balance < amt) {
            System.out.println("no money");
            return;
        }
        balance -= amt;
        System.out.println("get: " + amt);
        System.out.println("balance : " + balance);
    }
}
