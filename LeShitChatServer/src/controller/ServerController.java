package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

import controller.dao.CRUDInterface;
import model.Action;
import model.Transaction;
import model.User;
import model.ValueObject;

public class ServerController {

	private static final int PORT = 50000;

	private ServerSocket serverSocket;

	public void startServer() throws IOException {
		serverSocket = new ServerSocket(PORT);
		System.err.println("Server gestartet: ");
		System.err.println("Port: " + PORT + "\n");
	}

	public Socket warteAufVerbindungsEingang() throws IOException {
		System.out.println("Warte auf Verbindung...");
		Socket socket = serverSocket.accept();
		System.out.println("Verbindung hergestellt von " + socket.getInetAddress().getHostAddress());
		return socket;
	}

	public void stopServer() throws IOException {
		serverSocket.close();
		System.err.println("Server gestoppt");
	}

	public static void main(String[] args) throws IOException {
		// User user = new User();
		// user.setUsername("Lukas");
		// user.setOnline(true);
		// Transaction trans = new Transaction(Action.CREATE, user);
		//
		// String workdatatype = trans.getWorkdataType();
		// String classname = workdatatype.substring(6, workdatatype.length());
		// String fullclassname = "controller.dao." + classname + "Dao";
		// String methodNameFromAction = trans.getAction().toString().toLowerCase();
		// System.out.println(methodNameFromAction);
		// System.out.println(fullclassname);
		// try {
		// Class daoClass = Class.forName(fullclassname);
		// Object daoObject = daoClass.newInstance();
		//
		// Method method = daoClass.getMethod(methodNameFromAction,
		// Class.forName(workdatatype));
		//
		// method.invoke(daoObject,
		// Class.forName(workdatatype).cast(trans.getWorkdata()));
		// } catch (ClassNotFoundException | NoSuchMethodException | SecurityException |
		// IllegalArgumentException | InvocationTargetException | IllegalAccessException
		// | InstantiationException e) {
		// e.printStackTrace();
		// }
		//
		//
		// System.out.println();

		ServerController server = new ServerController();
		server.startServer();

		while (true) {
			server.warteAufVerbindungsEingang();
			VerarbeitungsController controll = new VerarbeitungsController();
			new Thread(controll).start();
		}
	}

	@Override
	public void finalize() throws IOException {
		stopServer();
	}
}
