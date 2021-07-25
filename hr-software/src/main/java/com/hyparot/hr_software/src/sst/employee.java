package com.hyparot.hr_software.src.sst;

import java.util.Vector;
import com.hyparot.hr_software.src.employeedata.Absence;
import com.hyparot.hr_software.src.employeedata.Contract;
import com.hyparot.hr_software.src.employeedata.Date;


/**
 * dient der Auflistung der an/mit Objekten der Klasse Employee ausführbaren Metoden
 */
public interface employee {

	/**
	 * dient dem einloggen ins Programm 
	 * 
	 * @param username
	 * @param password
	 * @return true username exists and the password is correct, else false
	 */
	public static boolean loginUser(String username, String password) {
		return false;
	};
	
	/**
	 * dient der Manipulation der persönlichen Daten
	 * 
	 * @param firstname the firstname to set
	 * @param lastname the lastname to set
	 * @param eMail the eMail to set
	 * @param phoneNumber the phoneNumber to set
	 * @param birthday the birthday to set
	 * @param country the country to set
	 * @param city the city to set
	 * @param postcode the postcode to set
	 * @param street the street to set
	 * @param houseNr the houseNr to set
	 * @param housenumberSupplement the housenumberSupplement to set
	 */
	public void setPersonaldata(String firstname, String lastname, String eMail, String phoneNumber, Date birthday,
								String country, String city, int postcode, String street, int houseNr, String housenumberSupplement);
	
	/**
	 * dient dem Beantragen eines Urlaubs
	 * 
	 * @param firstDayOfVac the first day of vacation (begin date of the vacation)
	 * @param lastDayOfVac the last day of vacation (end date of the vacation
	 * @return true if it was possible to apply, else false
	 */
	public boolean applyForVacation(Date firstDayOfVac, Date lastDayOfVac);
	
	/**
	 * dient dem löschen eines Urlaubsantrags
	 * 
	 * @param vacation the vacation which is to cancel
	 * @return true if there was such a vacation an it was able to cancel it, else false
	 */
	public boolean cancelVacation(Integer vacation);
	
	/**
	 * dient dem Erhalt einer Übersicht über alle seine Urlaubsanträge
	 * 
	 * @return Vector<Absence> with all Absence objects with the persNr of the employee
	 */
	public Vector<Absence> getVacationOverview();
	
	/**
	 * dient dem Krankmelden
	 * 
	 * @param duration the number of days the employee will be sick
	 */
	public void setSick(int duration);
	
	/**
	 * dient dem Schreiben der Arbeitszeiten
	 */
	public void setWorkTime(int worktime);
	
	/**
	 * dient dem Erhalt des Vertrgas 
	 * 
	 * @return the contract of the employee
	 */
	public Contract getContract();
	
	/**
	 * dient dem Erhalt einer Übersicht aller Angestellten, ihrer Kontaktdaten und Stellenbezeichung
	 */
	public void getPhoneBook();
	
	/**
	 * dient dem Erhalt seiner Gehaltsabrechnung
	 */
	public void getPayroll();
	
	/**
	 * dient dem Versenden von Mails
	 */
	public void sendMailinfo();
	
	
}