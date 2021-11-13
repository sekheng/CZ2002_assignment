package CZ2002_assignment;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.*;

/**
Represents a an Order Manager 
An Order Manager consists of a list Orders allocated to different Tables 
An Order Manager has a Revenue Report that tracks all Order Invoices
Database for all Existing Orders and their Details 

@author Kanupriya Malhotra 
@version 1.0
@since 2021-11-10
*/

public class OrderManager {
	
	/**
	 * Array containing all Orders and their details 
	 */
	private  ArrayList<Order> ArrayofOrders = new ArrayList<Order>();
	
	/**
	 * The Revenue Report for this Order Manager that keeps track of all Order Invoices 
	 */
	private RevenueReport revenueReport = new RevenueReport();
	
	/**
	 * Creates an OrderManager 
	 */
	public OrderManager(){
		this.ArrayofOrders = ArrayofOrders;
	}
		
	
	
	
	/**
	 * Adds an Order to the Order Manager. 
	 * Adds Order to the Array of Orders 
	 * @return confirmation of whether the order has been successfully added or not 
	 */
	public String addOrder(Order order){
		ArrayofOrders.add(order);
		String confirmation = "Successfully added Order";
		return confirmation;	
	}
	
	
	
	
	/**
	 * Removes an Order from the Order Manager based on the TableID of the Order. 
	 * Checks whether the TableID has an order attached to it 
	 * Removes Order from the Array of Orders 
	 * Prints whether the Order was successfully cancelled 
	 */
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
	
	
	
	
	/**
	 * Prints the receipt of the intended Order based on the TableID, tax, and discount 
	 * Checks whether the TableID has an order attached to it 
	 * Removes Order from the Array of Orders 
	 * Prints whether the Order was successfully cancelled 
	 * Stores Order Invoice into Revenue Report 
	 */
	public void printReceipt(int tableID, float discount, float tax) {
		
		Order order = this.getOrder(tableID);
		if(order != null) {
			OrderInvoice orderInvoice = new OrderInvoice(order, LocalDateTime.now(),discount,tax);
			orderInvoice.formatReceipt();
			this.removeOrder(tableID);
			revenueReport.StoreInvoice(orderInvoice);
		}
	}

	
	
	
	/**
	 * Gets Array of Orders in the OrderManager 
	 * @return Array of Orders
	 */
	public ArrayList<Order> getArrayofOrder(){
		return this.ArrayofOrders;
	}
	
	

	
	/**
	 * Gets Order assigned to a specific Table ID 
	 * @return Order assigned to the Table ID
	 */
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
	
	
	

	/**
	 * Gets Revenue Report for this Order Manager 
	 * @return Revenye Report for this Order Manager 
	 */
	public RevenueReport getRevenueReport() {
		return this.revenueReport;
	}

	
}
