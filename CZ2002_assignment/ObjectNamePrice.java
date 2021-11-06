package CZ2002_assignment;

/**
    Represents an object that has a name and price in cents
    @author    Kevin Patrick Santoso
    @version   1.0
    @since     2021-06-11
 */
public class ObjectNamePrice extends ObjectName{

    /**
     * priceInCents of the object
     */
    protected int priceInCents;

    /**constructs an ObjectNamePrice object with given name and priceInCents
     * @param name This object's name
     * @param priceInCents This object's priceInCents
     */
    public ObjectNamePrice (int price, String name){
        super(name);
        this.priceInCents=price;
    }

    /**
     * Gets the priceInCents of this object
     * @return this object's priceInCents
     */
    public int getPriceInCents(){
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
