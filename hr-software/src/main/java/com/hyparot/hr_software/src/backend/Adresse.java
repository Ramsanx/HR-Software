package com.hyparot.hr_software.src.backend;


//ein Objekt der Klasse Adresse wird zum Anlegen eines Angestellten ben�tigt
public class Adresse {
	
	private int Postleitzahl; // in der Tabelle "t_mitarbeiter" Feld "PLZ" typ int
	private int Hausnummer; // in der Tabelle "t_mitarbeiter" Feld "Hausnummer" typ int
	
	private String Land; // in der Tabelle "t_mitarbeiter" Feld "Land" typ String
	private String Stadt; // in der Tabelle "t_mitarbeiter" Feld "Stadt" typ String
	private String Straße; // in der Tabelle "t_mitarbeiter" Feld "Straße" typ String
	private String HausnummernZusatz; // in der Tabelle "t_mitarbeiter" Feld "HausnummerZusatz" typ String

	public Adresse(String Land, 
				   int Postleitzahl, String Stadt, 
				   String Straße, int Hausnummer) {
		
		this.Land = Land;
		this.Postleitzahl = Postleitzahl;
		this.Stadt = Stadt;
		this.Straße = Straße;
		this.Hausnummer = Hausnummer;
	}
	
	public Adresse(String Land, 
			   int Postleitzahl, String Stadt, 
			   String Straße, int Hausnummer, String HausnummernZusatz) {
	
		this.Land = Land;
		this.Postleitzahl = Postleitzahl;
		this.Stadt = Stadt;
		this.Straße = Straße;
		this.Hausnummer = Hausnummer;
		this.HausnummernZusatz = HausnummernZusatz;
	}
	
	public int getPostleitzahl() {
		return this.Postleitzahl;
	}
	
	public void setPostleitzahl(int newPostleitzahl) {
		this.Postleitzahl = newPostleitzahl;
	}
	
	public int getHausnummer() {
		return this.Hausnummer;
	}
	
	public void setHausnummer(int newHausnummer) {
		this.Hausnummer = newHausnummer;
	}

	public String getLand() {
		return this.Land;
	}
	
	public void setLand(String newLand) {
		this.Land = newLand;
	}

	public String getStadt() {
		return this.Stadt;
	}
	
	public void setStadt(String newStadt) {
		this.Stadt = newStadt;
	}

	public String getStraße() {
		return this.Straße;
	}
	
	public void setStraße(String newStraße) {
		this.Straße = newStraße;
	}

	public String getHausnummernZusatz() {
		return this.HausnummernZusatz;
	}
	
	public void setHausnummernZusatz(String newHausnummernZusatz) {
		this.HausnummernZusatz = newHausnummernZusatz;
	}
	
	public boolean deleteHausnummernZusatz() {
		if(!this.HausnummernZusatz.isEmpty()) {
			setHausnummernZusatz("");
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		if(this.HausnummernZusatz == null) {
			return(Land + ", " + Postleitzahl + " " + Stadt + ", " + Straße + " " + Hausnummer);
		}else {
			return(Land + ", " + Postleitzahl + " " + Stadt + ", " + Straße + " " + Hausnummer + HausnummernZusatz);
		}
			
	}
	
	public void print() {
		if(this.HausnummernZusatz == null) {
			System.out.println("Land: " + Land +
					   "\nPostleitzahl: " + Postleitzahl +
					   "\nStadt: " + Stadt +
					   "\nStraße: " + Straße +
					   "\nHausnummer: " + Hausnummer);
		}else {
			System.out.println("Land: " + Land +
					   "\nPostleitzahl: " + Postleitzahl +
					   "\nStadt: " + Stadt +
					   "\nStraße: " + Straße +
					   "\nHausnummer: " + Hausnummer + HausnummernZusatz);
		}
		
	}
}
