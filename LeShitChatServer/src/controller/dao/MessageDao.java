package controller.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.DBController;
import model.Message;

/**
 * MessageDao
 * Implementierung der CRUD Methoden und weitere für Message
 * @author ldonker
 */
public class MessageDao implements CRUDInterface<Message>{

	private DBController dbcontroller = DBController.getInstance();
	private UserDao userdao = new UserDao();
	private ChatroomDao chatroomdao = new ChatroomDao();
	
	@Override
	public int create(Message message) {		
		String sql = "INSERT INTO `messages`(`chatroomid`, `userid`, `timestamp`, `message`) VALUES ("
				+ message.getChatroom().getId() + "," //ChatroomId
				+ message.getUser().getId() + "," //userId
				+ message.getTimestamp().getTime() + ",'" // timestamp
				+ message.getMessage() + "')"; // Message
		
		return dbcontroller.executeUpdate(sql);
	}

	@Override
	public Message read(long id) {
		System.err.println("Not yet implemented");
		return null;
	}

	@Override
	public int update(Message valueObject) {
		System.err.println("Not yet implemented");
		return 0;
	}

	@Override
	public int delete(Message valueObject) {
		System.err.println("Not yet implemented");
		return 0;
	}

	@Override
	public List<Message> readList(Message valueObject) {
		List<Message> result = null;
		String sql = "";
		if(valueObject != null && valueObject.getChatroom() != null) {
			sql = "SELECT * FROM `messages` WHERE chatroomid = "
				+ valueObject.getChatroom().getId();
		}else {
			sql = "SELECT * FROM `messages`";
		}
		
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
	
	private List<Message> convertResultset(ResultSet resultset) throws SQLException{
		List<Message> resultList = new ArrayList<Message>();
		
		while(resultset.next()) {
			resultList.add(new Message(
					chatroomdao.read(resultset.getLong("chatroomid")),
					userdao.read(resultset.getLong("userid")),
					new Date(resultset.getLong("timestamp")),
					resultset.getString("message")));
		}
		
		return resultList;
	}
	
}
