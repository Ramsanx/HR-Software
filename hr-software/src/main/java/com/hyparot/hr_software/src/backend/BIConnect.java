package com.hyparot.hr_software.src.backend;

import java.util.Hashtable;
import java.util.Iterator;

import com.hyparot.hr_software.src.employee.Employee;
import com.hyparot.hr_software.src.employeedata.Absence;
import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Contract;
import com.hyparot.hr_software.src.employeedata.Date;
import com.hyparot.hr_software.src.sst.employee;
import com.hyparot.hr_software.src.sst.hr;
import com.hyparot.hr_software.src.sst.superior;

public class BIConnect implements employee, hr, superior{

	private int operatingUserID;
	
	public BIConnect() {
		
	}
	
	public BIConnect(int persNr) {
		this.operatingUserID = persNr;
	}
	
	public boolean loginUser(String username, String password) {
		
		Employee user = BusinessIntelligence.getEmployeeByName(username);
		if(user != null) {
			if(password.equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public Employee getEmployeeByName(String username) {
		return BusinessIntelligence.getEmployeeByName(username);
	}
	
	public Employee getEmployeeByID(int persNr) {
		return BusinessIntelligence.getEmployeeByID(persNr);
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
			String jobTitle, String phoneNumber, int workingTime_contract, Date birthday, Date startDate,
			Adress adress){
		
		BusinessIntelligence.createEmployee(group, username, password, firstname, lastname,
										   jobTitle, phoneNumber, workingTime_contract, birthday, startDate,
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
		Employee employ = this.getEmployeeByID(operatingUserID);
		if(employ.newAbsence(firstDayOfVac, lastDayOfVac, false)) {
			BusinessIntelligence.saveAbsence(employ.getAbsence(firstDayOfVac, lastDayOfVac));
			return true;
		}
		return false;
	}

	@Override
	public boolean cancelVacation(Absence vacation) {
		// TODO Auto-generated method stub
		
		return BusinessIntelligence.cancelVacation(vacation);
	}

	@Override
	public Hashtable<Absence, String> getVacationOverview() {
		// TODO Auto-generated method stub
		
		Hashtable<Absence, String> absence = BusinessIntelligence.getAbsenceOf(this.getEmployeeByID(operatingUserID));
		
		//TODO
		
		return absence;
	}

	@Override
	public void setSick(int duration) {
		
		Employee employ = this.getEmployeeByID(this.operatingUserID);
		if(employ.newAbsence(Date.getToday(), Date.getFutureDate(duration), true)) {
			BusinessIntelligence.saveAbsence(employ.getAbsence(Date.getToday(), Date.getFutureDate(duration)));
		}
		
	}

	@Override
	public void setWorkTime() {
		// TODO Auto-generated method stub
		
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
