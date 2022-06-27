package someKindOfShop.DAO;

import java.util.List;

import someKindOfShop.user.Customer;


public interface CustomerDAO {

	Customer retrieveUserById(int id);
	List<Customer> retrieveUsers();
	Customer retrieveUserByUsername(String username);
	
	boolean deleteUserById(int id);
	Customer createUser(Customer e);
	boolean updateUser(Customer e);

}
