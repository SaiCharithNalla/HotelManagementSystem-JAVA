package com.user;

import java.io.BufferedReader;
import java.time.LocalTime; 
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RoomCleaning<T> extends Thread {
	T obj1;
	HashMap<String,String> Emp = new HashMap<String,String>();

	static LocalTime myObj = LocalTime.now();
	  public RoomCleaning() {
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
  		  System.out.println("An Employee has been assaigned:");
  	      System.out.println("Emplyoee ID:"+randomName.toString()+" Emplyee Name: "+Emp.get(randomName));
  	      System.out.println("Please wait till he finishes his job");
  	       System.out.println("Sarted work at :"+myObj);
  		  try{Thread.sleep(10000);}catch(InterruptedException e){System.out.println(e);}   

  	      genericDisplay(obj1);
  	      
  		}
		

		//A generic method
		static <T> void genericDisplay (T element)
	    {
	  	      System.out.println("The opted service for "+ element.getClass().getName() +
	                  " = " + element    +" is complted");
	  	    try {
				System.out.println("Work ended at :"+myObj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
    	  
    }
