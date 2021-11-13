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
	private int customerID;
	
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
	 * @param 
	 * @param
	 */
	public Table(int noOfPax, int tableID) {
		
		this.noOfPax = noOfPax;
		this.tableID = tableID;
		this.setSeatsPax();
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getTableID() {
		return tableID;
	}

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



	public void setStatus(TableStatus status) {
		this.status = status;
	}


	public void setResExpiry() {
		this.resExpiry = this.resTime.plusMinutes(15);
	}



	public TablePax getSeatsPax() {
		return seatsPax;
	}

	public TableStatus getStatus() {
		return status;
	}

	public LocalDateTime getResTime() {
		return resTime;
	}

	public void setResTime(LocalDateTime resTime) {
		this.resTime = resTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	

	

}
