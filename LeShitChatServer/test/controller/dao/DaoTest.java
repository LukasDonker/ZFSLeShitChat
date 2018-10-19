package controller.dao;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.DBController;
import model.Chatroom;
import model.Message;
import model.User;

public class DaoTest {
	

	static UserDao userdao = new UserDao();
	static ChatroomDao chatroomdao = new ChatroomDao();
	static MessageDao messagedao = new MessageDao();
	User testUser;
	Chatroom chatroom;
	Message message;
	private String userName = "Mustermann";
	private String chatroomName = "General";
	private String messageText = "Hallo Welt!";
	
	@Before
	public void setUp() {
		testUser = new User();
		testUser.setId(-1);
		testUser.setUsername(userName);
		testUser.setOnline(false);
		
		chatroom = new Chatroom();
		chatroom.setId(-1);
		chatroom.setChatroomname(chatroomName);
	}
	
	@After
	public void tearDown() {
		DBController.getInstance().executeUpdate("DELETE FROM user");
		List<User> resultuser = userdao.readList(null);
		assertTrue(resultuser.isEmpty());
		
		DBController.getInstance().executeUpdate("DELETE FROM chatroom");
		DBController.getInstance().executeUpdate("DELETE FROM userchatroom");
		List<Chatroom> resultchat = chatroomdao.readList(null);
		assertTrue(resultchat.isEmpty());
		
		DBController.getInstance().executeUpdate("DELETE FROM messages");
		List<Message> resultmessage = messagedao.readList(null);
		assertTrue(resultmessage.isEmpty());
	}
	

	@Test
	public void userDaotest() {
		
		userdao.create(testUser);
		
		List<User> userList = userdao.readList(null);
		
		assertTrue(userList.size()>0);
		
		boolean foundMustermann = false;
		for(User value : userList) {
			if(value.getUsername().equals(userName)){
				foundMustermann = true;
			}
		}
		assertTrue(foundMustermann);
	}
	
	@Test
	public void chatroomDaotest() {
		
		userdao.create(testUser);
		
		List<User> userList = userdao.readList(null);
		
		assertTrue(userList.size()>0);
		
		List<User> userListForChatroom = new ArrayList<User>();
		userListForChatroom.add(userList.get(0));
		chatroom.setUserlist(userListForChatroom);
		
		chatroomdao.create(chatroom);
		
		List<Chatroom> chatroomList = chatroomdao.readList(null);
		
		boolean foundGeneral = false;
		for(Chatroom value : chatroomList) {
			if(value.getChatroomname().equals(chatroomName)){
				foundGeneral = true;
			}
		}
		assertTrue(foundGeneral);
	}
	
	
	@Test
	public void messageDaotest() {
		
		userdao.create(testUser);
		
		List<User> userList = userdao.readList(null);
		
		assertTrue(userList.size()>0);
		
		List<User> userListForChatroom = new ArrayList<User>();
		testUser = userList.get(0);
		userListForChatroom.add(testUser);
		chatroom.setUserlist(userListForChatroom);
		
		chatroomdao.create(chatroom);
		
		List<Chatroom> chatroomList = chatroomdao.readList(null);
		assertTrue(chatroomList.size()>0);
		chatroom = chatroomList.get(0);
		
		message = new Message(testUser, chatroom, messageText);
		
		messagedao.create(message);
		
		List<Message> messageList = messagedao.readList(null);
		assertTrue(messageList.size()>0);
		
		boolean foundHelloWorld = false;
		for(Message value : messageList) {
			if(value.getMessage().equals(messageText)){
				foundHelloWorld = true;
			}
		}
		assertTrue(foundHelloWorld);
	}
}
