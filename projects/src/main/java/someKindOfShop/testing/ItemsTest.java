package someKindOfShop.testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import someKindOfShop.service.ItemService;
import someKindOfShop.shoppingList.Items;






public class ItemsTest {



	private static ItemService sut;
	
	
	// Used to set up the test
	@BeforeAll
	public static void setUp() {
		sut = new ItemService();
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
	public void itemTest() {
		Items cu = new Items();
		cu.setName("test");
		cu.setPrice(500);
		cu.setId(2);
		Items actual = sut.addItems(cu);
		Items expected = new Items();
		expected = sut.getItemById(cu.getId());
		assertEquals(expected, actual);
	
	}
	
	
   
}
