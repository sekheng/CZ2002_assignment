package CZ2002_assignment;
import java.util.*;

public class Promotion extends FoodItem {
	private ArrayList<MenuItem> arrayOfItems = new ArrayList<MenuItem>();	
	private int index;
	
	public Promotion(int price, String name, ArrayList<MenuItem> items,int index) {
		super(price, name);
		// TODO Auto-generated constructor stub
		this.arrayOfItems = items;
		this.index = index;
	}
	
	public Promotion(int price, String name, int index) {
		super(price, name);
		// TODO Auto-generated constructor stub
		this.index = index;
	}

	public ArrayList<MenuItem> getArrayOfItems() {
		return arrayOfItems;
	}

	public int getIndex() {
		return index;
	}

	public void addItem(MenuItem menuItem) {
		this.arrayOfItems = this.getArrayOfItems();
		this.arrayOfItems.add(menuItem);
	}
	
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
	
	public String stringOfNames() {
		String names = "";
		for(int i = 0; i<this.arrayOfItems.size();i++) {
			names = names + " " + this.arrayOfItems.get(i).getName() + " ";
		}
		return names;
	}
	
   
}
	
	

