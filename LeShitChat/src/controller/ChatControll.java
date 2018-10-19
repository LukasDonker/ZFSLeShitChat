package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import view.ChatPanel;

public class ChatControll {
	
	//Singelton Pattern
	//Klassenvariable f�r Instanz anlegen
	private static ChatControll instance;
	
	/**
	 * Methode f�r Instanz Zugriff. 
	 * Gibt mir DIE EINE Instanz zur�ck die es gibt.
	 * @return ChatControll instance
	 */
	public static ChatControll getInstance() {
		if(instance == null) {
			instance = new ChatControll();
		}
		return instance;
	}
	
	/**
	 * Standard Konstruktor auf private setzen.
	 * Damit kein anderer eine Instanz erstellen kann.
	 */
	private ChatControll() {
		chatrooms = new HashMap<String, ChatPanel>();
	}

	//Globale Variablen
	//Map f�r Chatr�ume Key Value paare
	private Map<String, ChatPanel> chatrooms;
	
	/**
	 * Sendet den Text *Sp�ter* an den Server
	 * @param chatroom String name des Chatrooms
	 * @param text String text der reingeschrieben wird
	 */
	public void sendText(String chatroom, String text) {
		//Chatraum abfragen
		ChatPanel chat = chatrooms.get(chatroom);
		//Sp�ter an server senden
		
		//----------------------------------------------
		//Test text in output anzeigen kommt sp�ter raus
		List<String> messages = new ArrayList<String>();
		messages.add(text);
		
		//Text ausgeben
		chat.writeMessages(messages);
	}

	/**
	 * Registriert den Chatroom am Controller um sp�ter nachvollziehen zu k�nnen, 
	 * wo hin etwas geh�rt.
	 * �berlf�ssig? wo bekommt der User seine Chatrooms
	 * 
	 * @param name Name des Chatrooms
	 * @param chatPanel Das Panel mit input und Output zugeh�rig zum Chatroom
	 */
	public void registerChatroom(String name, ChatPanel chatPanel) {
		//Chatraum in die Map einf�gen
		chatrooms.put(name, chatPanel);
	}
}
