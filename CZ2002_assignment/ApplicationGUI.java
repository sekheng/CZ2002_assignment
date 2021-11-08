package CZ2002_assignment;
import java.util.*;
public class ApplicationGUI
import java.time.LocalDateTime;
{
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        System.out.println("code out application GUI");
        
        
        // user should already get the specific item from menu item manager
        // user select the attribute of the menu item to update
        // put in the correct value
        // 

        StaffMgr myStaffMgr = new StaffMgr();
        ReservationManager myReservationManager;
        
        System.out.println("Enter total number of small tables in this restaurant:");
        int smalltables = sc.nextInt();
        System.out.println("Enter total number of medium tables in this restaurant:");
        int medtables = sc.nextInt();
        System.out.println("Enter total number of large tables in this restaurant:");
        int largetables = sc.nextInt();
        
        myReservationManager = new ReservationManager(smalltables,medtables,largetables);
        System.out.println("Press 1 to make reservation :");
        if(sc.nextInt() == 1) {
        	System.out.println("How many tables would you like to book? (Each table can hold a maximum of 10 people)");
        	int noOfDesiredTables = sc.nextInt();
        	for (int i =0; i<noOfDesiredTables; i++) {
        		System.out.printf("Number of people on Table %d:",i+1);
        		int noOfPeople = sc.nextInt();
        		System.out.printf("What time would you like to book the reservation for? (YYYY-MM-DDTHH:MM:SS) ");
        		// Split string 
        		// UseLocalDateTime.of()
        		//Get Customer Name ID Contact 
        		//Call Add Reservation 
        		
        	}
        }
        
        
        
    }
}