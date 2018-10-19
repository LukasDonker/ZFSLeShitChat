package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 * Hauptfenster, hier fließt alles zusammen.
 * @author ldonker
 *
 */
public class Hauptfenster extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;
	private JTabbedPane tab_pane;
	
	/**
	 * Konstruktor legt "default" sachen fest, wie closeoperation, größe, titel usw.
	 */
	public Hauptfenster() {
		super("LeShitChat");
		
		initialize();
		
		this.setBounds(10, 10, 500, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * Fügt Komponenten ein
	 */
	public void initialize() {
		tab_pane = new JTabbedPane();
		for(int i = 0; i<3;i++) {
			ChatPanel chat = new ChatPanel("Groupchat " + i);
			tab_pane.addTab(chat.getName(), chat);
		}
		UserListPanel userList = new UserListPanel();
		this.add(userList, BorderLayout.WEST);
		this.add(tab_pane, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new Hauptfenster();
	}
}
