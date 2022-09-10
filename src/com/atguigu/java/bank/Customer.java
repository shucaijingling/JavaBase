package com.atguigu.java.bank;

/**
 * @author: xu
 * @email: xxx@xx.com
 * @date: 2022/9/10 07:34
 */
public class Customer {

    private String firstName;

    private String lastName;

    private Account account;

    public Customer(String f, String l) {
        this.firstName = f;
        this.lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account acct) {
        this.account = acct;
    }



}
