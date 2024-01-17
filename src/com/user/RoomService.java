package com.user;

import java.io.BufferedReader;
import java.time.LocalTime; 
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RoomService<T> extends Thread implements Roommaintance {
	T obj1;
	HashMap<String,String> Emp = new HashMap<String,String>();

	
	  public RoomService() {
		  HashMapFromTextFile();
	  }
    	public void HashMapFromTextFile()
    	{
    		

    		BufferedReader br = null;

    		try {

    			
    			File file = new File("Employee.csv");

    			br = new BufferedReader(new FileReader(file));

    			String line = null;

    			
    			br.readLine();
    			while ((line = br.readLine()) != null) {
  		
    				String[] parts = line.split(",");
    				
    				String number = parts[0].trim();
    				String name = parts[1].trim();
    				
    				
    				if (!name.equals("") && !number.equals("")) {
    					Emp.put(number, name);
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
    	
		
		





      
  		public void run() {
  		  Object randomName = Emp.keySet().toArray()[new Random().nextInt(Emp.keySet().toArray().length)];
  		  System.out.println();
  		  System.out.println("An Employee has been assaigned:");
  	      System.out.println("Emplyoee ID:"+randomName.toString()+" Emplyee Name: "+Emp.get(randomName));
  	      System.out.println("Please wait till he finishes his job");
  	      LocalTime myObj = LocalTime.now();
  	      System.out.println("Sarted work at :"+myObj);
  	      System.out.println();
  		  try{Thread.sleep(10000);}catch(InterruptedException e){System.out.println(e);}   

  	     
  	      
  		}
		

		
		 void genericDisplay (T element,LocalTime myObj1)
	    {
			  
			  String clsname= element.getClass().getName();
			  System.out.println("Full class name ="+clsname); 
			  int mid=clsname.lastIndexOf ('.') + 1;
			  String finalClsName = clsname.substring(mid);
			  System.out.println(finalClsName);

	  	      System.out.println("The opted service for "+finalClsName +" is complted");
	  	    try {
				System.out.println("Work ended at :"+myObj1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				 System.out.println(e);
			}
	  	  System.out.println();
	  	  isServiced();
	    }
		@Override
		public void isServiced() {
			System.out.println("Thank you for choosing our service,Enjoy the stay");
			
		}
 

}
