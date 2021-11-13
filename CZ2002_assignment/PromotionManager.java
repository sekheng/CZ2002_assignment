package CZ2002_assignment;
import java.util.*;

public class PromotionManager {
	private int promoID =1;
	private ArrayList<Promotion> arrayOfPromotions = new ArrayList<Promotion>();
	public PromotionManager() {
	}
	public int assignID() {
		int ID = this.promoID;
		this.promoID++;
		return ID;
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
	
	public void printPromotions() {
		for(int i = 0; i<this.arrayOfPromotions.size(); i++) {
			System.out.println("-----------AVAILABLE PROMOTIONS---------");
			System.out.printf("%-20s","Name");
			System.out.printf("%20s","Index \n");
			System.out.printf("%-20s",arrayOfPromotions.get(i).getName());
			System.out.printf("%20d \n",getArrayOfPromotions().get(i).getIndex() );
		}
	}

	
	
}
