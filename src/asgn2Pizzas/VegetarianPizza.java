package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.PizzaException;


/**
 * 
 *  A class that represents a vegetarian pizza made at the Pizza Palace restaurant. 
 *  The vegetarian pizza has certain toppings listed in Section 5.1 of the Assignment Specification Document.  
 *  A description of the class's fields and their constraints is provided in Section 5.1 of the Assignment Specification.
 * 
 * @author Kihoon Seo n8998949
 *
 */
public class VegetarianPizza extends Pizza {
	
	///////////////////////////////////////////////
	private static final String type = "Vegetarian";
	private static int priceOfPizzs = 10;
	///////////////////////////////////////////////

	/**
	 * 
	 *  This class represents a vegetarian pizza made at the  Pizza Palace restaurant. The vegetarian pizza has certain
	 *  toppings listed in Section 5.1 of the Assignment Specification Document.  A description of the class's
	 *  fields and their constraints is provided in Section 5.1 of the Assignment Specification.
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification are violated. 
	 * 
     * <P> PRE: TRUE
	 * <P> POST: All field values including the cost per pizza are set
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 *
	 */
	public VegetarianPizza(int quantity, LocalTime orderTime, LocalTime deliveryTime) throws PizzaException {
		// TO DO
		///////////////////////////////////////////////
		super(quantity, orderTime, deliveryTime, type, priceOfPizzs);
		////////////////////////////////////////////////
/*		
		if (quantity < 0 || quantity > 10) {
			throw new PizzaException("The number of odered pizza must be between 1 to 10.");
		}
		
		if (orderTime.isBefore(LocalTime.of(19, 00, 00)) || orderTime.isAfter(LocalTime.of(23, 00, 00))) {
			throw new PizzaException("You can place order only between 7pm to 11pm.");
		}
		
		if (deliveryTime.isBefore(LocalTime.of(19, 10, 00)) || orderTime.isAfter(LocalTime.of(24, 00, 00))) {
			throw new PizzaException("Invalid delivery time.");
		}
*/
		
	}

}
