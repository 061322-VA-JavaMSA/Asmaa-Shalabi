package com.revature.daos;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;


import com.revature.models.Rem;
import com.revature.util.ConnectionUtil;

public class RemPostgres implements RemDAO{

	@Override
	public Rem insertRem(Rem u) {
		
		/*-
		 *  condition to see if user was successfully created
		 *  	- if successful u.id != -1
		 *  	- if not successful u.id == -1
		 */
		u.setId(-1);
		Date subDate = (Date) new java.util.Date() ;
		
		String sql = "insert into rem (amount, submitted_date,resolved_date,description,employee_id,status_id,type_id) values (?,?,?,?,?,?,?) returning id;";
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, u.getAmount());
			ps.setDate(2, subDate);
			ps.setDate(3,(Date) u.getRessolved_date());
			ps.setString(4,u.getDescription());
			ps.setInt(5, u.getEmployee_id());
			
			
		//	ps.setString(3, u.getRole().toString());
			
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
	public Rem getRemById(int id){
		String sql = "select * from rem where id = ?;";
		Rem user = null;
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id); 
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new Rem();
				user.setId(rs.getInt("id"));
				user.setAmount(rs.getInt("amount"));
				user.setDescription(rs.getString("description"));
				user.setEmployee_id(rs.getInt("employee_id"));
				user.setSubmitted_date(rs.getDate("submited_date"));
				user.setRessolved_date(rs.getDate("resolved_date"));
				
				//user.setRole(Role.valueOf(rs.getString("role")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public Rem getRemByEmployee_Id(int id){
		String sql = "select * from rem where employee_id  = ?;";
		Rem u = null;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();){
			
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id); 

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new Rem();
				u.setId(rs.getInt("id"));
				u.setAmount(rs.getInt("amount"));
				u.setDescription(rs.getString("description"));
				u.setEmployee_id(rs.getInt("employee_id"));
				u.setRessolved_date(rs.getDate("resolved_date"));
				u.setSubmitted_date(rs.getDate("submited_date"));
				//u.setRole(Role.valueOf(rs.getString("role")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public List<Rem> getRems() {
		String sql = "select * from rem;";
		List<Rem> users = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				Rem u = new Rem();
				u.setId(rs.getInt("id"));
				u.setAmount(rs.getInt("amount"));
				u.setDescription(rs.getString("description"));
				u.setEmployee_id(rs.getInt("employee_id"));
				u.setRessolved_date(rs.getDate("resolved_date"));
				u.setSubmitted_date(rs.getDate("submited_date"));
				
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	


}