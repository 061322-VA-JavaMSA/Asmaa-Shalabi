
	package com.revature.models;

	import java.util.Objects;

	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.EnumType;
	import jakarta.persistence.Enumerated;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;

import jakarta.persistence.Table;

	@Entity
	@Table(name="employee")
	public class Employee {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name="username", nullable = false, unique = true)
		private String username;
		@Column( name="password",nullable = false)
		private String password;
		@Column(name="first_name", nullable = true, unique = true)
		private String first_name;
		@Column(name="last_name", nullable = true, unique = true)
		private String last_name;
		@Column(name="email", nullable = true, unique = true)
		private String email;
		@Enumerated(EnumType.STRING)
		private Role role;
//		@ManyToOne
//	    @JoinColumn(name = "e_role")
//		private int e_role;
		
		
		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
	
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

//		public int getE_role() {
//			return e_role;
//		}

//		public void setE_role(int e_role) {
//			this.e_role = e_role;
//		}

		public Employee() {
			super();
			
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}


		@Override
		public int hashCode() {
			return Objects.hash( email, first_name, id, last_name, password, username);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			return  Objects.equals(email, other.email)
					&& Objects.equals(first_name, other.first_name) && id == other.id
					&& Objects.equals(last_name, other.last_name) && Objects.equals(password, other.password)
					&& Objects.equals(username, other.username);
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", first_name="
					+ first_name + ", last_name=" + last_name + ", email=" + email + "]";
		}

		public void setRole(Role basicUser) {
			this.role=basicUser;
			
		}
		public Role getRole() {
			return this.role;
		}
		
	}


