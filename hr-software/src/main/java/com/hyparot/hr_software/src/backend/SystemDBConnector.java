package com.hyparot.hr_software.src.backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Iterator;
import com.hyparot.hr_software.src.db.db_connect;
import com.hyparot.hr_software.src.mitarbeiter.Adress;
import com.hyparot.hr_software.src.mitarbeiter.Employee;
import com.hyparot.hr_software.src.mitarbeiter.Date;
import com.hyparot.hr_software.src.mitarbeiter.HR;
import com.hyparot.hr_software.src.mitarbeiter.Superior;

public class SystemDBConnector {

	public static void loadDBDataToLocal() {
		ResultSet data = db_connect.read_table("t_employee");
		if(data != null) {
			
			try {
				while(data.next()) {
					
					String classType = data.getString("Gruppe");
					//System.out.println(Daten.getInt("PersNr"));
					if(classType.equals("HR")) {
						HR employee = new HR(db_connect.str_wert_auslesen("t_zugaenge", "Nutzername", data.getInt("PersNr")),
												db_connect.str_wert_auslesen("t_zugaenge", "Passwort", data.getInt("PersNr")),
												data.getString("Vorname"), 
												data.getString("Nachname"), 
												data.getString("bezeichnung"),
												data.getString("TelNr"), 
												db_connect.int_wert_auslesen("t_vertragsdata", "Arbeitsstunden", data.getInt("PersNr")), 
												data.getInt("PersNr"),
												new Date(data.getString("Geburtstag")), 
												new Date(data.getString("eingestellt_am")),
												new Adress(data.getString("Land"), 
														    data.getInt("PLZ"), 
														    data.getString("Ort"), 
														    data.getString("Straße"), 
														    data.getInt("Hausnummer"), 
														    data.getString("HausnummernZusatz")));
						
						LocalStorage.addToEmployees(employee);
						
						
					}else if(classType.equals("Vorgesetzter")) {
						Superior employee = new Superior(db_connect.str_wert_auslesen("t_zugaenge", "Nutzername", data.getInt("PersNr")),
																  db_connect.str_wert_auslesen("t_zugaenge", "Passwort", data.getInt("PersNr")),
																  data.getString("Vorname"), 
																  data.getString("Nachname"), 
																  data.getString("bezeichnung"),
																  data.getString("TelNr"), 
																  db_connect.int_wert_auslesen("t_vertragsdata", "Arbeitsstunden", data.getInt("PersNr")), 
																  data.getInt("PersNr"),
																  new Date(data.getString("Geburtstag")), 
																  new Date(data.getString("eingestellt_am")),
																  new Adress(data.getString("Land"), 
																		  	  data.getInt("PLZ"), 
																		  	  data.getString("Ort"), 
																		  	  data.getString("Straße"), 
																		  	  data.getInt("Hausnummer"), 
																		  	  data.getString("HausnummernZusatz")));
						
						LocalStorage.addToEmployees(employee);
							
						
					}else if(classType.equals("Angestellte")) {
						Employee employee = new Employee(db_connect.str_wert_auslesen("t_zugaenge", "Nutzername", data.getInt("PersNr")),
																  db_connect.str_wert_auslesen("t_zugaenge", "Passwort", data.getInt("PersNr")),
																  data.getString("Vorname"), 
																  data.getString("Nachname"), 
																  data.getString("bezeichnung"),
																  data.getString("TelNr"), 
																  db_connect.int_wert_auslesen("t_vertragsdata", "Arbeitsstunden", data.getInt("PersNr")), 
																  data.getInt("PersNr"),
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static boolean loadLocalDataToDB() {
		Hashtable<Integer, String> changes = LocalStorage.getChangeTable();
		Iterator<Integer> toStore = changes.keys().asIterator();
		while(toStore.hasNext()) {
			int persNr = toStore.next();
			Employee employee = BusinessIntellegent.getEmployeeByID(persNr);
			
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
									   employee.getStartDate().toString(), 
									   employee.getPersNr(), 
									   employee.getUsername(), 
									   employee.getPassword(), 
									   employee.getPersNr(), 
									   employee.getVacation_contract(), 
									   0,
									   false, 
									   employee.getPersNr(), 
									   0, 
									   0,
									   37);
				LocalStorage.removeFromChanges(persNr);
				
			}else if(changes.get(persNr).equals("changed")) {
				db_connect.wert_update("t_employee", "Stellenbezeichung", employee.getJobTitle(), persNr);
				db_connect.wert_update("t_employee", "E-Mail", employee.getEMail(), persNr);
				db_connect.wert_update("t_employee", "eingestellt am", employee.getStartDate().toString(), persNr);
				db_connect.wert_update("t_employee", "Geburtstag", employee.getBirthday().toString(), persNr);
				db_connect.wert_update("t_employee", "Gruppe", employee.getClass().getSimpleName(), persNr);
				db_connect.wert_update("t_employee", "Hausnummer", String.valueOf(employee.getAdress().getHouseNr()), persNr);
				db_connect.wert_update("t_employee", "Hausnummernzusatz", employee.getAdress().getHousenumberSupplement(), persNr);
				db_connect.wert_update("t_employee", "Land", employee.getAdress().getCountry(), persNr);
				db_connect.wert_update("t_employee", "Nachname", employee.getLastname(), persNr);
				db_connect.wert_update("t_employee", "Ort", employee.getAdress().getCity(), persNr);
				db_connect.wert_update("t_employee", "TelNr", employee.getPhoneNumber(), persNr);
				db_connect.wert_update("t_employee", "Vorname", employee.getFirstname(), persNr);
				
				LocalStorage.removeFromChanges(persNr);
				
			}else if(changes.get(persNr).equals("deleted")) {
				
				db_connect.delete_user(persNr);
				LocalStorage.removeFromChanges(persNr);
			}
		}
		return true;
	}
	
}
