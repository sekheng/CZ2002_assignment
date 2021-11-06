package CZ2002_assignment;

import java.util.Scanner;
import java.util.ArrayList;
public class StaffMgr {

    /**
     * Constructs a new Scanner object
     * sc contains the reference to the Scanner object
     */
    Scanner sc = new Scanner(System.in);

    /**
     * creates an ArrayList called staffList to hold each staff in as an element
     */
    private ArrayList<Staff> staffList = new ArrayList<Staff>();


    /**
     * this is a method to call the Staff constructor
     * with user input for staff values of the name, gender, employeeID, and jobTitle
     * @param name will be input into the Staff constructor name parameter
     * @param gender will be input into the Staff constructor gender parameter
     * @param employeeID will be input into the Staff constructor employeeID parameter
     * @param jobTitle will be input into the Staff constructor jobTitle parameter
     * when all inputs are valid the new Staff object will be added as an element in the staffList Arraylist
     * a message will also be printed to confirm the addition
     */
    public void createStaff(String name, int gender, String employeeID, String jobTitle){
        Staff a = new Staff(name, gender, employeeID, jobTitle);
        staffList.add(a);
        System.out.println(a.getName() + " added to staffList");
    }


    /**
     * this is a method to call the select a staff
     * the entire staffList ArrayList will be printed out
     * then we ask Arraylist index as user input to select which staff to login as
     * @return the staff object index they selected
     */
    public Staff selectStaff(){             //in sequence diagram there is staff login but in class diagram theres no method, so unsure abt this
        staffList.forEach(Staff -> {
            System.out.println(Staff);
        });

        System.out.println("please login as one staff");
        int i = sc.nextInt();        
        return staffList.get(i+1);
    }
}
