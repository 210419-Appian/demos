package com.revature;

public class Driver {
	
	public static void main(String[] args) {
		
		double rand = Math.random();
		if(rand >0.75) {
			System.out.println("It was greater than .75!");
		}else if(rand>=0.5) {
			System.out.println("It was greater than 0.5 but less than 0.75!");
		}else {
			System.out.println("It was less than .5!");
		}
		
		int total = 0;
		
		while(total<400) {
			total = total+85;
			System.out.println(total);
		}
		
		do {
			total = total-59;
			System.out.println(total);
		}while(total>0 && total < 400);
		
		System.out.println("========================");
		
		for(int i = 0 ;i<5 ;i++) {
			total = total +37;
			System.out.println(total);
			System.out.println(i);
		}
		
		char[] name = {'T', 'I', 'M', ' ', 'G', 'A', 'T', 'T', 'I', 'E'};
		
		System.out.println(name);
		
		for(int i =0; i<name.length; i++) {
			if(name[i]==' ') {
				//continue will end the current iteration of a loop but continue on to the evaluation for the next one. 
				continue;
			}
			name[i] += 32;
		}
		
		System.out.println(name);
		
	}

}
