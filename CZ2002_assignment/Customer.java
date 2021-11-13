package CZ2002_assignment;

public class Customer {
	private String name;
	private int gender; //1- male, 2- female
	private boolean membership;
	private int custID;
	
	public Customer(String name, int gender, boolean membership) {
		this.name = name;
		this.gender = gender; 
		this.membership = membership;
	}

	public String getName() {
		return this.name;
	}
	public int getCustID() {
		return this.custID;
	}

	public int getGender() {
		return this.gender;
	}

	public boolean isMembership() {
		return this.membership;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

}
