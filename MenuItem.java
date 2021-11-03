package CZ2002_assignment;

public class MenuItem {

    /**
     * name of menuItem
     */
    private String name;


    /**
     * description of a menuItem object
     */
    private String description;


    /**
     * the type of menuItem object (appetizer, drinks, etc)
     */
    private String type;

    /**
     * price of a menuItem object
     */
     private int price;


    /**constructs a menuItem object with given name, description, type, and price
     * @param price This menuItem's price
     * @param description This menuItem's description
     * @param name This menuItem's name
     * @param type This menuItem's type
    */
    public MenuItem (int price, String description, String name, String type){
        this.name=name;
        this.description=description;
        this.type=type;
        this.price=price;
    }


    /**
     * Gets the name of this menuItem object
     * @return this menuItem's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Changes the name of the menuItem
     * @param newName is the menuItem's new name
     */
    public void setName(String newName){
        this.name=newName;
    }

    /**
     * Gets the description of this menuItem object
     * @return this menuItem's description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Changes the description of the menuItem
     * @param newDescription is the menuItem's new description
     */
    public void setDescription(String newDescription){
        this.description=newDescription;
    }

    /**
     * Gets the price of this menuItem object
     * @return this menuItem's price
     */
    public int getPrice(){
        return this.price;
    }

    /**
     * Changes the price of the menuItem
     * @param newPrice is the menuItem's new price
     */
    public void setPrice(int newPrice){
        this.price=newPrice;
    }
}
