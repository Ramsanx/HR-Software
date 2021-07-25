package com.hyparot.hr_software.src.employee;

import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Contract;
import com.hyparot.hr_software.src.employeedata.Date;

/**
 * diese Klasse dient als Elternklasse für die Klasse Employee
 */
public abstract class Person {
	
	
	private String firstname; // in der Datenbank tabelle "t_mitarbeiter" Feld "Vorname" typ String
	private String lastname; // in der Datenbank tabelle "t_mitarbeiter" Feld "Nachname" typ String
	private String eMail; // in der Datenbank tabelle "t_mitarbeiter" Feld "E-Mail" typ String
	private String group; // in der Datenbank tabelle "t_mitarbeiter" Feld "Gruppe" typ String
	private String jobTitle; //  in der Datenbank tabelle "t_mitarbeiter" Feld "Gruppe" typ String
	private String phoneNumber;
	
	private int persNr; // in der Datenbank tabelle "t_mitarbeiter" Feld "PersNr" typ int
	private int workingTime_contract; // in der Datenbank tabelle "t_vertragsdaten" Feld "Arebitsstunden" typ int
	private int workingTime_left; // in der Datenbank tabelle "t_Urlaub_krankheit" Feld "IstArbeitszeit" typ int
	private int vacation_contract; // in der Datenbank tabelle "t_Urlaub_krankheit" Feld "Urlaubstage_gesamt" typ int
	private int vacation_left; // in der Datenbank tabelle "t_Urlaub_krankheit" Feld "Urlaubstage_verbleibend" typ int
	private int sickDays; // in der Datenbank tabelle "t_Urlaub_krankheit" Feld "Krankentage" typ int
	
	private boolean sick; // in der Datenbank tabelle "t_Urlaub_krankheit" Feld "Krank" typ boolean
	
	private Date birthday; // in der Datenbank "t_mitarbeiter" Feld "Geburtstag" typ date
	private Date startDate; // in der Datenbank "t_mitarbeiter" Feld "eingestellt_am"
	
	
	private Adress adress; 
	
	private Contract contract;
	
	
	/**
	 * dient als super-Konstruktor
	 * 
	 * @param firstname
	 * @param lastname
	 * @param jobTitle
	 * @param phoneNumber
	 * @param persNr
	 * @param workingTime_contract
	 * @param workingTime_left
	 * @param vacation_left
	 * @param birthday
	 * @param startDate
	 * @param adress
	 */
	public Person(String firstname, String lastname, String jobTitle,
				  String phoneNumber, int persNr, int workingTime_contract, int workingTime_left,
				  int vacation_left, Date birthday, Date startDate,
				  Adress adress) {
		
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setEMail(firstname.substring(0, 1).toLowerCase() + "." + lastname.toLowerCase() + "@unsere-firma.de");
		this.setGroup(getClass().getSimpleName());
		this.setJobTitle(jobTitle);
		
		this.setPhoneNumber(phoneNumber);
		this.setPersNr(persNr); 
		this.setWorkingTime_contract(workingTime_contract);
		if(workingTime_contract >= 37) {
			this.setVacation_contract(30);
		}else {
			this.setVacation_contract(26);
		}
		this.workingTime_left = workingTime_left;
		this.vacation_left = vacation_left;
		
		this.setBirthday(birthday);
		this.setStartDate(startDate);
		this.setAdress(adress);
		this.setContract(new Contract(firstname, lastname, group, jobTitle, 
								   phoneNumber, workingTime_contract,
								   birthday, startDate, 
								   adress));
	}


	//getter und setter Block beginn
	//__________________________________________________________________________________________________________________________________


	/**
	 * dient dem Abruf der Variablen firstname
	 * 
	 * @return the firstname of a person
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
	 * dient dem Abruf der Variablen lastname
	 * 
	 * @return the lastname of a person
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
	 * dient dem Abruf der Variablen eMail
	 * 
	 * @return the eMail of a person
	 */
	public String getEMail() {
		return eMail;
	}


	/**
	 * dient der Manipulation der Variablen eMail
	 * 
	 * @param eMail the eMail to set
	 */
	public void setEMail(String eMail) {
		this.eMail = eMail;
	}


	/**
	 * dient dem Abruf der Variablen group
	 * 
	 * @return the group of a person
	 */
	public String getGroup() {
		return group;
	}


	/**
	 * dient der Manipulation der Variablen group
	 * 
	 * @param group the group to set
	 */
	private void setGroup(String group) {
		this.group = group;
	}


	/**
	 * dient dem Abruf der Variablen jobTitle
	 * 
	 * @return the jobTitle of a person
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
	 * dient dem Abruf der Variablen phoneNumber
	 * 
	 * @return the phoneNumber of a person
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
	 * dient dem Abruf der Variablen persNr
	 * 
	 * @return the persNr of a person
	 */
	public int getPersNr() {
		return persNr;
	}


	/**
	 * dient der Manipulation der Variablen persNr
	 * 
	 * @param persNr the persNr to set
	 */
	public void setPersNr(int persNr) {
		this.persNr = persNr;
	}


	/**
	 * dient dem Abruf der Variablen workingTime_contract
	 * 
	 * @return the workingTime_contract of a person
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
	 * dient dem Abruf der Variablen workingTime_left
	 * 
	 * @return the workingTime_left of a person
	 */
	public int getWorkingTime_left() {
		return workingTime_left;
	}


	/**
	 * dient der Manipulation der Variablen workingTime_left 
	 * 
	 * @param workingTime_left the wrkingTime_left to set
	 */
	public void setWorkingTime_left(int workingTime_left) {
		this.workingTime_left = workingTime_left;
	}


	/**
	 * dient dem Abruf der Variablen vacation_contract
	 * 
	 * @return the vacation_contract of a person
	 */
	public int getVacation_contract() {
		return vacation_contract;
	}


	/**
	 * dient der Manipulation der Variablen vacation_contract
	 * 
	 * @param vacation_contract the vacation_contract to set
	 */
	public void setVacation_contract(int vacation_contract) {
		this.vacation_contract = vacation_contract;
	}


	/**
	 * dient dem Abruf der Variablen vacation_left
	 *  
	 * @return the vacation_left of a person
	 */
	public int getVacation_left() {
		return vacation_left;
	}


	/**
	 * dient der Manipulation der Variablen vacation_left
	 * 
	 * @param vacation_left the vacation_left to set
	 */
	public void setVacation_left(int vacation_left) {
		this.vacation_left = vacation_left;
	}


	/**
	 * dient dem Abruf der Variablen sickDays
	 * 
	 * @return the sickDays of a person
	 */
	public int getSickDays() {
		return sickDays;
	}


	/**
	 * dient der Manipulation der Variablen sickDays
	 * 
	 * @param sickDays the sickDays to set
	 */
	public void setSickDays(int sickDays) {
		this.sickDays = sickDays;
	}


	/**
	 * dient dem Abruf der Variablen sick
	 * 
	 * @return the sick status of a person
	 */
	public boolean getSick() {
		return sick;
	}


	/**
	 * dient der Manipulation der Variablen sick
	 * 
	 * @param sick the sick status to set
	 */
	public void setSick(boolean sick) {
		this.sick = sick;
	}
	
	
	/**
	 * dient dem Abruf der Variablen birthday
	 * 
	 * @return the birthday of a person
	 */
	public Date getBirthday() {
		return birthday;
	}


	/**
	 * dient der Manipulation der Variablen birthday
	 * 
	 * @param birthday the brithday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	/**
	 * dient dem Abruf der Variablen startDate
	 * 
	 * @return the startDate of a person (the day he was hired)
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
	 * dient dem Abruf der Variablen adress
	 * 
	 * @return the adress where a person lives
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
	 * dient dem Abruf der Variablen contract
	 * 
	 * @return the conrtact of a person
	 */
	public Contract getContract() {
		return contract;
	}


	/**
	 * dient der Manipulation der Variablen contract
	 * 
	 * @param contract the conrtact to set
	 */
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	//getter und setter Block ende
	//_________________________________________________________________________________________________________________________________

}
