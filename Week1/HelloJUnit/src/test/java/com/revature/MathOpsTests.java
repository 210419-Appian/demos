package com.revature;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathOpsTests {
	
	public static MathOps mo;
	public static int i;
	public static int j;
	public static int k;
	public static int result;
	
	@BeforeAll
	public static void setMO() {
		System.out.println("In BeforeAll");
		mo = new MathOps();
	}

	@BeforeEach
	public void setInts() {
		System.out.println("In BeforeEach");
		i = 7;
		j = 5;
		k = 0;
	}
	
	@AfterEach
	public void clearResult() {
		System.out.println("In AfterEach");
		result = 0;
	}
	
	@AfterAll
	public static void clearEnv() {
		mo = null;
		System.out.println("In AfterClass");
	}
	
	@Test
	public void testAdd() {
		System.out.println("Testing add");
		result = mo.add(i, j);
		assertTrue(result == 12);
	}
	
	@Test
	public void testAdd2() {
		System.out.println("Testing add again");
		result = mo.add(i, k);
		assertEquals(result, 7);
	}
	
	@Test
	public void testSubtract() {
		System.out.println("Testing subtraction");
		result = mo.subtract(i, j);
		Runnable lambda = () -> {System.out.println("I'm a lambda func");};
		lambda.run();
		assertNotEquals(0, result);
	}
	
	@Test
	public void testDivision() {
		System.out.println("Going to try and throw something.");
		Throwable exc = assertThrows(
				ArithmeticException.class, () -> mo.divide(i, k));
		//assertEquals(exc.getClass(), ArithmeticException.class);
	}
	
	
	
	
	
}
