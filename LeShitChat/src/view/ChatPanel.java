package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;

import controller.ChatControll;

/**
 * ChatPanel 
 * beinhaltet output + input + Oberflächen Logik zum registrieren des Chatfensters
 * @author ldonker
 *
 */
public class ChatPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;
	private TextInputPanel chatinput;
	private ChatOutputPanel chatoutput; 
	
	/**
	 * Konstruktor
	 * @param chatName String name des Chatrooms
	 */
	public ChatPanel(String chatName) {
		this.setName(chatName);
		this.setLayout(new BorderLayout());
		registerOnController();
		initialize();
	}
	
	/**
	 * Komponenten hinzufügen
	 */
	public void initialize() {
		chatinput = new TextInputPanel(this.getName());
		chatoutput = new ChatOutputPanel();
		this.add(chatinput, BorderLayout.SOUTH);
		this.add(chatoutput, BorderLayout.CENTER);
	}
	
	/**
	 * registriert das Chatfenster beim Controller
	 */
	public void registerOnController() {
		ChatControll.getInstance().registerChatroom(this.getName(), this);
	}
	
	/**
	 * gibt die Messages an die Outputbox weiter
	 * @param messages Liste an Strings die dargestellt werden sollen
	 */
	public void writeMessages(List<String> messages) {
		chatoutput.writeMessages(messages);
	}
	
}
