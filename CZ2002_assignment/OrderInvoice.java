package CZ2002_assignment;

import java.util.*;

public class OrderInvoice {
	
	private float tax;
	private float discount;
	private Date localDateTime;
	private Order AttachedOrder;
	
	public float getTotalCost(Order AttachedOrder, float tax, float discount) {
		ArrayList<FoodItem> arrayOfFoodItems = AttachedOrder.getArrayOfFoodItem();
		float cost =0;
		for(int i=0;i<arrayOfFoodItems.size();i++) {
			cost=cost+arrayOfFoodItems.get(i).getPriceInCents();
		}
		
		cost= cost+cost*(tax/100);
		cost = cost - discount*cost;
		return cost;
	}
	
	
	
}
