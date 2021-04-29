package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.models.Home;
import com.revature.utils.ConnectionUtil;

public class HomeDAOImpl implements HomeDAO{

	@Override
	public List<Home> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM homes;";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Home findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addHome(Home home) {
		// TODO Auto-generated method stub
		return false;
	}

}
