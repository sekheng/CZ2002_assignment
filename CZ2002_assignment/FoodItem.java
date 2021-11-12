package CZ2002_assignment;

public class FoodItem extends ObjectName{

	    /**
	     * priceInCents of the object
	     */
	    protected double priceInCents;

	    /**constructs an ObjectNamePrice object with given name and priceInCents
	     * @param name This object's name
	     * @param priceInCents This object's priceInCents
	     */
	    public FoodItem (double price, String name){
	        super(name);
	        this.priceInCents=price;
	    }

	    /**
	     * Gets the priceInCents of this object
	     * @return this object's priceInCents
	     */
	    public double getPriceInCents(){
	        return this.priceInCents;
	    }
	    
	    /**
	     * Changes the priceInCents of the object
	     * @param newPrice is the object's new priceInCents
	     */
	    public void setPriceInCents(int newPrice){
	        this.priceInCents=newPrice;
	    }
}
