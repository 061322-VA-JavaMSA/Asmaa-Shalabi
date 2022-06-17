package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.exceptions.DivideBy0Exception;
import com.revature.exceptions.Number13Exception;

public class CalculatorTest {

	private static Calculator sut;
	
	/*
	 * JUnit 5
	 * 	- @BeforeAll
	 *  - @BeforeEach
	 *  - @AfterAll
	 *  - @AfterEach
	 *  
	 *  - @Test
	 *  - @Ignore
	 *  - @Order
	 */
	
	// Used to set up the test
	@BeforeAll
	public static void setUp() {
		sut = new Calculator();
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
	public void addOneAndTwo() {
		int expected = 3;
		int actual = sut.add(1, 2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void addEightAndFive() {
		assertThrows(Number13Exception.class, () -> sut.add(8, 5));
	}
	
	@Test
	public void addZeroAndThirteen() {
		assertThrows(Number13Exception.class, () -> sut.add(0, 13));
	}
   @Test
   public void subtractfiveFromEight() {
	   int expected =3;
	   int actual = sut.subtract(8, 5);
	   assertEquals(expected,actual);
	   }
   @Test
   public void subtractfiveFromThree() {
	   int expected =-2;
	   int actual = sut.subtract(3, 5);
	   assertEquals(expected,actual);
	   }
   @Test
   public void multiplyfiveByTwo() {
	   int expected =10;
	   int actual = sut.multiply(2, 5);
	   assertEquals(expected,actual);
	   }
   @Test
   public void multiplyTwelveByFive() {
	   int expected =60;
	   int actual = sut.multiply(12, 5);
	   assertEquals(expected,actual);
	   }
   @Test
   public void sumOfArrOf111() {
	   int expected =3;
	   int actual = sut.sumOfArr(new int[]{1,1,1});
	   assertEquals(expected,actual);
	   }
   @Test
   public void sumOfArrOf123() {
	   int expected =6;
	   int actual = sut.sumOfArr(new int[]{1,2,3});
	   assertEquals(expected,actual);
	   }
   @Test
	public void divideFourByTwo() {
		int expected = 2;
		int actual = sut.divide(4, 2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void divideTwoByZero() {
		assertThrows(DivideBy0Exception.class, () -> sut.divide(2, 0));
	}
   
   
}
