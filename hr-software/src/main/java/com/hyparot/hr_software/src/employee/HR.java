package com.hyparot.hr_software.src.employee;

import com.hyparot.hr_software.src.backend.*;
import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Date;
import com.hyparot.hr_software.src.sst.hr;

/**
 * bei Objekten dieser Klasse handelt es sich um Angestellte im Personalwesen des Unternhemens
 * 
 * diese Klasse ist eine Tochterklasse der Klasse Employee
 */
public class HR extends Employee implements hr {

	
	/**
	 * dient der Erstellung eines Objektes dieser Klasse
	 * 
	 * @param username the username of the hr
	 * @param password the password of the hr
	 * @param firstname the firstname of the hr
	 * @param lastname the lastname of the hr
	 * @param jobTitle the jobTitle of the hr
	 * @param phoneNumber the phoneNumber of the hr
	 * @param workingTime_contract the workingTime which is written in the contract
	 * @param workingTime_left the workingTime which the employee has left
	 * @param vacation_left the vacation days the employee has left this year
	 * @param persNr the persNr (personnel number) of the employee
	 * @param birthday the birthday of the hr
	 * @param startDate the day the hr was hired
	 * @param adress the adress where the hr lives
	 */
	public HR(String username, String password, String firstname, String lastname, String jobTitle,
			  String phoneNumber, int workingTime_contract, int workingTime_left, int vacation_left, int persNr, 
			  Date birthday, Date startDate,
			  Adress adress) {
		
		super(username, password, firstname, lastname, jobTitle,
				phoneNumber, workingTime_contract, workingTime_left, vacation_left, persNr,
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
							   String jobTitle, String phoneNumber, int workingTime_contract, int workingTime_left,
							   int vacation_left, Date birthday, Date startDate,
							   Adress adress) {
		
		BIConnect bic = new BIConnect();
		bic.setNewEmployee(group, username, password, firstname, lastname,
					       jobTitle, phoneNumber, workingTime_contract, workingTime_left,
					       vacation_left, birthday, startDate,
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
