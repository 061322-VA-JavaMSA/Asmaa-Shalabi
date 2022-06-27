package com.revature.oop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import com.revature.oop.models.BoringTask;
import com.revature.oop.models.Task;



public class Driver {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Task t=new Task();
		System.out.println(t.getDueDate());
		System.out.println(t.isCompleted());
		System.out.println(t.getDescription());
		System.out.println();
		Task t1= new Task("Do laundary.");
		System.out.println(t1.getDueDate());
		System.out.println(t1.isCompleted());
		System.out.println(t1.getDescription());
		t1.setDueDate(LocalDate.now().minusYears(4));
		System.out.println(t1.getDueDate());
		BoringTask t2= new BoringTask();
		System.out.println(t2.getDueDate());
		System.out.println(t2.isCompleted());
		System.out.println(t2.getDescription());
		t2.setDueDate(LocalDate.now().minusYears(4));
		System.out.println(t2.getDueDate());
		String url="jdbc:postgresql://database-1.cs5pbm169msw.us-west-1.rds.amazonaws.com:5432/postgres";
		String username="postgres";
		String password="As1062013";
		try {
			Connection c=DriverManager.getConnection(url, username, password);
			System.out.println(c.getMetaData().getDriverName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
