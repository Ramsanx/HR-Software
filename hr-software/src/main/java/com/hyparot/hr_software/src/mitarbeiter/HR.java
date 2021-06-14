package com.hyparot.hr_software.src.mitarbeiter;

import com.hyparot.hr_software.src.backend.*;
import com.hyparot.hr_software.src.sst.hr;


public class HR extends Angestellte implements hr {

	public HR(String Benutzername, String Passwort, String Vorname, String Nachname, String StellenBezeichnung,
			  String Telefonnummer, int SollArbeitszeit, 
			  Datum GeburtsTag, Datum EinstellungsDatum,
			  Adresse Adresse) {
		
		super(Benutzername, Passwort, Vorname, Nachname, StellenBezeichnung,
				Telefonnummer, SollArbeitszeit, 
				GeburtsTag, EinstellungsDatum,
				Adresse);
	}

	@Override
	public void getPayroll(int Personalnummer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNewEmployee(String Stellung, String Benutzername, String Passwort, String Vorname, String Nachname, 
							   String GruppenBezeichnung, String StellenBezeichnung, String Telefonnummer, int SollArbeitszeit, 
							   Datum GeburtsTag, Datum EinstellungsDatum,
							   Adresse Adresse) {
		// TODO Auto-generated method stub
		BusinessIntellegent.createEmployee(Stellung, Benutzername, Passwort, Vorname, Nachname, GruppenBezeichnung, StellenBezeichnung,
				Telefonnummer, SollArbeitszeit, 
				GeburtsTag, EinstellungsDatum,
				Adresse);
		
	}

	@Override
	public boolean deleteEmployee(int Personalnummer) {
		// TODO Auto-generated method stub
		return BusinessIntellegent.deleteEmloyee(Personalnummer);
	}

	@Override
	public com.hyparot.hr_software.src.mitarbeiter.Angestellte getPersonalData(int Personalnummer) {
		// TODO Auto-generated method stub
		return BusinessIntellegent.getEmployeeByID(Personalnummer);
	}
}
