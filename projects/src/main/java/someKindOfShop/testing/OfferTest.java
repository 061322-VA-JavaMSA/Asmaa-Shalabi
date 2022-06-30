package someKindOfShop.testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import someKindOfShop.service.OfferService;
import someKindOfShop.shoppingList.Offers;




public class OfferTest {



	private static OfferService sut;
	
	
	// Used to set up the test
	@BeforeAll
	public static void setUp() {
		sut = new OfferService();
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
	public void offerTest() {
		Offers cu = new Offers();
//		cu.setCustomerId(1);
//		cu.setItemId(1);
//		cu.setAmount(100);
		cu= sut.getOfferById(1);
		Offers actual = cu;
		Offers expected = new Offers();
		expected = sut.getOfferById(cu.getId());
		assertEquals(expected, actual);
	
	}
	
	
   
}
