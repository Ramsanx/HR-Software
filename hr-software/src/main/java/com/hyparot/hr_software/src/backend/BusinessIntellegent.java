package com.hyparot.hr_software.src.backend;

import com.hyparot.hr_software.src.mitarbeiter.*;
import java.util.*;

public class BusinessIntellegent {

	private static Vector<Angestellte> mitarbeiterListe = new Vector<Angestellte>();
	private static ArrayList<Integer> bearbeitet = new ArrayList<Integer>();
	
	
	public static Vector<Angestellte> getEmployees() {
		return mitarbeiterListe;
	}
	
	
	static public Angestellte getEmployeeByName(String Nutzername) {;
		Iterator<Angestellte> mitarbeiter = mitarbeiterListe.iterator();
		
		while(mitarbeiter.hasNext()) {
			Angestellte nutzer = mitarbeiter.next();
			if(nutzer.getBenutzername().equals(Nutzername)) {
				return nutzer;
			}
		}
		return null;
	}
	
	static public Angestellte getEmployeeByID(int Personalnummer) {
		Iterator<Angestellte> mitarbeiter = mitarbeiterListe.iterator();
		
		while(mitarbeiter.hasNext()) {
			Angestellte nutzer = mitarbeiter.next();
			if(nutzer.getPersonalNummer() == Personalnummer) {
				return nutzer;
			}
		}
		return null;
	}
	
	
	
	public static void createEmployee(String Stellung, String Benutzername, String Passwort, String Vorname, String Nachname, 
									  String GruppenBezeichnung, String StellenBezeichnung, String Telefonnummer, int SollArbeitszeit, 
									  Calendar GeburtsTag, Calendar EinstellungsDatum,
									  Adresse Adresse) {
		
		Angestellte nutzer;
		if(Stellung.equals("HR")) {
			nutzer = new HR(Benutzername, Passwort, Vorname, Nachname, GruppenBezeichnung, 
					 StellenBezeichnung, Telefonnummer, SollArbeitszeit, 
					 GeburtsTag, EinstellungsDatum,
					 Adresse);
		}else if(Stellung.equals("Vorgesetzte")) {
			nutzer = new Vorgesetzte(Benutzername, Passwort, Vorname, Nachname, GruppenBezeichnung, 
					 StellenBezeichnung, Telefonnummer, SollArbeitszeit, 
					 GeburtsTag, EinstellungsDatum,
					 Adresse);
		}else {
			nutzer = new Angestellte(Benutzername, Passwort, Vorname, Nachname, GruppenBezeichnung, 
											 StellenBezeichnung, Telefonnummer, SollArbeitszeit, 
											 GeburtsTag, EinstellungsDatum,
											 Adresse);
		}
		mitarbeiterListe.add(nutzer);
		bearbeitet.add(nutzer.getPersonalNummer());
	}
	
	
	public static void editEmployee(int Personalnummer, 
									String vorname, 
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
		
		Angestellte nutzer = getEmployeeByID(Personalnummer);
		if(nutzer != null) {
			nutzer.setVorname(vorname);
			nutzer.setNachname(nachname);
			nutzer.setEmailAdresse(emailAdresse);
			nutzer.setTelefonNummer(telefonNummer);
			nutzer.setGeburtsTag(geburtsTag);
		
			nutzer.getAdresse().setLand(land);
			nutzer.getAdresse().setStadt(stadt);
			nutzer.getAdresse().setStraße(straße);
			nutzer.getAdresse().setPostleitzahl(postleitzahl);
			nutzer.getAdresse().setHausnummer(hausnummer);
			nutzer.getAdresse().setHausnummernZusatz(hausnummernZusatz);
		
			bearbeitet.add(Personalnummer);
		}
	}
	
	public static boolean deleteEmloyee(int Personalnummer) {
		Angestellte mitarbeiter = getEmployeeByID(Personalnummer);
		if(mitarbeiter == null) {
			return false;
		}else {
			mitarbeiterListe.remove(mitarbeiter);
			bearbeitet.add(Personalnummer);
			return true;
		}
	}
	
	
}
