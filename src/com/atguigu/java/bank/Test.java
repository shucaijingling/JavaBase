package com.atguigu.java.bank;

/**
 * @author: xu
 * @email: xxx@xx.com
 * @date: 2022/9/10 09:16
 */
public class Test {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addCustomer("qw","ert");

        System.out.println(bank.getCustomer(0).getFirstName());
        System.out.println(bank.getCustomer(0).getLastName());

        bank.getCustomer(0).setAccount(new Account(10000));
        bank.getCustomer(0).getAccount().deposit(1000);
        bank.getCustomer(0).getAccount().withdraw(9000);
        bank.getCustomer(0).getAccount().deposit(20000);
        bank.getCustomer(0).getAccount().deposit(-2);
        bank.getCustomer(0).getAccount().withdraw(90000);

        bank.addCustomer("www","ssss");
        System.out.println(bank.getNumberOfCustomer());

    }
}
