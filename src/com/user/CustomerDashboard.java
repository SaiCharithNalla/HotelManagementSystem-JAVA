package com.user;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

import com.management.hotel.Address;

public class CustomerDashboard {
	
 
	public static void main(String[] args) throws IOException, InterruptedException {
		Address CustomerAddress = new Address();
		Customer customer = new Customer(null, null, null, CustomerAddress);
		Amenities amenities = new Amenities();
		Bill bill = new Bill();	
		Cleaning s1 = new Cleaning();
		Repairing s2 = new Repairing();
		Restaurant restaurant = new Restaurant();
		RoomBooking newRoom = new RoomBooking(amenities);
		
		float restaurantBill =0f;
		RoomService<Cleaning> th1 = new RoomService();	
		RoomService<Repairing> th2 = new RoomService();
		System.out.println("Enter Customer Details:");
		customer.setDetails();
		System.out.println("Starting room booking:");
		newRoom.bookRoom();
		Scanner scan = new Scanner(System.in);
		System.out.println("Customer Dashboard:");
		 while(true){
				System.out.println("Enter 1 to get the details of the Customer");
				System.out.println("Enter 2 to get change details of the Customer");
				System.out.println("Enter 3 to View Room Services");
				System.out.println("Enter 4 to View Restaurant Services");
				System.out.println("Enter 5 to Pay bill and Checkout");
				System.out.println("To Exit, Enter value 9");
				System.out.println("Enter your choice::");
				int choice = scan.nextInt();//accept user input

				switch(choice){
				case 1:
				customer.getDetails();
				break;
				case 2: 
			    customer.changeDetails();
				customer.getDetails();
				break;
				case 3:
				{
					int choice1;
					String  ch="n";
					
					do 
					{
						System.out.println("Enter number:");
						System.out.println("1.cleaning");
						System.out.println("2.Repairing");
						choice1=scan.nextInt();
						switch(choice1)
						{
						case 1:
						{
							s1.cleaning();
							th1.run();
							th1.join();
							LocalTime myObj1 = LocalTime.now();
							th1.genericDisplay(s1,myObj1);
							break;
						}
						case 2:
						{
							s2.repairing();
							th2.run();
							th2.join();
							LocalTime myObj2 = LocalTime.now();
							th2.genericDisplay(s2,myObj2);
							break;
						}
				
			}    
					}while (ch=="y"||ch=="Y");
			}
				
				break;	
				case 4:
				restaurantBill = restaurant.menu();
				break;	
				case 5:
				customer.printDetails();	
				bill.getBill(newRoom.getNumOfDays(),newRoom.getchoice(), newRoom.getI(), newRoom.getN(), amenities.isSpa(), amenities.isBar(), amenities.isDisco(), amenities.isGolf(), amenities.isTrek(), restaurantBill,newRoom.getTotalOccupants(),newRoom.getBillAmt());
				
				bill.FileWriter();
				newRoom.checkout();
				System.out.println("Logout Succesfull");
				System.exit(0);
				case 9: System.out.println("Logout Succesfull");
				System.exit(0);
				default: System.out.println("Incorrect input!!! Please re-enter choice from our menu");
				}
			}
		 
		 
		 
	
	}

	

}
	
	

