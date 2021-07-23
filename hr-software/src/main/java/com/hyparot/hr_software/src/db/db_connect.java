package com.hyparot.hr_software.src.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.hyparot.hr_software.src.backend.Logging;

public class db_connect {

	// Zugangsdaten für die Datenbank
	private static String db_url = "jdbc:mysql://192.168.178.64:3306/hr"; 
	private static String user = "hr-adm";
	private static String pass = "pwd4HR-adm";
	
	
	// Funktion zum Anlegen eines neuem Benutzers
	public static void create_user(int persNr, String firstname, String lastname, String birthday, String street, int houseNr, String housenumberSupplement, String city, int postcode, String country, String phoneNumber, String eMail, String jobTitle,String group, int v_days_left, int ill_days, int w_time_left, String startDate, int z_ID, String username, String pwd, int v_days, int v_Nr, int gehalt, int entgeltabrNr, int a_Stunden){
		try {
			// hier wird eine Verbindung zur Datenbank aufgebaut 
			
			Connection con = DriverManager.getConnection(db_url, user, pass);
		    
		    // hier für ein neues Objekt vom typ Statement damit kann die Datenbank verändert werden erstellt (kann wie beim Scanner mehrmals verwendet werden)
		    Statement stm_anlegen = con.createStatement();
		    		
			stm_anlegen.executeUpdate("INSERT INTO t_mitarbeiter VALUES ('"+persNr+"', '"+firstname+"', '"+lastname+"', '"+birthday+"', '"+street+"', '"+houseNr+"', '"+housenumberSupplement+"', '"+city+"', '"+postcode+"', '"+country+"', '"+phoneNumber+"', '"+eMail+"', '"+jobTitle+"', '"+startDate+"', '"+group+"', '"+v_days_left+"', '"+ill_days+"', '"+w_time_left+"')");
			stm_anlegen.executeUpdate("INSERT INTO t_zugaenge VALUES ('"+z_ID+"', '"+persNr+"', '"+username+"', '"+pwd+"')");
			stm_anlegen.executeUpdate("INSERT INTO t_vertragsdaten VALUES ('"+v_Nr+"', '"+persNr+"', '"+a_Stunden +"', '"+gehalt+"', '"+entgeltabrNr+"', '"+v_days+"')");
			Logging.writeActlog("AUS001", persNr);
			
		} catch (SQLException  e) {
			System.out.println(e);
			Logging.writeErrlog("EUS001", persNr, e);
		}
	}
	// Funktion zum eintragen eines neuem Urlaubs- / Krankheitszeitraum in die Datenbank
	public static void new_vacation_sick(int persNr, String start, String end, boolean sick, boolean is_acceptet) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_vac = con.createStatement();
			int uk_ID = 1;

			ResultSet rs = stm_vac.executeQuery("SELECT (UK_ID) FROM t_urlaub_krankheit ORDER BY UK_ID DESC LIMIT 1;");
			while (rs.next()) {
				uk_ID = rs.getInt(1)+1;
				}
				int sick_i = 0;
				if (sick == true) {
					sick_i = 1;
				}
				int acceptet_i = 0;
				if (is_acceptet == true) {
					acceptet_i = 1;
				}
				stm_vac.executeUpdate("INSERT INTO t_urlaub_krankheit VALUES ('"+uk_ID+"', '"+persNr+"', '"+start+"', '"+end+"', '"+sick_i+"', '"+acceptet_i+"')");
				
				Logging.writeActlog("AVC001", persNr);
				
		} catch (SQLException  e) {
			System.out.println(e);
			Logging.writeErrlog("EVC001", persNr, e);
		}
	}
	
	// Funktion zum löschen eines Nutzers
	public static void delete_user(int persNr) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_loeschen = con.createStatement();
			stm_loeschen.executeUpdate("DELETE FROM t_urlaub_krankheit WHERE PersNr = "+persNr+"");
			stm_loeschen.executeUpdate("DELETE FROM t_zugaenge WHERE PersNr = "+persNr+"");
			stm_loeschen.executeUpdate("DELETE FROM t_vertragsdaten WHERE PersNr = "+persNr+"");
			stm_loeschen.executeUpdate("DELETE FROM t_mitarbeiter WHERE PersNr = "+persNr+"");
			
			Logging.writeActlog("AUS003", persNr);
			
		} catch (SQLException  e) {
			System.out.println(e);
			Logging.writeErrlog("EUS003", persNr, e);
		}
	}
	
	// Funktion zum aulesen eines Wertes aus der Datenbank als String
	public static String read_str_value(String table, String value, int persNr) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_wert_auslesen = con.createStatement();
			ResultSet rs_wert = stm_wert_auslesen.executeQuery("SELECT "+value+" FROM "+table+" WHERE PersNr='"+persNr+"';");
			while (rs_wert.next()) {
				Logging.writeActlog("ADB001", persNr);
			}
			
			return "Fehler";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "Fehler";
		}
	}
	// Funktion zum aulesen eines Wertes aus der Datenbank als Integer Value
	public static int read_int_value(String table, String value, int persNr) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_wert_auslesen = con.createStatement();
			ResultSet rs_wert = stm_wert_auslesen.executeQuery("SELECT "+value+" FROM "+table+" WHERE PersNr='"+persNr+"';");
			while (rs_wert.next()) {
				return rs_wert.getInt(value);
			}
			return -1;
		} catch (SQLException  e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	// Funktion zum ändern eines Wertes
	public static void value_update(String table, String collum, String value, int persNr) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_update = con.createStatement();
			stm_update.executeUpdate("UPDATE "+table+" SET "+collum+" = '"+value+"' WHERE PersNr = "+persNr+";");
			
			Logging.writeActlog("AUS002", persNr);
			
		} catch (SQLException  e) {
			System.out.println(e);
			Logging.writeErrlog("EUS002", persNr, e);
		} 
	}
	
	//	Funktion zum auslesen einer kompletten Tabelle und weitergeben dieser als "ResultSet" Objekt
	public static ResultSet read_table(String table) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_tabelle_auslesen = con.createStatement();
		
			ResultSet rs_tabelle = stm_tabelle_auslesen.executeQuery("SELECT * FROM "+table+";");
			Logging.writeActlog("ADB001", 0);
			return rs_tabelle;
			
		} catch (SQLException  e) {
			System.out.println(e);
			Logging.writeErrlog("EDB001", 0, e);
			return null;
		}
	}
	
	//	Funktion zum löschen eines Urlaubs aus der Datenbank
	public static boolean deleteAbsence(int absenceID) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_delete = con.createStatement();
			stm_delete.executeUpdate("DELETE FROM t_urlaub_krankheit WHERE UK_ID = "+absenceID+";");
			Logging.writeActlog("AVC004", absenceID);
			return true;

		} catch (SQLException  e) {
			System.out.println(e);
			Logging.writeErrlog("EVC004", absenceID, e);
			return false;
		}
	}
	
	// Funktion welche in der Datenbank anpasst wenn der Urlaub angenommen wurde
	public static boolean acceptVacation(int absenceID) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_update = con.createStatement();
			stm_update.executeUpdate("UPDATE t_urlaub_krankheit SET genemigt = 1 WHERE UK_ID = "+absenceID+";");
			Logging.writeActlog("AVC002", absenceID);
			return true;
			
		} catch (SQLException  e) {
			System.out.println(e);
			Logging.writeErrlog("EVC002", absenceID, e);
			return false;
		}
	}
	

}
