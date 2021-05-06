package com.revature.services;

import java.util.List;

import com.revature.daos.AvengerDAO;
import com.revature.daos.AvengerDAOImpl;
import com.revature.models.Avenger;

public class AvengerService {
	
	private AvengerDAO aDao = new AvengerDAOImpl();
	
	public List<Avenger> avengersAssemble(){
		
		return aDao.findAll();
		
	}
	
	public boolean addAvenger(Avenger a) {
		return aDao.addAvenger(a);
	}
	
	public Avenger getOneAvenger(int id) {
		return aDao.findById(id);
	}

}
