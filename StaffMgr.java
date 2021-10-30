import java.util.Scanner;
import java.util.ArrayList;
public class StaffMgr {
    Scanner sc = new Scanner(System.in);

    private ArrayList<Staff> staffList = new ArrayList<Staff>();  //staffList is an ArrayList for Staff

    public void createStaff(String name, int gender, String employeeID, String jobTitle){
        Staff a = new Staff(name, gender, employeeID, jobTitle);
        staffList.add(a);
        System.out.println(a.getName() + " added to staffList");
    }

    public Staff selectStaff(){
        staffList.forEach(Staff -> {
            System.out.println(Staff);
        });

        System.out.println("please login as one staff");
        int i = sc.nextInt();        
        return staffList.get(i+1);
    }
}
