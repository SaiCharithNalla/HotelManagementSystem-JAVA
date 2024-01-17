package com.management.hotel;

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

public class Rooms {
	
private int n,m,s,count;
HashMap<Integer,String> map;
HashMap<Integer,String> map2;
HashMap<Integer,String> map3;


	
public Rooms() {

	try {
		File fileTwo=new File("Rooms.csv");
    FileOutputStream fos=new FileOutputStream(fileTwo);
    PrintWriter pw=new PrintWriter(fos);
    pw.println("Room No"+","+"Vacancy");
       

        pw.flush();
        pw.close();
        fos.close();
} catch(Exception e) {}
	
	
}

//Methods to get number of rooms
public void getNumberOfRooms() {
	@SuppressWarnings("resource")
	Scanner S = new Scanner(System.in);
	System.out.println("Enter number of Standard rooms :");
	 n = S.nextInt();
	 System.out.println("Enter number of Delux rooms :");
	 m = S.nextInt();
	 System.out.println("Enter number of Luxury rooms :");
	 s = S.nextInt();
	 
}

public void roomCreator() {
	createRooms();
}

public void createRooms() {
	int i=0;
	
	map=new HashMap<Integer,String>();

    for ( i = 101; i<=n+100; i++) {
		map.put(i, "Vacant");
    }
    HashMap<Integer, String> standardRooms = sortByKey(map);
    writeToFile(standardRooms);
    
	map2=new HashMap<Integer,String>();

    for ( i = 201; i<=m+200; i++) {
		map2.put(i, "Vacant");
    }
    HashMap<Integer, String> deluxRoom = sortByKey(map2);
    writeToFile(deluxRoom);
    
	map3=new HashMap<Integer,String>();

    for ( i = 301; i<= s+300; i++) {
		map3.put(i, "Vacant");
    }
    HashMap<Integer, String> luxuryRoom = sortByKey(map3);
    writeToFile(luxuryRoom);
}

  
public static HashMap<Integer, String>
    sortByKey(Map<Integer, String> hm)
    {
       
        List<Map.Entry<Integer, String> > list
            = new LinkedList<Map.Entry<Integer, String>>( hm.entrySet());
               
 
       
        Collections.sort(
            list,
            (i1, i2) -> i1.getKey().compareTo(i2.getKey())); //Lamda Expressions
 
       
        HashMap<Integer, String> temp
            = new LinkedHashMap<Integer, String>();
        for (HashMap.Entry<Integer, String> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    
    
   //Method to write into a file 
public void writeToFile(HashMap<Integer, String> deroom) {
    
    try {
    	File fileTwo =new File("Rooms.csv");
  	  if(!fileTwo.exists()){
  		  fileTwo.createNewFile();}
      FileOutputStream fos=new FileOutputStream(fileTwo,true);
      PrintWriter pw=new PrintWriter(fos);
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

//Method to show number of rooms available
public void getdetails(){
	count(map,1);
	count(map2,2);
	count(map3,3);
}
public void count(HashMap<Integer, String> deroom,int a) {
	count = 0;
	String Type = null;
	if(a==1) {
		Type = "Standard Room";
	}
	else if(a==2) {
		Type = "Deluxe Room";
	}
	else if(a==3) {
		Type = "Luxury Room";
	}
	
	for(Map.Entry<Integer,String> m :deroom.entrySet()){
		if(m.getValue() == "Vacant") {
			count++;
		}
    }
	System.out.println();
	System.out.println("Number of "+Type+" rooms avalilabe "+deroom.size());
	System.out.println("Number of vacant rooms avalilabe "+count);
	System.out.println("Number of  rooms Occupied "+(deroom.size()-count));
	
}


	}