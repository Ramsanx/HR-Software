package sst;

import backend.*;
import java.util.Calendar;

public interface angestellte {

	public boolean loginUser(String Nutzername, String Passwort);
	
	public void editEmployee(String vorname, 
			 				 String nachname, 
			 				 String emailAdresse,
			 				 int telefunNummer,
			 				 Calendar geburtsTag, 
			 				 String land, 
			 				 String stadt, 
			 				 int postleitzahl, 
			 				 String straﬂe, 
			 				 int hausnummer, 
			 				 String hausnummernZusatz);
	
	public Calendar applyForVacation();
	
	public void cancelVacation();
	
	public void getVacationOverview();
	
	public void setSick(int dauer);
	
	public void setWorkTime();
	
	public void setPersonalDate();
	
	public Vertrag getContract();
	
	public void getPhoneBook();
	
	public void getPayrol();
	
	public void sendMailinfo();
	
	
}
