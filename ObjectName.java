package CZ2002_assignment;

public class ObjectName {
    
    /**
     * Name of the object
     */
    protected String name;



    /**constructs an ObjectName object with given name
     * @param name This object's name
     */
    public ObjectName (String name){
        this.name=name;
    }

    /**
     * Gets the name of this menuItem object
     * @return this menuItem's name
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Changes the name of the object
     * @param newName is the object's new name
     */
    public void setName(String newName){
        this.name=newName;
    }
}
