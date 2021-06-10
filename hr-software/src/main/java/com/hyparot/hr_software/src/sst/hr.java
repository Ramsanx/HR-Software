package sst;

import java.util.Calendar;

import backend.Adresse;
import backend.Vertrag;
import mitarbeiter.Angestellte;

public interface hr {

	public void getPayroll(int Personalnummer);
	
	public void setNewEmployee(String Benutzername, String Passwort, String Vorname, String Nachname, String GruppenBezeichnung, String StellenBezeichnung,
							   int Telefonnummer, int SollArbeitszeit, 
							   Calendar GeburtsTag, Calendar EinstellungsDatum,
							   Adresse Adresse,
							   Vertrag Vertrag);
	
	public void deleteEmployee(int Personalnummer);
	
	public Angestellte getPersonalData(int Personalnummer);
}
