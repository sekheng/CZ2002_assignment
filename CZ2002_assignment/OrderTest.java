package CZ2002_assignment;

import java.util.*;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.Test;
import java.time.*;

public class OrderTest {

	@Test
	public void test() {
		
		Staff stafftest;
		Scanner sc = new Scanner(System.in);
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
		
		sc.nextLine();
		System.out.println("Enter start Date: YYYY-MM-DD HH:MM:SS ");
		
		String s = sc.nextLine();
		
		System.out.println("Enter end Date: YYYY-MM-DD HH:MM:SS ");
		
		String e = sc.nextLine();
		LocalDateTime startDate = LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
		LocalDateTime endDate = LocalDateTime.parse(e, DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
		
		revenueReport.GetOrderInvoice(startDate, endDate);
		
	}

}
