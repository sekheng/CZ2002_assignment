package CZ2002_assignment;
import java.util.*;
/**
 * To handle promotions
 * @author	Lee Sek Heng
 * @version	1.0
 * @since	2021-11-05
 */
public class PromotionManager {
	/**
	 * to assign ID for promotions
	 */
	private int promoID =1;
	/**
	 * list of promotions
	 */
	private ArrayList<Promotion> arrayOfPromotions = new ArrayList<Promotion>();
	/**
	 * constructor for promotion manager
	 */
	public PromotionManager() {
	}
	/**
	 * to assign ID for the promotion
	 * @return
	 */
	public int assignID() {
		int ID = this.promoID;
		this.promoID++;
		return ID;
	}
	/**
	 * To add promotion into array of promotions
	 * @param newPromo	pass in the promotions
	 */
	public void addPromo(Promotion newPromo) {
		
		arrayOfPromotions.add(newPromo);
		System.out.println("New Promotion added!");
	}
	/**
	 * to remove the promotion via it's index
	 * @param index	promotion's index
	 */
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
	/**
	 * to get the array of promotions
	 * @return	it's array of promotions
	 */
	public ArrayList<Promotion> getArrayOfPromotions() {
		return arrayOfPromotions;
	}
	/**
	 * to get the promotion via the index
	 * @param index	promotion's index
	 * @return	promotion
	 */
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
	/**
	 * print the promotions for the application GUI
	 */
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
