package CZ2002_assignment;
import java.time.*;

public class Table {
	private boolean reservationStatus;
	private boolean occupancyStatus;
	private int seatsPax;
	private LocalDateTime resExpiry;
	private int tableID;
	private int customerContact;
	public boolean isReservationStatus() {
		return reservationStatus;
	}
	public boolean isOccupancyStatus() {
		return occupancyStatus;
	}
	public int getSeatsPax() {
		return seatsPax;
	}
	public LocalDateTime getResExpiry() {
		return resExpiry;
	}
	public int getTableID() {
		return tableID;
	}
	public int getCustomerContact() {
		return customerContact;
	}
	

}
