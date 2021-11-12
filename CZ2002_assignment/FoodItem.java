package CZ2002_assignment;

/**
 * Base class meant for promotional package and menu item
 * @author Lee Sek Heng
 * @version 1.2
 * @since 2021-11-12
 */
public class FoodItem extends ObjectName{
		/**
		 * Exception to be thrown when the price when negative
		 * @author Lee Sek Heng
		 * @version 1.0
		 * @since 2021-11-12
		 */
		protected class IncorrectPriceException extends Exception
		{
			public IncorrectPriceException(String errorMessage)
			{
				super(errorMessage);
			}
		}
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
			setPriceInCents(price);
	    }

	    /**
	     * Gets the priceInCents of this object
	     * @return this object's priceInCents
	     */
	    public double getPriceInCents(){
	        return this.priceInCents;
	    }
	    
	    /**
	     * Changes the priceInCents of the object.
	     * @param newPrice is the object's new priceInCents. Do not put it less than 0!
	     */
	    public void setPriceInCents(int newPrice){
			try
			{
				if (newPrice >= 0)
	        		this.priceInCents=newPrice;
				else
					throw new IncorrectPriceException("price is below negative value!");
			}
			catch (Exception exception)
			{
				exception.printStackTrace();
			}
	    }
}
