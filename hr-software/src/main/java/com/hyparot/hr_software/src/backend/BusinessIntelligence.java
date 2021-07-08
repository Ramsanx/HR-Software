package com.hyparot.hr_software.src.backend;

import com.hyparot.hr_software.src.employee.*;
import com.hyparot.hr_software.src.employeedata.Absence;
import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Date;
import java.util.*;

public class BusinessIntelligence {

	
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
	
	
	private static int findHighestPersNr() {
		if(LocalStorage.getStorage().isEmpty()) {
			return 1000;
		}
		Iterator<Employee> employee = LocalStorage.getStorage().iterator();
		int persNr = employee.next().getPersNr(); //wirft eine Exception
		while(employee.hasNext()) {
			Employee user = employee.next();
			if(user.getPersNr() > persNr) {
				persNr = user.getPersNr();
			}
		}
		return persNr;
	}
	
	
	
	protected static void createEmployee(String group, String username, String password, String firstname, String lastname, 
									  String jobTitle, String phoneNumber, int workingTime_contract, 
									  Date birthday, Date startDate,
									  Adress adress) {
		
		Iterator<Employee> employee = LocalStorage.getStorage().iterator();
		while(employee.hasNext()) {
			if(employee.next().getUsername().equals(username)) {
				return;
			}
		}
		
		// Hier war das --------------------------------------------------------------------------------
			Employee user = null;
			if(group.equals("HR")) {
				user = new HR(username, password, firstname, lastname, 
							  jobTitle, phoneNumber, findHighestPersNr()+1, workingTime_contract,
							  birthday, startDate,
							  adress);
			}else if(group.equals("Superior")) {
				user = new Superior(username, password, firstname, lastname, 
									jobTitle, phoneNumber, findHighestPersNr()+1, workingTime_contract, 
									birthday, startDate,
									adress);
			}else if(group.equals("Employee")){
				user = new Employee(username, password, firstname, lastname, 
									jobTitle, phoneNumber, findHighestPersNr()+1, workingTime_contract, 
									birthday, startDate,
									adress);
			}
			LocalStorage.addToEmployees(user);
			LocalStorage.addToChanges(user.getPersNr(), "created");
		}
		
		
	
	
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
		}
	}
	
	protected static boolean deleteEmloyee(int persNr) {
		Employee employee = getEmployeeByID(persNr);
		if(employee == null) {
			return false;
		}else {
			LocalStorage.removeFromEmployees(employee);
			LocalStorage.addToChanges(persNr, "deleted");
			return true;
		}
	}

	protected static Hashtable<Absence, String> getAbsenceOf(Employee User){
		return SystemDBConnector.getAbsenceOf(User);
	}
	
	protected static void saveAbsence(Absence abs) {
		SystemDBConnector.saveAbsence(abs);
	}
	
	protected static Vector<Employee> getPhonebook(){
		return LocalStorage.getStorage();
	}
	
	protected static boolean cancelVacation(Absence vacation){
		Employee user = getEmployeeByID(vacation.getPersNr());
		return SystemDBConnector.cancelVacation(user, vacation);
	}
	
	protected static boolean acceptVacation(Absence vacation) {
		if(getAbsenceOf(getEmployeeByID(vacation.getPersNr())).containsKey(vacation)) {
			SystemDBConnector.acceptVacation(vacation);
			return true;
		}
		return false;
	}

}
