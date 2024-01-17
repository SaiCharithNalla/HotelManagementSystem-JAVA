package com.user;
import com.management.hotel.*;

import java.io.FileWriter;
import java.util.Scanner;

class Customer extends user{	
	public Address address;
	
	public Customer(String name, String phone2, String aadhar2,Address address) {
		super(name, phone2, aadhar2);
		this.address = address;
	}
	

	

	public void getDetails() {
		System.out.println();
		System.out.println();
		System.out.println("===================Details===================");
		System.out.println("Name :" + this.name);
		System.out.println("Phone :" + this.phone);
		System.out.println("Aadhar Number:" + this.aadhar);
		address.getAddress();
		System.out.println("=============================================");
		System.out.println();
		System.out.println();
	}
	
	public void printDetails() {
		
		try{    
	           FileWriter fw=new FileWriter("Bill.txt",false); 
	           fw.write("Customer Details");
	           fw.write("\n");
	           fw.write("\n");
	           fw.write("Name :" + this.name);
	           fw.write("\n");
	           fw.write("Phone :" + this.phone);
	           fw.write("\n");
	           fw.write("Aadhar Number:" + this.aadhar);
	           fw.write("\n");
	          
	           
	           
	           
	           fw.close();    
	          }catch(Exception e){System.out.println(e);}    
	             
		
	}
	
	@Override
	public void setDetails() {
		@SuppressWarnings("resource")
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