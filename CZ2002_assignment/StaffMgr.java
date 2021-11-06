package CZ2002_assignment;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
    To manage a list of Staffs
    and select staff for logging in
    @author    Kevin Patrick Santoso
    @version   1.0
    @since     2021-06-11
 */
public class StaffMgr {

    /**
     * represents the staff that is logged in
     */
    private Staff currentStaff;


    /**
     * creates an ArrayList called staffList to hold all staff
     */
    private ArrayList<Staff> staffList = new ArrayList<Staff>();

    /**
     * Constructor for a StaffMgr object
     * when constructor is called, staffList will copy the ArrayList returned from StaffFactory
     */
    public StaffMgr()
    {
        try
        {
            staffList = StaffFactory.createStaff("StaffData.txt");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * adds a menu item to the menu item list
     * @param name This staff's name
     * @param gender This staff's gender
     * @param employeeID This staff's employee ID
     * @param jobTitle This staff's job title
     * @throws InputMismatchException
     */
    public void createStaff(String name, int gender, String employeeID, String jobTitle) throws InputMismatchException{
        Staff temp = new Staff(name, gender, employeeID, jobTitle);
        staffList.add(temp);
    }

    /**
     * method to select a staff
     * @param i is the index for the staff to be selected
     * @return the staff selected
     * @throws ArrayIndexOutofBoundsException
     */
    public Staff selectStaff(int i) throws ArrayIndexOutOfBoundsException
    {
        currentStaff = staffList.get(i);
        return currentStaff;
    }

    /**
     * method to remove a staff from the staffList
     * @param i is the index for the menuItem object to be deleted
     * deletes selected staff
     * @throws ArrayIndexOutOfBoundsException
     */
    public void removeObjectName(int i) throws ArrayIndexOutOfBoundsException
    {
        staffList.remove(i);
    }

    /**
     * gets the list of staff
     * @return staffList
     */
    public ArrayList<Staff> getArrayOfObjectName(){
        return staffList;
    };
}
