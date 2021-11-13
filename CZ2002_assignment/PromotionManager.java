package CZ2002_assignment;
import java.util.*;

public class PromotionManager {

	private ArrayList<Promotion> arrayOfPromotions = new ArrayList<Promotion>();
	public PromotionManager() {
	}
	
	public void addPromo(Promotion newPromo) {
		
		arrayOfPromotions.add(newPromo);
		System.out.println("New Promotion added!");
	}
	
	public void removePromotion(int index) {
		boolean flag = false;
		for(int i = 0; i<this.arrayOfPromotions.size(); i++) {
			if(this.arrayOfPromotions.get(i).getIndex() == index) {
				this.arrayOfPromotions.remove(i);
				flag = true;
				System.out.println("Successfully removed! \n");
			}
		}
		if (flag == false){
			System.out.println("No such index found! Try Again \n");
		}
	}

	public ArrayList<Promotion> getArrayOfPromotions() {
		return arrayOfPromotions;
	}
	
	public Promotion getPromotion(int index) {
		Promotion promo = null;
		for(int i = 0; i<this.arrayOfPromotions.size(); i++) {
			if(this.arrayOfPromotions.get(i).getIndex() == index) {
				promo = this.arrayOfPromotions.get(i);
				System.out.println("Successfully identified Promotion Index");
			}
		}
				
		if(promo == null) {
			System.out.println("Promotion with this Index does not exist");
		}
		return promo;
		
	}	
	
	
}
