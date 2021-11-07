package CZ2002_assignment;

import java.util.*;

public class Order {
	
	private Staff CurrentStaff;
	private int TableID;
	private ArrayList<FoodItem>  arrayOfFoodItem;
	
	
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
}
