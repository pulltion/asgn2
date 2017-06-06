package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Yoon Kim n9818901 
 * 
 */
public class PizzaFactoryTests {
	// TO DO
	Pizza mPizza;
	Pizza vPizza;
	Pizza lPizza;

	@Before
	public void pizzaFactoryTest() throws PizzaException {
		vPizza = PizzaFactory.getPizza("PZV", 2, LocalTime.of(19, 00, 00), LocalTime.of(19, 20, 00));
		mPizza = PizzaFactory.getPizza("PZM", 1, LocalTime.of(20, 00, 00), LocalTime.of(20, 25, 00));
		lPizza = PizzaFactory.getPizza("PZL", 3, LocalTime.of(21, 00, 00), LocalTime.of(21, 35, 00));
	}

	// Testing with invalid data formats
	@Test(expected = PizzaException.class)
	public void testInvalidCustomer() throws PizzaException {
		@SuppressWarnings("unused")
		Pizza invalid = PizzaFactory.getPizza("PVV", 11, LocalTime.of(21, 00, 00), LocalTime.of(21, 35, 00));
	}

	// Testing with correct data formats
	@Test
	public void testVegetarian() {
		assertEquals("Vegetarian", vPizza.getPizzaType());
		assertEquals(5.5, vPizza.getCostPerPizza(), 0.0);
		assertEquals(11, vPizza.getOrderCost(), 0.0);
		assertEquals(20, vPizza.getOrderPrice(), 0.0);
		assertEquals(9.0, vPizza.getOrderProfit(), 0.0);
		assertEquals(10, vPizza.getPricePerPizza(), 0.0);
		assertEquals(2, vPizza.getQuantity());
	}

	@Test
	public void testMargherita() {
		assertEquals("Margherita", mPizza.getPizzaType());
		assertEquals(1.5, mPizza.getCostPerPizza(), 0.0);
		assertEquals(1.5, mPizza.getOrderCost(), 0.0);
		assertEquals(8, mPizza.getOrderPrice(), 0.0);
		assertEquals(6.5, mPizza.getOrderProfit(), 0.0);
		assertEquals(8, mPizza.getPricePerPizza(), 0.0);
		assertEquals(1, mPizza.getQuantity());
	}

	@Test
	public void testMeatLovers() {
		assertEquals("Meat Lovers", lPizza.getPizzaType());
		assertEquals(5, lPizza.getCostPerPizza(), 0.0);
		assertEquals(15, lPizza.getOrderCost(), 0.0);
		assertEquals(36, lPizza.getOrderPrice(), 0.0);
		assertEquals(21, lPizza.getOrderProfit(), 0.0);
		assertEquals(12, lPizza.getPricePerPizza(), 0.0);
		assertEquals(3, lPizza.getQuantity());
	}
}
