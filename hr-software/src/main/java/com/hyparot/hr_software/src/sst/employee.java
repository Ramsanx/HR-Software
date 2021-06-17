package com.hyparot.hr_software.src.sst;

import com.hyparot.hr_software.src.mitarbeiter.Date;
import com.hyparot.hr_software.src.mitarbeiter.Contract;


public interface employee {

	public boolean loginUser(String username, String password);
	
	public void editEmployee(String firstname, 
			 				 String lastname, 
			 				 String eMail,
			 				 String phoneNumber,
			 				 Date birthday, 
			 				 String country, 
			 				 String city, 
			 				 int postcode, 
			 				 String street, 
			 				 int houseNr, 
			 				 String housenumberSupplement);
	
	public Date applyForVacation();
	
	public void cancelVacation();
	
	public void getVacationOverview();
	
	public void setSick(int dauer);
	
	public void setWorkTime();
	
	public void setPersonalDate();
	
	public Contract getContract();
	
	public void getPhoneBook();
	
	public void getPayrol();
	
	public void sendMailinfo();
	
	
}
