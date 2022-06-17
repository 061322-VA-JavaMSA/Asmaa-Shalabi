package com.revature;

public class DriverTest {

	public static void main(String[] args) {
		Calculator cal= new Calculator();
		System.out.println(cal.add(7, 7));
		System.out.println(cal.subtract(5, 6));
		System.out.println(cal.multiply(5, 6));
		int[] a = {1,2,3};
		System.out.println(cal.sumOfArr(a));
		

	}

}
