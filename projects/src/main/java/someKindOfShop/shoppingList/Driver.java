package someKindOfShop.shoppingList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import someKindOfShop.service.CustomerAuthService;
import someKindOfShop.service.CustomerService;
import someKindOfShop.service.EmployeeService;
import someKindOfShop.service.EmplyeeAuthService;
import someKindOfShop.service.ItemService;
import someKindOfShop.service.OfferService;
import someKindOfShop.user.Customer;
import someKindOfShop.user.Employee;


public class Driver {
	static Scanner scan;
	static EmplyeeAuthService eas;
	static CustomerAuthService cas;
	static EmployeeService es;
	static CustomerService cs;
	static ItemService is;
	static OfferService os;
	private static Logger log = LogManager.getLogger(Driver.class);

	public static void main(String[] args) throws LoginException {
		// TODO Auto-generated method stub
		
		
	
			scan = new Scanner(System.in);
			eas = new EmplyeeAuthService();
			cas = new CustomerAuthService();
			es = new EmployeeService();
			cs = new CustomerService();
			is = new ItemService();
			os= new OfferService();
			
			System.out.println("please select 1 for customer or 2 for employee");
			int input = scan.nextInt();
			switch(input) {
			case 1:
				System.out.println("hello customer");
				String c_username = null;
				String c_password = null;
				
				System.out.println("Please enter username:");
				c_username = scan.next();
				scan.nextLine();
				System.out.println("Please enter password:");
				c_password = scan.nextLine();
				
				try {
					log.info(cas.login(c_username, c_password));
					List<Items> items= is.getItem();
					for(Items item: items ) {
						System.out.println(item);
					}
					System.out.println("select 1 for making an offer, 2 to see your cart, 3 to see your remaining payments");
					int in = scan.nextInt();
					switch (in){
					case 1:
						System.out.println("Enter item number to make an offer!");
						int itemId = scan.nextInt();
						System.out.println(is.getItemById(itemId));
						System.out.println("Enter your offer!");
						int offerValue = scan.nextInt();
						os.createOffer(cs.getUserId(c_username),itemId,offerValue);
						break;
					//is.updateCId(is.getItemById(itemId), cs.getUserId(c_username));
					case 2:
							List<Items> cItems = is.getCustomerItem(cs.getUserId(c_username));
							for (Items i:cItems ) {
								System.out.println(i);
							}
					
						break;
					case 3:
						System.out.println(cs.getBalance(cs.getUserId(c_username)));				
						break;
					default:
							break;
							}
					
				} catch (LoginException e) {
					System.out.println("Invalid credentials.");
					System.out.println("sign up here");
					System.out.println("Create, username:");
					String uname = scan.nextLine();
					System.out.println("Create, password:");
					String pass = scan.nextLine();
					Customer userTBC = new Customer();
					userTBC.setUname(uname);
					userTBC.setPass(pass);
					log.info(cs.createUser(userTBC));
					//log.error("Login exception was thrown: " + e.fillInStackTrace());
				}
				break;
			case 2:
				System.out.println("hello employee");
				String e_username = null;
				String e_password = null;
				
				System.out.println("Please enter username:");
				e_username = scan.next();
				scan.nextLine();
				System.out.println("Please enter password:");
				e_password = scan.next();
				
				try {
					log.info(eas.login(e_username, e_password));
					System.out.println("select 1 to add an item OR select 2 to remove item: OR 3 to view offers OR 4 to see all payments");
					int select = scan.nextInt();
					switch (select) {
					case 1:
						System.out.println("add item's data, name and price ");
						String iName = scan.next();
						scan.next();
						int iPrice = scan.nextInt();
						Items neItem= new Items(iName,iPrice);
						es.addItems(neItem);
						break;
					case 2:
						System.out.println("Enter Item name to remove:");
						String removeN = scan.next();
						System.out.println(es.deletItem(removeN));
						break;
					case 3:
						List<Offers> offer = os.getoffers();
						for(Offers o: offer ) {
							System.out.println(o);
						}
						System.out.println("select 1 to accept an offer OR 2 to reject an offer");
						int pick = scan.nextInt();
						if(pick == 1) {
							System.out.println("select customer id and item id for the offer you want to accept");
							int cuId = scan.nextInt();
							int itId = scan.nextInt();
							os.updateOffer(cuId, itId,true);
							is.updateOwnedState(cuId, itId);
							os.rejectOffer(itId);
							cs.addpayments(os.getAmount(cuId,itId), cuId);
						}
						if(pick == 2) {
							System.out.println("select customer id and item id for the offer you want to reject");
							int cuId = scan.nextInt();
							int itId = scan.nextInt();
							os.updateOffer(cuId, itId,false);
						}
						break;
					case 4:
						List<Offers> acceptedOffer = os.getAcceptedOffers();
						for(Offers o: acceptedOffer ) {
							System.out.println(o.getAmount());
						}
						break;
						
					}
					
				} catch (LoginException e) {
					System.out.println("Invalid credentials.");
					log.error("Login exception was thrown: " + e.fillInStackTrace());
//					e.printStackTrace();
				}
				break;
			default:
				System.out.println("please try again");
			}
			
			scan.close();
		}
		

	}


