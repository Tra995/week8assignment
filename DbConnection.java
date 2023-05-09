package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {
	private static final String HOST = "localhost";
	private static final int PORT = 3306;
	private static final String USER = "projects";
	private static final String PASSWORD = "projects";
	private static final String SCHEMA = "projects";
	
	public static Connection getConnection() {
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s", 
				HOST,PORT,SCHEMA,USER,PASSWORD);	
		
		Connection conn;
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("CONNECTION TO " + SCHEMA + " WAS SUCCESSFUL.");
			return conn;
		} catch (SQLException e) {
			System.out.println("Unsuccessful connection.");
			throw new DbException();
		}		
		
	}
}