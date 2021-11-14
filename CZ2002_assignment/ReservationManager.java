package CZ2002_assignment;
import java.time.*;
import java.util.*;
import java.lang.*;
/**
 * Manager class for adding, checking, and removing reservations
 * @author swapneelbhatt
 * @version 1.0
 * @since 2021-11-10
 *
 */
public class ReservationManager {
	
	/**
	 * static int to create unique customer IDs
	 */
	private int customerID = 1;
	/**
	 * ArrayList of tables in the restauratnt, with details of table ID, 
	 * table size, status and the customer assigned to them
	 */
	private ArrayList<Table> arrayOfTables = new ArrayList<Table>();
	/**
	 * Number of tables in the restaurant
	 */
	private int smallTableno = 10;
	private int medTableno = 15;
	private int largeTableno = 10;
	
	/**
	 * Array of tables is filled up according to size, with first all small tables, then all medium tables, then all Large tables
	 * Table IDs start from 1
	 * ID numbers 1 -> smallTableNo : small tables
	 * ID numbers smallTableNo+1 -> smallTableNo + medTableNo : medium tables
	 * ID numbers smallTableNo + medTableNo +1 -> smallTableNo + medTableNo + largeTableNo : large tables
	 */
	private ArrayList<Customer> arrayOfCustomers = new ArrayList<Customer>();
	
	/**
	 * constructor function for reservation manager
	 * instantiates the tables in restaurant
	 */
	public ReservationManager() {
		
		//Adding small tables to array of tables
		for(int i = 0 ; i< 10; i++) {
			Table newTable = new Table(2,i);
			this.arrayOfTables.add(newTable);
			
		}

		
		//Adding medium tables to array of tables
		for(int i = 10; i<25; i++) {
			Table newTable = new Table(6,i);
			this.arrayOfTables.add(newTable);
		}

		//Adding large tables to array of tables
		for(int i = 25; i<35; i++) {
			Table newTable = new Table(10,i);
			this.arrayOfTables.add(newTable);
		}

		
	}
	
	/**
	 * Generating unique customer ID 
	 * @return customerID
	 */
	public int assignCustomerID() {
		
		int ID = this.customerID;
		this.customerID++;
		return ID;
	}
	
	/**
	 * Adding a reservation to array of tables
	 * @param Pax : number of people on the table
	 * @param RezTime : time of reservation
	 * @param CustomerName : string of customerName
	 * @param CustomerGender : int of customerGender
	 * @param MembershipStatus : boolean for MembershipStatus
	 * @param CustomerID : int for unique customerID
	 * Assigns a table that matches the size and vacancy requirements
	 */
	public void AddReservation(int Pax, LocalDateTime RezTime,String CustomerName,int CustomerGender, boolean MembershipStatus, int CustomerID) {
		System.out.println("Adding a reservation");
		Customer newCustomer = new Customer(CustomerName,CustomerGender,MembershipStatus);
		newCustomer.setCustID(CustomerID);
		int customerID = newCustomer.getCustID();
		this.arrayOfCustomers.add(newCustomer);
		System.out.println("New customer added");
		if(Pax<=2) {
			System.out.println("Booking a small table");
			for(int i = 0; i<this.arrayOfTables.size();i++) {
				if((this.arrayOfTables.get(i).getSeatsPax() == TablePax.SMALLTABLE) && (this.arrayOfTables.get(i).getStatus()==TableStatus.VACANT)) {
					Table smallTable = new Table(Pax,i);
					smallTable.setResTime(RezTime);
					smallTable.setStatus(TableStatus.RESERVED);
					smallTable.setCustomerID(customerID);
					smallTable.setCustomerName(CustomerName);
					this.arrayOfTables.set(i, smallTable);
					System.out.println("\n Booking added for customer ID " + this.arrayOfTables.get(i).getCustomerID() + " \n Name: " + CustomerName + " \n Table number: " + this.arrayOfTables.get(i).getTableID());
					return;
				}
			}
			System.out.println("No vacancy, sorry!");
			return;
		}
		
		else if(Pax<=6) {
			System.out.println("Booking a medium table");
			for(int i = 0; i<this.arrayOfTables.size();i++) {
				if((this.arrayOfTables.get(i).getSeatsPax() == TablePax.MEDTABLE) && (this.arrayOfTables.get(i).getStatus()==TableStatus.VACANT)) {
					Table medTable = new Table(Pax,i);
					medTable.setResTime(RezTime);
					medTable.setStatus(TableStatus.RESERVED);
					medTable.setCustomerID(customerID);
					medTable.setCustomerName(CustomerName);
					this.arrayOfTables.set(i, medTable);
					System.out.println("\n Booking added for customer ID " + this.arrayOfTables.get(i).getCustomerID() + " \n  Name: " + CustomerName + " \n Table number: " + this.arrayOfTables.get(i).getTableID());
					return;
				}
			}
			System.out.println("No vacancy, sorry!");
			return;
		}
		else {
			System.out.println("Booking a large table");
			for(int i = 0; i<this.arrayOfTables.size();i++) {
				if((this.arrayOfTables.get(i).getSeatsPax() == TablePax.LARGETABLE) && (this.arrayOfTables.get(i).getStatus()==TableStatus.VACANT)) {
					Table largeTable = new Table(Pax,i);
					largeTable.setResTime(RezTime);
					largeTable.setStatus(TableStatus.RESERVED);
					largeTable.setCustomerID(customerID);
					largeTable.setCustomerName(CustomerName);
					this.arrayOfTables.set(i, largeTable);
					System.out.println("\n Booking added for customer ID " + this.arrayOfTables.get(i).getCustomerID() + " \n Name: " + CustomerName + " \n Table number: " + this.arrayOfTables.get(i).getTableID());
					return;
				}
			}
			System.out.println("No vacancy, sorry!");
			return;
		}	
	}

/**
 * Checks the reservation for a particular customer ID
 * @param CustomerID: Customer ID whose reservation we want to check
 */
	public void CheckReservation(int CustomerID) {
		int flag = 0;
		for(int i = 0; i<this.arrayOfTables.size();i++) {
			if(this.arrayOfTables.get(i).getCustomerID()== CustomerID) {
				System.out.println("Booking found for customer " + CustomerID);
				System.out.println("Details are:");
				System.out.println("Table ID: " + this.arrayOfTables.get(i).getTableID());
				System.out.println("Booking time :" + this.arrayOfTables.get(i).getResTime());
				System.out.println("The check in status is : " + this.arrayOfTables.get(i).getStatus());
				flag = 1;
			}
		}
		if(flag ==0) {
			System.out.println("No booking found");
		}
		return;
	}
	
/**
 * Checks all the reservations and prints out the 
 * customer IDs that have a booking
 */
	public void CheckAllReservation() {
		System.out.println("Customer IDs who have bookings are");
		
		int check=0;
		for(int i = 0; i <this.arrayOfTables.size();i++) {
			if(this.arrayOfTables.get(i).getStatus()!=TableStatus.VACANT) {
				if(this.arrayOfTables.get(i).getCustomerID()!=check) {
					/*
					 * this helps to avoid the IDs of customers who have booked more than one table to get printed multiple times
					 */
					
					System.out.println(this.arrayOfTables.get(i).getCustomerID());
				}
				check = this.arrayOfTables.get(i).getCustomerID();
			}
		}
	}

/**
 * Checks reservation status for a particular customer ID
 * @param CustomerID customer whose ID will be removed
 */
	public void RemoveReservationCustomerID(int CustomerID) {
		int flag = 0;
		for(int i = 0; i<this.arrayOfTables.size();i++) {
			if(this.arrayOfTables.get(i).getCustomerID()== CustomerID) {
				flag = 1;
				System.out.println("Removing booking  for customer " + CustomerID);
				System.out.println("Details are:");
				System.out.println("Table ID: " + this.arrayOfTables.get(i).getTableID());
				System.out.println("Booking time :" + this.arrayOfTables.get(i).getResTime());
				this.arrayOfTables.get(i).setStatus(TableStatus.VACANT);	
			}
		}
		//Removing customer from customer array
		for (int i = 0; i<this.arrayOfCustomers.size();i++) {
			if(this.arrayOfCustomers.get(i).getCustID() == CustomerID) {
				this.arrayOfCustomers.remove(i);
			}
		}
		if(flag ==0) {
			System.out.println("No booking found");
		}
		return;
	}

/**
 * Removes reservation based on table ID
 * @param TableID ID whose table will be removed
 */
	public void RemoveReservationTableID(int TableID) {
		for(int i = 0; i<this.arrayOfTables.size();i++) {
			if(this.arrayOfTables.get(i).getTableID()  == TableID) {
				System.out.println("Removing booking  for customer " + this.arrayOfTables.get(i).getCustomerName());
				System.out.println("Details are:");
				System.out.println("Table ID: " + this.arrayOfTables.get(i).getTableID());
				System.out.println("Booking time :" + this.arrayOfTables.get(i).getResTime());
				this.arrayOfTables.get(i).setStatus(TableStatus.VACANT);
				int customerID = this.arrayOfTables.get(i).getCustomerID();
				
				//Removing customer from customer array
				for(i = 0; i<this.arrayOfCustomers.size();i++) {
					if(this.arrayOfCustomers.get(i).getCustID()==customerID) {
						this.arrayOfCustomers.remove(i);
					}
				}
				return;
			}
		}
		System.out.println("No booking found");
		return;
	}
/**
 * removes reservation based on customer name
 * @param name name whose reservation will be removed
 */
	public void RemoveReservationName(String name) {
		for(int i = 0; i<this.arrayOfTables.size();i++) {
			if(this.arrayOfTables.get(i).getCustomerName().compareTo(name)==0) {
				System.out.println("Removing booking  for customer " + name);
				System.out.println("Details are:");
				System.out.println("Table ID: " + this.arrayOfTables.get(i).getTableID());
				System.out.println("Booking time :" + this.arrayOfTables.get(i).getResTime());
				this.arrayOfTables.get(i).setStatus(TableStatus.VACANT);
				int customerID = this.arrayOfTables.get(i).getCustomerID();
				
				//Removing customer from customer array
				for(i = 0; i<this.arrayOfCustomers.size();i++) {
					if(this.arrayOfCustomers.get(i).getCustID()==customerID) {
						this.arrayOfCustomers.remove(i);
					}
				}
				return;
			}
		}
		System.out.println("No booking found");
		return;
	}

/**
 * Check in the customer, and change their booking status from reserved to booked
 * @param CustomerID ID of customer who is going to be checked in
 * @return boolean to show if check in was successful or not
 */
	public boolean CheckInCustomer(int CustomerID) {
		int flag = 0;
		for (int i = 0; i < this.arrayOfTables.size();i++) {
			if(this.arrayOfTables.get(i).getCustomerID() == CustomerID) {
				this.arrayOfTables.get(i).setStatus(TableStatus.OCCUPIED);
				System.out.println("Checked in at table : " + this.arrayOfTables.get(i).getTableID());
				flag = 1;
			}
		}
		
		if(flag ==1) {
			return true;
		}
		else {
		System.out.println("No such customer");
		return false;
		}
	}

/**
 * Update booking status, remove expired bookings
 * expiry for a booking is 15 minutes after the booking time
 */
	public void UpdateBookings() {
		for(int i = 0; i<this.arrayOfTables.size();i++) {
			if(this.arrayOfTables.get(i).getStatus() == TableStatus.RESERVED) {
				Duration duration = Duration.between(this.arrayOfTables.get(i).getResTime(), LocalDateTime.now());
				if(duration.toMinutes()>15) {
					this.arrayOfTables.get(i).setStatus(TableStatus.VACANT);
				}
			}
			
		}
	}

/**
 * prints out all tables that have a customer checked in	
 */
	public void getOccupiedTables() {
		System.out.println("The tables that are occupied are ");
		for(int i = 0;i<this.arrayOfTables.size();i++) {
			if(this.arrayOfTables.get(i).getStatus()==TableStatus.OCCUPIED) {
				System.out.println("Table ID " + this.arrayOfTables.get(i).getTableID());
			}
		}
	}
/**
 * returns the Table based on table ID
 * @param TableID ID of the table
 * @return object of class Table
 */
	public Table GetTableByID(int TableID) {
		Table selectedtable =null;
		for(int i =0; i<this.arrayOfTables.size(); i++) {
			if(this.arrayOfTables.get(i).getTableID() ==TableID) {
				 selectedtable =  this.arrayOfTables.get(i);
				 System.out.println("Table Successfully Identified...");
				 return selectedtable;
			}
		}
	if(selectedtable == null) {
		System.out.println("NO SUCH TABLE");
	}
	return selectedtable;
	}

	
}
