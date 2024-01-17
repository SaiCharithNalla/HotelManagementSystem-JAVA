package com.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File; 
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class RoomBooking {
	private int i,n,count;
	public float bill = 0f;
	HashMap<Integer,String> standardrooms;
	HashMap<Integer,String> deluxerooms;
	HashMap<Integer,String> luxuryrooms;
	public Amenities RoomAmenities;
	public int choice;	
	public int NumOfDays;
	int TotalOccupants;
	
	public int getTotalOccupants() {
		return TotalOccupants;
	}
	public int getI() {
		return i;
	}


	public void setI(int i) {
		this.i = i;
	}


	public int getchoice() {
		return choice;
	}
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}


	public int getNumOfDays() {
		return NumOfDays;
	}


	public void setNumOfDays(int numOfDays) {
		NumOfDays = numOfDays;
	}
	
	public float getBillAmt() {
		return BillAmt;
	}

	public float BillAmt;
	public static float LuxuryRoomCost = 10000f; //perDay
	public static final float deluxcost = 6000f;
	public static final float Standardcost = 3000f;
	HashMap<Integer,String> allRooms;
	
	public RoomBooking(Amenities RoomAmenities) {
		this.RoomAmenities = RoomAmenities;
		standardrooms=new HashMap<Integer,String>();
		deluxerooms=new HashMap<Integer,String>();
		luxuryrooms=new HashMap<Integer,String>();
		HashMapFromTextFile();
		 
	}
	

	public void HashMapFromTextFile()
	{
		

		BufferedReader br = null;

		try {

			
			File file = new File("Rooms.csv");

			br = new BufferedReader(new FileReader(file));

			String line = null;

			
			br.readLine();
			while ((line = br.readLine()) != null) {

		
				String[] parts = line.split(",");


				String number = parts[0].trim();
				String name = parts[1].trim();


				 int roomnumber = Integer.parseInt(number);
				if (!name.equals("") && !number.equals("")) {
					if(roomnumber > 100 && roomnumber < 200) {standardrooms.put(roomnumber, name);}
					else if(roomnumber > 200 && roomnumber < 300) {deluxerooms.put(roomnumber, name);}
					else if(roomnumber > 300 && roomnumber < 400) {luxuryrooms.put(roomnumber, name);}
			}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {

		
			if (br != null) {
				try {
					br.close();
				}
				catch (Exception e) {
				};
			}
		}
}
	
	
	//Methods to View Available Rooms	
		public void getdetails(){
			count(standardrooms,1);
			count(deluxerooms,2);
			count(luxuryrooms,3);
		}
		
		
		public boolean checkAvailability(HashMap<Integer, String> deroom) {
			boolean isAvailable = false;
			
			for(Map.Entry<Integer,String> m :deroom.entrySet()){
				
				
				String temp = m.getValue();
				if(m.getValue().toString() == temp) {
					this.n = m.getKey();
					System.out.println("Room No = " + n);
					isAvailable = true;
					System.out.println("Room is available");
					deroom.put(n,"Occupied");
					
					break;
				}
		    }
			
			return isAvailable;

		}
		
		public void bookRoom() {
			
			boolean Available = false,Okay = false;
			Scanner scan = new Scanner(System.in);

				
			do {
				System.out.println("Choose type of room: 1-Standard,2-Deluxe,3-Luxary");
				choice = scan.nextInt();
				if(choice ==1) {Available = checkAvailability(standardrooms); }
				else if(choice == 2) {Available = checkAvailability(deluxerooms); }
				else if(choice == 3) {Available = checkAvailability(luxuryrooms); }
				
			} while (Available == false);
			do {

					System.out.println("Enter number of occupants");
					TotalOccupants = scan.nextInt();
					if (TotalOccupants > 4) {
						System.out.println("Maximum Allowed Occupants = 4");
					}	
					else if(TotalOccupants <= 4) {
						Okay = true;
						System.out.println("Room booked Succesfully");
					}
			} while (Okay == false);
			System.out.println("Enter 1 for singleCot \n2 for DoubleCot:");
			
			i = scan.nextInt();
			float bill = 0f;
			bill += LuxuryRoomCost + (i - 1) * 3000;
			
			RoomAmenities.getInformation();
			
			System.out.println("Enter number of days:");
			this.NumOfDays = scan.nextInt();
			bill = bill * NumOfDays + RoomAmenities.calculateBill(NumOfDays);
			this.BillAmt = bill;
	        System.out.println("Room Booked Succesfully");
	        //Chamging the data into file
	        reWriteRoom();
		}
		
		

		
		public void count(HashMap<Integer, String> deroom,int a) {
			count = 0;
			String Type = null;
			if(a==1) {
				Type = "Standard Rooms";
			}
			else if(a==2) {
				Type = "Deluxe Rooms";
			}
			else if(a==3) {
				Type = "Luxury Rooms";
			}
			
			for(Map.Entry<Integer,String> m :deroom.entrySet()){
				String temp = m.getValue();
				if(m.getValue().toString() == temp) {
					count++;
				}
		    }
			
			System.out.println("Number of "+Type+"  avalilabe "+deroom.size());
			System.out.println("Number of vacant rooms avalilabe "+count);
			System.out.println("Number of  rooms Occupied "+(deroom.size()-count));
		}

		public void reWriteRoom() {
			allRooms=new HashMap<Integer,String>();
			allRooms.putAll(standardrooms);
			allRooms.putAll(deluxerooms);
			allRooms.putAll(luxuryrooms);
			writeToFile(allRooms);
		}
		
		
		public void writeToFile(HashMap<Integer, String> deroom) {
		    
		    try {
		    	File fileTwo =new File("Rooms.csv");
		  	  if(!fileTwo.exists()){
		  		  fileTwo.createNewFile();}
		      FileOutputStream fos=new FileOutputStream(fileTwo,false);
		      PrintWriter pw=new PrintWriter(fos);
		      pw.println("Room No"+","+"Vacancy");
		        for(Map.Entry<Integer,String> m :deroom.entrySet()){
		            pw.println(m.getKey()+","+m.getValue());
		        }

		        pw.flush();
		        pw.close();
		        fos.close();
		    } catch(Exception e) {
		    	 System.out.println("Error occurred while writing to the file.");
		    }
		}
		
		public void checkout() {
			for(HashMap.Entry<Integer,String> m :allRooms.entrySet()){
				allRooms.put(m.getKey(), "Vacant");
				writeToFile(allRooms);
			}
			
			
		}
		
		

		
}
	
