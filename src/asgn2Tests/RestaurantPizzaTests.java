package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that tests the methods relating to the handling of Pizza objects in
 * the asgn2Restaurant.PizzaRestaurant class as well as processLog and
 * resetDetails.
 * 
 * @author Yoon Kim n9818901
 *
 */
public class RestaurantPizzaTests {
	// TO DO
	PizzaRestaurant restaurant = new PizzaRestaurant();

	// Using log file 20170101 for following tests.
	@Before
	public void populatePizza() {
		try {
			restaurant.processLog("./logs/20170101.txt");
		} catch (PizzaException | LogHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Testing with invalid data formats
		@Test(expected = PizzaException.class)
		public void invalidIndex() throws PizzaException{
			restaurant.getPizzaByIndex(96755);
		}
		
		@Test
		public void testNumPizzaOrders(){
			int i = restaurant.getNumPizzaOrders();
			assertEquals(i,3);
		}

		@Test
		public void testGetTotalProfit(){
			double totprofit = restaurant.getTotalProfit();
			assertEquals(36.5, totprofit, 0);
		}
		
}
