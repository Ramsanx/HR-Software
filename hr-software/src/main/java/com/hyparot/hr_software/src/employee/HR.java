package com.hyparot.hr_software.src.employee;

import com.hyparot.hr_software.src.backend.*;
import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Date;
import com.hyparot.hr_software.src.sst.hr;


public class HR extends Employee implements hr {

	public HR(String username, String password, String firstname, String lastname, String jobTitle,
			  String phoneNumber, int workingTime_contract, int persNr, 
			  Date birthday, Date startDate,
			  Adress adress) {
		
		super(username, password, firstname, lastname, jobTitle,
				phoneNumber, workingTime_contract, persNr,
				birthday, startDate,
				adress);
	}

	@Override
	public void getPayroll(int persNr) {
		BIConnect bic = new BIConnect();
		bic.getPayroll(persNr);
	}

	@Override
	public void setNewEmployee(String group, String username, String password, String firstname, String lastname, 
							   String jobTitle, String phoneNumber, int workingTime_contract, 
							   Date birthday, Date startDate,
							   Adress adress) {
		
		BIConnect bic = new BIConnect();
		bic.setNewEmployee(group, username, password, firstname, lastname,
					       jobTitle, phoneNumber, workingTime_contract, 
						   birthday, startDate,
						   adress);	
	}

	@Override
	public boolean deleteEmployee(int persNr) {
		
		BIConnect bic = new BIConnect();
		return bic.deleteEmployee(persNr);
	}

	@Override
	public Employee getPersonalData(int persNr) {
		
		BIConnect bic = new BIConnect();
		return bic.getPersonalData(persNr);
	}
}
