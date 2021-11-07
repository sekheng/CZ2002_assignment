package CZ2002_assignment;

/**
    Represents the MenuItems available to order
    @author    Kevin Patrick Santoso
    @version   1.0
    @since     2021-06-11
 */
public class MenuItem extends FoodItem {


    /**
     * description of a menuItem object
     */
    private String description;


    /**
     * the type of menuItem object (appetizer,main course, drinks)
     */
    private String type;


    /**
     * Creates a new menu item with given name, description, type, and priceInCents
     * @param priceInCents This menuItem's priceInCents
     * @param description This menuItem's description
     * @param name This menuItem's name
     * @param type This menuItem's type
    */
    public MenuItem (int priceInCents, String description, String name, String type){
        super(priceInCents, name);
        this.description=description;
        this.type=type;
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
     * Gets the type of this menuItem object
     * @return this menuItem's type
     */
    public String getType(){
        return this.type;
    }

    /**
     * Changes the type of the menuItem
     * @param newType is the menuItem's new description
     */
    public void setType(String newType){
        this.type=newType;
    }
    
}
