package CZ2002_assignment;

public class MenuItem {

    //name of menuItem
    private String name;
    //description of a menuItem object
    private String description;
    //the type of menuItem object (appetizer, drinks, etc)
    private String type;
    //price of a menuItem object
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


    //method to get name
    public String getName(){
        return this.name;
    }

    //public to set name
    public void setName(String newName){
        this.name=newName;
    }

    //method to get description
    public String getDescription(){
        return this.description;
    }

    //method to set description
    public void setDescription(String description){
        this.description=description;
    }

    //method to get price
    public int getPrice(){
        return this.price;
    }

    //method to set price
    public void setPrice(int price){
        this.price=price;
    }
}
