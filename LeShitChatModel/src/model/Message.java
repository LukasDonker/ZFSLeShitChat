package model;

import java.util.Date;

public class Message extends ValueObject{

	private User user;
	private Chatroom chatroom;
	private Date timestamp;
	private String message;
	
	public Message(User user, Chatroom chatroom, String message) {
		this.user = user;
		this.chatroom = chatroom;
		this.message = message;
		this.timestamp = new Date();
	}

	public Message(Chatroom chatroom, User user, Date date, String message) {
		this.user = user;
		this.chatroom = chatroom;
		this.message = message;
		this.timestamp = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Chatroom getChatroom() {
		return chatroom;
	}

	public void setChatroom(Chatroom chatroom) {
		this.chatroom = chatroom;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
