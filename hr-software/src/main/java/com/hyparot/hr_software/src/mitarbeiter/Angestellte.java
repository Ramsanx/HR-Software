package com.hyparot.hr_software.src.mitarbeiter;

import java.util.Calendar;
//import java.util.Vector;
import com.hyparot.hr_software.src.backend.*;
//import backend.BusinessIntellegent;
//import backend.Vertrag;
import com.hyparot.hr_software.src.sst.angestellte;

public class Angestellte implements angestellte{
	
//	protected static Vector<Angestellte> Angestellte = new Vector<Angestellte>();
	
	private String Benutzername; // in der Datenbank tabelle "Zugänge" Feld "Nutzername" typ String
	private String Passwort; // in der Datenbank tabelle "Zugänge" Feld "Passwort" typ String
	private String Vorname; // in der Datenbank tabelle "t_mitarbeiter" Feld "Vorname" typ String
	private String Nachname; // in der Datenbank tabelle "t_mitarbeiter" Feld "Nachname" typ String
	private String EmailAdresse; // in der Datenbank tabelle "t_mitarbeiter" Feld "E-Mail" typ String
	private String GruppenBezeichnung; // in der Datenbank tabelle "t_mitarbeiter" Feld "Gruppe" typ String
	private String StellenBezeichnung; //  in der Datenbank tabelle "t_mitarbeiter" Feld "Gruppe" typ String
	private String TelefonNummer;
	
	private int PersonalNummer; // in der Datenbank tabelle "t_mitarbeiter" Feld "PersNr" typ int
	private int SollArbeitszeit; // in der Datenbank tabelle "t_vertragsdaten" Feld "Arebitsstunden" typ int
	private int IstArbeitszahl; // in der Datenbank tabelle "t_Urlaub_krankheit" Feld "IstArbeitszeit" typ int
	private int GesamtUrlaubstage; // in der Datenbank tabelle "t_Urlaub_krankheit" Feld "Urlaubstage_gesamt" typ int
	private int NochUrlaubstage; // in der Datenbank tabelle "t_Urlaub_krankheit" Feld "Urlaubstage_verbleibend" typ int
	private int Krankheitstage; // in der Datenbank tabelle "t_Urlaub_krankheit" Feld "Krankentage" typ int
	
	private boolean Krank; // in der Datenbank tabelle "t_Urlaub_krankheit" Feld "Krank" typ boolean
	
	private Calendar GeburtsTag; // in der Datenbank "t_mitarbeiter" Feld "Geburtstag" typ date
	private Calendar EinstellungsDatum; // in der Datenbank "t_mitarbeiter" Feld "eingestellt_am"
	//Erstellung eines Calender Objekts erfolgt an anderer Stelle mit z.B. Calender Geburtstag; Geburtstag.set(int Jahr, int Monat, int Tag);
	
	private Adresse Adresse; 
	
	private Vertrag Vertrag;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	
	public Angestellte(String Benutzername, String Passwort, String Vorname, String Nachname, String GruppenBezeichnung, String StellenBezeichnung,
					   String Telefonnummer, int SollArbeitszeit, 
					   Calendar GeburtsTag, Calendar EinstellungsDatum,
					   Adresse Adresse) {
		this.setBenutzername(Benutzername);
		this.setPasswort(Passwort);
		this.setVorname(Vorname);
		this.setNachname(Nachname);
		this.setEmailAdresse(Vorname.substring(0, 1).toLowerCase() + "." + Nachname.toLowerCase() + "@unsere-firma.de");
		this.setGruppenBezeichnung(GruppenBezeichnung);
		this.setStellenBezeichnung(StellenBezeichnung);
		
		this.setTelefonNummer(Telefonnummer);
		this.setPersonalNummer(10000000); 
		this.setSollArbeitszeit(SollArbeitszeit);
		if(SollArbeitszeit >= 37) {
			this.setGesamtUrlaubstage(30);
		}else {
			this.setGesamtUrlaubstage(26);
		}
		
		this.setGeburtsTag(GeburtsTag);
		this.setAdresse(Adresse);
		this.setVertrag(new Vertrag(Vorname, Nachname, GruppenBezeichnung, StellenBezeichnung, 
								   Telefonnummer, SollArbeitszeit,
								   GeburtsTag, EinstellungsDatum, 
								   Adresse));
	}


	//getter und setter Block beginn
	//_________________________________________________________________________________________________________________________________-
	public String getBenutzername() {
		return Benutzername;
	}


	public void setBenutzername(String benutzername) {
		Benutzername = benutzername;
	}


	public String getPasswort() {
		return Passwort;
	}


	public void setPasswort(String passwort) {
		Passwort = passwort;
	}


	public String getVorname() {
		return Vorname;
	}


	public void setVorname(String vorname) {
		Vorname = vorname;
	}


	public String getNachname() {
		return Nachname;
	}


	public void setNachname(String nachname) {
		Nachname = nachname;
	}


	public String getEmailAdresse() {
		return EmailAdresse;
	}


	public void setEmailAdresse(String emailAdresse) {
		EmailAdresse = emailAdresse;
	}


	public String getGruppenBezeichnung() {
		return GruppenBezeichnung;
	}


	public void setGruppenBezeichnung(String gruppenBezeichnung) {
		GruppenBezeichnung = gruppenBezeichnung;
	}


	public String getStellenBezeichnung() {
		return StellenBezeichnung;
	}


	public void setStellenBezeichnung(String stellenBezeichnung) {
		StellenBezeichnung = stellenBezeichnung;
	}


	public String getTelefonNummer() {
		return TelefonNummer;
	}


	public void setTelefonNummer(String telefonNummer) {
		TelefonNummer = telefonNummer;
	}


	public int getPersonalNummer() {
		return PersonalNummer;
	}


	public void setPersonalNummer(int personalNummer) {
		PersonalNummer = personalNummer;
	}


	public int getSollArbeitszeit() {
		return SollArbeitszeit;
	}


	public void setSollArbeitszeit(int sollArbeitszeit) {
		SollArbeitszeit = sollArbeitszeit;
	}


	public int getIstArbeitszahl() {
		return IstArbeitszahl;
	}


	public void setIstArbeitszahl(int istArbeitszahl) {
		IstArbeitszahl = istArbeitszahl;
	}


	public int getGesamtUrlaubstage() {
		return GesamtUrlaubstage;
	}


	public void setGesamtUrlaubstage(int gesamtUrlaubstage) {
		GesamtUrlaubstage = gesamtUrlaubstage;
	}


	public int getNochUrlaubstage() {
		return NochUrlaubstage;
	}


	public void setNochUrlaubstage(int nochUrlaubstage) {
		NochUrlaubstage = nochUrlaubstage;
	}


	public int getKrankheitstage() {
		return Krankheitstage;
	}


	public void setKrankheitstage(int krankheitstage) {
		Krankheitstage = krankheitstage;
	}


	public boolean isKrank() {
		return Krank;
	}


	public void setKrank(boolean krank) {
		Krank = krank;
	}
	
	
	public Calendar getGeburtsTag() {
		return GeburtsTag;
	}


	public void setGeburtsTag(Calendar geburtsTag) {
		GeburtsTag = geburtsTag;
	}


	public Calendar getEinstellungsDatum() {
		return EinstellungsDatum;
	}


	public void setEinstellungsDatum(Calendar einstellungsDatum) {
		EinstellungsDatum = einstellungsDatum;
	}
	
	
//	public static Vector<Angestellte> getAngestellte() {
//		return Angestellte;
//	}


	public Adresse getAdresse() {
		return Adresse;
	}


	public void setAdresse(Adresse adresse) {
		Adresse = adresse;
	}


	public Vertrag getVertrag() {
		return Vertrag;
	}


	public void setVertrag(Vertrag vertrag) {
		Vertrag = vertrag;
	}
	//getter und setter Block ende
	//_________________________________________________________________________________________________________________________________


	@Override
	public boolean loginUser(String username, String password) {
		// TODO Auto-generated method stub
		Angestellte nutzer = BusinessIntellegent.getEmployeeByName(username);
		if(nutzer != null) {
			if(password.equals(nutzer.getPasswort())) {
				return true;
			}
		}
		return false;
	}


	@Override
	public void editEmployee(String vorname, 
							 String nachname, 
							 String emailAdresse,
							 String telefonNummer,
							 Calendar geburtsTag, 
							 String land, 
							 String stadt, 
							 int postleitzahl, 
							 String straße, 
							 int hausnummer, 
							 String hausnummernZusatz) {
		// TODO Auto-generated method stub
		
		BusinessIntellegent.editEmployee(this.getPersonalNummer(),vorname, nachname, emailAdresse, telefonNummer, geburtsTag, 
										 land, stadt, postleitzahl, straße, hausnummer, hausnummernZusatz);
		
	}


	@Override
	public Calendar applyForVacation() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void cancelVacation() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void getVacationOverview() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setSick(int dauer) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setWorkTime() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setPersonalDate() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public com.hyparot.hr_software.src.backend.Vertrag getContract() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void getPhoneBook() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void getPayrol() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sendMailinfo() {
		// TODO Auto-generated method stub
		
	}

	
	public String toString() {
		return ("Vorname: " + this.Vorname +
				"\nNachname: " + this.Nachname +
				"\nE-Mail Adresse: " + this.EmailAdresse +
				"\nTelefonnummer: " + this.TelefonNummer +
				"\nStellenbeschreibung: " + this.StellenBezeichnung);
	}



}
