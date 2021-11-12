package CZ2002_assignment;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.*;


public class OrderManager {

	private  ArrayList<Order> ArrayofOrders = new ArrayList<Order>();
	private RevenueReport revenueReport = new RevenueReport();
	
	
	public OrderManager(){
		this.ArrayofOrders = ArrayofOrders;
	}
		
	
	public String addOrder(Order order){
		ArrayofOrders.add(order);
		String confirmation = "Successfully added Order";
		return confirmation;
		
	}
	
	public void removeOrder(int TableID) {
		int flag =0;
		String cancellation;
		for(int i =0; i<ArrayofOrders.size();i++) {
			if(ArrayofOrders.get(i).getTableID() == TableID) {
				ArrayofOrders.remove(i);
				flag=1;
			}
		}

		if(flag == 0) cancellation = "No order found for this tableID";
		else cancellation = "Order Cancelled";
		System.out.println(cancellation);
	}
	
	
	public void printReceipt(int tableID, float discount, float tax) {
		
		Order order = this.getOrder(tableID);
		OrderInvoice orderInvoice = new OrderInvoice(order, LocalDateTime.now(),discount,tax);
		orderInvoice.formatReceipt();
		this.removeOrder(tableID);
		revenueReport.StoreInvoice(orderInvoice);
		
		
	}
	
	public ArrayList<Order> getArrayofOrder(){
		return this.ArrayofOrders;
	}

	
	public Order getOrder(int TableID) {
		Order selectedOrder =null;
		
		// Search for Order by tableID 
		for(int i =0; i<ArrayofOrders.size();i++) {
			if(ArrayofOrders.get(i).getTableID() == TableID) {
				selectedOrder = ArrayofOrders.get(i);
			}
		}
		//Check whether tableID existed in ArrayofOrders 
		if(selectedOrder == null) {
			System.out.println("No such tableID has been assigned an Order");
		}
		
		return selectedOrder;
	}
	
	
	public RevenueReport getRevenueReport() {
		return this.revenueReport;
	}

	
}
