package com.shucai.class01;

public class Operate {

	public static void main(String[] args) {
		System.out.println(add(23, 22));
		System.out.println(subtracte(-23, 22));
	}

	public static int add(int a, int b) {
		int sum = a;
		while (b != 0) {
			sum = a ^ b;
			b = (a & b) << 1;
			a = sum;
		}
		return sum;
	}

	public static int subtracte(int a,int b) {
		return add(a, add(~b, 1));
	}
}
