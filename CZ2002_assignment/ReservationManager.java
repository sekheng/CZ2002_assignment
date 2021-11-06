package CZ2002_assignment;
import java.util.*;

public class ReservationManager {
	Scanner sc = new Scanner(System.in);
	private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	
	public void addReservation(Customer customer, Staff staff, int noOfPax) {
		Reservation r = new Reservation(customer, staff, noOfPax);
		reservationList.add(r);
		System.out.println("Added Reservation for customer" + r.getCurrentCustomer().getName());
	}
	

//Remove Reservation code has some doubts, need to clarify with YouXiang
	
	
	public void removeReservation(int customerContact) {  //delete reservation based on customer contact
		for(int i = 0; i<reservationList.size(); i++) {
			if(customerContact == reservationList.get(i).getCurrentCustomer().getContact()) {
				reservationList.remove(i);
			}
		}
		
	}
	
	public void checkReservation(int customerContact) {
		for(int i = 0; i<reservationList.size(); i++) {
			if(customerContact == reservationList.get(i).getCurrentCustomer().getContact()) {
				System.out.println("Reservation for " + reservationList.get(i).getCurrentCustomer().getName() + "Found");
				return;
			}
		System.out.println("No reservation found");
		}
		
	}
	
	

}
