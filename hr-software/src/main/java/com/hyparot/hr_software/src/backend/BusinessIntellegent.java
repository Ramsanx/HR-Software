package backend;

import mitarbeiter.*;
import java.util.*;

public class BusinessIntellegent {

	private static Vector<Angestellte> mitarbeiterListe = new Vector<Angestellte>();
	private static int[] bearbeitet;
	
	
	public static Vector<Angestellte> getAngestellte() {
		return mitarbeiterListe;
	}
	
	
	static public Angestellte getAngestellteByName(String Nutzername) {;
		Iterator<Angestellte> mitarbeiter = mitarbeiterListe.iterator();
		
		while(mitarbeiter.hasNext()) {
			Angestellte nutzer = mitarbeiter.next();
			if(nutzer.getBenutzername().equals(Nutzername)) {
				return nutzer;
			}
		}
		return null;
	}
	
	static public Angestellte getAngestellteByID(int Personalnummer) {
		Iterator<Angestellte> mitarbeiter = mitarbeiterListe.iterator();
		
		while(mitarbeiter.hasNext()) {
			Angestellte nutzer = mitarbeiter.next();
			if(nutzer.getPersonalNummer() == Personalnummer) {
				return nutzer;
			}
		}
		return null;
	}
	
	
	
	//muss bearebitet werden 
	//input erfolgt über javaFX textfelder
	public static void createMitarbeiter(String Benutzername, String Passwort, String Vorname, String Nachname, String GruppenBezeichnung, String StellenBezeichnung,
			int Telefonnummer, int SollArbeitszeit, 
			Calendar GeburtsTag, Calendar EinstellungsDatum,
			Adresse Adresse,
			Vertrag Vertrag) {
		
		new Angestellte(Benutzername, Passwort, Vorname, Nachname, GruppenBezeichnung, StellenBezeichnung,
						Telefonnummer, SollArbeitszeit, 
						GeburtsTag, EinstellungsDatum,
						Adresse,
						Vertrag);
		
	}
}
