package com.hyparot.hr_software.src.backend;

import com.hyparot.hr_software.src.employee.*;
import com.hyparot.hr_software.src.employeedata.Absence;
import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Date;
import java.util.*;

/**
 * diese Klasse beinhält die Logik der Funktionen des Programms (Business Logik)
 */
public class BusinessIntelligence {

	
	/**
	 * dient der Suche nach einem Angestellten über seinen username
	 * 
	 * @param username  the username of the employee which which is to be returned
	 * @return the employee with the username 'username', if no employee exists with these username the return value is null
	 */
	protected static Employee getEmployeeByName(String username) {
		Iterator<Employee> employee = LocalStorage.getStorage().iterator();
		
		while(employee.hasNext()) {
			Employee user = employee.next();
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	
	/**
	 * dient der Suche nach einem Angestellten über seine persNr
	 * 
	 * @param persNr the persNr of the employee which is to be returned
	 * @return the employee with the personnel number 'persNr', if no employee exists with these personnel number the return value is null
	 */
	protected static Employee getEmployeeByID(int persNr) {
		Iterator<Employee> employee = LocalStorage.getStorage().iterator();
		
		while(employee.hasNext()) {
			Employee user = employee.next();
			if(user.getPersNr() == persNr) {
				return user;
			}
		}
		return null;
	}
	
	
	/**
	 * dient der Findung einer noch nicht vergebenen persNr (höchste persNr + 1)
	 * 
	 * @return persNr (a unique persNr)
	 */
	private static int findHighestPersNr() {
		if(LocalStorage.getStorage().isEmpty()) {
			return 1000;
		}
		Iterator<Employee> employee = LocalStorage.getStorage().iterator();
		int persNr = employee.next().getPersNr(); 
		while(employee.hasNext()) {
			Employee user = employee.next();
			if(user.getPersNr() > persNr) {
				persNr = user.getPersNr();
			}
		}
		return persNr;
	}
	
	
	
	/**
	 * dient dem Erstellen eines neuen Angestellten
	 * 
	 * @param group the group of the new employee (Employee, HR or Superior)
	 * @param username the username of the new employee
	 * @param password the password of the new employee
	 * @param firstname the firstname of the new employee
	 * @param lastname the lastname of the new employee
	 * @param jobTitle the jobTitle of the new employee
	 * @param phoneNumber the phoneNumber of the new employee
	 * @param workingTime_contract the workingTime_contract of the new employee
	 * @param workingTime_left the workingTime_left of the new employee
	 * @param vacation_left the vacation_left of the new employee
	 * @param birthday the birthday of the new employee
	 * @param startDate the startDate of the new employee (the day he was hired)
	 * @param adress the adress of the new employee
	 */
	protected static void createEmployee(String group, String username, String password, String firstname, String lastname, 
									  String jobTitle, String phoneNumber, int workingTime_contract, int workingTime_left,
									  int vacation_left, Date birthday, Date startDate,
									  Adress adress) {
		
		Iterator<Employee> employee = LocalStorage.getStorage().iterator();
		while(employee.hasNext()) {
			if(employee.next().getUsername().equals(username)) {
				return;
			}
		}
		
			Employee user = null;
			if(group.equals("HR")) {
				user = new HR(username, password, firstname, lastname, 
							  jobTitle, phoneNumber, findHighestPersNr()+1, workingTime_contract, workingTime_left,
							  vacation_left, birthday, startDate,
							  adress);
			}else if(group.equals("Superior")) {
				user = new Superior(username, password, firstname, lastname, 
									jobTitle, phoneNumber, findHighestPersNr()+1, workingTime_contract, workingTime_left, 
									vacation_left, birthday, startDate,
									adress);
			}else if(group.equals("Employee")){
				user = new Employee(username, password, firstname, lastname, 
									jobTitle, phoneNumber, findHighestPersNr()+1, workingTime_contract, workingTime_left, 
									vacation_left, birthday, startDate,
									adress);
			}
			LocalStorage.addToEmployees(user);
			LocalStorage.addToChanges(user.getPersNr(), "created");
			saveData();
		}
		
		
	
	
	/**
	 * dient der Berabeitung der persönlichen Daten eines Angestellten
	 * 
	 * @param persNr the persNr of the employee whose personal data are to be changed
	 * @param firstname the firstname to set
	 * @param lastname the lastname to set
	 * @param eMail the eMail to set
	 * @param phoneNumber the phoneNumber to set
	 * @param birthday the birthday to set
	 * @param country the country to set
	 * @param city the city to set
	 * @param postcode the postcode to set
	 * @param street the street to set
	 * @param houseNr the houseNr  to set
	 * @param housenumberSupplement the housenumberSupplement to set
	 */
	protected static void editEmployee(int persNr, 
									String firstname, 
									String lastname, 
									String eMail,
									String phoneNumber,
									Date birthday, 
									String country, 
									String city, 
									int postcode, 
									String street, 
									int houseNr, 
									String housenumberSupplement) {
		
		Employee user = getEmployeeByID(persNr);
		if(user != null) {
			user.setFirstname(firstname);;
			user.setLastname(lastname);
			user.setEMail(eMail);
			user.setPhoneNumber(phoneNumber);
			user.setBirthday(birthday);
		
			user.getAdress().setCountry(country);
			user.getAdress().setCity(city);
			user.getAdress().setStreet(street);
			user.getAdress().setPostcode(postcode);
			user.getAdress().setHouseNr(houseNr);
			user.getAdress().setHousenumberSupplement(housenumberSupplement);
		
			LocalStorage.addToChanges(persNr, "changed");
			saveData();
		}
	}
	
	/**
	 * dient dem löschen eines Angestellten
	 * 
	 * @param persNr the persNr of the employee which is to be deleted
	 * @return true if there was such an employee and it was possible to delete him, else false
	 */
	protected static boolean deleteEmloyee(int persNr) {
		Employee employee = getEmployeeByID(persNr);
		if(employee == null) {
			return false;
		}else {
			LocalStorage.removeFromEmployees(employee);
			LocalStorage.addToChanges(persNr, "deleted");
			saveData();
			return true;
		}
	}
	
	/**
	 * dient dem laden von Änderungen in die Datenbank
	 */
	private static void saveData() {
		SystemDBConnector.loadLocalDataToDB();
	}
	
	
	/**
	 * dient der Korrektur der Variablen vacation_left bei der Beantragung oder Stornierung von Urlauben
	 * 
	 * @param persNr the persNr of the employee which applied or canceled a vacation
	 */
	protected static void correctVacation_left(int persNr) {
		LocalStorage.addToChanges(persNr, "workingTimeChange");
	}
	
	
	/**
	 * dient dem schreiben der Arbeitszeit
	 * 
	 * @param persNr the persNr of the employee whose working time is recorded
	 * @param worktime the recorded worktime
	 */
	protected static void setWorkTime(int persNr, int worktime) {
		Employee employ = getEmployeeByID(persNr);
		employ.setWorkingTime_left(employ.getWorkingTime_left() - worktime);
		LocalStorage.addToChanges(persNr, "workingTimeChange");
		saveData();
		
	}
	
	// Erik - auf public gesetzt
	/**
	 * dient dem laden das Abwesenheiten eines Nutzers aus der Datenbank
	 * 
	 * @param employ the employee whose absences are loaded
	 * @return Vector<Absence> with the absences of employ
	 */
	protected static Vector<Absence> getAbsenceOf(Employee employ){
		return SystemDBConnector.getAbsenceOf(employ);
	}
	
	/**
	 * dient dem Erhalt einer Liste (Vector) der Urlaube eines Ansgestellten
	 * 
	 * @param employ the employee whose vacation overview is to be loaded
	 * @return Vector<Absence> with the vacations of employ
	 */
	protected static Vector<Absence> getVacationOverview(Employee employ){
		Vector<Absence> vac = new Vector<Absence>();
		Iterator<Absence> it = getAbsenceOf(employ).iterator();
		while(it.hasNext()) {
			Absence abs = it.next();
			if(!abs.isSick()) {
				vac.add(abs);
			}
		}
		return vac;
	}
	
	//TODO
		//Ram
		/**
		 * @return
		 */
		protected static Vector<Absence> getAbsenceTable(){
			return SystemDBConnector.getAbsenceTable();
		}
		
		//TODO
		//Ram
		/**
		 * @return
		 */
		protected static Vector<Absence> getVacationRequests(){
			Vector<Absence> vac = new Vector<Absence>();
			Iterator<Absence> it = getAbsenceTable().iterator();
			
			while(it.hasNext()) {
				Absence abs = it.next();
				if(!abs.isSick()) {
					if(abs.isAccepted()) {
						Logging.writeActlog("AVC002", abs.getPersNr());
					}else {
						Logging.writeActlog("AVC003", abs.getPersNr());
					}
					vac.add(abs);
				}
			}
			return vac;
		}

	
	/**
	 * dient dem speichern einer Abwesenheit
	 * 
	 * @param abs the absence which is to be saved
	 */
	protected static void saveAbsence(Absence abs) {
		SystemDBConnector.saveAbsence(abs);
	}
	
	/**
	 * dient dem Erhalt einer Übersicht aller Angestellten
	 * 
	 * @return Vector<Employee> with all employees
	 */
	protected static Vector<Employee> getPhonebook(){
		return LocalStorage.getStorage();
	}
	
	/**
	 * dient dem stornieren eines Urlaubsantrags
	 * 
	 * @param vacation the vacation request to be deleted
	 * @return true if there was a absence with the ID 'vacation', else false
	 */
	protected static boolean cancelVacation(Integer vacation){
		return SystemDBConnector.cancelVacation(vacation);
	}
	
	/**
	 * dient dem Akzeptieren eines Urlaubsantrags
	 * 
	 * @param vacation the vacation request to be accepted
	 * @return true if there is an absence 'vacation', else false
	 */
	protected static boolean acceptVacation(Absence vacation) {
		return SystemDBConnector.acceptVacation(vacation);
		
	}
	
	
	/**
	 * dient dem hinzufügen einer Abwesenheit
	 * 
	 * @param absence the absence to be added
	 * @return true if the absence can be added (if the absence does not overlap with another and the user has enough vacation_left,
	 *  else false
	 */
	private static boolean addAbsence(Absence absence) {
		if(!absence.isSick()) {
			Iterator<Absence> it = getAbsenceOf(getEmployeeByID(absence.getPersNr())).iterator();
			while(it.hasNext()) {
				Absence abs = it.next();
				if(absence.isOverlapping(abs)) {
					return false;
				}
			}
		}
		saveAbsence(absence);
		return true;
	}
	

	/**
	 * dient dem hinzufügen einer neuen Abwesenheit
	 * 
	 * @param persNr the persNr of the Employee who requests the absence
	 * @param begin the begin date of the absence
	 * @param end the end date of the absence
	 * @param isSick the sick status of the absence (true if illness, false if vacation or something else)
	 * @return true if the absence can be added (if the absence does not overlap with another and the user has enough vacation_left,
	 *  else false
	 */
	protected static boolean newAbsence(int persNr, Date begin, Date end, boolean isSick) {
		return addAbsence(new Absence(persNr, begin, end, isSick));
	}
	
	
	/**
	 * dient dem Auffinden einer Abwesenheit 
	 * 
	 * @param persNr the persNr of the Employee who requests the absence
	 * @param begin the begin date of the absence
	 * @param end the end date of the absence
	 * @return the absence searched for or null if none was found
	 */
	protected static Absence getAbsenceByDate(int persNr, Date begin, Date end) {
		Iterator<Absence> it = getAbsenceOf(getEmployeeByID(persNr)).iterator();
		while(it.hasNext()) {
			Absence abs = it.next();
			if(abs.getBegin().compare(begin) == 0 && abs.getEnd().compare(end) == 0) {
				return abs;
			}
		}
		return null;
	}
	
	//Ram, Checken ob automatisch erzeugter Username existiert (Für createUserController)
	/**
	 * dient dem check nach Usernamen (diese müssen unique sein)
	 * 
	 * @param username the username which is to be checked
	 * @return a valid (unique) username or null if an error occurred
	 */
	protected static String checkUsername(String username) {
		return SystemDBConnector.checkUsername(username);
	}

}
