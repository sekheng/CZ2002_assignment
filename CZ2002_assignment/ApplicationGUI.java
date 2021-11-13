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
	        		+ " 5. Add/Remove order item/s to/from order \n 6. Create reservation booking \n 7. Check In a customer \n 8. Check reservation booking \n 9.Remove reservation booking \n 10. Check table availability \n"
	        		+ " 11. Print order invoice \n 12. Print sale revenue report by period (eg day or month) \n 13. Exit");
	        
	        
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
	        				sc.nextLine();
	        				System.out.println("Enter name of item");
	        				String name = sc.nextLine();
	        				System.out.println("Enter description of item");
	        				String desc = sc.nextLine();
	        				System.out.println("Is the item an appetiser,maincourse, or drinks?");
	        				String type = sc.next();
	        				System.out.println("What is the price of the item (in cents) ?");
	        				int price = sc.nextInt();
	        				restaurantMenuItemMgr.createMenuItem(price,desc,name,type);
	        				System.out.println("Created item");
	        				break;
	        		
	        			case 2:
	        				sc.nextLine();
	        				System.out.println("Enter the name of the item you want to update");
	        				String originalName = sc.nextLine();
	        				System.out.println("Do you want to update : \n 1. Name \n 2. Price \n 3. Description \4. Type");
	        				int updateChoice = sc.nextInt();
	        				switch(updateChoice) {
	        				case 1:
	        					sc.nextLine();
	        					System.out.println("Enter new name");
	        					String newName = sc.nextLine();
	        					restaurantMenuItemMgr.updateMenuItemName(originalName, newName);
	        					break;
	        				case 2:
	        					System.out.println("Enter new price in cents");
	        					int newPrice = sc.nextInt();
	        					restaurantMenuItemMgr.UpdateMenuItemPrice(originalName, newPrice);
	        					break;
	        				case 3:
	        					sc.nextLine();
	        					System.out.println("Enter new description");
	        					String newDesc = sc.nextLine();
	        					restaurantMenuItemMgr.UpdateMenuItemDescription(originalName, newDesc);
	        					break;
	        				case 4: 
	        					sc.nextLine();
	        					System.out.println("Enter new type");
	        					String newType = sc.nextLine();
	        					restaurantMenuItemMgr.UpdateMenuItemType(originalName, newType);
	        					break;
	        				default: 
	        					System.out.println("Enter a valid choice");
	        					break;
	        				}
	        				
	        				break;
	        			case 3: 
	        				sc.nextLine();
	        				System.out.println("Enter the name for the item you want to remove ");
	        				String itemName = sc.nextLine();
	        				restaurantMenuItemMgr.removeMenuItem(itemName);
	        				
	        				System.out.println("Menu Item Removed");
	        				break;
	        			default:
	        				System.out.println("Please enter a valid Option");
	        				break;
	        				
	        		}
	        		break;
	        		
	        	case 2:
	        		System.out.println("Press one of the following options to perform the following function: ");
	        		System.out.println("1. Create Promotion");
	        		System.out.println("2. Update Promotion");
	        		System.out.println("3. Remove Promotion");
	        		
	        		Integer input2 = sc.nextInt();
	        		
	        		switch(input2) {
	    			case 1:
	    				
	    				System.out.println("******CREATE PROMOTION*******");
	    				sc.nextLine();
	    				System.out.println("Please enter the name of the promotion: \n");
	    				String promotionName = sc.nextLine();
	    				System.out.println("Please enter the price of the promotion: \n");
	    				Integer promotionPrice = sc.nextInt();
	    				System.out.println("How many items would you like to add to this promotion? \n");
	    				Integer noOfPromotionItems = sc.nextInt();
	    				System.out.println("Enter Index of this promotion?: \n ");

	    				Integer promotionIndex = sc.nextInt();

	    				Promotion promo = new Promotion(promotionPrice, promotionName, promotionIndex) ;
	    				for(int p =0; p<noOfPromotionItems;) {
	    					sc.nextLine();
	    					System.out.printf("Enter the name of menu item %d: \n", (p+1));
	    					String menuItemName = sc.nextLine();
	    					MenuItem menuItem = restaurantMenuItemMgr.getMenuItem(menuItemName);
	    					if(menuItem != null) {
	    						promo.addItem(menuItem);
	    						System.out.println("Menu Item added .........");
	    						p++;
	    						
	    					}	
	    					else {
	    						System.out.println("Invalid Menu Item added! Try Again");
	    						
	    					}
	    				}
	    				
	    				restaurantPromoManager.addPromo(promo);
	    				break;
	    		
	    			case 2:
	    				System.out.println("********************UPDATE PROMOTION***************");
	    				System.out.println("Enter Index of Promotion to be edited:");
	    				Integer editIndex = sc.nextInt();
	    				Promotion editPromo = restaurantPromoManager.getPromotion(editIndex);
	    				if(editPromo!=null) {
	    					System.out.println("Enter: \n 1.Remove Item From Promotion \n 2. Add Item to Promotion \n 3. Update Price of Promotion");
		    				
		    				Integer updatechoice = sc.nextInt();
		    				if(updatechoice == 1) {
		    					sc.nextLine();
			    				System.out.println("Enter name of menu item to be removed:");
			    				String removeItemName = sc.nextLine();
			    				MenuItem removeItem = restaurantMenuItemMgr.getMenuItem(removeItemName);
			    				if(removeItem != null) {
			    					editPromo.removeItem(removeItem);
			    				}
			    				else {
			    					System.out.println("Incorrect Menu Item entered!");
			    				}
		    				}
			    				
			    			else if(updatechoice==2) {
			    				sc.nextLine();
			    				System.out.println("Enter name of menu item to be added:");
			    				String addItemName = sc.nextLine();
			    				MenuItem addItem = restaurantMenuItemMgr.getMenuItem(addItemName);
			    				if(addItem != null) {
			    					editPromo.addItem(addItem);
			    					System.out.println("Menu Item added to Promotion");
			    				}
			    				else {
			    					System.out.println("Incorrect Menu Item entered!");
			    				}
			    			}
			    			else if(updatechoice == 3) {
			    				System.out.println("Enter new price of Promotion:");
			    				Integer newPrice = sc.nextInt();
			    				editPromo.setPriceInCents(newPrice);
			    				
			    			}
		    				
			    			else {
			    				System.out.println("Invalid Input Entered!");

			    			}
	    					
	    				}
	    				

	    				

	    				break;
	    			case 3: 
	    				System.out.println("**********REMOVE PROMOTION****************:");
	    				System.out.println("Enter index of the Promotion to be removed:");
	    				Integer removeIndex = sc.nextInt();
	    				restaurantPromoManager.removePromotion(removeIndex);
	    				break;
	    				
	    			default:
	    				System.out.println("Please enter a valid Option");
	    				break;
	
	        		}
	        		break;
	        	

	        		
	        	case 3:
	        		System.out.println("***********CREATE ORDER**************");
	        		System.out.println("Please enter the Table ID that you would like to place the order for: ");
	        		Integer tableID = sc.nextInt();
	        		Table table = restaurantReservationManager.GetTableByID(tableID);
	        		if ( table == null) {
	        			System.out.println("Invalid Table Entered");
	        			break;
	        		}
	        		
	        
	        		System.out.println("Please enter the name of the Staff that is creating this Order : ");
	        		String staffName = sc.next();
	       
	        		Staff staff = restaurantStaffMgr.getStaff(staffName);
	        		
	        		
	        		if ( staff == null) {
	        			System.out.println("Invalid Staff Entered");
	        			break;
	        		}
	        		
	        		if (staff!= null && table!=null) {
	        			
	        			if(table.getStatus()==TableStatus.OCCUPIED) {
	        				Order newOrder = new Order(staff, tableID);
	        			}
	        			
	        			else {
	        				System.out.println("This Table has not been Occupied yet. Please Reserve and Check in Customer Details before placing an Order for this Table");
	        			}
	        		}
	        		
	        		break;
	        		
	        	case 4:
	        		
	        		break;
	        	case 5:
	        		break;
	        	case 6:
	        	restaurantReservationManager.UpdateBookings();
            	System.out.println("How many tables would you like to book? (Each table can hold a maximum of 10 people)");
            	int noOfDesiredTables = sc.nextInt();
        		
        		System.out.println("Enter Customer Name ");
        		String customerName = sc.next();

        		System.out.println("Enter customer Gender (1-male, 2-female)");
        		int customerGender = sc.nextInt();
        		System.out.println("Is customer a member? True/False");
        		boolean membershipStatus = sc.nextBoolean();
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
        		int bookingCustomerID = restaurantReservationManager.assignCustomerID();
            	for (int j =0; j<noOfDesiredTables; j++) {
            		System.out.printf("Number of people on Table %d:",j+1);
            		int noOfPeople = sc.nextInt();

            		restaurantReservationManager.AddReservation(noOfPeople, resTime, customerName, customerGender, membershipStatus,bookingCustomerID);
            	}
            	break;
            	
	        	case 7:
	        		restaurantReservationManager.UpdateBookings();
	        		System.out.println("Which customer would you like to check in ?");
	        		int id = sc.nextInt();
	        		restaurantReservationManager.CheckInCustomer(id);
	        		break;
	        	
	        	case 8:
	        		restaurantReservationManager.UpdateBookings();
	        		System.out.println("Do you want to \n 1. Check all reservations \n 2. Check a booking by customer ID");
	        		int choice = sc.nextInt();
	        		switch(choice) {
	        		case 1:
	        			restaurantReservationManager.CheckAllReservation();
	        			break;
	        		case 2:
	        			System.out.println("Enter customer ID you want to check reservation for");
	        			int customerID = sc.nextInt();
	        			restaurantReservationManager.CheckReservation(customerID);
	        			break;
	        		default:
	        			System.out.println("Choose a correct option");
	        		}
	        		break;
	        		
	        		
	        	case 9:
	        		restaurantReservationManager.UpdateBookings();
	        		System.out.println("Would you like to remove booking by \n 1. Customer ID \n 2. Customer name \n 3. Table ID");
	        		int choice2 = sc.nextInt();
	        		switch(choice2) {
	        		case 1:
	        			System.out.println("Enter customer ID");
	        			int customerID = sc.nextInt();
	        			restaurantReservationManager.RemoveReservationCustomerID(customerID);
	        			break;
	        		case 2:
	        			System.out.println("Enter Customer name");
	        			String name = sc.next();
	        			restaurantReservationManager.RemoveReservationName(name);
	        			break;
	        		case 3:
	        			System.out.println("Enter Table ID");
	        			int ID = sc.nextInt();
	        			restaurantReservationManager.RemoveReservationTableID(ID);
	        			break;
	        		default:
	        			System.out.println("Choose a correct option");
	        		}
	        		break;
	        		
	        	case 10:
	        		restaurantReservationManager.UpdateBookings();
	        		System.out.println("Enter the table ID whose status you want to check");
	        		int tableCheckID = sc.nextInt();
	        		Table newTable = restaurantReservationManager.GetTableByID(tableCheckID);
	        		System.out.println(newTable.getStatus());
	        	case 13:
	        		i = false;
	        		break;
	        		
	        }
	        
        }while(i);
	        
       

        
        



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