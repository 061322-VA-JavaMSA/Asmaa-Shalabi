package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;


public interface EmployeeDAO {
	Employee insertEmployee(Employee e);
	Employee getUserById(int id);

	List<Employee> getUsers();
	Employee getUserByUsername(String username);
	
}