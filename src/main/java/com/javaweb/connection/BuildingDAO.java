package com.javaweb.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BuildingDAO {
	public static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/estatebasic;root;123";
	
	public static Connection getConnect() throws SQLException {
		return DriverManager.getConnection(CONNECTION_URL);
	}
}
