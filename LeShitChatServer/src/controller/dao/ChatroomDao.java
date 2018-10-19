package controller.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.DBController;
import model.Chatroom;
import model.User;

/**
 * ChatroomDao
 * @author ldonker
 *
 */
public class ChatroomDao implements CRUDInterface<Chatroom> {

	private DBController dbcontroller = DBController.getInstance();
	private UserDao userDao = new UserDao();

	@Override
	public int create(Chatroom valueObject) {
		String sql = "INSERT INTO `chatroom`(`chatroomname`) VALUES ("
				+ "'" + valueObject.getChatroomname() + "')";

		int angepasst = dbcontroller.executeUpdate(sql);

		for (User user : valueObject.getUserlist()) {
			String sql2 = "INSERT INTO `userchatroom`(`userid`, `chatroomid`) VALUES (" + user.getId() + ", (SELECT MAX(id) FROM chatroom))";
			angepasst += dbcontroller.executeUpdate(sql2);
		}

		return angepasst;
	}

	@Override
	public Chatroom read(long id) {
		String sqlChatroom = "SELECT `id`, `chatroomname` FROM `chatroom` WHERE id = " + id;

		List<Chatroom> result = null;
		try {
			// Chatroom auslesen
			Connection connection = dbcontroller.connectToDB();
			ResultSet resultset = dbcontroller.executeQuery(connection, sqlChatroom);
			result = convertChatroomResultset(resultset);

			dbcontroller.closeConnection(connection);

			// Userliste auslesen
			for (Chatroom chatroom : result) {
				String sqlUserChatroom = "SELECT `userid`, `chatroomid` FROM `userchatroom` " + "WHERE chatroomid ="
						+ chatroom.getId();

				connection = dbcontroller.connectToDB();

				resultset = dbcontroller.executeQuery(connection, sqlUserChatroom);
				chatroom = convertUserChatroomResultset(chatroom, resultset);

				dbcontroller.closeConnection(connection);
			}
		} catch (SQLException e) {
			System.err.println("Fehler beim auslesen der Daten");
			e.printStackTrace();
		}

		return result.get(0);
	}

	@Override
	public int update(Chatroom valueObject) {
		System.err.println("Not yet implemented");
		return 0;
	}

	@Override
	public int delete(Chatroom valueObject) {
		System.err.println("Not yet implemented");
		return 0;
	}

	@Override
	public List<Chatroom> readList(Chatroom valueObject) {
		String sqlChatroom = "SELECT `id`, `chatroomname` FROM `chatroom`";

		List<Chatroom> result = null;
		try {
			// Chatroom auslesen
			Connection connection = dbcontroller.connectToDB();
			ResultSet resultset = dbcontroller.executeQuery(connection, sqlChatroom);
			result = convertChatroomResultset(resultset);

			dbcontroller.closeConnection(connection);

			// Userliste auslesen
			for (Chatroom chatroom : result) {
				String sqlUserChatroom = "SELECT `userid`, `chatroomid` FROM `userchatroom` " + "WHERE chatroomid ="
						+ chatroom.getId();

				connection = dbcontroller.connectToDB();

				resultset = dbcontroller.executeQuery(connection, sqlUserChatroom);
				chatroom = convertUserChatroomResultset(chatroom, resultset);

				dbcontroller.closeConnection(connection);
			}
		} catch (SQLException e) {
			System.err.println("Fehler beim auslesen der Daten");
			e.printStackTrace();
		}

		return result;
	}

	private List<Chatroom> convertChatroomResultset(ResultSet resultset) throws SQLException {
		List<Chatroom> resultList = new ArrayList<Chatroom>();

		while (resultset.next()) {
			Chatroom chatroom = new Chatroom();
			chatroom.setId(resultset.getInt("id"));
			chatroom.setChatroomname(resultset.getString("chatroomname"));
			resultList.add(chatroom);
		}
		return resultList;
	}

	private Chatroom convertUserChatroomResultset(Chatroom chatroom, ResultSet resultset) throws SQLException {
		List<User> userlist = new ArrayList<User>();
		while (resultset.next()) {
			long userid = resultset.getLong("userid");
			User user = userDao.read(userid);
			userlist.add(user);
		}
		chatroom.setUserlist(userlist);
		return chatroom;
	}
}
