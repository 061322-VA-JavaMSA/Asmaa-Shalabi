package someKindOfShop.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;

import someKindOfShop.DAO.EmployeePostgres;
import someKindOfShop.DAO.ItemDAO;
import someKindOfShop.DAO.ItemPostgres;
import someKindOfShop.user.Employee;
import someKindOfShop.DAO.UserDAO;
import someKindOfShop.shoppingList.Items;

public class EmployeeService {

	private UserDAO ud = new EmployeePostgres();
	private ItemDAO iD = new ItemPostgres();
	private static Logger log = LogManager.getLogger(EmployeeService.class);
	
	public List<Employee> getUsers(){
		return ud.retrieveUsers();
	}
	public Employee getEmployeeByName(String name) {
		return ud.retrieveUserByUsername(name);
	}
	
	public Employee createUser(Employee u) {
		// logic to validate u
		// if ok
//		u = ud.createUser(u);
		Employee user = ud.createUser(u);
		log.info("Employee: " + user + " was created.");
		return user;
	}

	public Message login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	public Items addItems(Items Item) {
		Items i = iD.addItem(Item);
		return i;
	}
	public boolean deletItem(String name) {
		return iD.deleteItemByName(name);
	}

}
