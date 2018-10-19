package model;

public class Ausführung {
	
	public static void main(String[] args) {
		Auto ford = new Auto("Ford", "Focus");
		Auto mercedes = new Auto("Mercedes", "A-Klasse");
		Auto fiat = new Auto("Fiat", "500");
		Auto vw = new Auto("VW", "E-Up");
		
		Fahrrad bulls = new Fahrrad("Bulls", "City-Rad");
		
		Fahrzeug[] array = new Fahrzeug[5];
		array[0] = ford;
		array[1] = mercedes;
		array[2] = fiat;
		array[3] = vw;
		array[4] = bulls;
		
		for(int i = 0; i<array.length; i++) {
			System.out.println(array[i].toString());
			
			switch(array[i].getModell()) {
			case "E-Up" : array[i].setFarbe("Schwarz");
							break;
			case "Focus" : array[i].setFarbe("Blau");
							break;
			default : array[i].setFarbe("Silber");
			
			}
			System.out.println(array[i].getFarbe());
			System.out.println(array[i].fahren());
		}
		
	}
	
	
}
