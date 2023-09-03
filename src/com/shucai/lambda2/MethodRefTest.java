package com.shucai.lambda2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * Created by shkstart.
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		//lambda
		Consumer<String> con1 = s -> System.out.println(s);
		con1.accept("Consumer . accept111");

		//方法引用
		PrintStream ps = System.out;
		Consumer<String> con2 = ps::println;
		con2.accept("Consumer . accep222");
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee employee = new Employee(1001, "Tom", 18, 20000);
		Supplier<String> supplier = () -> employee.getName();
		Supplier<int[]> supplier2 = () -> new int[]{11,2,3,2,4,5};
		System.out.println(supplier.get());
		System.out.println(Arrays.toString(supplier2.get()));

		System.out.println("88888888888888888888888888888888888");
		//方法引用
		Supplier<Object> sup = Employee::new;
		Supplier<String> sup2 = employee::getName;
		System.out.println(sup.get());
		System.out.println(sup2.get());
	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> com = (o1,o2) -> o1.compareTo(o2);
		System.out.println(com.compare(12,22));

		//方法引用
		Comparator<Integer> com2 = Integer::compareTo;
		System.out.println(com2.compare(55,33));
	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double, Long> fun = d -> Math.round(d);
		System.out.println(fun.apply(290.1111));

		//方法引用
		Function<Double, Long> fun2 = Math::round;
		System.out.println(fun2.apply(201.99999));
	}

	// 情况三：类 :: 实例方法 
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		
	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		
		
	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		
	}

}
