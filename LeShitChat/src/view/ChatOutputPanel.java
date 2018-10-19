package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * Chatoutputpanel
 * Beinhaltet die Textarea für die Ausgabe
 * @author ldonker
 *
 */
public class ChatOutputPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;
	private JTextArea txt_outputArea;
	
	/**
	 * Konstruktor
	 */
	public ChatOutputPanel() {
		this.setLayout(new BorderLayout());
	}

	/**
	 * Fügt Komponenten ein
	 */
	public void initialize() {
		txt_outputArea = new JTextArea();
		txt_outputArea.setText("Hallo Welt");
		txt_outputArea.setEditable(false);
		
		JScrollPane scrollpane = new JScrollPane(txt_outputArea);
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			
		this.add(scrollpane, BorderLayout.CENTER);
	}
	
	/**
	 * Fügt alle Nachrichten der Liste nacheinander in die TextArea ein 
	 * @param messages Liste an Strings die in den Chat reinkommen.
	 */
	public void writeMessages(List<String> messages) {
		String output = "";
		for(String message : messages) {
			output += message + "\n";
		}
		txt_outputArea.setText(output);
	}
	
}
