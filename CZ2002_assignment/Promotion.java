package CZ2002_assignment;
import java.util.*;
/**
 * promotion package definition
 * @author	Kanupriya Malhotra, Swapneel Bhatt
 * @version	1.0
 * @since	2021-11-10
 */
public class Promotion extends FoodItem {
	/**
	 * array to contain all menu items
	 */
	private ArrayList<MenuItem> arrayOfItems = new ArrayList<MenuItem>();
	/**
	 * unique index to identify itself from menu items
	 */
	private int index;
	/**
	 * contructor for promotion
	 * @param price	price of promotion
	 * @param name	name of promotion
	 * @param items	all the menu items
	 * @param index	unique ID
	 */
	public Promotion(int price, String name, ArrayList<MenuItem> items,int index) {
		super(price, name);
		this.arrayOfItems = items;
		this.index = index;
	}
	/**
	 * constructor for promotion without menu items
	 * @param price	price of promotion
	 * @param name	name of promotion
	 * @param index	unique ID
	 */
	public Promotion(int price, String name, int index) {
		super(price, name);
		this.index = index;
	}
	/**
	 * get all menu items from promotion
	 * @return	all the menu items
	 */
	public ArrayList<MenuItem> getArrayOfItems() {
		return arrayOfItems;
	}
	/**
	 * index of promotion
	 * @return	index
	 */
	public int getIndex() {
		return index;
	}
	/**
	 * to add individual menu item into promotion
	 * @param menuItem	valid menu item
	 */
	public void addItem(MenuItem menuItem) {
		this.arrayOfItems.add(menuItem);
	}
	/**
	 * to remove the menu item from the promotion
	 * @param menuItem	the desired menu item
	 */
	public void removeItem(MenuItem menuItem) {
		boolean flag = false;
		for(int i =0; i<this.getArrayOfItems().size(); i++) {
			if(this.getArrayOfItems().get(i) == menuItem) {
				this.arrayOfItems.remove(i);
				System.out.println("Successfully removed menu item from Promotion....");
				flag = true;
			}
		}
		
		if(flag == false) {
			System.out.println("This item does not exist in promotion");
		}
	}
	/**
	 * meant for formatting of menu items in its menu items array
	 * @return	a string by concatenation of the menu items' name
	 */
	public String stringOfNames() {
		String names = "";
		for(int i = 0; i<this.arrayOfItems.size();i++) {
			names = names + " " + this.arrayOfItems.get(i).getName() + " ";
		}
		return names;
	}
	
   
}
	
	

