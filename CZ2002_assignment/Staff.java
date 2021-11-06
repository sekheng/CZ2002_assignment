package CZ2002_assignment;

/**
    represents a staff working in the restaurant
    @author    Kevin Patrick Santoso
    @version   1.0
    @since     2021-06-11
 */
public class Staff extends ObjectName {

    /**
     * gender of a staff
     */
    private int gender;

    /**
     * employeeID of a staff
     */
    private String employeeID;

    /**
     * job title of a staff
     */
    private String jobTitle;


    /**
     * constructs a staff object with given name, gender, employeeId, and jobTitle
     * @param name This staff's name
     * @param gender This staff's gender
     * @param employeeID This staff's employee ID
     * @param jobTitle This staff's job title
    */
    public Staff(String name, int gender, String employeeID, String jobTitle){
        super(name);
        this.gender=gender;
        this.employeeID=employeeID;
        this.jobTitle=jobTitle;
    }

    /**
     * Gets the gender of the staff
     * @return this staff's gender
     */
    public int getGender(){
        return this.gender;
    }


    /**
     * Gets the employeeID of the staff
     * @return this staff employeeID
     */
    public String getEmployeeID(){
        return this.employeeID;
    }


    /**
     * Gets the jobTitle of the staff
     * @return this staff's jobTitle
     */
    public String getJobTitle(){
        return this.jobTitle;
    }
}
