package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Home;
import com.revature.utils.ConnectionUtil;

public class HomeDAOImpl implements HomeDAO {

	@Override
	public List<Home> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM homes;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Home> list = new ArrayList<>();

			while (result.next()) {
				Home home = new Home();
				home.setName(result.getString("home_name"));
				home.setStNum(result.getString("hb_st_num"));
				home.setStName(result.getString("hb_st_name"));
				home.setCity(result.getString("hb_city"));
				home.setRegion(result.getString("hb_region"));
				home.setCountry(result.getString("hb_country"));
				home.setZip(result.getString("hb_zip"));
				// TODO Here I could set my residences but I don't have the methods to do that
				// yet.
				list.add(home);
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Home findByName(String name) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM homes WHERE home_name = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, name);

			ResultSet result = statement.executeQuery();

			Home home = new Home();

			while (result.next()) {
				home.setName(result.getString("home_name"));
				home.setStNum(result.getString("hb_st_num"));
				home.setStName(result.getString("hb_st_name"));
				home.setCity(result.getString("hb_city"));
				home.setRegion(result.getString("hb_region"));
				home.setCountry(result.getString("hb_country"));
				home.setZip(result.getString("hb_zip"));
				// TODO Here I could set my residences but I don't have the methods to do that
				// yet.
			}

			return home;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addHome(Home home) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO homes (home_name, hb_st_num, hb_st_name, hb_city, hb_region, hb_country, hb_zip)"
					+ "VALUES(?,?,?,?,?,?,?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, home.getName());
			statement.setString(++index, home.getStNum());
			statement.setString(++index, home.getStName());
			statement.setString(++index, home.getCity());
			statement.setString(++index, home.getRegion());
			statement.setString(++index, home.getCountry());
			statement.setString(++index, home.getZip());
			
			statement.execute();
			
			return true;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
