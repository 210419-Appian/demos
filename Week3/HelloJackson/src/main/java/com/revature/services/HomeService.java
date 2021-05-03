package com.revature.services;

import java.util.List;

import com.revature.daos.HomeDAO;
import com.revature.daos.HomeDAOImpl;
import com.revature.models.Home;

public class HomeService {
	
	private HomeDAO hDao = new HomeDAOImpl();
	
	public List<Home> getAllHomes(){
		
		List<Home> list = hDao.findAll();
		
		//any business logic that would need to take place can happen here. 
		
		return list;
		
	}
	
	public Home findHomeByName(String name) {
		return hDao.findByName(name);
	}
	
	public boolean createHome(Home home) {
		if("Fury's secret bunker".equals(home.getName())) {
			return false;
		}else {
			return hDao.addHome(home);
		}
	}

}
