package com.revature.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.revature.daos.EmployeeHibernate;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Employee;
import com.revature.models.Role;


public class UserServiceTest {
	
	
	private static EmployeeHibernate uht;
	
	@InjectMocks
	private static UserService sut;
	
	@BeforeAll
	public static void setup() {
		sut = new UserService();
	}
	
	
	@Test
	public void getUserByNameExists() throws UserNotFoundException {
		Employee expected = new Employee();
		expected.setId(1);
		
		expected.setUsername("lolo");
		expected.setPassword("12345");
		expected.setUsername("aliaa");
		
		
		
		Employee actual = sut.getUserByUsername("lolo");
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void getUserByNameNotExists() throws UserNotFoundException {
		
		
		
		assertThrows(UserNotFoundException.class, ()->sut.getUserByUsername("Ehab"));
	}
	
	
	
	@Test
	public void getUserByIdExists() throws UserNotFoundException {
		Employee expected = new Employee();
		expected.setId(1);
		expected.setRole(Role.ADMIN);
		expected.setFirst_name("asmaa");
		expected.setPassword("12345");
		expected.setUsername("suma");
		
          
		
		Employee actual = sut.getUserById(3);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void getUserByIdNotExists() throws UserNotFoundException {
		
	
		
		assertThrows(UserNotFoundException.class, ()->sut.getUserById(7));
	}
	
	
	}
