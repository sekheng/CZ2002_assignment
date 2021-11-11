package CZ2002_assignment;

import java.util.*;
import java.time.LocalDateTime;

public class OrderInvoice {
	
	private float tax;
	private float discount;
	private LocalDateTime currentTime;
	private Order attachedOrder;
	private String restaurantName;
	
	public OrderInvoice(Order attachedOrder, LocalDateTime currentTime, float discount, float tax) {
		this.attachedOrder = attachedOrder;
		this.currentTime = currentTime;
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
		float discount = this.discount;
		System.out.println(restaurantName);
	}
	
	
}
