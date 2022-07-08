package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeHibernate;

import com.revature.exceptions.UserNotCreatedException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Employee;
import com.revature.models.Role;


public class UserService {

	private EmployeeDAO ud = new EmployeeHibernate();
	
	public Employee createUser(Employee u) throws UserNotCreatedException {
		// by default, created account will be basic Users
		u.setRole(Role.BASIC_USER);
		
		Employee createdUser = ud.insertEmployee(u);
		if(createdUser.getId() == -1) {
			throw new UserNotCreatedException();
		}
		return createdUser;
	}
	
	public Employee getUserById(int id) throws UserNotFoundException {
		Employee u = ud.getUserById(id);
		if (u == null) {
			throw new UserNotFoundException();
		}
		return u;
	}	
	
	public List<Employee> getUsers() {
		List<Employee> users = ud.getUsers();
		return users;
	}

}
