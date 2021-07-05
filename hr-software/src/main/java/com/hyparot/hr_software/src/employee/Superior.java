package com.hyparot.hr_software.src.employee;

import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Date;
import com.hyparot.hr_software.src.sst.superior;

public class Superior extends Employee implements superior{

	public Superior(String username, String password, String firstname, String lastname, 
			           String jobTitle, String phonenumber, int workingTime_contract, int persNr, 
			           Date birthday, Date startDate,
			           Adress adress) {
		
		super(username, password, firstname, lastname, jobTitle,
				phonenumber, workingTime_contract, persNr,
				birthday, startDate,
				adress);
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
