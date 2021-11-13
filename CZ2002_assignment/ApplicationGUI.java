package CZ2002_assignment;
import java.util.*;
import java.time.*;

public class ApplicationGUI
{
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        System.out.println("code out application GUI");
        
       OrderManager restaurantOrderManager =  new OrderManager();
       ReservationManager restaurantReservationManager = new ReservationManager();
       MenuItemMgr restaurantMenuItemMgr = new MenuItemMgr();
       PromotionManager restaurantPromoManager = new PromotionManager();
       
       
       
        
        //Reservation Manager Test
        //StaffMgr myStaffMgr = new StaffMgr();

        
        
        System.out.println("Welcome to Food Express' Restaurant Reservation and Point of Sale System");
        System.out.println("The capacity of all Tables is as follows:");
        System.out.println(" There are  10 small tables in the restaurant with a max capacity of 2 pax");
        System.out.println("There are  15 medium tables in the restaurant with a max capacity of 6 pax");
        System.out.println("There are  10 large tables in the restaurant with a max capacity of 10 pax");
        
        
        System.out.println("Press the following to perform the following function:");
        System.out.println(" 1. Create/Update/Remove menu item \n 2. Create/Update/Remove promotion  \n 3. Create order \n 4. View Order \n"
        		+ " 5. Add/Remove order item/s to/from order \n 6. Create reservation booking \n 7. Check/Remove reservation booking \n 8. Check table availability) \n"
        		+ " 9. Print order invoice \n 10. Print sale revenue report by period (eg day or month)");
        
        
//        
//        System.out.println("Press 1 to make reservation :");
//        if(sc.nextInt() == 1) {
//        	System.out.println("How many tables would you like to book? (Each table can hold a maximum of 10 people)");
//        	int noOfDesiredTables = sc.nextInt();
//
//        	for (int i =0; i<noOfDesiredTables; i++) {
//        		System.out.printf("Number of people on Table %d:",i+1);
//        		int noOfPeople = sc.nextInt();
//        		
//        		System.out.println("Enter Customer Name ");
//        		String customerName = sc.next();
//        		System.out.print("Enter customer ID ");
//        		int customerID = sc.nextInt();
//        		System.out.println("Enter customer Gender (1-male, 2-female)");
//        		int customerGender = sc.nextInt();
//        		System.out.println("Is customer a member? True/False");
//        		boolean membershipStatus = sc.nextBoolean();
//        		System.out.println("What time would you like to book the reservation for? (YYYY-MM-DD-HH-MM) ");
//        		// Split string 
//        		String str = sc.next();
//        		String[] substrings = str.split("-");
//        		int year = Integer.parseInt(substrings[0]);
//        		int month = Integer.parseInt(substrings[1]);
//        		int dayOfMonth = Integer.parseInt(substrings[2]);
//        		int hour = Integer.parseInt(substrings[3]);
//        		int minutes = Integer.parseInt(substrings[4]);
//        		LocalDateTime resTime = LocalDateTime.of(year, month, dayOfMonth, hour, minutes);
//        		
//
//        		myReservationManager.AddReservation(noOfPeople, resTime, customerName, customerID, customerGender, membershipStatus);
//        		
//        	}
//        	System.out.println("Checking all reservation");
//        	myReservationManager.CheckAllReservation();
//        	
//        	System.out.println("Press 2 to check reservation:");
//        	if(sc.nextInt()==2) {
//        		System.out.println("Enter customer ID");
//        		int customerID = sc.nextInt();
//        		myReservationManager.CheckReservation(customerID);
//        	}
//    		//myReservationManager.RemoveReservation(customerID);
//        	
//        	System.out.println("Press 3 to remove reservation:");
//        	if(sc.nextInt()==3) {
//        		System.out.println("Enter customer ID");
//        		int customerID= sc.nextInt();
//        		myReservationManager.RemoveReservationCustomerID(customerID);
//        	}
//        }
//        
//        
        
    }
}