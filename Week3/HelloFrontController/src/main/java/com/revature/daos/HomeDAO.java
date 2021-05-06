package com.revature.daos;

import java.util.List;

import com.revature.models.Home;

public interface HomeDAO {
	
	List<Home> findAll();
	Home findByName(String name);
	boolean addHome(Home home);
	//public boolean updateHome(Home home);

}
