package model;

public class Fahrzeug implements FahrzeugBewegen{
	
	private boolean verkehrsteilnehmer = true;
	private int reifen;
	private String marke;
	private String modell;
	private String farbe;
	
	public Fahrzeug(int reifen, String marke, String modell) {
		this.reifen = reifen;
		this.marke = marke;
		this.modell = modell;
		
	}
	
	
	public String toString() {
		return this.getClass() + ": " + marke + ", " + modell;
	}

	public boolean isVerkehrsteilnehmer() {
		return verkehrsteilnehmer;
	}

	public void setVerkehrsteilnehmer(boolean verkehrsteilnehmer) {
		this.verkehrsteilnehmer = verkehrsteilnehmer;
	}

	public int getReifen() {
		return reifen;
	}

	public void setReifen(int reifen) {
		this.reifen = reifen;
	}

	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}


	@Override
	public double fahren() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void bremsen() {
		// TODO Auto-generated method stub
		
	}
}
