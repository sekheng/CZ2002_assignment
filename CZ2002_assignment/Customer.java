package CZ2002_assignment;
/**
 * Customer definition class
 * @author Swapneel Bhatt
 *@version 1.0
 *@since 2021/11/14
 */
public class Customer extends ObjectName {
	/**
	 * identify the gender of the customer.
	 * 1 as male.
	 * 2 as female
	 */
	private int gender; 
	/**
	 * flag to indicate whether it has membership
	 */
	private boolean membership;
	/**
	 * customer ID. also meant as contact!
	 */
	private int custID;
	
	/**
	 * constructor for customer object
	 * @param name
	 * @param gender
	 * @param membership
	 */
	public Customer(String name, int gender, boolean membership) {
		super(name);
		this.gender = gender; 
		this.membership = membership;
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
