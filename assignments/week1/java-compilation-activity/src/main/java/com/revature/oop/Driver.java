package com.revature.oop;
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
		

	}

}
