package com.revature;

public class Driver {
	
	public static void main(String[] args) {
		MyMagicThread mmt1 = new MyMagicThread();
		mmt1.setPriority(1); //Priority is a value 1-10 the higher number the more priority that thread will have over others.
		
		MyMagicThread mmt2 = new MyMagicThread();
		mmt2.setPriority(2);
		
		//These do not create new threads because we did not use the start method. 
		//mmt1.run();
		//mmt2.run();
		
		mmt1.start();
		mmt2.start();
		MyMagicThread mmt3 = new MyMagicThread();
		
		mmt3.run();
		
	}

}
