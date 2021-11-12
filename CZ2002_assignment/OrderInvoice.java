package CZ2002_assignment;

import java.util.*;
import java.text.*;
import java.time.LocalDateTime;

/**
Represents a Order Invoice 
An Order Invoice contains one order assigned to a table
An Order can contain multiple Food Items

@author Kanupriya Malhotra 
@version 1.0
@since 2021-11-10
*/

public class OrderInvoice {
	
	/**
	 * The tax applied on the order in percentage 
	 */
	private float tax;
	
	
	/**
	 * The discount applied on the order in percentage 
	 */
	private float discount;
	
	/**
	 * The date and time of the Order Invoice's issue 
	 */
	private LocalDateTime currentTime;
	
	/**
	 * The Order attached to the invoice containing food items 
	 */
	private Order attachedOrder;
	
	/**
	 * The name of the restaurant
	 */
	private static String restaurantName = "Food Express";
	
	
	/**
	 * Creates a new Order Invoice with a given Order
	 * The date and time is typically the time of Order Invoice creation
	 * @param attachedOrder This OrderInvoice's attached Order.
	 * @param discount This OrderInvoice's discount.
	 * @param tax This OrderInvoice's tax.
	 * @param dateTime This OrderInvoice's time of creation. 
	 */
	
	public OrderInvoice(Order attachedOrder, LocalDateTime dateTime, float tax,float discount) {
		this.attachedOrder = attachedOrder;
		this.discount = discount;
		this.tax = tax;
		this.currentTime = dateTime;
	}
	
	
	/**
	 * Calculates the total cost by adding the prices and incorporating taxes and discounts 
	 * @return the total cost payable by the customer, including discounts and taxes. 
	 */
	public double getTotalCost() {
		ArrayList<FoodItem> arrayOfFoodItems = this.attachedOrder.getArrayOfFoodItem();
		double cost =0;
		for(int i=0;i<arrayOfFoodItems.size();i++) {
			cost=cost+(arrayOfFoodItems.get(i).getPriceInCents()/100);
		}
		cost= cost+(cost*(this.tax/100));
		cost = cost - ((this.discount/100)*cost);
		return cost;
	}
	
	/**
	 * Formats and prints out the receipt of the OrderInvoice
	 * Includes the Table ID and time of Invoice Creation
	 * Includes the name and price of each food item 
	 * Includes the total cost, after tax and discount has been applied
	 */
	public void formatReceipt() {
		double cost = this.getTotalCost();
		float tax = this.tax;
		String stars = new String(new char[40]).replace('\0', '*');
		float discount = this.discount;
		
		String[] dateTime = currentTime.toString().split("T");
		System.out.printf("%22s","Table ID :");
		System.out.println(attachedOrder.getTableID() + '\n');
		System.out.printf("%22s",restaurantName+'\n'+'\n');
		System.out.printf("%-20s",dateTime[0]);
		System.out.printf("%20s",dateTime[1]+'\n');
		
		System.out.print(stars+'\n');
		ArrayList<FoodItem> arrayOfFoodItems = attachedOrder.getArrayOfFoodItem();
		for(int i=0;i<arrayOfFoodItems.size();i++) {
			String foodName  = arrayOfFoodItems.get(i).getName();
			double price = arrayOfFoodItems.get(i).getPriceInCents();
			double finalprice = price/100;
			System.out.printf("%-20s | ", foodName );
			System.out.printf("%.2f",finalprice );
			System.out.printf("\n");
		}
		
		System.out.printf("%-20s | ", "Tax");
		System.out.printf("%.2f %",tax);
		System.out.printf("%-20s | ", "Discount");
		System.out.printf("%.2f %",discount);
		System.out.printf("%-20s | ", "Total");
		System.out.printf("%.2f",cost);	
		System.out.println();
		System.out.println();
		
	}
	
	/**
	 * Gets the Order attached to the Order Invoice 
	 * @return This Order Invoice's Order 
	 */
	public Order getOrder() {
		return this.attachedOrder;
	}
	
	/**
	 * Gets the date and time of creation of the Order Invoice 
	 * @return This Order Invoice's time of creation 
	 */
	public LocalDateTime getTime() {
		return this.currentTime;
	}

}
