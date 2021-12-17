package model;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String postCode;
	private String postOffice;

	public Student() {
		id = -1;
		firstName = "";
		lastName = "";
		streetAddress = "";
		postCode = "";
		postOffice = "";
	}

	public Student(int id, String firstName, String lastName, String streetAddress, String postCode,
			String postOffice) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.postCode = postCode;
		this.postOffice = postOffice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStrAddress() {
		return streetAddress;
	}

	public void setStrAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPostOffice() {
		return postOffice;
	}

	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}
	
	@Override
	public String toString() {
		return id + ": " + firstName + " " + lastName + ", " + streetAddress + ", " + postCode + " " + postOffice;
	}
}
