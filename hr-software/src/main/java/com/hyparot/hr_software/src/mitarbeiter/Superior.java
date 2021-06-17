package com.hyparot.hr_software.src.mitarbeiter;

import com.hyparot.hr_software.src.sst.superior;

public class Superior extends Employee implements superior{

	public Superior(String Benutzername, String Passwort, String Vorname, String Nachname, 
			           String StellenBezeichnung, String Telefonnummer, int SollArbeitszeit, int Personalnummer, 
			           Date GeburtsTag, Date EinstellungsDatum,
			           Adress Adresse) {
		
		super(Benutzername, Passwort, Vorname, Nachname, StellenBezeichnung,
				Telefonnummer, SollArbeitszeit, Personalnummer,
				GeburtsTag, EinstellungsDatum,
				Adresse);
	}

	@Override
	public boolean acceptVacation(String doYouAccept) {
		// TODO Auto-generated method stub
		if(doYouAccept.equals("Ja")) {
			return true;
		}
		return false;
	}
}
