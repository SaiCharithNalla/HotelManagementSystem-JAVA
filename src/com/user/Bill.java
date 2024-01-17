package com.user;

import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;



public class Bill{
	private float SpaCost,BillAmt;
	private float BarCost;
	private float DiscoCost;
	private float GolfCost,pay;
	private float TrekCost;
	private int NumberOfDays;
	private int Spa;
	private int Bar;
	private int Disco;
	private int Golf;
	private int Trek;
	private int i,n;
	private int choice;
	private static float LuxuryRoomCost = 10000f; //perDay
	private static final float deluxcost = 6000f;
	private static final float Standardcost = 3000f;
	String Type = null;
	String Type2 = null;
	private int TotalOccupants;
	
	
	public void  getBill(int NumberOfDays,int choice,int i,int n,int Spa,int Bar,int Disco,int Golf,int Trek,float pay,int TotalOccupants,float BillAmt){
		this.NumberOfDays=NumberOfDays;
		this.Spa = Spa;
		this.choice = choice;
		this.Bar = Bar;
		this.Disco = Disco;
		this.Golf= Golf;
		this.Trek= Trek;
		this.SpaCost = 100.0f;
		this.BarCost = 250.0f;
		this.DiscoCost = 300f;
		this.GolfCost = 350f;
		this.TrekCost = 750f;
		this.pay=pay;
		this.TotalOccupants = TotalOccupants;
		this.BillAmt = BillAmt;
		if(i==1) {
			Type2 = "Single Cot";
		}
		else if(i==2) {
			Type2 = "Double Cot with an extra cost of 3000";
		}
		
		if(choice==1) {
			Type = "Standard Room,Price:3000";
		}
		else if(choice==2) {
			Type = "Deluxe Room,Price:6000";
		}
		else if(choice==3) {
			Type = "Luxury Room,Price:10000";
		}

	}
	
	

	
	
	
	public void FileWriter() throws IOException {  
	      
	         try{    
	           FileWriter fw=new FileWriter("Bill.txt",true);    
	           fw.write("Bill:");
	           fw.write("\n");
	           fw.write("Choice of Room: " + Type );
	           fw.write("\n");
	           fw.write("Type of Bed: "+ Type2 );
	           fw.write("\n");
	           fw.write("Number of Occupants "+ TotalOccupants );
	           fw.write("\n");
	           fw.write("Cost of Room and Amenities: "+ BillAmt );
	           fw.write("\n");
	           fw.write("Bill at Restaurant: "+ pay );
	           fw.write("\n");
	           fw.write("Total Payable Amount: "+ (BillAmt + pay));
	           
	           
	           
	           fw.close();    
	          }catch(Exception e){System.out.println(e);}    
	           
	          
	        
	     }    

}
