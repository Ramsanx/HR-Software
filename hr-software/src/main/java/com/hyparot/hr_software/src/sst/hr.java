package com.hyparot.hr_software.src.sst;

import com.hyparot.hr_software.src.employee.Employee;
import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Date;

/*
 * dient der Auflistung der nur an/mit Objekten der Klasse HR ausführbaren Metoden
 */
public interface hr {

	public void getPayroll(int persNr);
	
	public void setNewEmployee(String group, String username, String password, String firstname, String lastname, 
							   String jobTitle, String phoneNumber, int workingTime_contract, int workingTime_left, 
							   int vacation_left, Date birthday, Date startDate,
							   Adress adress);
	
	public boolean deleteEmployee(int persNr);
	
	public Employee getPersonalData(int persNr);
}
