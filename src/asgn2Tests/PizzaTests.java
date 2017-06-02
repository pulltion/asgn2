package asgn2Tests;

import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.PizzaTopping;
import asgn2Pizzas.VegetarianPizza;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.PizzaException;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Person B
 *
 */
public class PizzaTests {
	// TO DO
	MargheritaPizza mPizza;
	VegetarianPizza vPizza;
	MeatLoversPizza lPizza;
	
	@Test
	public void testCalculateCostPerPizzaWithMargheritaPizza1() {

		assertEquals(1.5, PizzaTopping.BACON.getCost(), 0.0);
		assertEquals(1.0, PizzaTopping.CHEESE.getCost(), 0.0);
		assertEquals(0.5, PizzaTopping.TOMATO.getCost(), 0.0);
		assertEquals(1.0, PizzaTopping.SALAMI.getCost(), 0.0);
		assertEquals(0.8, PizzaTopping.EGGPLANT.getCost(), 0.0);
		assertEquals(2, PizzaTopping.MUSHROOM.getCost(), 0.0);
		assertEquals(1.2, PizzaTopping.CAPSICUM.getCost(), 0.0);
		assertEquals(1.0, PizzaTopping.PEPPERONI.getCost(), 0.0);
		
		try {
			mPizza = new MargheritaPizza(1, LocalTime.of(19, 15, 00), LocalTime.of(19, 30, 00));
			double cost = mPizza.getCostPerPizza();
			assertEquals(1.5, cost, 0.0);
			mPizza = null;
		
		} catch (PizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCalculateCostPerPizzaWithMargheritaPizza2() {
		
		try {
			mPizza = new MargheritaPizza(5, LocalTime.of(19, 15, 00), LocalTime.of(19, 30, 00));
			double cost = mPizza.getCostPerPizza();
			assertEquals(1.5, cost, 0.0);
		
		} catch (PizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCalculateCostPerPizzaWithVegetarianPizza() {
		
		try {
			vPizza = new VegetarianPizza(5, LocalTime.of(19, 15, 00), LocalTime.of(19, 30, 00));
			double cost = vPizza.getCostPerPizza();
			assertEquals(5.5, cost, 0.0);
		
		} catch (PizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
