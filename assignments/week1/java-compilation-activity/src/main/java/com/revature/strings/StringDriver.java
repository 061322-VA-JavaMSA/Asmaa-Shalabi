package com.revature.strings;

public class StringDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="hello";
		String s1="hello";
		String s2=new String("hello");
		System.out.println("Is s ==s1?"+ (s ==s1));
		System.out.println("Is s ==s2?"+ (s ==s2));
		System.out.println("s.equals(s2)"+ s.equals(s2));
		s2=s2.intern();
		System.out.println("After intern Is s ==s2?"+ (s ==s2));
		StringBuilder sb = new StringBuilder("Hello world!");
		
		sb.append("abc");
		sb.reverse();
		System.out.println(sb);
		StringBuffer sbuff= new StringBuffer("ASmaa!");
		sbuff.append("Shalabi");
		sbuff.reverse();
		System.out.println(sbuff);

	}

}
