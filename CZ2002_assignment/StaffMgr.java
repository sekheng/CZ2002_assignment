package CZ2002_assignment;

import java.util.Scanner;
import java.util.ArrayList;
public class StaffMgr {
    private Staff currentStaff;
    /**
     * Constructs a new Scanner object
     * sc contains the reference to the Scanner object
     */
    Scanner sc = new Scanner(System.in);

    /**
     * creates an ArrayList called staffList to hold each staff in as an element
     */
    private ArrayList<Staff> staffList = new ArrayList<Staff>();

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
     * this is a method to call the select a staff
     * the entire staffList ArrayList will be printed out
     * then we ask Arraylist index as user input to select which staff to login as
     * @return the staff object index they selected
     */
    public Staff selectStaff()
    {
        Scanner sc = new Scanner(System.in);
        for (int q=0; q<staffList.size();q++)
            {
                System.out.print(staffList.get(q).getName()+", ");
            }

        System.out.println("enter staff index");
        currentStaff = staffList.get(sc.nextInt());
        sc.close();
        return currentStaff;
    }
}
