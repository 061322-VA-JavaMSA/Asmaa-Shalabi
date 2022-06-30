package someKindOfShop.testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import someKindOfShop.service.CustomerService;
import someKindOfShop.user.Customer;

public class CustomerTest {
	private static CustomerService sut;
	
	
	// Used to set up the test
	@BeforeAll
	public static void setUp() {
		sut = new CustomerService();
	}
	
	@AfterAll
	public static void tearDown() {
		System.out.println("Tear down behavior.");
	}
	
	@BeforeEach
	public void before() {
		System.out.println("@Before each behavior");
	}
	
	@Test
	public void customerTest() {
		Customer cu = new Customer();
		cu.setUname("test");
		cu.setPass("test");
		cu.setId(2);
		Customer actual = sut.createUser(cu);
		Customer expected = new Customer();
		expected = sut.retrieveCustomerById(cu.getId());
		assertEquals(expected, actual);
	
	}
	
	
   
}
