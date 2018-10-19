package controller;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import model.Action;
import model.Transaction;

public class ClientController {

	private static final String HOSTADRESS = "localhost";
	private static final int PORT = 50000;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		for(int i = 0; i<200;i++) {
			Socket socket = new Socket(HOSTADRESS, PORT);
			socket.close();
		}	
	}
	
}
