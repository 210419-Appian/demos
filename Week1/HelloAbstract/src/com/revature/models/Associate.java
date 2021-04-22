package com.revature.models;

public class Associate extends Person{
	
	public String batch;
	
	public Associate() {
		super();
	}

	public Associate (String name, int age, String batch) {
		super(name, age);
		this.batch = batch;
	}

	@Override
	public String talk(String words) {
		//Super will allow access to parent's fields and methods in the child class. 
		return super.name+" is saying '"+words+".'";
	}
	
	public void move(int i) {
		System.out.println("I walked "+i+" "+unitOfMeasurement+" today");
	}
	
	
}
