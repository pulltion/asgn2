package asgn2Restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/**
 *
 * A class that contains methods that use the information in the log file to
 * return Pizza and Customer object - either as an individual Pizza/Customer
 * object or as an ArrayList of Pizza/Customer objects.
 * 
 * @author Kihoon Seo n8998949 and Yoon Kim n9818901
 *
 */
public class LogHandler {

	final static String COMMA = ",";

	/**
	 * Returns an ArrayList of Customer objects from the information contained
	 * in the log file ordered as they appear in the log file.
	 * 
	 * @param filename
	 *            The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained
	 *         in the log file ordered as they appear in the log file.
	 * @throws CustomerException
	 *             If the log file contains semantic errors leading that violate
	 *             the customer constraints listed in Section 5.3 of the
	 *             Assignment Specification or contain an invalid customer code
	 *             (passed by another class).
	 * @throws LogHandlerException
	 *             If there was a problem with the log file not related to the
	 *             semantic errors above
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException {
		// TO DO
		BufferedReader br;
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		String line = new String();

		// Read lines from the input file
		try {
			br = new BufferedReader(new FileReader(filename));
			while ((line = br.readLine()) != null) {
				customerList.add(createCustomer(line));
			}
			br.close();
		} catch (Exception e) {
			throw new LogHandlerException("" + e);
		}
		return customerList;
	}

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in
	 * the log file ordered as they appear in the log file. .
	 * 
	 * @param filename
	 *            The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in
	 *         the log file ordered as they appear in the log file. .
	 * @throws PizzaException
	 *             If the log file contains semantic errors leading that violate
	 *             the pizza constraints listed in Section 5.3 of the Assignment
	 *             Specification or contain an invalid pizza code (passed by
	 *             another class).
	 * @throws LogHandlerException
	 *             If there was a problem with the log file not related to the
	 *             semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException {
		// TO DO
		////////////////////////////////////////
		BufferedReader br;
		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
		String line;

		// Read lines from the input file
		try {
			br = new BufferedReader(new FileReader(filename));
			while ((line = br.readLine()) != null) {
				pizzaList.add(createPizza(line));
			}
			br.close();
		} catch (Exception e) {
			throw new LogHandlerException("" + e);
		}
		return pizzaList;
		////////////////////////////////////////
	}

	/**
	 * Creates a Customer object by parsing the information contained in a
	 * single line of the log file. The format of each line is outlined in
	 * Section 5.3 of the Assignment Specification.
	 * 
	 * @param line
	 *            - A line from the log file
	 * @return- A Customer object containing the information from the line in
	 *          the log file
	 * @throws CustomerException
	 *             - If the log file contains semantic errors leading that
	 *             violate the customer constraints listed in Section 5.3 of the
	 *             Assignment Specification or contain an invalid customer code
	 *             (passed by another class).
	 * @throws LogHandlerException
	 *             - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException {
		// TO DO
		
		String[] index;

		// Read values from the lines, separated by commas
		try {
			index = line.split(COMMA);
		} catch (Exception e) {
			throw new LogHandlerException("" + e);
		}

		// Return values and create customers
		try {
			return CustomerFactory.getCustomer(index[4], index[2], index[3], Integer.parseInt(index[5]),
					Integer.parseInt(index[6]));
		} catch (CustomerException e) {
			throw e;
		} catch (Exception e) {
			throw new LogHandlerException("" + e);
		}
	}

	/**
	 * Creates a Pizza object by parsing the information contained in a single
	 * line of the log file. The format of each line is outlined in Section 5.3
	 * of the Assignment Specification.
	 * 
	 * @param line
	 *            - A line from the log file
	 * @return- A Pizza object containing the information from the line in the
	 *          log file
	 * @throws PizzaException
	 *             If the log file contains semantic errors leading that violate
	 *             the pizza constraints listed in Section 5.3 of the Assignment
	 *             Specification or contain an invalid pizza code (passed by
	 *             another class).
	 * @throws LogHandlerException
	 *             - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException {
		// TO DO
		/////////////////////////////////////

		String[] pizzaStr;

		// Read values from the lines, separated by commas
		try {
			pizzaStr = line.split(COMMA);
		} catch (Exception e) {
			throw new LogHandlerException("" + e);
		}

		// Return values and create pizza
		try {
			LocalTime orderTime = LocalTime.parse(pizzaStr[0], DateTimeFormatter.ofPattern("HH:mm:ss"));
			LocalTime deliveryTime = LocalTime.parse(pizzaStr[1], DateTimeFormatter.ofPattern("HH:mm:ss"));
			String pizzaCode = pizzaStr[7];
			int quantity = Integer.parseInt(pizzaStr[8]);
			return PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);
		} catch (PizzaException e) {
			throw e;
		} catch (Exception e) {
			throw new LogHandlerException("" + e);
		}

		/////////////////////////////////////
	}

}
