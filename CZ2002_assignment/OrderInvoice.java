package CZ2002_assignment;

import java.util.*;
import java.text.*;
import java.time.LocalDateTime;

public class OrderInvoice {
	
	private float tax;
	private float discount;
	private LocalDateTime currentTime;
	private Order attachedOrder;
	private static String restaurantName = "Food Express";
	
	public OrderInvoice(Order attachedOrder, LocalDateTime dateTime, float tax,float discount) {
		this.attachedOrder = attachedOrder;
		this.discount = discount;
		this.tax = tax;
		this.currentTime = dateTime;
	}
	
	
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
		
		System.out.printf("%-20s | ", "Total");
		System.out.printf("%.2f",cost);	
		System.out.println();
		System.out.println();
		
	}
	
	public Order getOrder() {
		return this.attachedOrder;
	}
	
	public LocalDateTime getTime() {
		return this.currentTime;
	}

}
