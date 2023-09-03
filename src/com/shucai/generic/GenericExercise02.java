package com.shucai.generic;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericExercise02 {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("tom", 20000, new MyDate(2000, 11 ,11)));
        employees.add(new Employee("tom", 12000, new MyDate(2001, 12,12)));
        employees.add(new Employee("c", 50000, new MyDate(1980, 10 ,10 )));

        System.out.println("排序前");
        System.out.println("Employee : " + employees);

        System.out.println("排序后");
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                //先根据名字排序
                int i = e1.getName().compareTo(e2.getName());
                if (i != 0) {
                    return i;
                }
                //名字相同，根据MyDate排序
                return e1.getBirthday().compareTo(e2.getBirthday());
            }
        });

        System.out.println("Employee : " + employees);
    }
}
