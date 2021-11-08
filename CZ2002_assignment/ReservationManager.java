package CZ2002_assignment;
import java.time.LocalDateTime;
import java.util.*;

public class ReservationManager {
	private ArrayList<Table> arrayOfTables = new ArrayList<Table>();
	private int smallTableno;
	private int medTableno;
	private int largeTableno;
	
	
	//Array of tables is filled up according to size, with first all small tables, then all medium tables, then all Large tables
	//Table IDs start from 1
	//ID numbers 1 -> smallTableNo : small tables
	//ID numbers smallTableNo+1 -> smallTableNo + medTableNo : medium tables
	//ID numbers smallTableNo + medTableNo +1 -> smallTableNo + medTableNo + largeTableNo : large tables
	
	private ArrayList<Customer> arrayOfCustomers = new ArrayList<Customer>();
	
	public ReservationManager(int smallTableno, int medTableno, int largeTableno) {
		this.smallTableno = smallTableno;
		this.medTableno = medTableno;
		this.largeTableno = largeTableno;
		
		//Adding small tables to array of tables
		for(int i = 0 ; i< this.smallTableno; i++) {
			Table newTable = new Table(2,LocalDateTime.now(),i+1);
			this.arrayOfTables.add(newTable);
		}
		
		//Adding medium tables to array of tables
		for(int i = this.smallTableno ; i<(this.smallTableno+ this.medTableno); i++) {
			Table newTable = new Table(6,LocalDateTime.now(),i+1);
			this.arrayOfTables.add(newTable);
		}
		
		//Adding large tables to array of tables
		for(int i = this.smallTableno+this.medTableno; i<(this.smallTableno + this.medTableno + this.largeTableno) ; i++) {
			Table newTable = new Table(10,LocalDateTime.now(),i=1);
			this.arrayOfTables.add(newTable);
		}
		
	}
	
	public void AddReservation(int Pax, LocalDateTime RezTime,String customerName, int customerID,int customerGender, boolean membershipStatus) {
		Customer newCustomer = new Customer(customerName,customerGender,membershipStatus,customerID);
		this.arrayOfCustomers.add(newCustomer);

		if(Pax<=2) {
			for(int i = 0; i<this.arrayOfTables.size();i++) {
				if((this.arrayOfTables.get(i).getSeatsPax() == TablePax.SMALLTABLE) && (this.arrayOfTables.get(i).getStatus()==TableStatus.VACANT)) {
					Table smallTable = new Table(Pax,RezTime,i);
					smallTable.setStatus(TableStatus.RESERVED);
					smallTable.setCustomerID(customerID);
					smallTable.setResExpiry();
					this.arrayOfTables.set(i, smallTable);
				}
			}
		}
		else if(Pax<=6) {
			for(int i = 0; i<this.arrayOfTables.size();i++) {
				if((this.arrayOfTables.get(i).getSeatsPax() == TablePax.MEDTABLE) && (this.arrayOfTables.get(i).getStatus()==TableStatus.VACANT)) {
					Table medTable = new Table(Pax,RezTime,i);
					medTable.setStatus(TableStatus.RESERVED);
					medTable.setCustomerID(customerID);
					medTable.setResExpiry();
					this.arrayOfTables.set(i, medTable);
				}
			}
		}
		
		else {
			for(int i = 0; i<this.arrayOfTables.size();i++) {
				if((this.arrayOfTables.get(i).getSeatsPax() == TablePax.LARGETABLE) && (this.arrayOfTables.get(i).getStatus()==TableStatus.VACANT)) {
					Table largeTable = new Table(Pax,RezTime,i);
					largeTable.setStatus(TableStatus.RESERVED);
					largeTable.setCustomerID(customerID);
					largeTable.setResExpiry();
					this.arrayOfTables.set(i, largeTable);
				}
			}
					
		}	
			
	}
	public void RemoveReservation(int customerID) {
		for(int i = 0;i<this.arrayOfTables.size();i++) {
			if(this.arrayOfTables.get(i).getCustomerID()==customerID) {
				System.out.println("Removed reservation for customer number " + customerID + " at table number" + this.arrayOfTables.get(i).getTableID());
				this.arrayOfTables.remove(i);
				return;
			}
		}
		System.out.println("No booking found for this customer ID");
	}
	
	public void CheckReservation(int customerID) {
		for(int i = 0; i <this.arrayOfTables.size();i++) {
			if(this.arrayOfTables.get(i).getCustomerID() == customerID) {
				System.out.println("Booking found for customer number " + customerID + " at table number " + this.arrayOfTables.get(i).getTableID() + "at time " + this.arrayOfTables.get(i).getResTime());
			}
		}
	}
	public void CheckTable(int tableID) {
		for(int i = 0; i<this.arrayOfTables.size();i++) {
			if(this.arrayOfTables.get(i).getTableID()==tableID) {
				System.out.println("Status of table number " + this.arrayOfTables.get(i).getTableID() + " is " + this.arrayOfTables.get(i).getStatus());
			}
		}
	}
}
