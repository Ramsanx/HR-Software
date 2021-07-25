package com.hyparot.hr_software.src.sst;

import com.hyparot.hr_software.src.employee.Employee;
import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Date;

/**
 * dient der Auflistung der nur an/mit Objekten der Klasse HR ausführbaren Metoden
 */
public interface hr {

	
	/**
	 * öffnet die Gehaltsbrechnung des Angestellten mit der Personalnummer 'persNr'
	 * 
	 * @param persNr the persNr of the employee whose payroll is to be retrieved
	 */
	public void getPayroll(int persNr);
	
	/**
	 * dient dem Erstellen eines neuen Angestellten
	 * 
	 * @param group the group of the new employee (Employee, HR or Superior)
	 * @param username the username of the new employee
	 * @param password the username of the new employee
	 * @param firstname the firstname of the new employee
	 * @param lastname the lastname of the new employee
	 * @param jobTitle the jobTitle of the new employee
	 * @param phoneNumber the phoneNumber of the new employee
	 * @param workingTime_contract the workingTime_contract of the new employee
	 * @param workingTime_left the workingTime_left of the new employee
	 * @param vacation_left the vacation_left of the new employee
	 * @param birthday the birthday of the new employee
	 * @param startDate the startDate of the new employee
	 * @param adress the adress of the new employee
	 */
	public void setNewEmployee(String group, String username, String password, String firstname, String lastname, 
							   String jobTitle, String phoneNumber, int workingTime_contract, int workingTime_left, 
							   int vacation_left, Date birthday, Date startDate,
							   Adress adress);
	
	/**
	 * dient dem löschen eines Angestellten
	 * 
	 * @param persNr the persNr of the employee which is to be deleted
	 * @return true if there was such an employee and it was possible to delete him, else false
	 */
	public boolean deleteEmployee(int persNr);
	
	/**
	 * dient dem Erhalt der persönlichen Daten eines Angestellten
	 * 
	 * @param persNr the persNr of the employee whose data is to be retrieved
	 * @return the employee with the personnel number 'persNr'
	 */
	public Employee getPersonalData(int persNr);
}
