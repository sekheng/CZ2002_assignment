package CZ2002_assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class OrderTest {

	@Test
	public void test() {
		
		Staff stafftest;
		stafftest = new Staff("Katy", 20, "5U34582", "Manager");
		Order testOrder1 = new Order(stafftest, 8);
		
		FoodItem foodItem = new FoodItem(170,"Fried Rice");
		FoodItem foodItem2 = new FoodItem(270,"Hakka Noodles");
		testOrder1.addItem(foodItem);
		testOrder1.addItem(foodItem2);
		OrderManager test = new OrderManager();
		test.addOrder(testOrder1);
		OrderInvoice testinvoice = new OrderInvoice(testOrder1, 0, 0);
		test.printReceipt(8, 3, 2);
		
	}

}
