package com.hyparot.hr_software.src.sst;

import java.util.Calendar;

import com.hyparot.hr_software.src.backend.Adresse;
import com.hyparot.hr_software.src.backend.Vertrag;
import com.hyparot.hr_software.src.mitarbeiter.Angestellte;

public interface hr {

	public void getPayroll(int Personalnummer);
	
	public void setNewEmployee(String Stellung, String Benutzername, String Passwort, String Vorname, String Nachname, 
							   String GruppenBezeichnung, String StellenBezeichnung, String Telefonnummer, int SollArbeitszeit, 
							   Calendar GeburtsTag, Calendar EinstellungsDatum,
							   Adresse Adresse);
	
	public boolean deleteEmployee(int Personalnummer);
	
	public Angestellte getPersonalData(int Personalnummer);
}
