package com.hyparot.hr_software.src.sst;

import com.hyparot.hr_software.src.backend.Datum;
import com.hyparot.hr_software.src.backend.Adresse;
import com.hyparot.hr_software.src.mitarbeiter.Angestellte;

public interface hr {

	public void getPayroll(int Personalnummer);
	
	public void setNewEmployee(String Stellung, String Benutzername, String Passwort, String Vorname, String Nachname, 
							   String StellenBezeichnung, String Telefonnummer, int SollArbeitszeit, 
							   Datum GeburtsTag, Datum EinstellungsDatum,
							   Adresse Adresse);
	
	public boolean deleteEmployee(int Personalnummer);
	
	public Angestellte getPersonalData(int Personalnummer);
}
