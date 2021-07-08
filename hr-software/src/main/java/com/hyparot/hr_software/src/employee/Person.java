package com.hyparot.hr_software.src.employee;

import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Contract;
import com.hyparot.hr_software.src.employeedata.Date;
import com.hyparot.hr_software.src.employeedata.Absence;
import java.util.Hashtable;
import java.util.Iterator;


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
	
	private Hashtable<Absence, String> absence= new Hashtable<Absence, String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	
	public Person(String firstname, String lastname, String jobTitle,
					   String phoneNumber, int persNr, int workingTime_contract,  
					   Date birthday, Date startDate,
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


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEMail() {
		return eMail;
	}


	public void setEMail(String eMail) {
		this.eMail = eMail;
	}


	public String getGroup() {
		return group;
	}


	private void setGroup(String group) {
		this.group = group;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getPersNr() {
		return persNr;
	}


	public void setPersNr(int persNr) {
		this.persNr = persNr;
	}


	public int getWorkingTime_contract() {
		return workingTime_contract;
	}


	public void setWorkingTime_contract(int workingTime_contract) {
		this.workingTime_contract = workingTime_contract;
	}


	public int getWorkingTime_left() {
		return workingTime_left;
	}


	public void setWorkingTime_left(int workingTime_left) {
		this.workingTime_left = workingTime_left;
	}


	public int getVacation_contract() {
		return vacation_contract;
	}


	public void setVacation_contract(int vacation_contract) {
		this.vacation_contract = vacation_contract;
	}


	public int getVacation_left() {
		return vacation_left;
	}


	public void setVacation_left(int vacation_left) {
		this.vacation_left = vacation_left;
	}


	public int getSickDays() {
		return sickDays;
	}


	public void setSickDays(int sickDays) {
		this.sickDays = sickDays;
	}


	public boolean getSick() {
		return sick;
	}


	public void setSick(boolean sick) {
		this.sick = sick;
	}
	
	
	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	


	public Adress getAdress() {
		return adress;
	}


	public void setAdress(Adress adress) {
		this.adress = adress;
	}


	public Contract getContract() {
		return contract;
	}


	public void setContract(Contract contract) {
		this.contract = contract;
	}
	

	private boolean addAbsence(Absence absence) {
		boolean applicable = true;
		Iterator<Absence> it = this.absence.keys().asIterator();
		while(it.hasNext()) {
			if(absence.isOverlapping(it.next())) {
				applicable = false;
				break;
			}
		}
		if(applicable) {
			this.absence.put(absence, "nicht genehmigt");
		}
		return applicable;
	}
	

	protected Hashtable<Absence, String> getAbsencesa(){
		return this.absence;
	}
	

	public boolean newAbsence(Date begin, Date end, boolean isSick) {
		return addAbsence(new Absence(this.persNr, begin, end, isSick));
	}
	
	
	public void cancelAbsence(Absence absence) {
		this.absence.remove(absence);
	}
	
	
	public Absence getAbsence(Date begin, Date end) {
		Iterator<Absence> it = this.absence.keys().asIterator();
		while(it.hasNext()) {
			Absence abs = it.next();
			if(abs.getBegin() == begin && abs.getEnd() == end) {
				return abs;
			}
		}
		return null;
	}
	//getter und setter Block ende
	//_________________________________________________________________________________________________________________________________

}
