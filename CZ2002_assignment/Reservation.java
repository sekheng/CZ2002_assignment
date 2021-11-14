package CZ2002_assignment;
/**
 * definition of resevervation
 * @author	Lee Sek Heng
 * @version	1.0
 * @since	2021-11-05
 */
public class Reservation {
	/**
	 * Number of people
	 */
	private int noOfPax;
	/**
	 * to check whether it's assigned.
	 * 0 as table unavailable
	 * 1 as table assigned
	 */
	private int assigned;
	/**
	 * know what customer is reserving
	 */
	private Customer currentCustomer = new Customer(null,0,false);
	/**
	 * what staff is attending to this
	 */
	private Staff currentStaff = new Staff(null, 0, null, null);	
	/**
	 * constructor for reservation
	 * @param customer	the customer
	 * @param staff		staff attending to this
	 * @param noOfPax	number of people
	 */
	public Reservation(Customer customer, Staff staff, int noOfPax) {
		this.currentCustomer = customer;
		this.currentStaff = staff;
		this.noOfPax = noOfPax;
		this.assigned = 0;   
	}
	/**
	 * get the current customer
	 * @return	customer who reserved it
	 */
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}
	/**
	 * get the staff attending it
	 * @return	return staff 
	 */
	public Staff getCurrentStaff() {
		return currentStaff;
	};
	/**
	 * to get whether is it available
	 * @return	assigned variable
	 */
	public int isAvailable() {   //gets value for assigned
		return assigned;
	}
	/**
	 * to get number of people in the reservation
	 * @return	number of people
	 */
	public int getNoOfPax() {
		return noOfPax;
	}
}
