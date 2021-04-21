package com.revature.throwables;

public class MyError extends Error{
//This is my custom error. 
	public MyError() {
		super();
	}
	
	public MyError(String arg) {
		super(arg);
	}
}
