package CZ2002_assignment;
import java.time.*;


/**
Represents a Table 
A Table can be of three different sizes depending on the number of people it can accomodate 
A Table can have one of the three status at one time : Vacant, Occupied or Reserved 
@author Swapneel Bhatt
@version 1.0
@since 2021-11-1
*/
public class Table {

	
	/**
	 * The category of table size 
	 */
	private TablePax seatsPax;
	
	/**
	 * The number of People to be assigned to a table 
	 */
	private int noOfPax;
	
	/**
	 * The time of Reservation 
	 */
	LocalDateTime resTime = LocalDateTime.now() ;  //dummy values for reservation time and expiry, will be updated in constructor and setter.
	
	/**
	 * The time of Reservation Expiry 
	 */
	LocalDateTime resExpiry = LocalDateTime.now();
	
	
	/**
	 * The Table ID (Unique for each table)
	 */
	
	private int tableID;
	
	/**
	 * The Customer ID assigned to the Table 
	 */
	private int customerID =0;
	
	/**
	 * The status of the Table indicating its availibility 
	 */
	private TableStatus status = TableStatus.VACANT;
	
	/** 
	 * The name of the Customer assigned to the table
	 */
	private String customerName;
	
	/**
	 * Creates a new Table given the number of people needed to be accomodated  
	 * The name should include both first and
	 * last name.
	 * @param noOfPax : number of people on a table
	 * @param tableID : system assigned table ID
	 */
	public Table(int noOfPax, int tableID) {
		
		this.noOfPax = noOfPax;
		this.tableID = tableID;
		this.setSeatsPax();
	}

	/**
	 * getter for customer ID
	 * @return customer ID
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * setter for customer ID
	 * @param customerID new customer ID
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	/**
	 * getter for table ID
	 * @return new table ID
	 */
	public int getTableID() {
		return tableID;
	}

	/**
	 * setter for table size (small,medium,table)
	 */
	public void setSeatsPax() {
		if(this.noOfPax<=2) {
			this.seatsPax = TablePax.SMALLTABLE;
		}
		else if(this.noOfPax<=6) {
			this.seatsPax = TablePax.MEDTABLE;
		}
		else if(this.noOfPax<=10) {
			this.seatsPax = TablePax.LARGETABLE;
		}
	}


/**
 * setter for table status : vacant,reserved, or occupied
 * @param status new status of the table
 */
	public void setStatus(TableStatus status) {
		this.status = status;
	}

/**
 * reservation expiry setter
 * expiry time : 15 mins after booking time
 */
	public void setResExpiry() {
		this.resExpiry = this.resTime.plusMinutes(15);
	}


/**
 * getter for table size - small, medium, large
 * @return
 */
	public TablePax getSeatsPax() {
		return seatsPax;
	}
	
/**
 * getter for table status
 * @return vacant, occupied, or reserved
 */
	public TableStatus getStatus() {
		return status;
	}

	/**
	 * getter for reservation time
	 * @return Date and Time
	 */
	public LocalDateTime getResTime() {
		return resTime;
	}

	/**
	 * setter for reservation time
	 * @param resTime new time for the table
	 */
	public void setResTime(LocalDateTime resTime) {
		this.resTime = resTime;
	}

	/**
	 * getter for customer name
	 * @return customer name
	 */
	public String getCustomerName() {
		return customerName;
	}
	
	/**
	 * setter for customer name
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	

	

}
