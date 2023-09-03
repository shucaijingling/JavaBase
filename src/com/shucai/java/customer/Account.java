package com.shucai.java.customer;

/**
 * @author: xu
 * @email: xxx@xx.com
 * @date: 2022/9/10 00:05
 */
public class Account {

    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    //取钱
    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("no money");
            return;
        }
        balance -= amount;
        System.out.println("成功取出：" + amount);
    }

    //存钱
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("can not deposit");
        }
        balance += amount;
        System.out.println("success deposit money:" + amount);
    }
}
