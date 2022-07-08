package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Role;

import com.revature.util.ConnectionUtil;

public class EmployeePostgres implements EmployeeDAO{

	@Override
	public Employee insertEmployee(Employee u) {
		
		/*-
		 *  condition to see if user was successfully created
		 *  	- if successful u.id != -1
		 *  	- if not successful u.id == -1
		 */
		u.setId(-1);
		
		String sql = "insert into employee (username, password,first_name,last_name,email) values (?,?,?,?,?) returning id;";
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3,u.getFirst_name());
			ps.setString(4,u.getLast_name());
			ps.setString(4, u.getEmail());
			
			
			ps.setString(3, u.getRole().toString());
			
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				u.setId(rs.getInt("id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public Employee getUserById(int id){
		String sql = "select * from employee where id = ?;";
		Employee user = null;
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id); 
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new Employee();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirst_name(rs.getString("first_name"));
				user.setLast_name(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setRole(Role.valueOf(rs.getString("role")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Employee getUserByUsername(String username){
		String sql = "select * from employee where username  = ?;";
		Employee u = null;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, username); 

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new Employee();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setFirst_name(rs.getString("first_name"));
				u.setLast_name(rs.getString("last_name"));
				u.setEmail(rs.getString("email"));
				u.setRole(Role.valueOf(rs.getString("role")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public List<Employee> getUsers() {
		String sql = "select * from employee;";
		List<Employee> users = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				Employee u = new Employee();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setFirst_name(rs.getString("first_name"));
				u.setLast_name(rs.getString("last_name"));
				u.setEmail(rs.getString("email"));
				u.setRole(Role.valueOf(rs.getString("role")));
				
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}


}

