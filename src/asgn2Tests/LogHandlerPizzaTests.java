package asgn2Tests;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Pizza objects in
 * the asgn2Restaurant.LogHander class.
 * 
 * @author Yoon Kim n9818901
 * 
 */
public class LogHandlerPizzaTests {
	// TO DO
	ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
	
	//Using log file 20170101 for following tests.
		@Before
		public void populatePizzaDataset(){
				try {
					pizzaList = LogHandler.populatePizzaDataset("./logs/20170101.txt");
				} catch (PizzaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (LogHandlerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		//Testing with invalid data: no log files supplied
		@Test(expected=LogHandlerException.class)
		public void invalidLogfileTest() throws PizzaException, LogHandlerException {
			pizzaList = LogHandler.populatePizzaDataset("");
		}
		
		@Test
		public void testCreatePizza() {
			assertEquals(pizzaList.get(1).getCostPerPizza(), 1.5, 0);
			assertEquals(pizzaList.get(1).getPizzaType(), "Margherita");
			assertEquals(pizzaList.get(1).getQuantity(), 1);
			assertEquals(pizzaList.get(1).getPricePerPizza(), 8.0, 0);
		}
}
