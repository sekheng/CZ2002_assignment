package CZ2002_assignment;
import java.util.*;

public class PromotionManager {

	private ArrayList<Promotion> arrayOfPromotions = new ArrayList<Promotion>();
	public PromotionManager() {
	}
	
	public void createPromotion(String name,int Price, ArrayList<MenuItem> list, int index) {
		Promotion newPromo = new Promotion(Price, name, list,index);
		arrayOfPromotions.add(newPromo);
	}
	
	public void removeReservation(int index) {
		for(int i = 0; i<this.arrayOfPromotions.size(); i++) {
			if(this.arrayOfPromotions.get(i).getIndex() == index) {
				this.arrayOfPromotions.remove(i);
			}
		}
	}

	public ArrayList<Promotion> getArrayOfPromotions() {
		return arrayOfPromotions;
	}
	
}
