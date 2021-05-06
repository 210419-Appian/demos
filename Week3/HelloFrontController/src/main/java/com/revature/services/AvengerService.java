package com.revature.services;

import java.util.List;

import com.revature.daos.AvengerDAO;
import com.revature.daos.AvengerDAOImpl;
import com.revature.daos.HomeDAO;
import com.revature.daos.HomeDAOImpl;
import com.revature.models.Avenger;
import com.revature.models.Home;

public class AvengerService {

	private AvengerDAO aDao = new AvengerDAOImpl();
	private HomeDAO hDao = new HomeDAOImpl();

	public List<Avenger> avengersAssemble() {

		return aDao.findAll();

	}

	public boolean addAvenger(Avenger a) {
		if (a.getHomeBases() == null) {
			return aDao.addAvenger(a);
		}
		
		Home h = hDao.findByName(a.getHomeBases().getName());
		
		if(h.getName()==(null)) {
			return aDao.addAvengerWithHome(a);
		}
		
		return aDao.addAvenger(a);
	}

	public Avenger getOneAvenger(int id) {
		return aDao.findById(id);
	}

	public boolean updateFullAvenger(Avenger a) {
		return aDao.updateAvenger(a);
	}

	public boolean updatePartialAvenger(Avenger a) {
		if (a.getId() == 0) {
			return false;
		}

		Avenger aData = getOneAvenger(a.getId());

		if (a.getSupName() == null) {
			a.setSupName(aData.getSupName());
		}
		if (a.getSupPower() == null) {
			a.setSupPower(aData.getSupPower());
		}
		if (a.getFirstName() == null) {
			a.setFirstName(aData.getFirstName());
		}
		if (a.getLastName() == null) {
			a.setLastName(aData.getLastName());
		}
		if (a.getPowerLevel() == 0) {
			a.setPowerLevel(aData.getPowerLevel());
		}
		if (a.getHomeBases() == null) {
			a.setHomeBases(aData.getHomeBases());
		}

		return aDao.updateAvenger(a);

	}

	public boolean killAvenger(int id) {
		return aDao.deleteAvenger(id);
	}
}
