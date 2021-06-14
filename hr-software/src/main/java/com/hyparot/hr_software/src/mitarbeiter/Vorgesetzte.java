package com.hyparot.hr_software.src.mitarbeiter;

import com.hyparot.hr_software.src.backend.Datum;
import com.hyparot.hr_software.src.backend.Adresse;
import com.hyparot.hr_software.src.sst.vorgesetzte;

public class Vorgesetzte extends Angestellte implements vorgesetzte{

	public Vorgesetzte(String Benutzername, String Passwort, String Vorname, String Nachname, 
			           String StellenBezeichnung, String Telefonnummer, int SollArbeitszeit, 
			           Datum GeburtsTag, Datum EinstellungsDatum,
			           Adresse Adresse) {
		
		super(Benutzername, Passwort, Vorname, Nachname, StellenBezeichnung,
				Telefonnummer, SollArbeitszeit, 
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
