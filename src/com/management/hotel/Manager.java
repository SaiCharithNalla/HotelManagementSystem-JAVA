package com.management.hotel;
import java.util.Scanner;

public class Manager extends user{
	private Address address;
	
	public Manager(String name, String phone2, String aadhar2,Address address) {
		super(name, phone2, aadhar2);
		this.address = address;
	}


	
	@Override
	public void getDetails() {
		//TODO 
		System.out.println();
		System.out.println();
		System.out.println("===================Details===================");
		System.out.println("Name :" + this.name);
		System.out.println("Phone :" + this.phone);
		System.out.println("Aadhar Number:" + this.aadhar);
		System.out.println("Address:");
		address.getAddress();
		System.out.println("=============================================");
		System.out.println();
		System.out.println();
	}

	@Override
	public void setDetails() {
		//TODO
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Name:");
		this.name = scan.next();
		scan.nextLine();
		System.out.print("Enter Phone Number:");
		this.phone=scan.next();
		scan.nextLine();
		System.out.print("Enter Aadhar Number:");
		this.aadhar=scan.next();
		scan.nextLine();
		System.out.print("Address:");
		address.setAddress();
	}
	
	
	public void changeDetails() {
		Scanner scan = new Scanner(System.in);
		
        int abc = 1;
		
		while(abc == 1) {
			System.out.println("To change All details, Enter value 0");
			System.out.println("To change Name, Enter value 1");
			System.out.println("To change Phone Number, Enter value 2");
			System.out.println("To change Adhaar Number, Enter value 3");
			System.out.println("To change Adress, Enter value 4");
			System.out.println("To Exit, Enter value 9");
			
			System.out.println("Enter your choice::");
			int choice = scan.nextInt();//accept user input

			switch(choice){
			case 0:
			setDetails();
			break;
			case 1: System.out.println("Enter Name:");
			this.name = scan.next();
			scan.nextLine();
			break;
			case 2: System.out.print("Enter Phone Number:");
			this.phone=scan.next();
			scan.nextLine();
			break;
			case 3:System.out.print("Enter Aadhar Number:");
			this.aadhar=scan.next();
			scan.nextLine();
			break;
			case 4:
			address.setAddress();
			break;
			case 9: System.out.println();
			abc = 0;
			break;
			default: System.out.println("Incorrect input!!! Please re-enter choice from our menu");
			}
			
		}

	}

}
