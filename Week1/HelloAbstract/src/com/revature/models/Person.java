package com.revature.models;

public abstract class Person implements Walkable, Joggable{
	
	public String name;
	public int age;
	
	public Person() {
		super();
	}
	
	public Person (String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public void breath() {
		System.out.println("I am taking a big breath");
	}

	public abstract String talk(String words);

	@Override
	public void trip() {
		Joggable.super.trip();
	}


}
