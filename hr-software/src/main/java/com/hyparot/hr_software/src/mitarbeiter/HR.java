package mitarbeiter;

import java.util.Calendar;
import backend.*;
import sst.hr;



public class HR extends Angestellte implements hr {

	public HR(String Benutzername, String Passwort, String Vorname, String Nachname, String GruppenBezeichnung, String StellenBezeichnung,
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
	public void getPayroll(int Personalnummer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNewEmployee(String Benutzername, String Passwort, String Vorname, String Nachname, String GruppenBezeichnung, String StellenBezeichnung,
			int Telefonnummer, int SollArbeitszeit, 
			Calendar GeburtsTag, Calendar EinstellungsDatum,
			Adresse Adresse,
			Vertrag Vertrag) {
		// TODO Auto-generated method stub
		BusinessIntellegent.createMitarbeiter(Benutzername, Passwort, Vorname, Nachname, GruppenBezeichnung, StellenBezeichnung,
				Telefonnummer, SollArbeitszeit, 
				GeburtsTag, EinstellungsDatum,
				Adresse,
				Vertrag);
		
	}

	@Override
	public void deleteEmployee(int Personalnummer) {
		// TODO Auto-generated method stub
		//Angestellte.remove(BusinessIntellegent.getAngestellteByID(Personalnummer));
	}

	@Override
	public mitarbeiter.Angestellte getPersonalData(int Personalnummer) {
		// TODO Auto-generated method stub
		return BusinessIntellegent.getAngestellteByID(Personalnummer);
	}
}
