package com.hyparot.hr_software.src.employee;

import com.hyparot.hr_software.src.backend.BIConnect;
import com.hyparot.hr_software.src.employeedata.Absence;
import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Date;
import com.hyparot.hr_software.src.sst.superior;

/**
 * bei Objekten dieser Klasse handlet es sich um Vorgesetzte im Unternehmen 
 * 
 * diese Klasse ist eine Tochterklasse der Klasse Employee
 */
public class Superior extends Employee implements superior{

	/**
	 * dient der Erstellung eines Objektes dieser Klasse
	 * 
	 * @param username the username of the superior
	 * @param password the password of the superior
	 * @param firstname the firstname of the superior
	 * @param lastname the lastname of the superior
	 * @param jobTitle the jobTitle of the superior
	 * @param phoneNumber the phoneNumber of the superior
	 * @param workingTime_contract the workingTime which is written in the contract
	 * @param workingTime_left the workingTime which the superior has left
	 * @param vacation_left the vacation days the superior has left this year
	 * @param persNr the persNr (personnel number) of the superior
	 * @param birthday the birthday of the superior
	 * @param startDate the day the superior was hired
	 * @param adress the adress where the superior lives
	 */
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
