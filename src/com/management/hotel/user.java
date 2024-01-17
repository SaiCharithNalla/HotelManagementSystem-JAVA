package com.management.hotel;
public abstract class user {
	//Declaring required fields
	public String name;
	public String phone;
	public String aadhar;
	
	
	//Parameterized Constructor for the user class
	public user(String name, String phone2, String aadhar2) {
		this.name = name;
		this.phone = phone2;
		this.aadhar = aadhar2;
	}
	

	//Getter and setter methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}


   //abstract methods
	public abstract void setDetails();
	public abstract void getDetails();
	 public abstract void changeDetails();
}
