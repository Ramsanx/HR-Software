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
		int persNr = employee.next().getPersNr(); 
		while(employee.hasNext()) {
			Employee user = employee.next();
			if(user.getPersNr() > persNr) {
				persNr = user.getPersNr();
			}
		}
		return persNr;
	}
	
	
	
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
		
		// Hier war das --------------------------------------------------------------------------------
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
	
	//Ram u.a.
	protected static void addToChanges(int persNr) {
		LocalStorage.addToChanges(persNr, "workingTimeChange");
	}
	
	// Erik - auf public gesetzt
	protected static Vector<Absence> getAbsenceOf(Employee employ){
		return SystemDBConnector.getAbsenceOf(employ);
	}
	
	protected static Vector<Absence> getVacationOverview(Employee employ){
		Vector<Absence> vac = new Vector<Absence>();
		Iterator<Absence> it = getAbsenceOf(employ).iterator();
		while(it.hasNext()) {
			Absence abs = it.next();
			if(!abs.isSick()) {
				String acceptance;
//				if(abs.isAccepted()) {
//					acceptance = "genehmigt";
//				}else {
//					acceptance = "nicht genehmigt";
//				}
				vac.add(abs);
			}
		}
		return vac;
	}
	
	
		//Ram
		protected static Vector<Absence> getAbsenceTable(){
			return SystemDBConnector.getAbsenceTable();
		}
		
		//Ram
		protected static Vector<Absence> getVacationRequests(){
			Vector<Absence> vac = new Vector<Absence>();
			Iterator<Absence> it = getAbsenceTable().iterator();
			
			while(it.hasNext()) {
				Absence abs = it.next();
				if(!abs.isSick()) {
					String acceptance;
					if(abs.isAccepted()) {
						acceptance = "genehmigt";
						Logging.writeActlog("AVC002", abs.getPersNr());
					}else {
						acceptance = "nicht genehmigt";
						Logging.writeActlog("AVC003", abs.getPersNr());
					}
					vac.add(abs);
				}
			}
			return vac;
		}

	
	protected static void saveAbsence(Absence abs) {
		SystemDBConnector.saveAbsence(abs);
	}
	
	protected static Vector<Employee> getPhonebook(){
		return LocalStorage.getStorage();
	}
	
	protected static boolean cancelVacation(Integer vacation){
		return SystemDBConnector.cancelVacation(vacation);
	}
	
	protected static boolean acceptVacation(Absence vacation) {
		return SystemDBConnector.acceptVacation(vacation);
		
	}
	
	
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
	

	protected static boolean newAbsence(int persNr, Date begin, Date end, boolean isSick) {
		return addAbsence(new Absence(persNr, begin, end, isSick));
	}
	
	
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
	protected static String checkUsername(String username) {
		return SystemDBConnector.checkUsername(username);
	}

}
