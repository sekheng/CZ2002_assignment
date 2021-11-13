package CZ2002_assignment;
/**
 * Customer definition class
 * @author swapneelbhatt
 *@version 1.0
 *@since 2021/11/14
 */
public class Customer {
	private String name;
	private int gender; //1- male, 2- female
	private boolean membership;
	private int custID;
	
	/**
	 * constructor for customer object
	 * @param name
	 * @param gender
	 * @param membership
	 */
	public Customer(String name, int gender, boolean membership) {
		this.name = name;
		this.gender = gender; 
		this.membership = membership;
	}

	/**
	 * getter for customer name
	 * @return customer name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * getter for customer ID
	 * @return customer id
	 */
	public int getCustID() {
		return this.custID;
	}

	/**
	 * getter for customer gender
	 * @return customer gender
	 */
	public int getGender() {
		return this.gender;
	}

	/**
	 * getter for membership boolean
	 * @return customer membership boolean
	 */
	public boolean isMembership() {
		return this.membership;
	}

	/**
	 * setter for customer ID
	 * @param custID
	 */
	public void setCustID(int custID) {
		this.custID = custID;
	}

}
