package com.management.hotel;
//Using Threads
public class GenaralHotelmaintenance implements Runnable {  
    // run() method to perform action for thread.   
    public void run()  
    {    
         System.out.println("The hotel staff are notified for cleaning the Hotel. Cleaning may take a While.");  
         try{Thread.sleep(10000);}catch(InterruptedException e){System.out.println(e);}   
         System.out.println("The hotel is cleaned");


    }
}
