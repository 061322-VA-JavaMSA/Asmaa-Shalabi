package someKindOfShop.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;

import someKindOfShop.DAO.CustomerPostgres;
import someKindOfShop.user.Customer;
import someKindOfShop.DAO.CustomerDAO;


public class CustomerService {
	private CustomerDAO ud = new CustomerPostgres();
	private static Logger log = LogManager.getLogger(CustomerService.class);
	
	public List<Customer> getUsers(){
		return ud.retrieveUsers();
	}
	
	public Customer createUser(Customer u) {
		// logic to validate u
		
//		u = ud.createUser(u);
		Customer user = ud.createUser(u);
		log.info("Customer: " + user + " was created.");
		return user;
	}
	public Customer retrieveCustomerById(int id) {
		return ud.retrieveUserById(id);
	}

	public Customer login(String username, String password) {
		
		CustomerAuthService cAs= new CustomerAuthService();
		Customer c = new Customer();
		try {
			c = cAs.login(username, password);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;}
	public int getUserId(String username) {
		return ud.retrieveUserByUsername(username).getId();
	}
	public boolean addpayments(int amount, int cId) {
		return ud.addpayments(amount, cId);
	}
	public int getBalance(int id) {
		return ud.getBalance(id);
	}

}
