package CZ2002_assignment;

public class Reservation {
	private int noOfPax;
	private int assigned;  //available or not, 0 - table unavailable, 1-table assigned
	private Customer currentCustomer = new Customer(null,0,false);
	private Staff currentStaff = new Staff(null, 0, null, null);	
	
	public Reservation(Customer customer, Staff staff, int noOfPax) {
		this.currentCustomer = customer;
		this.currentStaff = staff;
		this.noOfPax = noOfPax;
		this.assigned = 0;   
	}

	public Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public Staff getCurrentStaff() {
		return currentStaff;
	};

	public int isAvailable() {   //gets value for assigned
		return assigned;
	}

	public int getNoOfPax() {
		return noOfPax;
	}
	
	
	
	

}
