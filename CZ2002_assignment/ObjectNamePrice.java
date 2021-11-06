package CZ2002_assignment;

public class ObjectNamePrice extends ObjectName{

    /**
     * price of the object
     */
    protected int price;

    /**constructs an ObjectNamePrice object with given name and price
     * @param name This object's name
     * @param price This object's price
     * we call the superclass ObjectName constructor and input @param name into it
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
