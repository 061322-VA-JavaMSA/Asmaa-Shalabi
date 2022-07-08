package com.revature.services;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeePostgres;

import com.revature.exceptions.LoginException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Employee;


public class AuthService {

	private EmployeeDAO ud = new EmployeePostgres();
	
	/*-
	 * if the user is found by username and the password matches, returns that user
	 */
	public Employee login(String username, String password) throws UserNotFoundException, LoginException {
		
		// principal refers to "currently logged in user"
		Employee principal = ud.getUserByUsername(username);
		
		if(principal == null) {
			throw new UserNotFoundException();
		}
		
		if(!principal.getPassword().equals(password)){
			throw new LoginException();
		}
		
		return principal;
	}
}
