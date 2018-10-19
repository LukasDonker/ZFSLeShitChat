package model;

public class Auto extends Fahrzeug {
	
	private int ps;
	private String antrieb;
	private int anzahlSitze;
	private int anzahlTueren;
	private double durchschnittsgeschwindigkeit = 80;
	
	public Auto(String marke, String modell) {
		super(4, marke, modell);
	}

	@Override
	public double fahren() {
		return durchschnittsgeschwindigkeit;
	}
	
	public double getDurchschnittsgeschwindigkeit() {
		return durchschnittsgeschwindigkeit;
	}
	
	public void setDurchschnittsgeschwindigkeit(double geschwindigkeit) {
		durchschnittsgeschwindigkeit = geschwindigkeit;
	}
	
	public int getPs() {
		return ps;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}

	public String getAntrieb() {
		return antrieb;
	}

	public void setAntrieb(String antrieb) {
		this.antrieb = antrieb;
	}

	public int getAnzahlSitze() {
		return anzahlSitze;
	}

	public void setAnzahlSitze(int anzahlSitze) {
		this.anzahlSitze = anzahlSitze;
	}

	public int getAnzahlTueren() {
		return anzahlTueren;
	}

	public void setAnzahlTueren(int anzahlTueren) {
		this.anzahlTueren = anzahlTueren;
	}
	
}
