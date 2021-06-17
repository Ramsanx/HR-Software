package com.hyparot.hr_software.src.backend;

import com.hyparot.hr_software.src.mitarbeiter.*;
import com.hyparot.hr_software.src.mitarbeiter.Date;
import java.util.*;

public class BusinessIntellegent {

	
	static public Employee getEmployeeByName(String username) {
		Iterator<Employee> employee = LocalStorage.getStorage().iterator();
		
		while(employee.hasNext()) {
			Employee user = employee.next();
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	
	static public Employee getEmployeeByID(int persNr) {
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
	
	
	
	public static void createEmployee(String group, String username, String password, String firstname, String lastname, 
									  String jobTitle, String phoneNumber, int workingTime_contract, 
									  Date birthday, Date startDate,
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
							  jobTitle, phoneNumber, workingTime_contract, findHighestPersNr()+1,
							  birthday, startDate,
							  adress);
			}else if(group.equals("Superior")) {
				user = new Superior(username, password, firstname, lastname, 
									jobTitle, phoneNumber, workingTime_contract, findHighestPersNr()+1,
									birthday, startDate,
									adress);
			}else if(group.equals("Employee")){
				user = new Employee(username, password, firstname, lastname, 
									jobTitle, phoneNumber, workingTime_contract, findHighestPersNr()+1,
									birthday, startDate,
									adress);
			}
			LocalStorage.addToEmployees(user);
			LocalStorage.addToChanges(user.getPersNr(), "created");
		}
		
		
	
	
	public static void editEmployee(int persNr, 
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
	
	public static boolean deleteEmloyee(int persNr) {
		Employee employee = getEmployeeByID(persNr);
		if(employee == null) {
			return false;
		}else {
			LocalStorage.removeFromEmployees(employee);
			LocalStorage.addToChanges(persNr, "deleted");
			return true;
		}
	}
	
	

	
}
