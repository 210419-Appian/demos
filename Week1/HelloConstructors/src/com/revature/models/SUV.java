package com.revature.models;

public class SUV extends Car {
	
	public int seats;
	
	public SUV() {
		super();
	}
	
	public SUV(int tires, String color, double fuelLevel, int maxSpeed, int seats) {
		super(tires, color, fuelLevel, maxSpeed);
		this.seats = seats;
		System.out.println("In SUV 5 arg constructor");
	}
	
	public void offRoading() {
		System.out.println("I'm driving in the dirt up a hill.");
	}

	public String drive(int speed) {
		return "Hold up, you are going " + speed + " miles per hour. Don't tip over!!!!";
	}
	
	
}
