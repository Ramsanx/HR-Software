package com.hyparot.hr_software.src.backend;

import java.util.Iterator;
import java.util.Vector;
import com.hyparot.hr_software.src.employee.Employee;
import com.hyparot.hr_software.src.employeedata.Absence;
import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Contract;
import com.hyparot.hr_software.src.employeedata.Date;
import com.hyparot.hr_software.src.sst.employee;
import com.hyparot.hr_software.src.sst.hr;
import com.hyparot.hr_software.src.sst.superior;

/**
 * diese Klasse dient der Anbindung der Klassen Employee, HR, Superior... an die Klasse BusinessInteligence
 */
public class BIConnect implements employee, hr, superior{

	private int operatingUserID;
	
	
	/**
	 * dient der Erstellung eines Objektes, dieser Klasse, für die Nutzung von, von Angestelleten unabhängigen, Funktionen 
	 */
	public BIConnect() {
	}
	
	/**
	 * dient der Erstellung eines Objektes, dieser Klasse, für die Nutzung von, von Angestelleten abhängigen, Funktionen 
	 * 
	 * @param persNr the persNr of the employee who or on whom the method is to be applied later on
	 */
	public BIConnect(int persNr) {
		this.operatingUserID = persNr;
	}
	
	/**
	 * dient dem Einloogen eines Nutzers
	 * 
	 * @param username the username of the user which wants to log in
	 * @param password the password of the user which wants to log in
	 * @return true if there is an employee with this username and the password is correct, else false
	 */
	public boolean loginUser(String username, String password) {
		
		Employee user = BusinessIntelligence.getEmployeeByName(username);
		if(user != null) {
			if(password.equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * dient der Suche nach einem Angestellten über seinen username
	 * 
	 * @param username the username of the employee which which is to be returned
	 * @return the employee with the username 'username', if no employee exists with these username the return value is null
	 */
	public Employee getEmployeeByName(String username) {
		return BusinessIntelligence.getEmployeeByName(username);
	}
	
	/**
	 * dient der Suche nach einem Angestellten über seine persNr
	 * 
	 * @param persNr the persNr of the employee which is to be returned
	 * @return the employee with the personnel number 'persNr', if no employee exists with these personnel number the return value is null
	 */
	public Employee getEmployeeByID(int persNr) {
		return BusinessIntelligence.getEmployeeByID(persNr);
	}
	
	
	/**
	 * dient der Überprüfung ob automatisch erzeugter Username existiert (Für createUserController)
	 * 
	 * @param username the username which is to be checked
	 * @return a username that did not exist beforet 
	 */
	public static String checkUsername(String username) {
		return BusinessIntelligence.checkUsername(username);
	}
	
	/**
	 * dient der Korrektur der Variablen vacation_left bei der Beantragung oder Stornierung von Urlauben
	 * 
	 * @param persNr the persNr of the employee which applied or canceled a vacation
	 */
	public void correctVacation_left(int persNr) {
		BusinessIntelligence.correctVacation_left(persNr);
	}
	
	//Overrides superior
	//_____________________________________________________________________________________________________________________________________
	@Override
	public boolean acceptVacation(Absence vacation) {
		return BusinessIntelligence.acceptVacation(vacation);
	}
	//_____________________________________________________________________________________________________________________________________

	
	//Overrides hr
	//_____________________________________________________________________________________________________________________________________
	@Override
	public void getPayroll(int persNr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNewEmployee(String group, String username, String password, String firstname, String lastname,
			String jobTitle, String phoneNumber, int workingTime_contract, int workingTime_left, int vacation_left, Date birthday, Date startDate,
			Adress adress){
		
		BusinessIntelligence.createEmployee(group, username, password, firstname, lastname,
										   jobTitle, phoneNumber, workingTime_contract, workingTime_left, vacation_left, birthday, startDate,
										   adress);
	}

	@Override
	public boolean deleteEmployee(int persNr) {
		return BusinessIntelligence.deleteEmloyee(persNr);
	}

	@Override
	public Employee getPersonalData(int persNr) {
		return BusinessIntelligence.getEmployeeByID(persNr);
	}
	//_____________________________________________________________________________________________________________________________________


	//Overrides employee
	//_____________________________________________________________________________________________________________________________________
	@Override
	public boolean applyForVacation(Date firstDayOfVac, Date lastDayOfVac) {
		if(BusinessIntelligence.newAbsence(operatingUserID, firstDayOfVac, lastDayOfVac, false)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean cancelVacation(Integer vacation) {
		
		return BusinessIntelligence.cancelVacation(vacation);
	}

	@Override
	public Vector<Absence> getVacationOverview() {
		Employee user = this.getEmployeeByID(operatingUserID);
		Vector<Absence> absence = BusinessIntelligence.getVacationOverview(user);
		
		return absence;
	}

	//Ram
	public Vector<Absence> getVacationRequests() {
		Vector<Absence> absence = BusinessIntelligence.getVacationRequests();
			
		return absence;
	}


	@Override
	public void setSick(int duration) {
		
		BusinessIntelligence.newAbsence(operatingUserID, Date.getToday(), Date.getFutureDate(duration), true);

	}

	@Override
	public void setWorkTime(int worktime) {
		// TODO Auto-generated method stub
		BusinessIntelligence.setWorkTime(this.operatingUserID, worktime);
	}


	//könnte gelöscht werden, da die Vertragsdaten anderweitig eingesehen werden können
	@Override
	public Contract getContract() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getPhoneBook() {
		
		Iterator<Employee> it = BusinessIntelligence.getPhonebook().listIterator();
		
		//TODO
		//Anstatt in der commandline zu printen muss es im Phonebook passieren
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	//TODO
	//Variable salary benötigt
	@Override
	public void getPayroll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMailinfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPersonaldata(String firstname, String lastname, String eMail, String phoneNumber, Date birthday,
								String country, String city, int postcode, String street, int houseNr, String housenumberSupplement) {
		
		BusinessIntelligence.editEmployee(operatingUserID, firstname, lastname, eMail, phoneNumber, birthday,
			     country, city, postcode, street, houseNr, housenumberSupplement);
	}
	//_____________________________________________________________________________________________________________________________________
	
	

}
