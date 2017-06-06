package asgn2Tests;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Kihoon Seo n8998949
 *
 */
public class CustomerFactoryTests {
	// TO DO
	Customer driver;
	Customer drone;
	Customer pickup;

	@Before
	public void customerFactoryTest() throws CustomerException {
		driver = CustomerFactory.getCustomer("DVC", "Darth Vader", "0420666123", -3, -1);
		drone = CustomerFactory.getCustomer("DNC", "Luke Skywalker", "0123456789", 2, 5);
		pickup = CustomerFactory.getCustomer("PUC", "Master Yoda", "0666420123", 0, 0);
	}

	// Testing with invalid data formats
	@Test(expected = CustomerException.class)
	public void testInvalidCustomer() throws CustomerException {
		@SuppressWarnings("unused")
		Customer invalid = CustomerFactory.getCustomer("0", "0", "0", 0, 0);
	}

	// Testing with correct data formats
	@Test
	public void testDriverDelivery() {
		assertEquals("Driver Delivery Customer", driver.getCustomerType());
		assertEquals("Darth Vader", driver.getName());
		assertEquals("0420666123", driver.getMobileNumber());
		assertEquals(-3, driver.getLocationX());
		assertEquals(-1, driver.getLocationY());
	}

	@Test
	public void testDroneDelivery() {
		assertEquals("Drone Delivery Customer", drone.getCustomerType());
		assertEquals("Luke Skywalker", drone.getName());
		assertEquals("0123456789", drone.getMobileNumber());
		assertEquals(2, drone.getLocationX());
		assertEquals(5, drone.getLocationY());
	}

	@Test
	public void testPickUpCustomer() {
		assertEquals("Pick Up Customer", pickup.getCustomerType());
		assertEquals("Master Yoda", pickup.getName());
		assertEquals("0666420123", pickup.getMobileNumber());
		assertEquals(0, pickup.getLocationX());
		assertEquals(0, pickup.getLocationY());

	}
}
