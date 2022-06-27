package someKindOfShop.DAO;

import java.util.List;

import someKindOfShop.user.Employee;


public interface UserDAO {
	
	Employee retrieveUserById(int id);
	List<Employee> retrieveUsers();
	Employee retrieveUserByUsername(String username);
	
	boolean deleteUserById(int id);
	Employee createUser(Employee e);
	boolean updateUser(Employee e);
	

}
