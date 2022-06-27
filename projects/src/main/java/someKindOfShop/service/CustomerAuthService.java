package someKindOfShop.service;

import javax.security.auth.login.LoginException;

import someKindOfShop.DAO.CustomerDAO;
import someKindOfShop.DAO.CustomerPostgres;
import someKindOfShop.user.Customer;


public class CustomerAuthService {
private CustomerDAO ud = new CustomerPostgres();
	
	public Customer login(String username, String password) throws LoginException {
		
		// if username/password passed are null, throws an exception
		if(username == null || password == null) {
			
			throw new LoginException();
			
		}
		
		Customer u = ud.retrieveUserByUsername(username);
		// if no user of that name has been retrieved/if pass don't match, throw an exception
		if(u == null || !u.getPass().equals(password)) {
			
			throw new LoginException();
		}
		
		return u;
	}


}
