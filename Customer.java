package CZ2002_assignment;

public class Customer {
	private String name;
	private int gender;
	private boolean membership;
	private int contact;
	
	public Customer(String name, int gender, boolean membership, int contact) {
		this.name = name;
		this.gender = gender;
		this.membership = membership;
		this.contact = contact;
	}

	public int getContact() {
		return contact;
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
