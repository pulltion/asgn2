package asgn2Tests;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Kihoon Seo n8998949
 */
public class RestaurantCustomerTests {
	// TO DO
	PizzaRestaurant restaurant = new PizzaRestaurant();
	
	//Using log file 20170101 for following tests.
	@Before
	public void populateCustomer(){
		try{
			restaurant.processLog("./logs/20170101.txt");
		} catch(CustomerException|LogHandlerException e){
			//TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Testing with invalid data formats
	@Test(expected = CustomerException.class)
	public void invalidIndex() throws CustomerException{
		restaurant.getCustomerByIndex(10000);
	}
	
	@Test
	public void testNumOrders(){
		int i = restaurant.getNumCustomerOrders();
		assertEquals(3, i);
	}

	@Test
	public void testGetDistance(){
		double dist = restaurant.getTotalDeliveryDistance();
		assertEquals(15, dist, 0);
	}
	
}
