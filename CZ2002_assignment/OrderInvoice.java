package CZ2002_assignment;

import java.util.*;
import java.text.*;
import java.time.LocalDateTime;

public class OrderInvoice {
	
	private float tax;
	private float discount;
	private LocalDateTime currentTime;
	private Order attachedOrder;
	private static String restaurantName = "SYAKKW";
	
	public OrderInvoice(Order attachedOrder, float discount, float tax) {
		this.attachedOrder = attachedOrder;
		this.discount = discount;
		this.tax = tax;
	}
	
	
	public double getTotalCost(Order AttachedOrder, float tax, float discount) {
		ArrayList<FoodItem> arrayOfFoodItems = AttachedOrder.getArrayOfFoodItem();
		float cost =0;
		for(int i=0;i<arrayOfFoodItems.size();i++) {
			cost=cost+arrayOfFoodItems.get(i).getPriceInCents();
		}
		cost= cost+(cost*(tax/100));
		cost = cost - discount*cost;
		return cost;
	}
	
	
	public void PrintReceipt() {
		double cost = this.getTotalCost(this.attachedOrder,this.tax,this.discount);
		float tax = this.tax;
		String stars = new String(new char[48]).replace('\0', '*');
		float discount = this.discount;
		String currentTime = LocalDateTime.now().toString();
		String[] dateTime = currentTime.split("T");
		System.out.printf("%22s",restaurantName+'\n'+'\n');
		System.out.printf("%-20s",dateTime[0]);
		System.out.printf("%20s",dateTime[1]+'\n');
		System.out.print(stars);
		
		
	}



	
}
