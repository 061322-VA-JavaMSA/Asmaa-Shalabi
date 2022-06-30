package someKindOfShop.testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import someKindOfShop.service.EmployeeService;
import someKindOfShop.user.Employee;




public class EmployeeTest {



	private static EmployeeService sut;
	
	
	// Used to set up the test
	@BeforeAll
	public static void setUp() {
		sut = new EmployeeService();
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
	public void employeeTest() {
		Employee cu = new Employee();
		cu.setUname("test");
		cu.setPass("test");
		cu.setId(2);
		Employee actual = sut.createUser(cu);
		Employee expected = new Employee();
		expected = sut.getEmployeeByName(cu.getUname());
		assertEquals(expected, actual);
	
	}
	
	
   
}
