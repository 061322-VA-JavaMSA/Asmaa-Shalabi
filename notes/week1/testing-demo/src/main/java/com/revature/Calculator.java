package com.revature;
import com.revature.exceptions.DivideBy0Exception;
import com.revature.exceptions.Number13Exception;

public class Calculator {
	


public  int add(int a, int b) {
	int c= a+b;
	if (c==13) {
		throw new Number13Exception("the result is 13");
	}
	return c;
}
public int subtract(int a,int b) {
	int c;
	
	c=a-b;
	return c;
}
public int multiply(int a,int b) {
	int c;
	
	c=a*b;
	return c;
}
public int sumOfArr(int[] arr) {
	int c=0;
	for(int i=0;i<arr.length;i++) {
		c+=arr[i];
	}
	return c;
}
public int divide(int a,int b) {
	int c;
	if(b ==0) {
		throw new DivideBy0Exception();	
	}
	c=a/b;
	return c;
}
	

}
