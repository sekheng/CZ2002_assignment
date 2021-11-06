package CZ2002_assignment;

import CZ2002_assignment.ObjectNamePrice;

public class MenuItem extends ObjectNamePrice {


    /**
     * description of a menuItem object
     */
    private String description;


    /**
     * the type of menuItem object (appetizer,main course, drinks)
     */
    private String type;


    /**constructs a menuItem object with given name, description, type, and price
     * @param price This menuItem's price
     * @param description This menuItem's description
     * @param name This menuItem's name
     * @param type This menuItem's type
     * we call the superclass ObjectNamePrice constructor and input @param price and @param name into it
    */
    public MenuItem (int price, String description, String name, String type){
        super(price, name);
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

    
}
