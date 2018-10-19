package controller.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.DBController;
import model.User;

/**
 * UserDao
 * @author ldonker
 *
 */
public class UserDao implements CRUDInterface<User>{

	private DBController dbcontroller = DBController.getInstance();
	
	@Override
	public int create(User valueObject) {
		String sql = "INSERT INTO `user`(`username`, `online`) VALUES ("
				+"'" + valueObject.getUsername() + "',"
				+ valueObject.isOnline() +")";
		
		return dbcontroller.executeUpdate(sql);
	}

	@Override
	public User read(long id) {
		List<User> result = null;
		String sql = "SELECT `id`, `username`, `online` FROM `user` WHERE id = "
				+ id;
		
		try {
			Connection connection = dbcontroller.connectToDB();
			ResultSet resultset = dbcontroller.executeQuery(connection, sql);
			
			result = convertResultset(resultset);
			
			dbcontroller.closeConnection(connection);
		} catch (SQLException e) {
			System.err.println("Fehler beim auslesen der Daten");
			e.printStackTrace();
		}
		
		return result.get(0);
		
	}

	@Override
	public int update(User valueObject) {
		System.err.println("Not yet implemented");
		return 0;
	}

	@Override
	public int delete(User valueObject) {
		System.err.println("Not yet implemented");
		return 0;
	}

	@Override
	public List<User> readList(User valueObject) {
		List<User> result = null;
		String sql = "SELECT `id`, `username`, `online` FROM `user`";
		
		try {
			Connection connection = dbcontroller.connectToDB();
			ResultSet resultset = dbcontroller.executeQuery(connection, sql);
			
			result = convertResultset(resultset);
			
			dbcontroller.closeConnection(connection);
		} catch (SQLException e) {
			System.err.println("Fehler beim auslesen der Daten");
			e.printStackTrace();
		}
		
		return result;
	}

	private List<User> convertResultset(ResultSet resultset) throws SQLException{
		List<User> resultList = new ArrayList<User>();
		
		while(resultset.next()) {
			User user = new User();
			user.setId(resultset.getInt("id"));
			user.setUsername(resultset.getString("username"));
			user.setOnline(resultset.getBoolean("online"));
			resultList.add(user);
		}
		
		return resultList;
	}
	
	public static void main(String[] args) {
		
	}
}
