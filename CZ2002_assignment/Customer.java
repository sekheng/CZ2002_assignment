package CZ2002_assignment;

public class Customer extends ObjectName{
	private int gender; //1- male, 2- female
	private boolean membership;
	private int custID;
	
	public Customer(String name, int gender, boolean membership, int custID) {
		super(name);
		this.gender = gender; 
		this.membership = membership;
		this.custID = custID;
	}

	public int getCustID() {
		return this.custID;
	}

	public String getName() {
		return this.name;
	}


	public int getGender() {
		return this.gender;
	}

	public boolean isMembership() {
		return this.membership;
	}

}
