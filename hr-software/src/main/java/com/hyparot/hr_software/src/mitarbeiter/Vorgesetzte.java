package com.hyparot.hr_software.src.mitarbeiter;

import java.util.Calendar;
import com.hyparot.hr_software.src.backend.Vertrag;
import com.hyparot.hr_software.src.backend.Adresse;
import com.hyparot.hr_software.src.sst.vorgesetzte;

public class Vorgesetzte extends Angestellte implements vorgesetzte{

	public Vorgesetzte(String Benutzername, String Passwort, String Vorname, String Nachname, String GruppenBezeichnung, 
			           String StellenBezeichnung, String Telefonnummer, int SollArbeitszeit, 
			           Calendar GeburtsTag, Calendar EinstellungsDatum,
			           Adresse Adresse) {
		
		super(Benutzername, Passwort, Vorname, Nachname, GruppenBezeichnung, StellenBezeichnung,
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