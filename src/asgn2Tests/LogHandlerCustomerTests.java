package asgn2Tests;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import java.util.ArrayList;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Kihoon Seo n8998949
 */
public class LogHandlerCustomerTests {
	// TO DO
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	//Using log file 20170101 for following tests.
	@Before
	public void populateCustomerDataset(){
		try{
			customerList = LogHandler.populateCustomerDataset("./logs/20170101.txt");
		} catch(CustomerException | LogHandlerException e){
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Testing with invalid data: no log files supplied
	@Test(expected=LogHandlerException.class)
	public void invalidLogfileTest() throws CustomerException, LogHandlerException {
		customerList = LogHandler.populateCustomerDataset("");
	}
	
	//Testing with customer 2 (line 2, index 1)
	@Test
	public void test(){
		assertEquals(customerList.get(1).getName(),"April O'Neal");
		assertEquals(customerList.get(1).getCustomerType(),"Drone Delivery Customer");
		assertEquals(customerList.get(1).getLocationX(),3);
		assertEquals(customerList.get(1).getLocationY(),4);
		assertEquals(customerList.get(1).getMobileNumber(),"0987654321");
		
	}
}
