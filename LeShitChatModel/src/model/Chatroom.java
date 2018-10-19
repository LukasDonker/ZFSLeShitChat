package model;

import java.util.ArrayList;
import java.util.List;

public class Chatroom extends ValueObject{

	private List<User> userlist = new ArrayList<User>();
	private long id = -1;
	private String chatroomname = "";
	
	public List<User> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getChatroomname() {
		return chatroomname;
	}
	public void setChatroomname(String chatroomname) {
		this.chatroomname = chatroomname;
	}	
}
