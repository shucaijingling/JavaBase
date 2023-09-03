package com.shucai.generics3;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {

    @Test
    public void test1() {
        //可以
        Object obj = null;
        String str = null;
        obj = str;

        //可以
        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        //不可以
        List<Object> list1 = null;
        List<String> list2 = null;
//        list1 = list2;
    }

    /**
     * 通配符的使用
     * 通配符：?
     */
    @Test
    public void test2() {
        List<String> list1 = null;
        List<Object> list2 = null;
        List<?> list = null;
        //不可以，编译不通过
//        list1 = list2;
//        list2 = list1;

        list = list1;
        list = list2;
        print(list1);
        print(list2);
    }
    public void print(List<?> list) {
        if (list != null) {
            for (Object o : list) {
                System.out.println(o);
            }
        }

    }

    @Test
    public void test3() {
        List<?> list = null;
        List<String> list1 = new ArrayList<>();
        list1.add("AA");
        list1.add("BB");
        list1.add("CC");
        list1.add("DD");

        list = list1;
        //写入，List<?>不能再添加,除了null
//        list.add("AAAa");
        list1.add(null);

        //获取（读取）:允许读取数据，读取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);
    }

    @Test
    public void test4() {
        List<? extends Person> listE = null;
        List<? super Student> listS = null;

        List<Student> list1 = null;
        List<Person> list2 = null;
        List<Object> list3 = null;

        //编译不通过
//        list1 = list2;
//        listE = list3;
        listE = list1;
        listE = list2;

        listS =list1;
        listS = list2;
        listS = list3;

        //读取数据
        listE = list1;
        Person person = listE.get(0);
        //编译不通过
//        Student s = listE.get(0);
//        listE.add(new Person());
//        listE.add(new Student());

    }
    @Test
    public void test5() {
        List<? extends Person> listE = new ArrayList<>();
        List<? super Student> listS = new ArrayList<>();
//        listE.add(new Person());
//        listE.add(new Student());
//        listE.add(Object);
        listS.add(new Student());
//        listS.add(new Person());
    }
}
