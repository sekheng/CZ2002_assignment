package CZ2002_assignment;
import java.time.*;

public class Table {

	private TablePax seatsPax;
	private int noOfPax;
	LocalDateTime resTime = LocalDateTime.now() ;  //dummy values for reservation time and expiry, will be updated in constructor and setter.
	LocalDateTime resExpiry = LocalDateTime.now();
	private int tableID;
	private int customerID;
	private TableStatus status = TableStatus.VACANT;
	
	
	
	public Table(int noOfPax, LocalDateTime resTime, int tableID) {
		
		this.noOfPax = noOfPax;
		this.resTime = resTime;
		this.tableID = tableID;
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

	public void setSeatsPax(TablePax seatsPax) {
		if(this.noOfPax<=2) {
			this.seatsPax = TablePax.SMALLTABLE;
		}
		else if(this.noOfPax<=4) {
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
	

	

}
