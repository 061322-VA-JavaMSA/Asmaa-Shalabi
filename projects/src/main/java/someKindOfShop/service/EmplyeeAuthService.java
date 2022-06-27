package someKindOfShop.service;

import javax.security.auth.login.LoginException;

import someKindOfShop.DAO.EmployeePostgres;
import someKindOfShop.DAO.UserDAO;
import someKindOfShop.user.Employee;

public class EmplyeeAuthService {
private UserDAO ud = new EmployeePostgres();
	
	public Employee login(String username, String password) throws LoginException {
		// if username/password passed are null, throws an exception
		if(username == null || password == null) {
			throw new LoginException();
		}
		
		Employee u = ud.retrieveUserByUsername(username);
		// if no user of that name has been retrieved/if pass don't match, throw an exception
		if(u == null || !u.getPass().equals(password)) {
			throw new LoginException();
		}
		return u;
	}

}
