package com.shucai.class01;

public class Byte {

	public static void printByte(int num) {
		for (int i = 31; i >= 0; i--) {

			System.out.print((num & (1 << i)) == 0 ? "0" : "1");
		}
		System.out.println();

	}

	public static void main(String[] args) {
		
		printByte(13);
		System.out.println(13 & 1);
		printByte(13 & 1);
	}
}
