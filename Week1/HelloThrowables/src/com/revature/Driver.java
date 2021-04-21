package com.revature;

import com.revature.throwables.*; //adds all classes in the package. 

public class Driver {
	
	public static void main(String[] args)  {
		System.out.println("The main method has started.");
		
		try {
			throwChecked();
		}catch(MyException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("===========================");
		
		try {
			System.out.println("I am starting the try block.");
			throwUnchecked("I am causing you problems!"); //The block will stop here when the first exception is thrown. 
			System.out.println("I will never print because the Exception happens first.");
			throwChecked();
		}catch(MyException e) {
			System.out.println("I am a MyException.");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("I could be any Exception");
			e.printStackTrace();
		}
		
		//throwError(); //This is not checked so will compile even though it will crash the application. 
		
		System.out.println("The main method has ended.");
		
	}
	
	public static void throwError() throws MyError{
		System.out.println("I'm about to throw an Error!");
		throw new MyError();
	}
	
	public static void throwChecked() throws MyException {
		System.out.println("I'm about to throw a checked Exception");
		throw new MyException();
	}
	
	public static void throwUnchecked(String message) {
		System.out.println("I'm about to throw an unchecked Exception");
		throw new MyUncheckedException(message);
	}

}
