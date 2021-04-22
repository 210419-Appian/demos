package com.revature;

import com.revature.models.Associate;
import com.revature.models.Person;

public class Driver {

	public static void main(String[] args) {
		Person philip = new Associate("Philip", 23, "210419");
		
		philip.breath();
		
		System.out.println(philip.talk("This is the best course ever!")); //
		
		//System.out.println(philip.batch); //Person variable does not have access to associate only field. 
		
		Associate Michael = new Associate("Michael", 25, "210419");
		
		Michael.move(5);
		
		Michael.trip();

	}

}
