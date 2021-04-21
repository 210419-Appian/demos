package com.revature;

import com.revature.models.Car;
import com.revature.models.SUV;

public class Driver {

	public static void main(String[] args) {
		Car myCar = new Car("black", 4);
		
		System.out.println(myCar);
		System.out.println(myCar.color);
		System.out.println(myCar.maxSpeed);
		
		System.out.println("===============================");
		
		Car yourCar = new Car(3, "Red", 0.5, 420);
		
		System.out.println(yourCar);
		System.out.println(yourCar.color);
		System.out.println(yourCar.maxSpeed);
		
		System.out.println("===============================");
		
		//This is upcasting
		Car coolSUV = new SUV(5, "yellow", 1.0, 120, 8);
		//coolSUV = myCar; this breaks the downcasting. 
		((SUV)coolSUV).seats = 7;
		//This is downcasting
		SUV newSUV = null;
		
		System.out.println(coolSUV.getClass());
		
		if(coolSUV instanceof com.revature.models.SUV) {
			System.out.println("in if");
			newSUV = (SUV) coolSUV;
		}
		
		System.out.println(coolSUV);
		System.out.println(coolSUV.color);
		System.out.println(newSUV.seats);
		System.out.println(coolSUV.maxSpeed);
		
		newSUV.offRoading();
		
		System.out.println("===============================");
		
		System.out.println(yourCar.drive(25));
		System.out.println(newSUV.drive(88));
		System.out.println(coolSUV.drive(100));
	}

}
