package com.shucai.java.bank;

/**
 * @author: xu
 * @email: xxx@xx.com
 * @date: 2022/9/10 07:34
 */
public class Bank {
    private Customer[] customers;

    private int numberOfCustomer;

    public Bank() {
        customers = new Customer[10];
    }

    public void addCustomer(String f, String l) {
        Customer customer = new Customer(f, l);
        customers[numberOfCustomer++] = customer;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < numberOfCustomer) {
        return customers[index];
        }

        System.out.println("input error");
        return null;
    }
}
