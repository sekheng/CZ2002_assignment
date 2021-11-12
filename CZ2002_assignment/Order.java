package CZ2002_assignment;

import java.util.*;

public class Order {
	
	private Staff CurrentStaff;
	private int TableID;
	private ArrayList<FoodItem>  arrayOfFoodItem = new ArrayList<FoodItem>();

	public Order(Staff CurrentStaff, int TableID) {
		this.CurrentStaff = CurrentStaff;
		this.TableID = TableID;
	}
	
	public Staff getStaff() {
		return this.CurrentStaff;
	}
	
	public ArrayList<FoodItem> getArrayOfFoodItem(){
		return this.arrayOfFoodItem;
	}
	
	public int getTableID() {
		return this.TableID;
	}

	public void setArrayOfFoodItem(ArrayList<FoodItem> arrayOfFoodItem) {
		this.arrayOfFoodItem = arrayOfFoodItem;
	}
	
	public void addItem(FoodItem food) {
		this.arrayOfFoodItem.add(food);
	}
	
	public void viewOrder() {
		System.out.printf("%30s","Order for %d", TableID);
		for (int i =0; i<arrayOfFoodItem.size(); i++) {
			String name = arrayOfFoodItem.get(i).getName();
			System.out.printf("Item %d : %-20s", (i+1), name);
		}
	}
}
