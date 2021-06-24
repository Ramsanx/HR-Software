package com.hyparot.hr_software.src.backend;

import com.hyparot.hr_software.src.sst.BI;
import com.hyparot.hr_software.employeedata.Absence;
import com.hyparot.hr_software.employeedata.Adress;
import com.hyparot.hr_software.employeedata.Contract;
import com.hyparot.hr_software.employeedata.Date;
import com.hyparot.hr_software.src.employee.*;
import com.hyparot.hr_software.src.sst.*;

import java.util.*;

public class BusinessIntellegent implements BI, employee, hr, superior{

	
	public static Employee getEmployeeByName(String username) {
		Iterator<Employee> employee = LocalStorage.getStorage().iterator();
		
		while(employee.hasNext()) {
			Employee user = employee.next();
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	
	public static Employee getEmployeeByID(int persNr) {
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

	@Override
	public boolean acceptVacation(String doYouAccept) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getPayroll(int persNr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNewEmployee(String group, String username, String password, String firstname, String lastname,
			String jobTitle, String phoneNumber, int workingTime_contract, Date birthday, Date startDay,
			Adress adress) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteEmployee(int persNr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getPersonalData(int persNr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loginUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void editEmployee(String firstname, String lastname, String eMail, String phoneNumber, Date birthday,
			String country, String city, int postcode, String street, int houseNr, String housenumberSupplement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean applyForVacation(Date firstDayOfVac, Date lastDayOfVac) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelVacation(Absence vacation) {
		// TODO Auto-generated method stub
//		if(vacation.exists()) {
//			return true;
//		}
		return false;
	}

	@Override
	public void getVacationOverview() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSick(int dauer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWorkTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPersonalDate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contract getContract() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getPhoneBook() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPayrol() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMailinfo() {
		// TODO Auto-generated method stub
		
	}
	
	

	
}
