package CZ2002_assignment;

import java.util.*;
import java.time.*;
import java.time.format.*;


public class RevenueReport {
	ArrayList<OrderInvoice> ArrayOfOrderInvoice = new ArrayList<OrderInvoice>();
	
	LocalDateTime invoiceTime;
	
	RevenueReport(){
		
	}
	
	public void GetOrderInvoice(LocalDateTime startDate,LocalDateTime endDate ){
		
		System.out.println("SEARCHING FOR INVOICES IN GIVEN TIME RANGE..........");
		
		for(int i=0;i<ArrayOfOrderInvoice.size();i++) {
			invoiceTime = ArrayOfOrderInvoice.get(i).getTime();
			if (invoiceTime.isBefore(endDate) && invoiceTime.isAfter(startDate)) {
				ArrayOfOrderInvoice.get(i).formatReceipt();
			}
		}
        
	}
	
	public void GetOrderInvoice(){
		
		System.out.println("PRINTING ALL RECIEPTS..........");
		
		for(int i=0;i<ArrayOfOrderInvoice.size();i++) {
				ArrayOfOrderInvoice.get(i).formatReceipt();
			}
		}
        

	public void StoreInvoice(OrderInvoice orderInvoice) {
		ArrayOfOrderInvoice.add(orderInvoice);
		System.out.println("Order Invoice Stored...");
	}
	
	
	
	
	

}
