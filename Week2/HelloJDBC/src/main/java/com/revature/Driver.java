package com.revature;

import java.util.List;

import com.revature.models.Avenger;
import com.revature.models.Home;
import com.revature.services.AvengerService;
import com.revature.services.HomeService;

public class Driver {
	
	private static HomeService hService = new HomeService();
	private static AvengerService aService = new AvengerService();

	public static void main(String[] args) {
		List<Home> list = hService.getAllHomes();
		
		//System.out.println(list);

		for(Home h: list) {
			System.out.println(h);
		}
		
		System.out.println("======================================");
		Home h = hService.findHomeByName("Stark Tower");
		
		System.out.println(h);
		System.out.println("======================================");
		
		Home h2 = new Home("Fury's secret bunker", "5468", "3rd Street", "Brooklyn", "NY", "10521", "USA");
		
		hService.createHome(h2);
		
		h = hService.findHomeByName("Fury's secret bunker");
		System.out.println(h);
		System.out.println("======================================");
		
		List<Avenger> aList = aService.avengersAssemble();
		
		System.out.println(aList);
	}

}
