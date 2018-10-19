package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Wir mˆchten in dieser Klasse unseren Username in ein File reinschreiben und
 * auslesen. Vom Desktop -> danke mariuﬂ
 * 
 * @author ldonker
 *
 */
public class UsernameController {

	private static final String DIRECTORY = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop";
	private static final String FILENAME = "LeShitChat.KEKS";

	/**
	 * Liest den Inhalt des Files ein
	 * 
	 * @return String Inhalt
	 */
	public String auslesen() {

		File file = new File(DIRECTORY, FILENAME);
		String result = "";

		try {
			FileReader reader = new FileReader(file);

			char[] buffer = new char[(int) file.length()];

			reader.read(buffer);

			result = String.copyValueOf(buffer);

			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("File existiert nicht");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Reinschreiben in die Datei
	 * 
	 * @param String
	 *            inhalt
	 * @return boolean erfolgreich
	 */
	public boolean reinschreiben(String inhalt) {
		File file = new File(DIRECTORY, FILENAME);

		FileWriter writer;
		try {
			writer = new FileWriter(file);

			writer.write(inhalt);
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new UsernameController().reinschreiben("Lukas"));
		System.out.println(new UsernameController().auslesen());

	}

}
