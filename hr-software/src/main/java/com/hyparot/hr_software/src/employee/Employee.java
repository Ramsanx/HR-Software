package com.hyparot.hr_software.src.employee;

import java.util.Hashtable;

import com.hyparot.hr_software.src.backend.*;
import com.hyparot.hr_software.src.employeedata.Absence;
import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Contract;
import com.hyparot.hr_software.src.employeedata.Date;
import com.hyparot.hr_software.src.sst.employee;


public class Employee extends Person implements employee{
	

	
	private String username; // in der Datenbank tabelle "Zugänge" Feld "Nutzername" typ String
	private String password; // in der Datenbank tabelle "Zugänge" Feld "Passwort" typ String
	

	public static void main(String[] args) {
		
		
	}
	
	
	public Employee(String username, String password, String firstname, String lastname, String jobTitle,
			   String phoneNumber, int persNr, int workingTime_contract,  
			   Date birthday, Date startDate,
			   Adress adress) {
		
		super(firstname, lastname, jobTitle, phoneNumber, persNr, workingTime_contract,  
			  birthday, startDate,
			  adress);
		this.setUsername(username);
		this.setPassword(password);
	}


	//getter und setter Block beginn
	//__________________________________________________________________________________________________________________________________
	public String getUsername() {
		return this.username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return this.password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	//getter und setter Block ende
	//_________________________________________________________________________________________________________________________________


	

	@Override
	public boolean applyForVacation(Date firstDayOfVac, Date lastDayOfVac) {
		// TODO Auto-generated method stub
		
		BIConnect bic = new BIConnect(this.getPersNr());
		return bic.applyForVacation(firstDayOfVac, lastDayOfVac);
		
	}


	@Override
	public boolean cancelVacation(Absence vacation) {
		// TODO Auto-generated method stub
		
		BIConnect bic = new BIConnect();
		bic.cancelVacation(vacation);
		
		return false;
	}


	@Override
	public Hashtable<Absence, String> getVacationOverview() {
		
		BIConnect bic = new BIConnect(this.getPersNr());
		return bic.getVacationOverview();
	}


	@Override
	public void setSick(int duration) {
		
		BIConnect bic = new BIConnect(this.getPersNr());
		bic.setSick(duration);
		
	}


	@Override
	public void setWorkTime() {
		
		BIConnect bic = new BIConnect(this.getPersNr());
		bic.setWorkTime();
		
	}


	@Override
	public void setPersonaldata(String firstname, String lastname, String eMail, String phoneNumber, Date birthday,
							    String country, String city, int postcode, String street, int houseNr, String housenumberSupplement) {
		
		BIConnect bic = new BIConnect(this.getPersNr());
		bic.setPersonaldata(firstname, lastname, eMail, phoneNumber, birthday, 
					        country, city, postcode, street, houseNr, housenumberSupplement);
	}


	//Könnte prinzipiell gelöscht werden, da die Funktion in der Software alternativ umgesetzt ist
	@Override
	public Contract getContract() {
		
		BIConnect bic = new BIConnect(this.getPersNr());
		return bic.getContract();
	}


	@Override
	public void getPhoneBook() {
		
		BIConnect bic = new BIConnect();
		bic.getPhoneBook();
		
	}


	@Override
	public void getPayroll() {
		// TODO Auto-generated method stub
		
		BIConnect bic = new BIConnect(this.getPersNr());
		bic.getPayroll();;
		
	}


	@Override
	public void sendMailinfo() {
		// TODO Auto-generated method stub
		
		BIConnect bic = new BIConnect(this.getPersNr());
		bic.sendMailinfo();
		
	}

	
	public String toString() {
		return ("Vorname: " + this.getFirstname() +
				"\nNachname: " + this.getLastname() +
				"\nE-Mail-Adresse: " + this.getEMail() +
				"\nTelefonnummer: " + this.getPhoneNumber() +
				"\nStellenbeschreibung: " + this.getJobTitle());
	}


	
}