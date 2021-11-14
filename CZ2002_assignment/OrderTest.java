package CZ2002_assignment;

import java.time.LocalDateTime;


import org.junit.Test;
/**
 * To test order
 * @author		Lee Sek Heng
 * @version		1.0
 * @since		2021-11-13
 */
public class OrderTest {

	/**
	 * Test whether each of the functions work properly.
	 * the output at the debug console will show whether anything is printing
	 */
	@Test
	public void test() {
		
		Staff stafftest;
		stafftest = new Staff("Katy", 20, "5U34582", "Manager");

		Order testOrder1 = new Order(stafftest, 8);
		
		FoodItem foodItem = new FoodItem(170,"Fried Rice");
		FoodItem foodItem2 = new FoodItem(270,"Hakka Noodles");
		testOrder1.addItem(foodItem);
		testOrder1.addItem(foodItem2);
		
		
		OrderManager testManager = new OrderManager();
		testManager.addOrder(testOrder1);
		testOrder1.viewOrder();
		
		
		OrderInvoice testinvoice = new OrderInvoice(testOrder1, LocalDateTime.now(), 0, 0);
		testManager.printReceipt(8, 3, 2);
		
		RevenueReport revenueReport = testManager.getRevenueReport();
		
		LocalDateTime startDate = LocalDateTime.of(2011, 11, 11, 11, 11, 11);
		LocalDateTime endDate = LocalDateTime.of(2025, 11, 11, 11, 11, 11);
		
		revenueReport.StoreInvoice(testinvoice);
		revenueReport.GetOrderInvoice(startDate, endDate);
		// if everything is called successfully, then passed in here
	}

}
