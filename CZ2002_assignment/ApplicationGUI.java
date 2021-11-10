package CZ2002_assignment;
import java.util.*;
import java.time.*;

public class ApplicationGUI
{
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        System.out.println("code out application GUI");
        
        
        // user should already get the specific item from menu item manager
        // user select the attribute of the menu item to update
        // put in the correct value
        // 
        
        
        //Reservation Manager Test
        //StaffMgr myStaffMgr = new StaffMgr();
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
        		System.out.println("What time would you like to book the reservation for? (YYYY-MM-DD-HH-MM) ");
        		// Split string 
        		String str = sc.next();
        		String[] substrings = str.split("-");
        		int year = Integer.parseInt(substrings[0]);
        		int month = Integer.parseInt(substrings[1]);
        		int dayOfMonth = Integer.parseInt(substrings[2]);
        		int hour = Integer.parseInt(substrings[3]);
        		int minutes = Integer.parseInt(substrings[4]);
        		LocalDateTime resTime = LocalDateTime.of(year, month, dayOfMonth, hour, minutes);
        		
        		System.out.println("Enter Customer Name");
        		String customerName = sc.next();
        		System.out.print("Enter customer ID");
        		int customerID = sc.nextInt();
        		System.out.println("Enter customer Gender (1-male, 2-female)");
        		int customerGender = sc.nextInt();
        		System.out.println("Is customer a member? True/False");
        		boolean membershipStatus = sc.nextBoolean();
        		myReservationManager.AddReservation(noOfPeople, resTime, customerName, customerID, customerGender, membershipStatus);
        		
        	}
    		//myReservationManager.CheckReservation(customerID);
    		//myReservationManager.RemoveReservation(customerID);
        }
        
        
        
    }
}