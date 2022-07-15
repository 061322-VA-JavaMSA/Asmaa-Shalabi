package com.revature.dtos;

import java.util.Objects;

import com.revature.models.Employee;
import com.revature.models.Role;



/*-
 * Data Transfer Objects
 */
public class EmployeeDTO {

	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	

	private Role role;
	
	public EmployeeDTO() {
		super();
		
	}
	public EmployeeDTO(Employee e) {
		id= e.getId();
		username=e.getUsername();
		firstName= e.getFirst_name();
		lastName= e.getLast_name();
		email=e.getEmail();
		role= e.getRole();
		
	}

	public void setRole(Role role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password, role, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& role == other.role && Objects.equals(username, other.username);
	}

	

	
	
}