package com.atguigu.generics2;

import org.testng.annotations.Test;

import java.util.List;

public class DAOTest {
    @Test
    public void test1() {
        CustomerDAO c = new CustomerDAO();
        c.add(new Customer());
        boolean remove = c.remove(1);
        List<Customer> list = c.list(1);
        Customer one = c.getOne(1);

    }
    @Test
    public void test2StudentDAO() {
        StudentDAO s = new StudentDAO();
        List<Student> list = s.list(1);
        s.add(new Student());
        Student one = s.getOne(1);
        s.update(1,new Student());
        boolean remove = s.remove(1);
    }
}
