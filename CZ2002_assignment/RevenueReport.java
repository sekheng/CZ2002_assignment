package CZ2002_assignment;

import java.util.*;
import java.time.*;
import java.time.format.*;

/**
Represents a Revenue Report containing all the Order Invoices 
Each Order Invoice depicts One order assigned to a table
A Order Manager has a Revenue Report 
@author Kanupriya Malhotra 
@version 1.0
@since 2021-11-10
*/


public class RevenueReport {
	
	/**
	 * Array containing all OrderInvoices and details of Order 
	 */
	ArrayList<OrderInvoice> ArrayOfOrderInvoice = new ArrayList<OrderInvoice>();
	
	/**
	 * Date of Issue of an invoice  
	 */
	LocalDateTime invoiceTime;
	
	 /**
	 * Creates a new Revenue Report
	 */
	RevenueReport(){
		
	}
	
	
	
	
	 /**
	 * Gets Order Invoices in a specified period of time
	 * Searches through Array of Orders to get Order Invoice's date and time of Issue 
	 * Prints the Order Invoices issued within the specific period of Time 
	 * @param start Date for search (lower limit for search) 
	 * @param end Date for search (upper limit for search) 
	 */
	public void GetOrderInvoice(LocalDateTime startDate,LocalDateTime endDate ){
		
		System.out.println("SEARCHING FOR INVOICES IN GIVEN TIME RANGE..........");
		
		for(int i=0;i<ArrayOfOrderInvoice.size();i++) {
			invoiceTime = ArrayOfOrderInvoice.get(i).getTime();
			if (invoiceTime.isBefore(endDate) && invoiceTime.isAfter(startDate)) {
				ArrayOfOrderInvoice.get(i).formatReceipt();
			}
		}
        
	}
	
	
	
	
	 /**
	 * Gets Order Invoices all Order Invoices
	 * Prints all Order Invoices in Revenue Report 
	 */
	public void GetOrderInvoice(){
		
		System.out.println("PRINTING ALL RECIEPTS..........");
		
		for(int i=0;i<ArrayOfOrderInvoice.size();i++) {
				ArrayOfOrderInvoice.get(i).formatReceipt();
			}
		}
	
	
        
	/**
	 * Stores Order Invoice into Revenue Report 
	 * Prints Order Invoice Stores to show confirmation 
	 * @param Order Invoice that needs to be stoerd into Revenue Report 
	 */
	public void StoreInvoice(OrderInvoice orderInvoice) {
		ArrayOfOrderInvoice.add(orderInvoice);
		System.out.println("Order Invoice Stored...");
	}
}
