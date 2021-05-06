package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM avengers WHERE superhero_id = "+id+";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			Avenger a = null;

			while (result.next()) {
				a = new Avenger(
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
			}

			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addAvenger(Avenger a) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			//There is no chance for sql injection with just an integer so this is safe. 
			String sql = "INSERT INTO avengers (superhero_name, superhero_power, first_name, last_name, power_level, home_base)"
					+ "	VALUES (?, ?, ?, ?, ?, ?);";

			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setString(++index, a.getSupName());
			statement.setString(++index, a.getSupPower());
			statement.setString(++index, a.getFirstName());
			statement.setString(++index, a.getLastName());
			statement.setInt(++index, a.getPowerLevel());
			if(a.getHomeBases() != null) {
				statement.setString(++index, a.getHomeBases().getName());
			} else {
				statement.setString(++index, null);
			}
			
			statement.execute();
			return true;


		} catch (SQLException e) {
			e.printStackTrace();
		}
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
