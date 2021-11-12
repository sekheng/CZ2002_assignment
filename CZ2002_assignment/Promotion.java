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

	public ArrayList<MenuItem> getArrayOfItems() {
		return arrayOfItems;
	}

	public int getIndex() {
		return index;
	}

}
	
	
