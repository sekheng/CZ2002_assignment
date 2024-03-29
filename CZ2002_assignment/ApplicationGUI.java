package CZ2002_assignment;
import java.util.*;
import java.time.*;

/**
 * Boundary class meant to test the UI
 * @author	Kanupriya Malhotra, Swapneel Bhatt
 * @version	1.0
 * @since	2021-11-14
 */
public class ApplicationGUI
{
	/**
	 * To render the UI at the console
	 * Opens a switch case with Options to:
	 * 1. Manage menu and menu items
	 * 2. Manage promotions and promo items
	 * 3. Manage and view orders for particular tables
	 * 4. Make and manage bookings and customer check-ins
	 * 5. Output table availability
	 * 6. Print reciepts
	 * 7. Print revenue reports for a period of time 
	 * @param args	Not Applicable
	 */
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);   
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
	       
	        /**
	         * main switch case
	         */
	        switch(input) {
	        /**
	         * Menu item manager.
	         * Here we can create menu items, update them, and remove them
	         * 
	         */
	        	case 1:
	        		System.out.println("Press one of the following options to perform the following function: ");
	        		System.out.println("1. Create Menu Item");
	        		System.out.println("2. Update Menu Item");
	        		System.out.println("3. Remove Menu Item");
	        		
	        		Integer input1 = sc.nextInt();
	        		
	        		switch(input1) {
	        			case 1:
	        				System.out.println("********************* CREATE MENU ITEM *********************");
	        				
	        				System.out.println("\n ------------------ EXISTING MENU-----------------------------------\n");
	        				restaurantMenuItemMgr.viewMenu();
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
	        				
	        				System.out.println("\n ------------------ UPDATE MENU-----------------------------------\n");
	        				restaurantMenuItemMgr.viewMenu();
	        				
	        				break;
	        		
	        			case 2:
	        				System.out.println("******************* UPDATE MENU ITEM **********************");
	        				System.out.println("\n ------------------MENU-----------------------------------\n");
	        				restaurantMenuItemMgr.viewMenu();
	        				sc.nextLine();
	        				System.out.println("Enter the name of the item you want to update");
	        				String originalName = sc.nextLine();
	        				System.out.println("Do you want to update : \n 1. Name \n 2. Price \n 3. Description \n");
	        				int updateChoice = sc.nextInt();
	        				switch(updateChoice) {
	        				case 1:
	        					sc.nextLine();
	        					System.out.println("Enter new name");
	        					String newName = sc.nextLine();
	        					restaurantMenuItemMgr.updateMenuItemName(originalName, newName);
	        					System.out.println("\n ------------------UPDATED MENU-----------------------------------\n");
		        				restaurantMenuItemMgr.viewMenu();
	        					
	        					break;
	        				case 2:
	        					System.out.println("Enter new price in cents");
	        					int newPrice = sc.nextInt();
	        					restaurantMenuItemMgr.updateMenuItemPrice(originalName, newPrice);
	        					System.out.println("\n ------------------UPDATED MENU-----------------------------------\n");
		        				restaurantMenuItemMgr.viewMenu();
	        					
	        					break;
	        				case 3:
	        					sc.nextLine();
	        					System.out.println("Enter new description");
	        					String newDesc = sc.nextLine();
	        					restaurantMenuItemMgr.updateMenuItemDescription(originalName, newDesc);
	        					System.out.println("\n ------------------UPDATED MENU-----------------------------------\n");
		        				restaurantMenuItemMgr.viewMenu();
	        					
	        					break;
	        				case 4: 
	        					sc.nextLine();
	        					System.out.println("Enter new type");
	        					String newType = sc.nextLine();
	        					restaurantMenuItemMgr.updateMenuItemType(originalName, newType);
	        					System.out.println("\n ------------------UPDATED MENU-----------------------------------\n");
		        				restaurantMenuItemMgr.viewMenu();
	        					
	        					break;
	        				default: 
	        					System.out.println("Enter a valid choice");
	        					break;
	        				}
	        				
	        				break;
	        			case 3: 
	        				System.out.println("************************** REMOVE MENU ITEM ****************************");
	        				System.out.println("\n ------------------MENU-----------------------------------\n");
	        				restaurantMenuItemMgr.viewMenu();
	        				sc.nextLine();
	        				System.out.println("Enter the name for the item you want to remove ");
	        				String itemName = sc.nextLine();
	        				restaurantMenuItemMgr.removeMenuItem(itemName);
	        				
	        				System.out.println("Menu Item Removed");
	        				System.out.println("\n ------------------ UPDATED MENU-----------------------------------\n");
	        				restaurantMenuItemMgr.viewMenu();
	        				break;
	        			default:
	        				System.out.println("Please enter a valid Option");
	        				break;
	        				
	        		}
	        		break;
	        	/**	
	        	 * Promotion manager
	        	 * Here we can create, update, and remove promotions.
	        	 * A promotion is a set meal with a discounted price.
	        	 */
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
	    				Integer promotionIndex = restaurantPromoManager.assignID();
	    				
	    				System.out.println("\n ------------------ MENU-----------------------------------\n");
        				restaurantMenuItemMgr.viewMenu();

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
	    				restaurantMenuItemMgr.createMenuItem(promo.getPriceInCents(),promo.stringOfNames(),promo.getName(),"promotion");
	    				System.out.println("\n ------------------ UPDATED MENU-----------------------------------\n");
        				restaurantMenuItemMgr.viewMenu();
	    				break;
	    		
	    			case 2:
	    				System.out.println("********************UPDATE PROMOTION***************");
	    				
	    				restaurantPromoManager.printPromotions();
	    				System.out.println("Enter Index of Promotion to be edited:");
	    				Integer editIndex = sc.nextInt();
	    				Promotion editPromo = restaurantPromoManager.getPromotion(editIndex);
	    				restaurantMenuItemMgr.removeMenuItem(editPromo.getName());
	    				if(editPromo!=null) {
	    					System.out.println("Enter: \n 1.Remove Item From Promotion \n 2. Add Item to Promotion \n 3. Update Price of Promotion");
		    				
		    				Integer updatechoice = sc.nextInt();
		    				if(updatechoice == 1) {
		    					
		    					System.out.println("\n ------------------ MENU-----------------------------------\n");
		        				restaurantMenuItemMgr.viewMenu();
		        				
		    					sc.nextLine();
			    				System.out.println("Enter name of menu item to be removed:");
			    				String removeItemName = sc.nextLine();
			    				MenuItem removeItem = restaurantMenuItemMgr.getMenuItem(removeItemName);
			    				if(removeItem != null) {
			    					editPromo.removeItem(removeItem);
			    					restaurantMenuItemMgr.createMenuItem(editPromo.getPriceInCents(), editPromo.stringOfNames(), editPromo.getName(), "promotion");
			    					System.out.println("\n ------------------ UPDATED MENU-----------------------------------\n");
			        				restaurantMenuItemMgr.viewMenu();
			    				}
			    				else {
			    					System.out.println("Incorrect Menu Item entered!");
			    				}
			    				
		    				}
			    				
			    			else if(updatechoice==2) {
			    				
			    				System.out.println("\n ------------------ MENU-----------------------------------\n");
		        				restaurantMenuItemMgr.viewMenu();
		        				
			    				sc.nextLine();
			    				System.out.println("Enter name of menu item to be added:");
			    				String addItemName = sc.nextLine();
			    				MenuItem addItem = restaurantMenuItemMgr.getMenuItem(addItemName);
			    				if(addItem != null) {
			    					editPromo.addItem(addItem);
			    					System.out.println("Menu Item added to Promotion");
			    					restaurantMenuItemMgr.createMenuItem(editPromo.getPriceInCents(), editPromo.stringOfNames(), editPromo.getName(), "promotion");
			    					System.out.println("\n ------------------ UPDATED MENU-----------------------------------\n");
			        				restaurantMenuItemMgr.viewMenu();
			    				}
			    				else {
			    					System.out.println("Incorrect Menu Item entered!");
			    				}
			    			}
			    			else if(updatechoice == 3) {
			    				System.out.println("Enter new price of Promotion:");
			    				Integer newPrice = sc.nextInt();
			    				editPromo.setPriceInCents(newPrice);
		    					restaurantMenuItemMgr.createMenuItem(editPromo.getPriceInCents(), editPromo.stringOfNames(), editPromo.getName(), "promotion");
		    					System.out.println("\n ------------------ UPDATED MENU-----------------------------------\n");
		        				restaurantMenuItemMgr.viewMenu();
			    				
			    			}
		    				
			    			else {
			    				System.out.println("Invalid Input Entered!");

			    			}
	    					
	    				}
	    				break;
	    				
	    				
	    			case 3: 
	    				System.out.println("**********REMOVE PROMOTION****************:");
	    				restaurantPromoManager.printPromotions();
	    				System.out.println();
	    				System.out.println("Enter index of the Promotion to be removed:");
	    				Integer removeIndex = sc.nextInt();
	    				Promotion removePromo = restaurantPromoManager.getPromotion(removeIndex);
	    				restaurantPromoManager.removePromotion(removeIndex);
	    				restaurantMenuItemMgr.removeMenuItem(removePromo.getName());
    					System.out.println("\n ------------------ UPDATED MENU-----------------------------------\n");
        				restaurantMenuItemMgr.viewMenu();
	    				
	    				
	    				break;
	    				
	    			default:
	    				System.out.println("Please enter a valid Option");
	    				break;
	
	        		}
	        		break;
	        	

	        	/**	
	        	 * Here we can create an order for a table.
	        	 * Creating an order is basically opening a tab for a table.
	        	 * Items can be added to and removed from the order now.
	        	 */
	        	case 3:
	        		System.out.println("\n***********CREATE ORDER**************");
	        		restaurantReservationManager.getOccupiedTables();
	        		System.out.println("Please enter the Table ID that you would like to place the order for: ");
	        		Integer tableID = sc.nextInt();
	        		Table table = restaurantReservationManager.GetTableByID(tableID);
	        		if ( table == null) {
	        			System.out.println("Invalid Table Entered");
	        			break;
	        		}
	        		
	        		restaurantStaffMgr.printStaff();
	        		System.out.println();
	        		
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
	        				restaurantOrderManager.addOrder(newOrder);
	        				System.out.println("Order successfully created. Please Add Items to the order using Function 5 on the Control Panel");
	        			}
	        			
	        			else {
	        				System.out.println("This Table has not been Occupied yet. Please Reserve and Check in Customer Details before placing an Order for this Table");
	        			}
	        		}
	        		
	        		break;
	        		
	        	/**	
	        	 * View the current order for a table
	        	 */
	        	case 4:
	        		System.out.println("\n***********VIEW ORDER**************");
	        		restaurantReservationManager.getOccupiedTables();
	        		System.out.println("Enter Table ID of Order you would like to print:");
	        		Integer viewtableID = sc.nextInt();
	        		Order viewOrder = restaurantOrderManager.getOrder(viewtableID);
	        		
	        		if(viewOrder!=null) {
	        			viewOrder.viewOrder();
	        		}
	        		else {
	        			System.out.println("No Order Found for this Table ID");
	        		}
	        		
	        		break;
	        		
	        	/**
	        	 * Order manager
	        	 * Here we can add or remove items from the order
	        	 */
	        	case 5:
	        		System.out.println("\n***********ADD/REMOVE ITEMS TO/FROM ORDER**************");
	        		restaurantReservationManager.getOccupiedTables();
	        		System.out.println("Enter Table ID of Order you would like to update:");
	        		Integer updatetableID = sc.nextInt();
	        		Order updateOrder = restaurantOrderManager.getOrder(updatetableID);
	        		if(updateOrder!=null) {
	        			
	        			System.out.println("Enter: \n 1.Remove Item From Order \n 2. Add Item to Order ");
						Integer input5 = sc.nextInt();
						
						switch(input5) {
						
						case 1:
							System.out.println("\n***********REMOVE ITEM FROM ORDER**************");
							System.out.println("\n ------------------ MENU-----------------------------------\n");
	        				restaurantMenuItemMgr.viewMenu();
	        				sc.nextLine();
							System.out.println("Enter name of menu item to be removed:");
		    				String removeItemName = sc.nextLine();
		    				MenuItem removeItem = restaurantMenuItemMgr.getMenuItem(removeItemName);
		    				if(removeItem != null) {
		    					updateOrder.removeItem(removeItem.getName());
		    				}
		    				else {
		    					System.out.println("Incorrect Menu Item entered!");
		    				}
							
							break;
							
							
						case 2:
							System.out.println("\n***********ADD ITEM TO ORDER**************");
							System.out.println("\n ------------------ MENU-----------------------------------\n");
	        				restaurantMenuItemMgr.viewMenu();
							sc.nextLine();
							System.out.println("How many items would you like to add to this order? \n");
		    				Integer noOfOrderItems = sc.nextInt();
		    				for(int p =0; p<noOfOrderItems;) {
		    					sc.nextLine();
		    					System.out.printf("Enter the name of menu item %d: \n", (p+1));
		    					String menuItemName = sc.nextLine();
		    					MenuItem menuItem = restaurantMenuItemMgr.getMenuItem(menuItemName);
		    					if(menuItem != null) {
		    						updateOrder.addItem(menuItem);
		    						System.out.println("Menu Item added .........");
		    						p++;
		    						
		    					}	
		    					else {
		    						System.out.println("Invalid Menu Item added! Try Again");
		    						
		    					}
		    				}
		    				break;

						
						default:
							System.out.println("Invalid choice Entered!!");
							
						}
	        		}
	        	
	        		break;
	        	/**	
	        	 * Reservation system.
	        	 * Here we can add a booking per customer
	        	 * Each customer can book multiple tables, but max 10 pax per table.
	        	 */
	        	case 6:
	        	System.out.println("************************* ADD RESERVATION ****************************");
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
            		if(noOfPeople>10) {
            			j=j-1;
            			System.out.println("Maxmimum 10 per table");
            			continue;
            			}
            		restaurantReservationManager.AddReservation(noOfPeople, resTime, customerName, customerGender, membershipStatus,bookingCustomerID);
            	}
            	break;
            	
            	/**
            	 * Here the customer can check-in to the restaurant, to change booking status from reserved to occupied.
            	 * If a customer doesnt check in within 15 mins of booking time, his booking expires.
            	 */
	        	case 7:
	        		System.out.println("**************************** CHECK IN CUSTOMER *******************************");
	        		restaurantReservationManager.UpdateBookings();
	        		restaurantReservationManager.CheckAllReservation();
	        		System.out.println("Which customer ID would you like to check in ?");
	        		int id = sc.nextInt();
	        		if(id == 0) {
	        			System.out.println("0 is not a customer ID. Please choose from the printed values");
	        			break;
	        		}
	        		boolean checkin = restaurantReservationManager.CheckInCustomer(id);
	        		if(checkin== true) {	

	        			System.out.println("Customer has checked in");

	        		}
	        	
	        		break;
	        	/**
	        	 * Checks reservation status per customer ID.
	        	 */
	        	case 8:
	        		System.out.println("****************************** CHECK RESERVATION****************************");
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
	        			if(customerID==0) {
	        				System.out.println("0 is not a valid customerID");
	        				break;
	        			}
	        			restaurantReservationManager.CheckReservation(customerID);
	        			break;
	        		default:
	        			System.out.println("Choose a correct option");
	        		}
	        		break;
	        		
	        	/**		   
	        	 * Remove reservation based on
	        	 * Customer ID, customer name, or table ID
	        	 */
	        	case 9:
	        		System.out.println("******************************REMOVE RESERVATION ***********************************");
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
	        	/**	
	        	 * Check the status of a particular table
	        	 */
	        	case 10:
	        		System.out.println("*************************************CHECK STATUS OF TABLE *************************");
	        		restaurantReservationManager.UpdateBookings();
	        		System.out.println("Enter the table ID whose status you want to check");
	        		int tableCheckID = sc.nextInt();
	        		Table newTable = restaurantReservationManager.GetTableByID(tableCheckID);
	        		System.out.println("Table number : " + newTable.getTableID());
	        		System.out.println(newTable.getStatus());
	        		break;
	        	/**	
	        	 * Print the reciept for a table
	        	 *Also vacates that particular table
	        	 */
	        	case 11:
	        		System.out.println("*************************************ORDER INVOICE *************************");
	        		restaurantReservationManager.getOccupiedTables();
	        		System.out.println("What table would you like to print the Invoice for?");
	        		Integer invoiceTable = sc.nextInt();
	        		System.out.println("Enter Tax:");
	        		float invoiceTax = sc.nextFloat();
	        		System.out.println("Enter Discount:");
	        		float invoiceDiscount = sc.nextFloat();
	        		restaurantOrderManager.printReceipt(invoiceTable, invoiceDiscount, invoiceTax);
	        		restaurantReservationManager.RemoveReservationTableID(invoiceTable);
	        		break;
	        	/**	
	        	 * Prints revenue report for a particular period
	        	 */
	        	case 12:
	        		System.out.println("********PRINT REVENUE REPORT**************");
	        		System.out.println("Enter start: (YYYY-MM-DD-HH-MM) ");
	        		// Split string 
	        		String start = sc.next();
	        		String[] startsubstrings = start.split("-");
	        		int startyear = Integer.parseInt(startsubstrings[0]);
	        		int startmonth = Integer.parseInt(startsubstrings[1]);
	        		int startdayOfMonth = Integer.parseInt(startsubstrings[2]);
	        		int starthour = Integer.parseInt(startsubstrings[3]);
	        		int startminutes = Integer.parseInt(startsubstrings[4]);
	        		LocalDateTime startresTime = LocalDateTime.of(startyear, startmonth, startdayOfMonth, starthour, startminutes);
	        		
	        		System.out.println("Enter end time: (YYYY-MM-DD-HH-MM) ");
	        		// Split string 
	        		String end = sc.next();
	        		String[] endsubstrings = end.split("-");
	        		int endyear = Integer.parseInt(endsubstrings[0]);
	        		int endmonth = Integer.parseInt(endsubstrings[1]);
	        		int enddayOfMonth = Integer.parseInt(endsubstrings[2]);
	        		int endhour = Integer.parseInt(endsubstrings[3]);
	        		int endminutes = Integer.parseInt(endsubstrings[4]);
	        		LocalDateTime endresTime = LocalDateTime.of(endyear, endmonth, enddayOfMonth, endhour, endminutes);
	        		restaurantOrderManager.getRevenueReport().GetOrderInvoice(startresTime, endresTime);
	        		break;

	        		
	        	case 13:
	        		i = false;
	        		break;
	        		
	        }
	        
        }while(i);
	        
       

    }       
    
}