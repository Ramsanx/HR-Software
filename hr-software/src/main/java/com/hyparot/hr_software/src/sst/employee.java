package com.hyparot.hr_software.src.sst;

import com.hyparot.hr_software.src.employeedata.Absence;
import com.hyparot.hr_software.src.employeedata.Contract;
import com.hyparot.hr_software.src.employeedata.Date;


public interface employee {

	public static boolean loginUser(String username, String password) {
		return false;
	};
	
	public void setPersonaldata(String firstname, String lastname, String eMail, String phoneNumber, Date birthday,
								String country, String city, int postcode, String street, int houseNr, String housenumberSupplement);
	
	public boolean applyForVacation(Date firstDayOfVac, Date lastDayOfVac);
	
	public boolean cancelVacation(Absence vacation);
	
	public void getVacationOverview();
	
	public void setSick(int duration);
	
	public void setWorkTime();
	
	public Contract getContract();
	
	public void getPhoneBook();
	
	public void getPayroll();
	
	public void sendMailinfo();
	
	
}