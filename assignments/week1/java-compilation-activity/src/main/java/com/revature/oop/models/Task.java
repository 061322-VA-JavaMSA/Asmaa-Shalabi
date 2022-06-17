package com.revature.oop.models;

import java.time.LocalDate;
import java.util.Objects;

public class Task {
	private int id;
	private String description;
	private User userAssigned; 
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		if(dueDate.isBefore(LocalDate.now())) {
			System.out.println("not Valid!");
		}
		this.dueDate = dueDate;
	}
	private boolean completed;
	private LocalDate dueDate;
	public Task() {
		dueDate = LocalDate.now().plusDays(5);
		description ="None provided";
	}
	public Task(String description) {
		this();
		this.description=description;
	}
	public String toString() {
		return "Task [description : "+ description +", completed : "+completed+
				" , DueDate:"+ dueDate+"]";
		
		
	}
	public void doTask() {
		System.out.println("Doing a task!");
	}
	public void doTask(String speed) {
		System.out.println("Doing task at "+speed+" speed");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUserAssigned() {
		return userAssigned;
	}
	public void setUserAssigned(User userAssigned) {
		this.userAssigned = userAssigned;
	}
	
}
