package com.shucai.stream;

import com.shucai.lambda2.Employee;
import com.shucai.lambda2.EmployeeData;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

public class StreamAPITest {

    @Test
    public void test() {
        List<Employee> employees = EmployeeData.getEmployees();

        //匹配与查找
        //是否所有的员工都大于18
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);

        //是否存在薪资大于9000的员工
        boolean b1 = employees.stream().anyMatch(e -> e.getSalary() > 9000);
        System.out.println(b1);

        //是否不存在名字叫Tom的员工
        boolean tom = employees.stream().noneMatch(e -> e.getName().equals("Tom"));
        System.out.println(tom);

        //返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        //返回任一元素
        //stream()串行流  返回第一个
        Optional<Employee> any = employees.stream().findAny();
        //parallelStream()并行流返回随机
        Optional<Employee> any1 = employees.parallelStream().findAny();
        System.out.println(any);

        //count返回元素个数
        long count = employees.stream().filter(f -> f.getSalary() > 9000).count();
        System.out.println(count);

        //max最大值
        Optional<Double> max = employees.stream().map(Employee::getSalary).max(Double::compare);
        System.out.println(max);
    }
}
