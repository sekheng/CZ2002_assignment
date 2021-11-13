package CZ2002_assignment;

import java.util.*;


/**
Represents an Order 
Each Order can only be assigned to one Table 
Each Order consists of an array of food items 
@author Kanupriya Malhotra 
@version 1.0
@since 2021-11-10
*/


public class Order {
	
	/**
	 * Staff Object Composition Indicating the Staff Assigned to the specific Order or Table 
	 */
	private Staff currentStaff;
	
	/**
	 * Table ID Assigned to the Order  
	 */
	private int tableID;
	
	/**
	 * Array containing all the Food Items for that Order  
	 */
	private ArrayList<FoodItem>  arrayOfFoodItem = new ArrayList<FoodItem>();

	
	/**
	 * Creates a new Order with a given Staff Member assigned to a specific Table 
	 * @param CurrentStaff Staff assigned to the Order 
	 * @param tableID Table assigned to the Order
	 */
	public Order(Staff currentStaff, int tableID) {
		this.currentStaff = currentStaff;
		this.tableID = tableID;
	}	
	
	
	
	/**
	 * adds single Food Item to array of Food Items in the Order 
	 * @param food item that needs to be added to Order 
	 */
	public void addItem(FoodItem food) {
		this.arrayOfFoodItem.add(food);
	}
	
	
	
	
	/**
	 * removes single Food Item from array of Food Items in the Order 
	 * @param name of food item that needs to be removed from Order 
	 */
	public void removeItem(String name) {
		boolean flag = false;
		for(int i =0; i<arrayOfFoodItem.size();i++) {
			if(arrayOfFoodItem.get(i).getName() == name) {
				arrayOfFoodItem.remove(i);
				System.out.println("Item successfully removed!");
				flag = true;
			}
		}
		if(flag == false) {
			System.out.println("No such item found in the order");
		}
	}
	
	
	
	
	/**
	 * Views the Details of the Order (Names of Food Items) 
	 */
	public void viewOrder() {
		System.out.printf("%20s","Order for Table ");
		System.out.println(this.tableID);
		for (int i =0; i<arrayOfFoodItem.size(); i++) {
			String name = arrayOfFoodItem.get(i).getName();
			System.out.printf("Item %d : %-20s |", (i+1), name);
		}
		String end = new String(new char[30]).replace('\0', '-');
		System.out.println(end);
	}
	
	
	
	
	/**
	 * gets Staff member assigned to the Order 
	 * @return Staff member assigned to the Order 
	 */
	public Staff getStaff() {
		return this.currentStaff;
	}
	
	
	
	/**
	 * gets Staff member assigned to the Order 
	 * @return Staff member assigned to the Order 
	 */
	public void setStaff(Staff staff) {
		 this.currentStaff =  staff;
	}
	
	
	
	/**
	 * gets Array of Food Items assigned to the Order 
	 * @return Array of Food Items belonging to the Order 
	 */
	public ArrayList<FoodItem> getArrayOfFoodItem(){
		return this.arrayOfFoodItem;
	}
	
	
	
	
	/**
	 * gets Table ID 
	 * @return Table ID that the Order is assigned to 
	 */
	public int getTableID() {
		return this.tableID;
	}

	
	
	
	/**
	 * sets Array of Food Item to Order 
	 * @param Array of Food Item that needs to be assigned to the Order 
	 */
	public void setArrayOfFoodItem(ArrayList<FoodItem> arrayOfFoodItem) {
		this.arrayOfFoodItem = arrayOfFoodItem;
	}

}
