package com.shucai.java.customer;

/**
 * @author: xu
 * @email: xxx@xx.com
 * @date: 2022/9/10 00:26
 */
public class CustomerTest {

    public static void main(String[] args) {
        Customer customer = new Customer("鲁班", "七号");
        Account account = new Account(1,1000,0.02);
        customer.setAccount(account);

        customer.getAccount().deposit(1000);
        customer.getAccount().withdraw(2000);
        customer.getAccount().withdraw(20);
    }
}
