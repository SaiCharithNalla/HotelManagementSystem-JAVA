package com.management.hotel;
import java.util.Scanner;

public class Address {
	//Declaring required fields
    public String street,city,state,country;
    public String houseNumber;
    
  //Constructor for the user class
    public Address() {
    	super();
    	this.street = "street";
    	this.city = "city";
    	this.state = "state";
    	this.country = "country";
    	this.houseNumber = "5/8-9";
    }
    
  //Getter and setter methods
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
    
	
	public void setAddress() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter House Number:");
		this.houseNumber = scan.next();
		scan.nextLine();
		System.out.print("Enter Street:");
		this.street = scan.next();
		scan.nextLine();
		System.out.print("Enter City:");
		this.city = scan.next();
		scan.nextLine();
		System.out.print("Enter State:");
		this.state = scan.next();
		scan.nextLine();
		System.out.print("Enter Country:");
		this.country = scan.next();
		scan.nextLine();
	}
	
	public void getAddress() {
	
		System.out.println("House Number :" + this.houseNumber);
		System.out.println("Street :" + this.street);
		System.out.println("City :" + this.city);
		System.out.println("State :" + this.state);
		System.out.println("Country:" + this.country);
	}
}
