package CZ2002_assignment;
import java.time.LocalDateTime;
import java.util.*;
import java.lang.*;

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
		System.out.println("Number of small tables "+ this.smallTableno);
		this.medTableno = medTableno;
		System.out.println("Number of medium tables "+ this.medTableno);
		this.largeTableno = largeTableno;
		System.out.println("Number of large tables "+this.largeTableno);
		
		//Adding small tables to array of tables
		for(int i = 0 ; i< this.smallTableno; i++) {
			Table newTable = new Table(2,LocalDateTime.now(),i+1);
			this.arrayOfTables.add(newTable);
			
		}
		System.out.println("Small tables added");
		
		//Adding medium tables to array of tables
		for(int i = this.smallTableno ; i<(this.smallTableno+ this.medTableno); i++) {
			Table newTable = new Table(6,LocalDateTime.now(),i+1);
			this.arrayOfTables.add(newTable);
		}
		System.out.println("Medium tables added");
		//Adding large tables to array of tables
		for(int i = (this.smallTableno+this.medTableno); i<(this.smallTableno + this.medTableno + this.largeTableno); i++) {
			Table newTable = new Table(10,LocalDateTime.now(),i+1);
			this.arrayOfTables.add(newTable);
		}
		System.out.println("Large Tables added");
		
	}
	
	public void AddReservation(int Pax, LocalDateTime RezTime,String CustomerName, int CustomerID,int CustomerGender, boolean MembershipStatus) {
		Customer newCustomer = new Customer(CustomerName,CustomerGender,MembershipStatus,CustomerID);
		this.arrayOfCustomers.add(newCustomer);

		if(Pax<=2) {
			for(int i = 0; i<this.arrayOfTables.size();i++) {
				if((this.arrayOfTables.get(i).getSeatsPax() == TablePax.SMALLTABLE) && (this.arrayOfTables.get(i).getStatus()==TableStatus.VACANT)) {
					Table smallTable = new Table(Pax,RezTime,i);
					smallTable.setStatus(TableStatus.RESERVED);
					smallTable.setCustomerID(CustomerID);
					this.arrayOfTables.set(i, smallTable);
				}
			}
		}
		else if(Pax<=6) {
			for(int i = 0; i<this.arrayOfTables.size();i++) {
				if((this.arrayOfTables.get(i).getSeatsPax() == TablePax.MEDTABLE) && (this.arrayOfTables.get(i).getStatus()==TableStatus.VACANT)) {
					Table medTable = new Table(Pax,RezTime,i);
					medTable.setStatus(TableStatus.RESERVED);
					medTable.setCustomerID(CustomerID);
					this.arrayOfTables.set(i, medTable);
				}
			}
		}
		
		else {
			for(int i = 0; i<this.arrayOfTables.size();i++) {
				if((this.arrayOfTables.get(i).getSeatsPax() == TablePax.LARGETABLE) && (this.arrayOfTables.get(i).getStatus()==TableStatus.VACANT)) {
					Table largeTable = new Table(Pax,RezTime,i);
					largeTable.setStatus(TableStatus.RESERVED);
					largeTable.setCustomerID(CustomerID);
					this.arrayOfTables.set(i, largeTable);
				}
			}
					
		}	
			
	}
	
	

}
