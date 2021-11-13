package CZ2002_assignment;
import java.time.*;
import java.util.*;
import java.lang.*;

public class ReservationManager {
	private ArrayList<Table> arrayOfTables = new ArrayList<Table>();
	private int smallTableno = 10;
	private int medTableno = 15;
	private int largeTableno = 10;
	
	//Array of tables is filled up according to size, with first all small tables, then all medium tables, then all Large tables
	//Table IDs start from 1
	//ID numbers 1 -> smallTableNo : small tables
	//ID numbers smallTableNo+1 -> smallTableNo + medTableNo : medium tables
	//ID numbers smallTableNo + medTableNo +1 -> smallTableNo + medTableNo + largeTableNo : large tables
	private ArrayList<Customer> arrayOfCustomers = new ArrayList<Customer>();
	
	public ReservationManager() {
		
		//Adding small tables to array of tables
		for(int i = 0 ; i< this.smallTableno; i++) {
			Table newTable = new Table(2,i+1);
			this.arrayOfTables.add(newTable);
			
		}
		System.out.println("Small tables created");
		
		//Adding medium tables to array of tables
		for(int i = this.smallTableno ; i<(this.smallTableno+ this.medTableno); i++) {
			Table newTable = new Table(6,i+1);
			this.arrayOfTables.add(newTable);
		}
		System.out.println("Medium tables created");
		//Adding large tables to array of tables
		for(int i = (this.smallTableno+this.medTableno); i<(this.smallTableno + this.medTableno + this.largeTableno); i++) {
			Table newTable = new Table(10,i+1);
			this.arrayOfTables.add(newTable);
		}
		System.out.println("Large Tables created");
		
	}
	
	public void AddReservation(int Pax, LocalDateTime RezTime,String CustomerName, int CustomerID,int CustomerGender, boolean MembershipStatus) {
		System.out.println("Adding a reservation");
		Customer newCustomer = new Customer(CustomerName,CustomerGender,MembershipStatus,CustomerID);
		this.arrayOfCustomers.add(newCustomer);
		System.out.println("New customer added");
		if(Pax<=2) {
			System.out.println("Booking a small table");
			for(int i = 0; i<this.arrayOfTables.size();i++) {
				if((this.arrayOfTables.get(i).getSeatsPax() == TablePax.SMALLTABLE) && (this.arrayOfTables.get(i).getStatus()==TableStatus.VACANT)) {
					Table smallTable = new Table(Pax,i);
					smallTable.setResTime(RezTime);
					smallTable.setStatus(TableStatus.RESERVED);
					smallTable.setCustomerID(CustomerID);
					this.arrayOfTables.set(i, smallTable);
					System.out.println("Booking added for customer ID " + this.arrayOfTables.get(i).getCustomerID() + " at table number " + this.arrayOfTables.get(i).getTableID());
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
					System.out.println("Booking table " + this.arrayOfTables.get(i).getTableID());
					Table medTable = new Table(Pax,i);
					medTable.setResTime(RezTime);
					medTable.setStatus(TableStatus.RESERVED);
					medTable.setCustomerID(CustomerID);
					this.arrayOfTables.set(i, medTable);
					System.out.println("Booking added for customer ID " + this.arrayOfTables.get(i).getCustomerID() + " at table number " + this.arrayOfTables.get(i).getTableID());
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
					largeTable.setCustomerID(CustomerID);
					this.arrayOfTables.set(i, largeTable);
					System.out.println("Booking added for customer ID " + this.arrayOfTables.get(i).getCustomerID() + " at table number " + this.arrayOfTables.get(i).getTableID());
					return;
				}
			}
			System.out.println("No vacancy, sorry!");
			return;
		}	
	}

//Check reservation for particular customer ID
	public void CheckReservation(int CustomerID) {
		for(int i = 0; i<this.arrayOfTables.size();i++) {
			if(this.arrayOfTables.get(i).getCustomerID()== CustomerID) {
				System.out.println("Booking found for customer " + CustomerID);
				System.out.println("Details are:");
				System.out.println("Table ID: " + this.arrayOfTables.get(i).getTableID());
				System.out.println("Booking time :" + this.arrayOfTables.get(i).getResTime());
				return;
			}
		}
		System.out.println("No booking found");
		return;
	}
	
//Check all reservations
	public void CheckAllReservation() {
		System.out.println("Customer IDs who have bookings are");
		for(int i = 0; i <this.arrayOfTables.size();i++) {
			if(this.arrayOfTables.get(i).getStatus()==TableStatus.RESERVED) {
				System.out.println(this.arrayOfTables.get(i).getCustomerID());
			}
		}
	}

//Remove reservation for all tables based on customer ID
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

//Remove reservation based on table ID
	public void RemoveReservationTableID(int TableID) {
		for(int i = 0; i<this.arrayOfTables.size();i++) {
			if(this.arrayOfTables.get(i).getTableID()  == TableID) {
				System.out.println("Removing booking  for customer " + TableID);
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

//Change status of customer's bookings from Reserved to Occupied
	public void CheckInCustomer(int CustomerID) {
		for (int i = 0; i < this.arrayOfTables.size();i++) {
			if(this.arrayOfTables.get(i).getCustomerID() == CustomerID) {
				this.arrayOfTables.get(i).setStatus(TableStatus.OCCUPIED);
			}
		}
	}

	//Check all tables that are reserved, and make them vacant if current time is >15 mins from reservation time
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

	//Get object of class Table with a given TableID
	public Table GetTableByID(int TableID) {
		Table selectedtable =null;
		for(int i =0; i<this.arrayOfTables.size(); i++) {
			if(this.arrayOfTables.get(i).getTableID() ==TableID) {
				 selectedtable =  this.arrayOfTables.get(i);
			}
		}
	return selectedtable;
	}
}
