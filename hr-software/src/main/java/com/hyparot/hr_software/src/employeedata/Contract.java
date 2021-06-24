package com.hyparot.hr_software.src.employeedata;


//ein Objekt der Klasse Vertrag wird beim Anlegen eines Angestellten erstellt
public class Contract {

	private String Vorname;
	private String Nachname;
	private String GruppenBezeichnung;
	private String StellenBezeichnung;
	private String Telefonnummer;
	
	private int SollArbeitszeit;
	
	private Date GeburtsTag;
	private Date EinstellungsDatum;
	
	private Adress Adresse;
	
	public Contract(String Vorname, String Nachname, String GruppenBezeichnung, String StellenBezeichnung, String Telefonnummer, 
				   int SollArbeitszeit,
				   Date GeburtsTag, Date EinstellungsDatum, 
				   Adress Adresse) {
		
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
	
	public String Telefonnumer() {
		return this.Telefonnummer;
	}
	
	public void setTelefonnummer(String newTelefonnummer) {
		this.Telefonnummer = newTelefonnummer;
	}
	
	public int SollArbeitszeit() {
		return this.SollArbeitszeit;
	}
	
	public void setSollArbeitszeit(int newSollArbeitszeit) {
		this.SollArbeitszeit = newSollArbeitszeit;
	}
	
	public Date getGeburtsTag() {
		return this.GeburtsTag;
	}
	
	public void setGeburtsTag(Date newGeburtsTag) {
		this.GeburtsTag = newGeburtsTag;
	}
	
	public Date EinstellungsDatum() {
		return this.EinstellungsDatum;
	}
	
	public void setEinstellungsDatum(Date newEinstellungsDatum) {
		this.EinstellungsDatum = newEinstellungsDatum;
	}
	
	public Adress getAdresse() {
		return this.Adresse;
	}
	
	public void setAdresse(Adress newAdresse) {
		this.Adresse = newAdresse;
	}
}
