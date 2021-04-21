package com.revature;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		String s1 = "Hello Java";
		String s2 = "Hello Java";
		String s3 = "hello java";
		String s4 = new String("Hello Java");
		
		System.out.println(s1 == s2); //true
		System.out.println(s1 == s3); //false
		System.out.println(s1 == s4); //false
		System.out.println(s1.equals(s4)); //true
		
		System.out.println("=========================");
		
		String s5 = s1.toLowerCase();
		System.out.println(s5.equals(s3)); //true
		System.out.println(s1); //Hello Java
		System.out.println(s5); //hello java
		System.out.println(s5 == s3); //false
		
		System.out.println("=========================");
		
		char c1 = s1.charAt(4); 
		System.out.println(c1); //o
		
		String s6 = s1.concat(" ").concat(s3); //5 different String objects on this line: 
												//s1, s3, " ", s1.concat(" "), s1.concat(" ").concat(s3)
		System.out.println(s6); //true
		
		String s7 = s1+" "+s3;
		System.out.println(s6.equals(s7)); //true
		
		String[] arr = s1.split(" ");
		
		//This is an enhanced for-loop you can use with most Java datastructures.
		for(String string: arr) { //for each String called string in arr. 
			System.out.println(string);
		}
		
		String s8 = arr[0]+arr[1];
		System.out.println(s8);
		
		char[] charArr = s8.toCharArray();
		
		for(char c: charArr) {
			System.out.println(c);
		}
		
		System.out.println("=========================");
		
		scannerMethod();

	}

	public static void scannerMethod() {
		
		Scanner scan = new Scanner(System.in); //System.in represents the console. 
		
		String s1 = scan.nextLine();
		
		System.out.println(s1);
		
		System.out.println("What is your name?");
		String name = scan.nextLine();
		
		System.out.println("Hello "+name+" it's good to meet you!");
		
		System.out.println("What is your age?");
		int age = scan.nextInt();
		scan.nextLine(); //nextInt grabs the interger but leaves the new line character require us to clear it with nextLine
		
		System.out.println("Wow you don't look "+age+" at all! What is your secret?");
		String secret = scan.nextLine();
		System.out.println("Wow your really "+secret+"? Thanks for telling me!");
		
	}
	
}
