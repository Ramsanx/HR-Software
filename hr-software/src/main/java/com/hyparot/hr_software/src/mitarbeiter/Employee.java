package com.hyparot.hr_software.src.mitarbeiter;

import com.hyparot.hr_software.src.backend.*;
import com.hyparot.hr_software.src.sst.employee;


public class Employee extends Person implements employee{
	

	
	private String username; // in der Datenbank tabelle "Zugänge" Feld "Nutzername" typ String
	private String password; // in der Datenbank tabelle "Zugänge" Feld "Passwort" typ String
	

	public static void main(String[] args) {
		Date test = new Date("2021-01-02");
		Date test2 = new Date("2021-01-22");
//		System.out.println(test.getVacDays(test2));
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
	public boolean loginUser(String username, String password) {
		// TODO Auto-generated method stub
		Employee user = BusinessIntellegent.getEmployeeByName(username);
		if(user != null) {
			if(password.equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}


	@Override
	public void editEmployee(String firstname, 
							 String lastname, 
							 String eMail,
							 String phoneNumber,
							 Date birthday, 
							 String land, 
							 String city, 
							 int postcode, 
							 String street, 
							 int houseNr, 
							 String housenumberSupplement) {
		// TODO Auto-generated method stub
		
		BusinessIntellegent.editEmployee(this.getPersNr(), firstname, lastname, eMail, phoneNumber, birthday, 
										 land, city, postcode, street, houseNr, housenumberSupplement);
		
	}


	@Override
	public Date applyForVacation() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void cancelVacation() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void getVacationOverview() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setSick(int dauer) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setWorkTime() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setPersonalDate() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public com.hyparot.hr_software.src.mitarbeiter.Contract getContract() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void getPhoneBook() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void getPayrol() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sendMailinfo() {
		// TODO Auto-generated method stub
		
	}

	
	public String toString() {
		return ("Vorname: " + this.getFirstname() +
				"\nNachname: " + this.getLastname() +
				"\nE-Mail Adresse: " + this.getEMail() +
				"\nTelefonnummer: " + this.getPhoneNumber() +
				"\nStellenbeschreibung: " + this.getJobTitle());
	}



}
