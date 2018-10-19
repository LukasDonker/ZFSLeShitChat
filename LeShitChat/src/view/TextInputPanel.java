package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.ChatControll;

/**
 * TextInputPanel
 * beinhaltet Input + Senden Button.
 * @author ldonker
 *
 */
public class TextInputPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;
	
	private JTextArea txt_textinput;
	private JButton btn_abschicken;
	private String chatname;

	/**
	 * Konstruktor
	 * @param chatname String name des zugehörigen Chatrooms
	 */
	public TextInputPanel(String chatname) {
		this.chatname = chatname;
		this.setLayout(new BorderLayout());
		initialize();
	}
	
	/**
	 * Fügt Komponenten ein
	 */
	public void initialize() {
		txt_textinput = new JTextArea(5,150);
		txt_textinput.setLineWrap(true);
		btn_abschicken = new JButton("Senden");
		btn_abschicken.addActionListener(new SendenActionListener());
		this.add(new JScrollPane(txt_textinput), BorderLayout.CENTER);
		this.add(btn_abschicken, BorderLayout.EAST);	
	}
	
	/**
	 * ActionListener für das senden vom Text.
	 * Wird vom "Senden"-Button verwendet
	 * @author ldonker
	 *
	 */
	public class SendenActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ChatControll.getInstance().sendText(chatname, txt_textinput.getText());
		}
		
	}
}




