package com.revature.daos;

import java.util.List;

import com.revature.models.Avenger;

public interface AvengerDAO {
	
	public List<Avenger> findAll();
	public Avenger findById(int id);
	public boolean addAvenger(Avenger a);
	public List<Avenger> findByHome(String homeName);
	public boolean addAvengerWithHome(Avenger a); 
	public boolean updateAvenger(Avenger a);
	public boolean deleteAvenger(int id);

}
