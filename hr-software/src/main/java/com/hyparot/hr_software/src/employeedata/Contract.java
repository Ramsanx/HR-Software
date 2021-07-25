package com.hyparot.hr_software.src.employeedata;


/**
 * ein Objekt der Klasse Vertrag wird beim Anlegen eines Angestellten erstellt
 */
public class Contract {

	private String firstname;
	private String lastname;
	private String group;
	private String jobTitle;
	private String phoneNumber;
	
	private int workingTime_contract;
	
	private Date birthday;
	private Date startDate;
	
	private Adress adress;
	

	/**
	 * dient der Erstellung eines Objektes dieser Klasse
	 * 
	 * @param firstname the firstname of the Employee
	 * @param lastname the lastname of the Employee
	 * @param group the group of the Employee
	 * @param jobTitle the jobTitle of the Employee
	 * @param phoneNumber the phoneNumber of the Employee
	 * @param workingTime_contract the workingTime_contract of the Employee
	 * @param birthday the birthday of the Employee
	 * @param startDate the startDate of the Employee
	 * @param adress the adress of the Employee
	 */
	public Contract(String firstname, String lastname, String group, String jobTitle, String phoneNumber, 
				   int workingTime_contract,
				   Date birthday, Date startDate, 
				   Adress adress) {
		
		this.setFirstname(firstname);
		this.setLastname(firstname);
		this.setGroup(group);
		this.setJobTitle(jobTitle);
		this.setPhoneNumber(phoneNumber);
		this.setWorkingTime_contract(workingTime_contract);
		this.setBirthday(birthday);
		this.setStartDate(startDate);
		this.setAdress(adress);
	}


	/**
	 * dient der Abfrage der Variablen firstname
	 * 
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}


	/**
	 * dient der Manipulation der Variablen firstname
	 * 
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	/**
	 * dient der Abfrage der Variablen jobTitle
	 * 
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}


	/**
	 * dient der Manipulation der Variablen jobTitle
	 * 
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	/**
	 * dient der Abfrage der Variablen phoneNumber
	 * 
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * dient der Manipulation der Variablen phoneNumber
	 * 
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	/**
	 * dient der Abfrage der Variablen workingTime_contract
	 * 
	 * @return the workingTime_contract
	 */
	public int getWorkingTime_contract() {
		return workingTime_contract;
	}


	/**
	 * dient der Manipulation der Variablen workingTime_contract
	 * 
	 * @param workingTime_contract the workingTime_contract to set
	 */
	public void setWorkingTime_contract(int workingTime_contract) {
		this.workingTime_contract = workingTime_contract;
	}


	/**
	 * dient der Abfrage der Variablen birthday
	 * 
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}


	/**
	 * dient der Manipulation der Variablen birthday
	 * 
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	/**
	 * dient der Abfrage der Variablen startDate
	 * 
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}


	/**
	 * dient der Manipulation der Variablen startDate
	 * 
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	/**
	 * dient der Abfrage der Variablen adress
	 * 
	 * @return the adress
	 */
	public Adress getAdress() {
		return adress;
	}


	/**
	 * dient der Manipulation der Variablen adress
	 * 
	 * @param adress the adress to set
	 */
	public void setAdress(Adress adress) {
		this.adress = adress;
	}


	/**
	 * dient der Abfrage der Variablen lastname
	 * 
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}


	/**
	 * dient der Manipulation der Variablen lastname
	 * 
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	/**
	 * dient der Abfrage der Variablen group
	 * 
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}


	/**
	 * dient der Manipulation der Variablen group
	 * 
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}
	
}
