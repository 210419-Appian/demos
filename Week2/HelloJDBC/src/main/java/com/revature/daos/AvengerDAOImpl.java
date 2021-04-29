package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Avenger;
import com.revature.models.Home;
import com.revature.utils.ConnectionUtil;

public class AvengerDAOImpl implements AvengerDAO {

	private static HomeDAO hDao = new HomeDAOImpl();
	
	@Override
	public List<Avenger> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM avengers;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Avenger> list = new ArrayList<>();

			while (result.next()) {
				Avenger a = new Avenger(
						result.getInt("superhero_id"), 
						result.getString("superhero_name"), 
						result.getString("superhero_power"), 
						result.getString("first_name"), 
						result.getString("last_name"), 
						result.getInt("power_level"),
						null
						);
				String hName = result.getString("home_base");
				if(hName!=null) {
					a.setHomeBases(hDao.findByName(hName));
				}
				list.add(a);
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Avenger findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAvenger(Avenger a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Avenger> findByHome(String homeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAvengerWithHome(Avenger a) {
		// TODO Auto-generated method stub
		return false;
	}

}
