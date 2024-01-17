package com.management.hotel;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Address adr = new Address();
		user Manager = new Manager("Manager","9999999999" , "111111111111",adr); // Upcasting
        Rooms rooms = new Rooms();	
        GenaralHotelmaintenance genaralHotelmaintenance=new GenaralHotelmaintenance();
        Thread th = new Thread(genaralHotelmaintenance);
        Address EmployeeAddress = new Address();
        Employee employee = new Employee(EmployeeAddress);
		 @SuppressWarnings("resource")
		 Scanner scan = new Scanner(System.in);
		 while(true){
			    System.out.println("Welcome To Manager Dashboard");
				System.out.println("Enter 1 to get the details of the manager");
				System.out.println("Enter 2 to  change details of the manager");
				System.out.println("Enter 3 to select the Number of Rooms in hotel");
				System.out.println("Enter 4 to View number of Rooms available");
				System.out.println("Enter 5 to View Employees List");
				System.out.println("Enter 6 to add an employee");
				System.out.println("Enter 7 to delete an employee");
				System.out.println("Enter 8 to assign the cleaning Staff.");	
				System.out.println("Enter 9 to  logout.");
				System.out.println("Enter Your Choice:");
				int choice = scan.nextInt();//accept user input

				switch(choice){
				case 1:
				Manager.getDetails();
				break;
				case 2: 
				Manager.changeDetails();
				Manager.getDetails();
				break;
				case 3:
				rooms.getNumberOfRooms();
				rooms.roomCreator();	
				break;	
				case 4:
			    rooms.getdetails();
				break;	
				case 5:
				employee.view();
				break;	
				case 6:
				employee.addEmployee();
				break;
				case 7:
				employee.deleteEmployee();
				break;
				case 8:
					th.start();
					th.join();
					th.interrupt();
				break;
				case 9: System.out.println("Logout Succesfull");
				System.exit(0);
				default: System.out.println("Incorrect input!!! Please re-enter choice from our menu");
				}
			}
	}    
	}   
		