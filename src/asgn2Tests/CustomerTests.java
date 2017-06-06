package asgn2Tests;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Kihoon Seo n8998949
 * 
 *
 */
public class CustomerTests {
	// TO DO
	DriverDeliveryCustomer driver;
	DroneDeliveryCustomer drone;
	PickUpCustomer pickup;
	
	
	@Before
	public void customerTest() throws CustomerException{
		driver = new DriverDeliveryCustomer("Darth Vader","0420666123",-3,-1);
		drone = new DroneDeliveryCustomer("Luke Skywalker","0123456789",2,5);
		pickup = new PickUpCustomer("Master Yoda","0666420123",0,0);
	}
	
	//Testing with invalid data formats
	@Test(expected = CustomerException.class)
	public void invalidCustomerTest() throws CustomerException{
		@SuppressWarnings("unused")
		Customer invalid = new DriverDeliveryCustomer("N", "123412", 0,-220);
	}
	
	//Testing getName() method
	@Test
	public void getDriverName(){
		assertEquals("Darth Vader", driver.getName());
	}
	@Test
	public void getDroneName(){
		assertEquals("Luke Skywalker", drone.getName());
	}
	@Test
	public void getPickUpName(){
		assertEquals("Master Yoda", pickup.getName());
		
	}
	//Testing getMobileNumber() method
	@Test
	public void getDriverNumber(){
		assertEquals("0420666123", driver.getMobileNumber());
	}
	@Test
	public void getDroneNumber(){
		assertEquals("0123456789", drone.getMobileNumber());
	}
	@Test
	public void getPickUpNumber(){
		assertEquals("0666420123", pickup.getMobileNumber());
		
	}
	//Testing getCustomerType() method
	@Test
	public void getDriverType(){
		assertEquals("Driver Delivery Customer", driver.getCustomerType());
	}
	@Test
	public void getDroneType(){
		assertEquals("Drone Delivery Customer", drone.getCustomerType());
	}
	@Test
	public void getPickUpType(){
		assertEquals("Pick Up Customer", pickup.getCustomerType());
		
	}
	//Testing getLocationX() method
	@Test
	public void getDriverLocationX(){
		assertEquals(-3, driver.getLocationX());
	}
	@Test
	public void getDroneLocationX(){
		assertEquals(2, drone.getLocationX());
	}
	@Test
	public void getPickUpLocationX(){
		assertEquals(0, pickup.getLocationX());
		
	}
	//Testing getLocationY() method
		@Test
		public void getDriverLocationY(){
			assertEquals(-1, driver.getLocationY());
		}
		@Test
		public void getDroneLocationY(){
			assertEquals(5, drone.getLocationY());
		}
		@Test
		public void getPickUpLocationY(){
			assertEquals(0, pickup.getLocationY());
			
		}
	
	//Testing getDeliveryDistance() method
		@Test
		public void getDriverDistance(){
			assertEquals(4.0, driver.getDeliveryDistance(), 0.0);
		}
		@Test
		public void getDroneDistance(){
			assertEquals(Math.sqrt(29), drone.getDeliveryDistance(), 0.0);
		}
		@Test
		public void getPickUpDistance(){
			assertEquals(0, pickup.getDeliveryDistance(), 0.0);
			
		}
		
}
