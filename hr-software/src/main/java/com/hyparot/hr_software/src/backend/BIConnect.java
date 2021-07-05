package com.hyparot.hr_software.src.backend;

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
	
	public Employee getEmployeeByName(String username) {
		return BusinessIntellegent.getEmployeeByName(username);
	}
	
	public Employee getEmployeeByID(int persNr) {
		return BusinessIntellegent.getEmployeeByID(persNr);
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
			String jobTitle, String phoneNumber, int workingTime_contract, Date birthday, Date startDate,
			Adress adress){
		
		BusinessIntellegent.createEmployee(group, username, password, firstname, lastname,
										   jobTitle, phoneNumber, workingTime_contract, birthday, startDate,
										   adress);
	}

	@Override
	public boolean deleteEmployee(int persNr) {
		return BusinessIntellegent.deleteEmloyee(persNr);
	}

	@Override
	public Employee getPersonalData(int persNr) {
		return BusinessIntellegent.getEmployeeByID(persNr);
	}


	@Override
	public boolean applyForVacation(Date firstDayOfVac, Date lastDayOfVac) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelVacation(Absence vacation) {
		// TODO Auto-generated method stub
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
	public Contract getContract() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getPhoneBook() {
		// TODO Auto-generated method stub
		
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
		
		BusinessIntellegent.editEmployee(operatingUserID, firstname, lastname, eMail, phoneNumber, birthday,
			     country, city, postcode, street, houseNr, housenumberSupplement);
	}
	
	
	public boolean loginUser(String username, String password) {
		
		Employee user = BusinessIntellegent.getEmployeeByName(username);
		if(user != null) {
			if(password.equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
