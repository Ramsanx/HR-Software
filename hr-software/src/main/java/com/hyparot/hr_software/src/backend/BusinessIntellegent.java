package com.hyparot.hr_software.src.backend;

import com.hyparot.hr_software.src.mitarbeiter.*;
import com.hyparot.hr_software.src.db.db_connect;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class BusinessIntellegent {

	private static Vector<Angestellte> mitarbeiterListe = new Vector<Angestellte>();
	private static Hashtable<Integer, String> bearbeitet = new Hashtable<Integer, String>();
	
	
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
									  Datum GeburtsTag, Datum EinstellungsDatum,
									  Adresse Adresse) {
		
		Angestellte nutzer;
		if(Stellung.equals("HR")) {
			nutzer = new HR(Benutzername, Passwort, Vorname, Nachname, 
					 StellenBezeichnung, Telefonnummer, SollArbeitszeit, 
					 GeburtsTag, EinstellungsDatum,
					 Adresse);
		}else if(Stellung.equals("Vorgesetzte")) {
			nutzer = new Vorgesetzte(Benutzername, Passwort, Vorname, Nachname, 
					 StellenBezeichnung, Telefonnummer, SollArbeitszeit, 
					 GeburtsTag, EinstellungsDatum,
					 Adresse);
		}else {
			nutzer = new Angestellte(Benutzername, Passwort, Vorname, Nachname, 
											 StellenBezeichnung, Telefonnummer, SollArbeitszeit, 
											 GeburtsTag, EinstellungsDatum,
											 Adresse);
		}
		mitarbeiterListe.add(nutzer);
		bearbeitet.put(nutzer.getPersonalNummer(), "angelegt");
	}
	
	
	public static void editEmployee(int Personalnummer, 
									String vorname, 
									String nachname, 
									String emailAdresse,
									String telefonNummer,
									Datum geburtsTag, 
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
		
			bearbeitet.put(Personalnummer, "geändert");
		}
	}
	
	public static boolean deleteEmloyee(int Personalnummer) {
		Angestellte mitarbeiter = getEmployeeByID(Personalnummer);
		if(mitarbeiter == null) {
			return false;
		}else {
			mitarbeiterListe.remove(mitarbeiter);
			bearbeitet.put(Personalnummer, "gelöscht");
			return true;
		}
	}
	
	
//	public static void loadDBDataToLocal() throws SQLException {
//		ResultSet Daten = db_connect.read_table("t_mitarbeiter");
//		if(Daten != null) {
//			ResultSetMetaData meta = Daten.getMetaData();
//			while(Daten.next()) {
//				
//				String Klasse = Daten.getString(meta.getColumnCount());
//				if(Klasse.equals("HR")) {
//					HR mitarbeiter = new HR(String Benutzername,
//											String Passwort,
//											String Vorname, 
//											String Nachname, 
//											String StellenBezeichnung,
//											String Telefonnummer, 
//											int SollArbeitszeit, 
//											Datum GeburtsTag, 
//											Datum EinstellungsDatum,
//											Adresse Adresse);
//				}else if(Klasse.equals("Vorgesetzte")) {
//					Vorgesetzte mitarbeiter = new Vorgesetzte();
//				}else if(Klasse.equals("Angestellte")) {
//					Angestellte mitarbeiter = new Angestellte();
//				}
//				PersNr
//				Vorname
//				Nachname
//				Geburtstag
//				Straße
//				Hausnummer
//				HausnummernZusatz
//				Ort
//				PLZ
//				Land
//				TelNr
//				E-Mail
//				Bezeichnung
//				eingestellt_am
//				Gruppe
//			}
//		}
//		
//	}
	
	
	public static boolean loadLocalDataToDB() {
		Iterator<Integer> zuspeichernd = bearbeitet.keys().asIterator();
		while(zuspeichernd.hasNext()) {
			int Personalnummer = zuspeichernd.next();
			Angestellte mitarbeiter = getEmployeeByID(Personalnummer);
			
			if(bearbeitet.get(Personalnummer).equals("angelegt")) {
				db_connect.anlegen_Benutzer(mitarbeiter.getPersonalNummer(),
						mitarbeiter.getVorname(), mitarbeiter.getNachname(),
						mitarbeiter.getGeburtsTag().toString(),
						mitarbeiter.getAdresse().getStraße(),
						mitarbeiter.getAdresse().getHausnummer(),
						mitarbeiter.getAdresse().getHausnummernZusatz(),
						mitarbeiter.getAdresse().getStadt(),
						mitarbeiter.getAdresse().getPostleitzahl(),
						mitarbeiter.getAdresse().getLand(),
						mitarbeiter.getTelefonNummer(),
						mitarbeiter.getEmailAdresse(),
						mitarbeiter.getStellenBezeichnung(),
						mitarbeiter.getEinstellungsDatum().toString(),
						mitarbeiter.getGruppenBezeichnung());
				
			}else if(bearbeitet.get(Personalnummer).equals("geändert")) {
				db_connect.wert_update("t_mitarbeiter", "Stellenbezeichung", mitarbeiter.getStellenBezeichnung(), Personalnummer);
				db_connect.wert_update("t_mitarbeiter", "E-Mail", mitarbeiter.getEmailAdresse(), Personalnummer);
				db_connect.wert_update("t_mitarbeiter", "eingestellt am", mitarbeiter.getEinstellungsDatum().toString(), Personalnummer);
				db_connect.wert_update("t_mitarbeiter", "Geburtstag", mitarbeiter.getGeburtsTag().toString(), Personalnummer);
				db_connect.wert_update("t_mitarbeiter", "Gruppe", mitarbeiter.getClass().getSimpleName(), Personalnummer);
				db_connect.wert_update("t_mitarbeiter", "Hausnummer", String.valueOf(mitarbeiter.getAdresse().getHausnummer()), Personalnummer);
				db_connect.wert_update("t_mitarbeiter", "Hausnummernzusatz", mitarbeiter.getAdresse().getHausnummernZusatz(), Personalnummer);
				db_connect.wert_update("t_mitarbeiter", "Land", mitarbeiter.getAdresse().getLand(), Personalnummer);
				db_connect.wert_update("t_mitarbeiter", "Nachname", mitarbeiter.getNachname(), Personalnummer);
				db_connect.wert_update("t_mitarbeiter", "Ort", mitarbeiter.getAdresse().getStadt(), Personalnummer);
				db_connect.wert_update("t_mitarbeiter", "TelNr", mitarbeiter.getTelefonNummer(), Personalnummer);
				db_connect.wert_update("t_mitarbeiter", "Vorname", mitarbeiter.getVorname(), Personalnummer);
				
			}else if(bearbeitet.get(Personalnummer).equals("gelöscht")) {
				db_connect.löschen_Benutzer(Personalnummer);
			}
		}
		return false;
	}
	
	
}
