package com.hyparot.hr_software.src.backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Iterator;
import com.hyparot.hr_software.src.db.db_connect;
import com.hyparot.hr_software.src.employee.Employee;
import com.hyparot.hr_software.src.employee.HR;
import com.hyparot.hr_software.src.employee.Superior;
import com.hyparot.hr_software.src.employeedata.Absence;
import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Date;

public class SystemDBConnector {

	public static void loadDBDataToLocal() {
		ResultSet data = db_connect.read_table("t_mitarbeiter");
		if(data != null) {

			try {
				while(data.next()) {

					String classType = data.getString("Gruppe");
					//System.out.println(Daten.getInt("PersNr"));
					if(classType.equals("HR")) {
						HR employee = new HR(db_connect.read_str_value("t_zugaenge", "Nutzername", data.getInt("PersNr")),
								db_connect.read_str_value("t_zugaenge", "Passwort", data.getInt("PersNr")),
								data.getString("Vorname"), 
								data.getString("Nachname"), 
								data.getString("bezeichnung"),
								data.getString("TelNr"), 
								data.getInt("PersNr"),
								db_connect.read_int_value("t_vertragsdaten", "Arbeitsstunden", data.getInt("PersNr")), 
								new Date(data.getString("Geburtstag")), 
								new Date(data.getString("eingestellt_am")),
								new Adress(data.getString("Land"), 
										data.getInt("PLZ"), 
										data.getString("Ort"), 
										data.getString("Straße"), 
										data.getInt("Hausnummer"), 
										data.getString("HausnummernZusatz")));

						LocalStorage.addToEmployees(employee);


					}else if(classType.equals("Superior")) {
						Superior employee = new Superior(db_connect.read_str_value("t_zugaenge", "Nutzername", data.getInt("PersNr")),
								db_connect.read_str_value("t_zugaenge", "Passwort", data.getInt("PersNr")),
								data.getString("Vorname"), 
								data.getString("Nachname"), 
								data.getString("bezeichnung"),
								data.getString("TelNr"),
								data.getInt("PersNr"),
								db_connect.read_int_value("t_vertragsdaten", "Arbeitsstunden", data.getInt("PersNr")), 
								new Date(data.getString("Geburtstag")), 
								new Date(data.getString("eingestellt_am")),
								new Adress(data.getString("Land"), 
										data.getInt("PLZ"), 
										data.getString("Ort"), 
										data.getString("Straße"), 
										data.getInt("Hausnummer"), 
										data.getString("HausnummernZusatz")));

						LocalStorage.addToEmployees(employee);


					}else if(classType.equals("Employee")) {
						Employee employee = new Employee(db_connect.read_str_value("t_zugaenge", "Nutzername", data.getInt("PersNr")),
								db_connect.read_str_value("t_zugaenge", "Passwort", data.getInt("PersNr")),
								data.getString("Vorname"), 
								data.getString("Nachname"), 
								data.getString("bezeichnung"),
								data.getString("TelNr"), 
								data.getInt("PersNr"),
								db_connect.read_int_value("t_vertragsdaten", "Arbeitsstunden", data.getInt("PersNr")), 
								new Date(data.getString("Geburtstag")), 
								new Date(data.getString("eingestellt_am")),
								new Adress(data.getString("Land"), 
										data.getInt("PLZ"), 
										data.getString("Ort"), 
										data.getString("Straße"), 
										data.getInt("Hausnummer"), 
										data.getString("HausnummernZusatz")));

						LocalStorage.addToEmployees(employee);
					}
				}
			} catch (SQLException e) {
				
			}
		}
	}


	public static boolean loadLocalDataToDB() {
		Hashtable<Integer, String> changes = LocalStorage.getChangeTable();
		Iterator<Integer> toStore = changes.keys().asIterator();
		boolean answered = false;
		while(toStore.hasNext()) {
			int persNr = toStore.next();
			Employee employee = BusinessIntelligence.getEmployeeByID(persNr);

			if(changes.get(persNr).equals("created")) {
				db_connect.create_user(employee.getPersNr(),
						employee.getFirstname(), 
						employee.getLastname(), 
						employee.getBirthday().toString(), 
						employee.getAdress().getStreet(), 
						employee.getAdress().getHouseNr(), 
						employee.getAdress().getHousenumberSupplement(), 
						employee.getAdress().getCity(), 
						employee.getAdress().getPostcode(), 
						employee.getAdress().getCountry(), 
						employee.getPhoneNumber(),
						employee.getEMail(),
						employee.getJobTitle(),
						employee.getGroup(),
						0,//v_day_left
						0,//ill_days
						0,//w_time_left
						employee.getStartDate().toString(), 
						employee.getPersNr(), 
						employee.getUsername(), 
						employee.getPassword(), 
						employee.getVacation_contract(),
						employee.getPersNr(),
						0,//Gehalt
						0,//entgeltabrNr
						employee.getWorkingTime_contract()
						);
				LocalStorage.removeFromChanges(persNr);

			}else if(changes.get(persNr).equals("changed")) {
				db_connect.value_update("t_mitarbeiter", "Bezeichnung", employee.getJobTitle(), persNr);
				db_connect.value_update("t_mitarbeiter", "Mail", employee.getEMail(), persNr);
				db_connect.value_update("t_mitarbeiter", "eingestellt_am", employee.getStartDate().toString(), persNr);
				db_connect.value_update("t_mitarbeiter", "Geburtstag", employee.getBirthday().toString(), persNr);
				db_connect.value_update("t_mitarbeiter", "Gruppe", employee.getClass().getSimpleName(), persNr);
				db_connect.value_update("t_mitarbeiter", "Hausnummer", String.valueOf(employee.getAdress().getHouseNr()), persNr);
				db_connect.value_update("t_mitarbeiter", "Hausnummernzusatz", employee.getAdress().getHousenumberSupplement(), persNr);
				db_connect.value_update("t_mitarbeiter", "Land", employee.getAdress().getCountry(), persNr);
				db_connect.value_update("t_mitarbeiter", "Nachname", employee.getLastname(), persNr);
				db_connect.value_update("t_mitarbeiter", "Ort", employee.getAdress().getCity(), persNr);
				db_connect.value_update("t_mitarbeiter", "TelNr", employee.getPhoneNumber(), persNr);
				db_connect.value_update("t_mitarbeiter", "Vorname", employee.getFirstname(), persNr);

				LocalStorage.removeFromChanges(persNr);

			}else if(changes.get(persNr).equals("deleted")) {

				db_connect.delete_user(persNr);
				LocalStorage.removeFromChanges(persNr);
			}
			answered = true;
		}
		return answered;
	}
	

	protected static Hashtable<Absence, String> getAbsenceOf(Employee User) {
		try {
			Hashtable<Absence, String> abs = new Hashtable<Absence, String>();
			ResultSet rs = db_connect.read_table("t_urlaub_krankheit");
		
			int id = User.getPersNr();
			Absence absence;
			String acceptance;
			
			while(rs.next()) { ;
				if(rs.getInt("PersNr") == id) {
					boolean sick = false;
					if(rs.getInt("krank") == 1) {
						sick = true;
					}
					absence = new Absence(id, new Date(rs.getString("Von")), new Date(rs.getString("Bis")), sick);;
					if(rs.getInt("genemigt") == 1) {
						acceptance = "genehmigt";
						absence.setAccepted(true);
					}else {
						acceptance = "nicht genehmigt";
					}
					absence.setAbsenceID(rs.getInt("UK_ID"));
					abs.put(absence, acceptance);
				}
			}	
			return abs;
		}
		catch(Exception e) {
			return null;
		}
		
	}
	
	protected static void saveAbsence(Absence abs) {
		db_connect.new_vacation_sick(abs.getPersNr(), abs.getBegin().toString(), abs.getEnd().toString(), abs.isSick(), abs.isAccepted());
	}
	
	protected static boolean cancelVacation(Absence vacation) {
		System.out.println(vacation.getAbsenceID());
		return db_connect.deleteAbsence(vacation.getAbsenceID());


	}
	
	protected static boolean acceptVacation(Absence vacation) {
		return db_connect.acceptVacation(vacation.getAbsenceID());
	}

}
