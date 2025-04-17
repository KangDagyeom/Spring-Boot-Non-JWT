package com.javaweb.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaweb.object.BuildingDTO;

public class BuildingDAO {
	public static String url = "jdbc:mysql://localhost:3306/estatebasic";
	public static String user = "root";
	public static String password = "hungisreal";


	public static Connection getConnect() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public BuildingDTO mapResult(ResultSet rs) throws SQLException {
		return new BuildingDTO(rs.getString("name"), rs.getInt("numberofBasement"), rs.getString("ward"),
				rs.getString("street"));
	}
}
