package CZ2002_assignment;

/**
    Represents an object that has a name and price
    @author    Kevin Patrick Santoso
    @version   1.0
    @since     2021-06-11
 */
public class ObjectNamePrice extends ObjectName{

    /**
     * price of the object
     */
    protected int price;

    /**constructs an ObjectNamePrice object with given name and price
     * @param name This object's name
     * @param price This object's price
     */
    public ObjectNamePrice (int price, String name){
        super(name);
        this.price=price;
    }

    /**
     * Gets the price of this object
     * @return this object's price
     */
    public int getPrice(){
        return this.price;
    }
    
    /**
     * Changes the price of the object
     * @param newPrice is the object's new price
     */
    public void setPrice(int newPrice){
        this.price=newPrice;
    }
}
