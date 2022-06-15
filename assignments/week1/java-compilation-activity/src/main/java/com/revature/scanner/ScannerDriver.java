package com.revature.scanner;
import java.util.Scanner;

public class ScannerDriver {
    static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		menu();
		// TODO Auto-generated method stub
	/*	Scanner scan =new Scanner(System.in);
		System.out.println("Hello World!");
		System.out.println("what's your name");
		String name = scan.nextLine();
		System.out.println("Hello "+name+ " !");
        System.out.println("Plz pick a number!");
        int num= scan.nextInt();
        scan.nextLine();
        System.out.println("Hello "+ name
        +" your number is:"+ num);
        System.out.println("please pick a number from 1:2");
        String number= scan.nextLine();
        int numb= Integer.parseInt(number);
        switch(number) {
        case "1":
        	System.out.println("Hello!");
        	break;
        case "2":
        	System.out.println("GoodBye");
        	break;
       default:
    	   System.out.println("not recognize!");*/
        }
	public static void menu() {
		/*
		 * Menu that gives a user multiple options:
		 * 	- 1: get a random number
		 *  - 2: reverse a String of the user's choice
		 *  - 3: exit the program
		 *  
		 *  this menu should repeat until the user decides to exit
		 */
		int x=0;
		while(x != 3){
		System.out.println("please choose one option! ");
		System.out.println("1 for get a number");
		System.out.println("2 for reverse String");
		System.out.println("3 for exit");
		x= sc.nextInt();
		sc.nextLine();
		switch(x) {
		case 1:
			System.out.println(Math.random());
			break;
		case 2:
			System.out.println("Enter your String");
			String str= sc.nextLine();
			StringBuilder sb= new StringBuilder(str);
			sb.reverse();
			System.out.println(sb);
			break;
		default	:
			break;
			
		}
		
	}
		sc.close();

	}}
