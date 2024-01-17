package com.user;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Restaurant {

	public  float menu() {
		int choice = 0;
		float respayment = 0;
		Scanner input = new Scanner(System.in);
		cuisi c = new cuisi();
		c.show();
	    System.out.println("Select your cuisine");
        choice = input.nextInt();
       
		switch (choice) 
		{
			case 0:
				 cuisi ch = new chinese();
				 respayment=ch.show();
		         break;
			case 1:
			     cuisi ch1 = new northindian();
			     respayment=ch1.show();
			case 2:
				 cuisi ch2 = new southindian();
				respayment= ch2.show();
			      
			      break;
			case 3:
				continental ch3 = new continental();
				respayment=ch3.show();
				
		         break;
			
		  }
		return respayment;
		
		
    }
	
 }
interface offers
{
    public abstract void discount(float cost);
    public abstract void  cupon();
}

class cuisi{
public static String cuisine[] = {"chinese","North indian","south indian","continental"};
public String[] order = new String[10];
public int[] bill = new int[10];
public int[] quant = new int[10];
public int n;
public float total_amount = 0;
public float show()
{
	for(int i = 0;i<=3;i++)
       {
	
		System.out.println(i + cuisine[i]+"\n");
		
	   }
	return 0;
}
}

class chinese extends cuisi implements offers{
     public final static String cop = "chi101" ;
	 Scanner input = new Scanner(System.in);
	 static HashMap<String, Integer> chinese = new HashMap<>();
     public chinese() {
	chinese.put("hot and sour soup", 95);
	chinese.put("chinese shrimp soup", 120);
	chinese.put(" chilli chicken", 150);
	chinese.put(" chilli potato", 110);
	chinese.put(" chilli mushroom", 130);
	chinese.put(" chilli panner", 140);
	chinese.put(" chilli shrimp", 190);
	chinese.put(" spring roll", 90);
	chinese.put("chicken rice", 135);
	chinese.put("prawn rice", 170);
	chinese.put("chicken machurian", 165);
	chinese.put("chicken noodles", 170);
	chinese.put("panner noodles", 150);
	chinese.put("mango pudding", 100);
	chinese.put("sponge cake", 90);
	chinese.put("alomond float", 190);

}
     
  
@Override
public float show()
{
for (Map.Entry<String, Integer> e: chinese.entrySet())
         {
			System.out.println("-----------------------------------------------------------------");
			System.out.println(" name: " + e.getKey() + "\t"+" price " + e.getValue()+"\n");
			System.out.println("-------------------------------------------------------------------");
			}
		System.out.println("enter the number of items to be ordered");
		n = input.nextInt();
		try {
			if(n<0)
			throw new ArithmeticException ("you have entered invalid number");
		    }
		catch(ArithmeticException e) 
		{
			System.out.println(e);
		}
	    
		for (int i = 0; i<n; i++)
		{
		input.nextLine();
		System.out.println("enter the dish to be odered");
		order[i] = input.nextLine();

		System.out.println("enter the quantity");
		quant[i] = input.nextInt();
		System.out.println("----------------------------------------------------------------");
		for (Map.Entry<String, Integer> e: chinese.entrySet())
		{
		if (e.getKey().equalsIgnoreCase(order[i]))
		{
		bill[i] = e.getValue() * quant[i];
		}
		}
		}for (int j = 0; j<= n; j++) 
		 {
		total_amount = total_amount + bill[j];
		}
	   this.cupon();
      return total_amount;
		
}

public void discount(float cost4) 
{
		
	if(cost4<600) {
		 this.total_amount = cost4;
	 }
	 if(cost4>1200) {
		 
		 this.total_amount = cost4-250f;
	 }
	 else if(cost4>2800) {
		 
		 this.total_amount = cost4-550f;
	 }
	 else if(cost4>5400)
	 {
		 this.total_amount = cost4 - cost4*30/100;
	 }
  
  

}
@Override
public void cupon() 
{
	String decision = null;
	String getcode = null;
	System.out.println("Do you have coupon  discount for chinese");
	input.nextLine();
	decision = input.nextLine();
	
	if( decision.equalsIgnoreCase("yes") )
	{
		System.out.println("please enter the coupon code");
		getcode = input.nextLine();
		if(getcode.contentEquals( cop ))
		{
			this.discount(total_amount);
		}

     }
 }
}
class  northindian extends cuisi implements offers{
	public final static  String  ncp = "north100";
	Scanner input = new Scanner(System.in);
	public static HashMap<String, Integer> north = new HashMap<String,Integer>();
	public northindian()
	{
		
		north.put("palak soup", 90);
		north.put("panner soup", 95);
		north.put("malai soup", 90);
		north.put(" hariyali chicken", 150);
		north.put(" tandoori chicken", 110);
		north.put(" grill chicken", 190);
		north.put(" malai tikka", 140);
		north.put(" butter chicken", 190);
		north.put("panner butter", 135);
		north.put("shahi panner", 170);
		north.put("palak panner", 165);
		north.put("chicken tikka", 170);
		north.put("panner tikka", 150);
		north.put("lassi", 50);
		north.put("rasamalai", 90);
		north.put(" kheer", 30);
		
	}
	
	@Override
	public float show()
	{
		for (Map.Entry<String, Integer> e: north.entrySet()) {
				System.out.println("-----------------------------------------------------------------");
				System.out.println(" name: " + e.getKey() + "\t"+" price " + e.getValue()+"\n");
				System.out.println("-------------------------------------------------------------------");
				}
			System.out.println("enter the number of items to be ordered");
			n = input.nextInt();
			try {
				if(n<0)
				throw new ArithmeticException ("you have entered invalid number");
			}
			catch(ArithmeticException e) 
			{
				System.out.println(e);
			}
		input.nextLine();
	for (int i = 0; i<n; i++) {
	System.out.println("enter the dish to be odered");
	order[i] = input.nextLine();

	System.out.println("enter the quantity");
	quant[i] = input.nextInt();
	System.out.println("----------------------------------------------------------------");
	for (Map.Entry<String, Integer> e: north.entrySet()) {
	if (e.getKey().equalsIgnoreCase(order[i])) {
	bill[i] = e.getValue() * quant[i];
	}
	}
	}for (int j = 0; j<= n; j++) 
	{
	total_amount = total_amount + bill[j];
	}
this.cupon();
return total_amount;
}

	@Override
	public void discount(float cost5) {
		
		 if(cost5<700) {
			 this.total_amount =cost5; 
		 }
		 if(cost5>1500) {
			 
			 this.total_amount = cost5-250f;
		 }
		 else if(cost5>2500) {
			 
			 this.total_amount = cost5-550f;
		 }
		 else if(cost5>5000)
		 {
			 this.total_amount = cost5 - cost5*30/100;
		 }
	}

	@Override
	public void cupon() {
		String getcode = "";
		String decision = "";
		System.out.println("Do you have coupon to get discount for north indian");
		input.nextLine();
		decision = input.nextLine();
		if( decision.equalsIgnoreCase("yes") )
		{
			System.out.println("please enter the coupon code");
			getcode = input.nextLine();
			if(getcode.contentEquals(ncp))
			{
				this.discount(total_amount);
			}
		
	}
}
}
class southindian extends cuisi implements offers{
	public final static String Scp = "south108";
	Scanner input = new Scanner(System.in);
	

	
	
  static HashMap<String, Integer> south = new HashMap<String,Integer>();
  public southindian() {
  south.put("peper chicken soup", 90);
  south.put("crab soup", 95);
  south.put("coffe", 35);
  south.put(" idli", 30);
  south.put(" dosa", 50);
  south.put(" poori", 60);
  south.put(" vada ", 10);
  south.put(" nonveg meal", 120);
  south.put(" veg meal", 90);
  south.put("chicken 65", 135);
  south.put("andhra chicken", 170);
  south.put("tomato chicken", 165);
  south.put("chettinad chicken", 170);
  south.put("chicken briyani", 150);
  south.put("mutton briyani", 90);
  south.put("payasam", 50);
  south.put("laddu ", 20);
  }
  @Override
  public float show()
  {
	  
 
	  for (Map.Entry<String, Integer> e: south.entrySet()) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println(" name: " + e.getKey() + "\t"+" price " + e.getValue()+"\n");
			System.out.println("-------------------------------------------------------------------");
			}
		System.out.println("enter the number of items to be ordered");
		
		n = input.nextInt();
		try {
			if(n<0)
			throw new ArithmeticException ("you have entered invalid number");
		}
		catch(ArithmeticException e) 
		{
			System.out.println(e);
		}
		
		input.nextLine();
		for (int i = 0; i<n; i++) {
		System.out.println("enter the dish to be odered");
		order[i] = input.nextLine();

		System.out.println("enter the quantity");
		
		quant[i] = input.nextInt();
		System.out.println("----------------------------------------------------------------");
		input.nextLine();
		for (Map.Entry<String, Integer> e: south.entrySet()) {
		if (e.getKey().equalsIgnoreCase(order[i])) {
		bill[i] = e.getValue() * quant[i];
		}
		}
		}for (int j = 0; j<= n; j++) {
		total_amount = total_amount + bill[j];
		}
		
		this.cupon();

      return total_amount;
  
  }
   @Override
   public void discount(float cost1) 
	{
	 
	   if(cost1<500) {
			 this.total_amount = cost1;
		 }
		 if(cost1>1500) {
			 
			 this.total_amount = cost1-250f;
		 }
		 else if(cost1>2500) {
			 
			 this.total_amount = cost1-550f;
		 }
		 else if(cost1>5000)
		 {
			 this.total_amount = cost1 - cost1*30/100;
		 }
	   

	}
    @Override
	public void cupon() 
	{  String decision = "";
		String getcode = "";
		System.out.println("Do you have coupon to get discount for Southindian");
		
		decision = input.nextLine();
		if( decision.equalsIgnoreCase("yes") )
		{
			System.out.println("please enter the coupon code");
			getcode = input.nextLine();
			if(getcode.contentEquals(getcode))
			{
				this.discount(total_amount);
			}	
		

	}
	
	}
}
class continental extends cuisi implements offers{
	
	public final static String concp = "conti999";
	Scanner input = new Scanner(System.in);
	HashMap<String, Integer> cont = new HashMap<>();
	public continental()
	{
		cont.put("chickpea soup", 90);
		cont.put("chicken salad", 95);
		cont.put("Scotch", 120);
		cont.put("buger", 150);
		cont.put("pizza", 200);
		cont.put("pasta", 130);
		cont.put("pesto pasata", 140);
		cont.put(" panner steak", 190);
		cont.put(" french fries", 90);
		cont.put("batter fish", 135);
		cont.put("prawn rice", 170);
		cont.put("chicken steak", 165);
		cont.put("chicken stew", 170);
		cont.put("mutton stew", 150);
		cont.put("mango pudding", 100);
		cont.put("cheese cake", 90);
		cont.put("caramel pie", 190);
	}
	@Override
public float show()
	{
		for (Map.Entry<String, Integer> e: cont.entrySet()) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println(" name: " + e.getKey() + "\t"+" price " + e.getValue()+"\n");
			System.out.println("-------------------------------------------------------------------");
			}
		System.out.println("enter the number of items to be ordered");
		n = input.nextInt();
		try {
			if(n<0)
			throw new ArithmeticException ("you have entered invalid number");
		}
		catch(ArithmeticException e) 
		{
			System.out.println(e);
		}
		
		input.nextLine();
		for (int i = 0; i<n; i++) {
		System.out.println("enter the dish to be odered");
		order[i] = input.nextLine();

		System.out.println("enter the quantity");
		quant[i] = input.nextInt();
		System.out.println("----------------------------------------------------------------");
		for (Map.Entry<String, Integer> e: cont.entrySet()) {
		if (e.getKey().equalsIgnoreCase(order[i])) {
		bill[i] = e.getValue() * quant[i];
		}
		}
		for (int j = 0; j<= n; j++) {
		total_amount = total_amount + bill[j];
		}
		
	   this.cupon();

		}
		return total_amount;	
}
@Override
	public void discount(float cost) {
	 if(cost<1000) {
		 this.total_amount = cost;
	 }
	 if(cost>1000) {
		 
		 this.total_amount = cost-300f;
	 }
	 else if(cost>3000) {
		 
		 this.total_amount = cost-500f;
	 }
	 else if(cost>5000)
	 {
		 this.total_amount = cost - cost*20/100;
	 }
}
@Override
public void cupon() 
   {    
	String decision = "";
	String getcode = "";
	System.out.println("Do you have coupon to get discount for continental");
	input.nextLine();
	decision = input.nextLine();
	if( decision.equalsIgnoreCase("yes") )
		{
			System.out.println("please enter the coupon code");
			getcode = input.nextLine();
			if(getcode.contentEquals(concp))
			  {
				this.discount(total_amount);
			  }
			}
		}
}