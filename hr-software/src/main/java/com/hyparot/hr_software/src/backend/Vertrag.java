package com.hyparot.hr_software.src.backend;

import java.util.Calendar;


//ein Objekt der Klasse Vertrag wird beim Anlegen eines Angestellten erstellt
public class Vertrag {

	private String Vorname;
	private String Nachname;
	private String GruppenBezeichnung;
	private String StellenBezeichnung;
	
	private int Telefonnummer;
	private int SollArbeitszeit;
	
	private Calendar GeburtsTag;
	private Calendar EinstellungsDatum;
	
	private Adresse Adresse;
	
	public Vertrag(String Vorname, String Nachname, String GruppenBezeichnung, String StellenBezeichnung, 
				   int Telefonnummer, int SollArbeitszeit,
				   Calendar GeburtsTag, Calendar EinstellungsDatum, 
				   Adresse Adresse) {
		
		this.Vorname = Vorname;
		this.Nachname = Nachname;
		this.GruppenBezeichnung = GruppenBezeichnung;
		this.StellenBezeichnung = StellenBezeichnung;
		this.GruppenBezeichnung = GruppenBezeichnung;
		this.GeburtsTag = GeburtsTag;
		this.EinstellungsDatum = EinstellungsDatum;
		this.Adresse = Adresse;
	}
	
	public String getVorname() {
		return this.Vorname;
	}
	
	public void setVorname(String newVorname) {
		this.Vorname = newVorname;
	}
	
	public String getNachname() {
		return this.Nachname;
	}
	
	public void setNachname(String newNachname) {
		this.Nachname = newNachname;
	}
	
	public String GruppenBezeichnung() {
		return this.GruppenBezeichnung;
	}
	
	public void setGruppenBezeichnung(String newGruppenBezeichnung) {
		this.GruppenBezeichnung = newGruppenBezeichnung;
	}
	
	public String StellenBezeichnung() {
		return this.StellenBezeichnung;
	}
	
	public void setStellenBezeichnung(String newStellenBezeichnung) {
		this.StellenBezeichnung = newStellenBezeichnung;
	}
	
	public int Telefonnumer() {
		return this.Telefonnummer;
	}
	
	public void setTelefonnummer(int newTelefonnummer) {
		this.Telefonnummer = newTelefonnummer;
	}
	
	public int SollArbeitszeit() {
		return this.SollArbeitszeit;
	}
	
	public void setSollArbeitszeit(int newSollArbeitszeit) {
		this.SollArbeitszeit = newSollArbeitszeit;
	}
	
	public Calendar getGeburtsTag() {
		return this.GeburtsTag;
	}
	
	public void setGeburtsTag(Calendar newGeburtsTag) {
		this.GeburtsTag = newGeburtsTag;
	}
	
	public Calendar EinstellungsDatum() {
		return this.EinstellungsDatum;
	}
	
	public void setEinstellungsDatum(Calendar newEinstellungsDatum) {
		this.EinstellungsDatum = newEinstellungsDatum;
	}
	
	public Adresse getAdresse() {
		return this.Adresse;
	}
	
	public void setAdresse(Adresse newAdresse) {
		this.Adresse = newAdresse;
	}
}
