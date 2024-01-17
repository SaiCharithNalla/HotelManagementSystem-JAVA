package com.management.hotel;

import java.io.File;
import java.util.Random;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Employee{
	private int EmpID;
	private String name;
	private String phone;
	private String aadhar;
	public Address address; 
	private String salary;
	//An array list of hashmaps 
	ArrayList<HashMap<String, String>> myArrList = new ArrayList<HashMap<String, String>>();
	HashMap<String, String> map;
	
	public Employee(Address address) {
		this.address = address;
		map = new HashMap<String, String>();
		map.put("EmpID","E001");
		map.put("Name", "Employee1");
		map.put("Phone Number", "9999999999");
		map.put("Aadhar Number", "123456789123");
		map.put("Salary", "25000");
		map.put("House Number", "5-7/8");
		map.put("Street", "street");
		map.put("City", "city");
		map.put("State", "State");
		map.put("country", "country");
		myArrList.add(map);

		map = new HashMap<String, String>();
		map.put("EmpID","E002");
		map.put("Name", "Employee2");
		map.put("Phone Number", "9999879999");
		map.put("Aadhar Number", "117654321123");
		map.put("Salary", "15000");
		map.put("House Number", "5-7/8");
		map.put("Street", "street");
		map.put("City", "city");
		map.put("State", "State");
		map.put("country", "country");
		myArrList.add(map);

		
		map = new HashMap<String, String>();
		map.put("EmpID","E003");
		map.put("Name", "Employee3");
		map.put("Phone Number", "9999666999");
		map.put("Aadhar Number", "1234567321987");
		map.put("Salary", "25000");
		map.put("House Number", "5-7/8");
		map.put("Street", "street");
		map.put("City", "city");
		map.put("State", "State");
		map.put("country", "country");
		myArrList.add(map);

		
		map = new HashMap<String, String>();
		map.put("EmpID","E004");
		map.put("Name", "Employee4");
		map.put("Phone Number", "8888888888");
		map.put("Aadhar Number", "654321789123");
		map.put("Salary", "29000");
		map.put("House Number", "5-7/8");
		map.put("Street", "street");
		map.put("City", "city");
		map.put("State", "State");
		map.put("country", "country");
		myArrList.add(map);
		
		 writeToFile();
	
	}
	
	//Add Employees
	public void addEmployee() {
		int n;
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		System.out.println("Enter number of Employees to add :");
		 n = S.nextInt();
	    for(int i = 0;i < n;i++) {
	    	String Empgen="E0";  
	    	setDetails();
	    	String Empgen2 = Empgen+i+5;
	    	map = new HashMap<String, String>();
			map.put("EmpID",Empgen2);
			map.put("Name", name);
			map.put("Phone Number", phone);
			map.put("Aadhar Number",aadhar);
			map.put("Salary", salary);
			map.put("House Number",this.address.getHouseNumber());
			map.put("Street", this.address.getStreet());
			map.put("City", this.address.getCity());
			map.put("State", this.address.getState());
			map.put("country", this.address.getCountry());
			myArrList.add(map);
	    }
	    writeToFile();
	}
	
	//Method to delete an employee
	public void deleteEmployee() {
		int index;
		
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		System.out.println("Enter ID of Employees to delete/Fire:");
		index = S.nextInt();
		index = index-1;
		myArrList.remove(index);
		 writeToFile();
	}
	
	//Method to view Employees list
	public void view() {
		System.out.println();
		System.out.println();
		System.out.println("===================Details===================");
		System.out.println("Employee ID:" + "                 "+"Employee Name:");
		System.out.println("=============================================");
		for (int i = 0; i < myArrList.size(); i++) {	
			System.out.println(myArrList.get(i).get("EmpID").toString() + "                 " + myArrList.get(i).get("Name").toString());
		}
		System.out.println("=============================================");
		System.out.println();
		System.out.println();
	}
	
	//Set details of Employees 
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
		System.out.print("Enter Salary:");
		this.salary=scan.next();
		scan.nextLine();
		System.out.print("Address:");
		address.setAddress();
	}
	
	//Method to write into a file 
	@SuppressWarnings("resource")
	public void writeToFile()  {
		try {
			
			
			
			
			File Employee =new File("Employee.csv");
			
			
			FileWriter writer;
			writer = new FileWriter(Employee, false);  
			writer.write("Employee ID");
			writer.write(",");
			writer.write("Name");
			writer.write(",");
			writer.write("Phone Number");
			writer.write(",");
			writer.write("Adhaar Number");
			writer.write(",");
			writer.write("Salary");
			writer.write(",");
			writer.write("House Number");
			writer.write(",");
			writer.write("Street");
			writer.write(",");
			writer.write("City");
			writer.write(",");
			writer.write("State");
			writer.write(",");
			writer.write("country");
			writer.write("\r\n");
			
			for (int i = 0; i < myArrList.size(); i++) {	 
				writer.write(myArrList.get(i).get("EmpID").toString());
				writer.write(",");
				writer.write(myArrList.get(i).get("Name").toString());
				writer.write(",");
				writer.write(myArrList.get(i).get("Phone Number").toString());
				writer.write(",");
				writer.write(myArrList.get(i).get("Aadhar Number").toString());
				writer.write(",");
				writer.write(myArrList.get(i).get("Salary").toString());
				writer.write(",");
				writer.write(myArrList.get(i).get("House Number").toString());
				writer.write(",");
				writer.write(myArrList.get(i).get("Street").toString());
				writer.write(",");
				writer.write(myArrList.get(i).get("City").toString());
				writer.write(",");
				writer.write(myArrList.get(i).get("State").toString());
				writer.write(",");
				writer.write(myArrList.get(i).get("country").toString());
				writer.write("\r\n");
				

			}
			
			
			writer.close();
			
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
		

	

}




