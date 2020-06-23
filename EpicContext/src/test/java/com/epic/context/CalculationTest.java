package com.epic.context;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculationTest {
	@SuppressWarnings("deprecation")
	@Test
	public void testCalculate() {
		assertEquals(5000, Calculation.calculate(Customer.REGULAR,5000),0.0);
		assertEquals(9500, Calculation.calculate(Customer.REGULAR,10000),0.0);
		assertEquals(13500, Calculation.calculate(Customer.REGULAR,15000),0.0);
		assertEquals(3600, Calculation.calculate(Customer.PREMIUM,4000),0.0);
		assertEquals(7000, Calculation.calculate(Customer.PREMIUM,8000),0.0);
		assertEquals(10200, Calculation.calculate(Customer.PREMIUM,12000),0.0);
		assertEquals(15800, Calculation.calculate(Customer.PREMIUM,20000),0.0);
	}

	
}
