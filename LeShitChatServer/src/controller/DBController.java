package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBController {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/leshitchat";
	private static final String DB_USER = "root";
	private static final String DB_PW = "";
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private static DBController instance;

	public static DBController getInstance() {
		if(instance == null) {
			instance = new DBController();
		}
		return instance;
	}
	
	private DBController() {}
	
	public Connection connectToDB() {
		Connection connection = null;
		try {
			Class.forName(DRIVER).newInstance();
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.err.println("Treiber konnte nicht geladen werden.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Datenbankverbindung fehlgeschlagen");
			e.printStackTrace();
		}
		return connection;
	}
	
	public void closeConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("Fehler beim beenden der DB-Verbindung");
				e.printStackTrace();
			}
		}
	}
	
	public ResultSet executeQuery(Connection connection, String sql) {
		ResultSet result = null;
		if(connection != null) {
			try {
				Statement statement = connection.createStatement();
				result = statement.executeQuery(sql);
			} catch (SQLException e) {
				System.err.println("Fehler im SQL!");
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int executeUpdate(String sql) {
		Connection connection = connectToDB();
		int result = 0;
		if(connection != null) {
			try {
				Statement statement = connection.createStatement();
				result = statement.executeUpdate(sql);
			} catch (SQLException e) {
				System.err.println("Fehler im SQL!");
				e.printStackTrace();
			}
		}
		closeConnection(connection);
		return result;
	}
		
}
