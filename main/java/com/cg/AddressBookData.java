package com.cg;

public class AddressBookData {

	public String firstName;
	private String lastName;
	private double address;
	private String city;
	private String state;
	private double zip;
	private double phone_Number;
	public String email;
	
	public AddressBookData(String firstName, String lastName, double address, String city, String state, double zip,
			double phone_Number, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone_Number = phone_Number;
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressBookData other = (AddressBookData) obj;
		if (Double.doubleToLongBits(address) != Double.doubleToLongBits(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Double.doubleToLongBits(phone_Number) != Double.doubleToLongBits(other.phone_Number))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (Double.doubleToLongBits(zip) != Double.doubleToLongBits(other.zip))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddressBookData [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", phone_Number=" + phone_Number + ", email=" + email
				+ "]";
	}
	
}
