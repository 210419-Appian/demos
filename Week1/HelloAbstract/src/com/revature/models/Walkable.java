package com.revature.models;

public interface Walkable {
	
	String unitOfMeasurement = "miles";
	
	void move(int distance);

	default void trip() {
		System.out.println("Oh no you tripped.");
	}
}
