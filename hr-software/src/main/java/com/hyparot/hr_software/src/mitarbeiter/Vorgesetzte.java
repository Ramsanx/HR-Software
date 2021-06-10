package mitarbeiter;

import java.util.Calendar;
import backend.Vertrag;
import backend.Adresse;
import sst.vorgesetzte;

public class Vorgesetzte extends Angestellte implements vorgesetzte{

	public Vorgesetzte(String Benutzername, String Passwort, String Vorname, String Nachname, String GruppenBezeichnung, String StellenBezeichnung,
			int Telefonnummer, int SollArbeitszeit, 
			Calendar GeburtsTag, Calendar EinstellungsDatum,
			Adresse Adresse,
			Vertrag Vertrag) {
		
		super(Benutzername, Passwort, Vorname, Nachname, GruppenBezeichnung, StellenBezeichnung,
				Telefonnummer, SollArbeitszeit, 
				GeburtsTag, EinstellungsDatum,
				Adresse,
				Vertrag);
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
