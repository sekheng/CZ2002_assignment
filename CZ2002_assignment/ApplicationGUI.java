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
       StaffMgr restaurantStaffMgr = new StaffMgr();
       
       
       
        
        //Reservation Manager Test
        //StaffMgr myStaffMgr = new StaffMgr();

        
        
        System.out.println("Welcome to Food Express' Restaurant Reservation and Point of Sale System");
        System.out.println("The capacity of all Tables is as follows:");
        System.out.println(" There are  10 small tables in the restaurant with a max capacity of 2 pax");
        System.out.println("There are  15 medium tables in the restaurant with a max capacity of 6 pax");
        System.out.println("There are  10 large tables in the restaurant with a max capacity of 10 pax");

        
        boolean i = true;
        do {
	        System.out.println("Press the following to perform the following function:");
	        System.out.println(" 1. Create/Update/Remove menu item \n 2. Create/Update/Remove promotion  \n 3. Create order \n 4. View Order \n"
	        		+ " 5. Add/Remove order item/s to/from order \n 6. Create reservation booking \n 7. Check/Remove reservation booking \n 8. Check table availability) \n"
	        		+ " 9. Print order invoice \n 10. Print sale revenue report by period (eg day or month) \n 11. Exit");
	        
	        
	        Integer input = sc.nextInt();
	       
	        
	        switch(input) {
	        
	        	case 1:
	        		System.out.println("Press one of the following options to perform the following function: ");
	        		System.out.println("1. Create Menu Item");
	        		System.out.println("2. Update Menu Item");
	        		System.out.println("3. Remove Menu Item");
	        		
	        		Integer input1 = sc.nextInt();
	        		
	        		switch(input1) {
	        			case 1:
	        				System.out.println("Enter name of item");
	        				String name = sc.next();
	        				System.out.println("Enter description of item");
	        				String desc = sc.next();
	        				System.out.println("Is the item an appetiser,maincourse, or drinks?");
	        				String type = sc.next();
	        				System.out.println("What is the price of the item (in cents) ?");
	        				int price = sc.nextInt();
	        				restaurantMenuItemMgr.createMenuItem(price,desc,name,type);
	        				System.out.println("Created item");
	        		
	        			case 2:
	        				System.out.println("Menu Item Updated");
	        			case 3: 
	        				System.out.println("Menu Item Removed");
	        				
	        			default:
	        				System.out.println("Please enter a valid Option");
	
	        		}
	        		
	        	case 2:
	        		System.out.println("Press one of the following options to perform the following function: ");
	        		System.out.println("1. Create Promotion");
	        		System.out.println("2. Update Promotion");
	        		System.out.println("3. Remove Promotion");
	        		
	        		Integer input2 = sc.nextInt();
	        		
	        		switch(input2) {
	    			case 1:
	    				System.out.println("Created Promotion");
	    		
	    			case 2:
	    				System.out.println("Promotion Updated");
	    			case 3: 
	    				System.out.println("Promotion Removed");
	    				
	    			default:
	    				System.out.println("Please enter a valid Option");
	
	        		}
	        		
	        	case 3:
	        		System.out.println("***********CREATE ORDER**************");
	        		System.out.println("Please enter the Table ID that you would like to place the order for: ");
	        		Integer tableID = sc.nextInt();
	        		Table table = restaurantReservationManager.GetTableByID(tableID);
	        		
	        
	        		System.out.println("Please enter the name of the Staff that is creating this Order : ");
	        		String staffName = sc.next();
	        		System.out.println(staffName);
	       
	        		Staff staff = restaurantStaffMgr.getStaff(staffName);
	        		
	        		if ( table == null) {
	        			System.out.println("Invalid Table Entered");
	        			break;
	        		}
	        		
	        		else if ( staff == null) {
	        			System.out.println("Invalid Staff Entered");
	        			break;
	        		}
	        		
	        		else {
	        			
	        			if(table.getStatus()==TableStatus.OCCUPIED) {
	        				Order newOrder = new Order(staff, tableID);
	        			}
	        			
	        			else {
	        				System.out.println("This Table has not been Occupied yet. Please Reserve and Check in Customer Details before placing an Order for this Table");
	        			}
	        		}
	        		
	        	case 11:
	        		i = false;
	        		
	        }
	        
        }while(i);
	        
       

        
        
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