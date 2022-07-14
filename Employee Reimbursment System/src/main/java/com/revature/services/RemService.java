package com.revature.services;

import java.util.List;


import com.revature.daos.RemDAO;
import com.revature.daos.RemHibernate;
import com.revature.exceptions.UserNotCreatedException;
import com.revature.exceptions.UserNotFoundException;

import com.revature.models.Rem;


public class RemService {
private RemDAO ud = new RemHibernate();
	
	public Rem createRem(Rem u) throws UserNotCreatedException {
		// by default, created account will be basic Users
		//u.setRole(Role.BASIC_USER);
		
		
		Rem createdRem = ud.insertRem(u);
		if(createdRem.getId() == -1) {
			throw new UserNotCreatedException();
		}
		return createdRem;
	}
	public Rem createRem(int amount,String des,int eId) throws UserNotCreatedException {
		// by default, created account will be basic Users
		//u.setRole(Role.BASIC_USER);
		
		Rem rem= new Rem();
		rem.setAmount(amount);
		rem.setDescription(des);
		rem.setEmployee_id(eId);
		Rem createdRem = ud.insertRem(rem);
		if(createdRem.getId() == -1) {
			throw new UserNotCreatedException();
		}
		return createdRem;
	}
	
	public Rem getUserById(int id) throws UserNotFoundException {
		Rem u = ud.getRemById(id);
		if (u == null) {
			throw new UserNotFoundException();
		}
		return u;
	}	
	
	
	public List<Rem> getRems() {
		List<Rem> users = ud.getRems();
		return users;
	}


}
