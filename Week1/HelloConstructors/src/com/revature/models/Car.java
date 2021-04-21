package com.revature.models;

public class Car {
	
	public int maxSpeed;
	public double fuelLevel; 
	public int tires; 
	public String color;
	
	public Car() {
		super();
		this.tires = 4;
		this.color = "white";
		this.maxSpeed = 90;
		this.fuelLevel = 0.25;
	}
	
	//Constructor
	public Car(int newTires, String dealerColor) {
		//Object is the parent class and it has a no-args constructor so while an explicit call to super is best
		//practice it is not technically required. 
		tires = newTires;
		color = dealerColor;
		this.maxSpeed = 100;
		this.fuelLevel = 0.7;
		System.out.println("In int String constructor");
	}
	
	//This is constructor overloading. 
	public Car(String color, int tires) {
		super();
		this.tires = tires;
		this.color = color;
		this.maxSpeed = 80;
		this.fuelLevel = 0.9;
		System.out.println("In String int constructor");
	}


	public Car(int tires, String color, double fuelLevel, int maxSpeed) {
		
		//calls the 2-arg constructor above.
		this(tires, color);
		//this here will call the instance or class scoped variables.
		this.maxSpeed = maxSpeed;
		this.fuelLevel = fuelLevel;
		System.out.println("In 4-args constructor.");
	}
	
	public String drive(int speed) {
		return "You are going "+speed+" miles per hour";
	}
	
}
