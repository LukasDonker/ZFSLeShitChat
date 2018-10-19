package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import controller.ChatControll;

/**
 * UserlistPanel
 * Zeigt die Userliste an und beinhaltet den New Chat Button
 * @author ldonker
 *
 */
public class UserListPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;
	
	JList<String> list_user; 
	
	/**
	 * Konstruktor
	 */
	public UserListPanel() {
		this.setLayout(new BorderLayout());
		initialize();
	}
	
	/**
	 * Komponenten einfügen
	 */
	public void initialize() {
		//Userliste erstellen *Beispiel*
		DefaultListModel<String> userdata = new DefaultListModel<String>();
		for(int i = 0; i<10;i++) {
			userdata.addElement("User"+i);
		}
		
		//Liste erstellen mit beispieldaten
		list_user = new JList<String>(userdata);
		
		//Liste anpassen
		list_user.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list_user.setLayoutOrientation(JList.VERTICAL);
		list_user.setVisibleRowCount(-1);
		
		//Scroll
		JScrollPane listScroller = new JScrollPane(list_user);
		listScroller.setPreferredSize(new Dimension(80, 600));
		
		//newchat-button
		JButton btn_newChat = new JButton("+");
		
		this.add(listScroller, BorderLayout.CENTER);
		this.add(btn_newChat, BorderLayout.SOUTH);
	}
	
	/**
	 * ActionListener für das öffnen eines neuen Chats.
	 * Wird vom "+"-Button verwendet
	 * @author ldonker
	 *
	 */
	public class OpenNewActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO Öffne neuen Chatroom 
		}
		
	}
}
