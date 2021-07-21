package com.hyparot.hr_software.src.employee;

import com.hyparot.hr_software.src.backend.BIConnect;
import com.hyparot.hr_software.src.employeedata.Absence;
import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Date;
import com.hyparot.hr_software.src.sst.superior;

public class Superior extends Employee implements superior{

	public Superior(String username, String password, String firstname, String lastname, 
			           String jobTitle, String phonenumber, int workingTime_contract, int workingTime_left, int vacation_left, int persNr, 
			           Date birthday, Date startDate,
			           Adress adress) {
		
		super(username, password, firstname, lastname, jobTitle,
				phonenumber, workingTime_contract, workingTime_left, vacation_left, persNr,
				birthday, startDate,
				adress);
	}

	@Override
	public boolean acceptVacation(Absence vacation) {
		
		BIConnect bic = new BIConnect();
		return bic.acceptVacation(vacation);
	}
}
