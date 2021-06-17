package com.hyparot.hr_software.src.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db_connect {

	// sobald die Software auf dem Server läuft muss die IP zu "localhost" geändert werden
	static String db_url = "jdbc:mysql://192.168.178.64:3306/hr"; 
	// Logindaten bitte nicht ändern
	static String user = "hr-adm";
	static String pass = "pwd4HR-adm";
	
		
	
	// Main Funktion zum testen
	public static void main(String[] args) {

	}
	
	public static void create_user(int persNr, String firstname, String lastname, String birthday, String street, int houseNr, String housenumberSupplement, String city, int postcode, String country, String phoneNumber, String eMail, String jobTitle,String group, String startDate, int z_ID, String username, String pwd, int uk_ID, int u_tage_gesamt, int ist_Arbeitszeit, boolean krank, int v_Nr, int gehalt, int entgeltabrNr, int a_Stunden){
		try {
			// hier wird eine Verbindung zur Datenbank aufgebaut 
			
			Connection con = DriverManager.getConnection(db_url, user, pass);
		    System.out.println("Verbindung zur Datenbank erfolgreich hergestellt");
		    
		    // hier für ein neues Objekt vom typ Statement damit kann die Datenbank verändert werden erstellt (kann wie beim Scanner mehrmals verwendet werden)
		    Statement stm_anlegen = con.createStatement();
		    		
			stm_anlegen.executeUpdate("INSERT INTO t_mitarbeiter VALUES ('"+persNr+"', '"+firstname+"', '"+lastname+"', '"+birthday+"', '"+street+"', '"+houseNr+"', '"+housenumberSupplement+"', '"+city+"', '"+postcode+"', '"+country+"', '"+phoneNumber+"', '"+eMail+"', '"+jobTitle+"', '"+startDate+"', '"+group+"')");
			stm_anlegen.executeUpdate("INSERT INTO t_zugaenge VALUES ('"+z_ID+"', '"+persNr+"', '"+username+"', '"+pwd+"')");
			stm_anlegen.executeUpdate("INSERT INTO t_urlaub_krankheit VALUES ('"+uk_ID+"', '"+persNr+"', '"+u_tage_gesamt+"', '"+u_tage_gesamt+"', '"+0+"', '"+a_Stunden+"', '"+2+"')");
			stm_anlegen.executeUpdate("INSERT INTO t_vertragsdaten VALUES ('"+v_Nr+"', '"+persNr+"', '"+a_Stunden +"', '"+gehalt+"', '"+entgeltabrNr+"')");
			System.out.println("Benutzer mit der Personalnummer "+persNr+" wurde angelegt");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void delete_user(int persNr) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_loeschen = con.createStatement();
			stm_loeschen.executeUpdate("DELETE FROM t_urlaub_krankheit WHERE PersNr = "+persNr+"");
			stm_loeschen.executeUpdate("DELETE FROM t_zugaenge WHERE PersNr = "+persNr+"");
			stm_loeschen.executeUpdate("DELETE FROM t_vertragsdaten WHERE PersNr = "+persNr+"");
			stm_loeschen.executeUpdate("DELETE FROM t_mitarbeiter WHERE PersNr = "+persNr+"");
			System.out.println("Benutzer mit der Personalnummer "+persNr+" wurde erfolgreich gelöscht");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static String read_str_value(String table, String value, int persNr) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_wert_auslesen = con.createStatement();
			ResultSet rs_wert = stm_wert_auslesen.executeQuery("SELECT "+value+" FROM "+table+" WHERE PersNr='"+persNr+"';");
			while (rs_wert.next()) {
				return rs_wert.getString(value);
			}
			return "Fehler";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "Fehler";
		}
	}
	
	public static void value_update(String tabelle, String spalte, String wert_neu, int persNr) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_update = con.createStatement();
			stm_update.executeUpdate("UPDATE "+tabelle+" SET "+spalte+" = '"+wert_neu+"' WHERE PersNr = "+persNr+"");
			System.out.println("Benutzer mit der Personalnummer "+persNr+" wurde erfolgreich geändert");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
	}
	
// 	public static void db_read_table(String table) {
// 		try {
// 			Connection con = DriverManager.getConnection(db_url, user, pass);
// 			Statement stm_tabelle_auslesen = con.createStatement();
		
// 			ResultSet rs_tabelle = stm_tabelle_auslesen.executeQuery("SELECT * FROM "+table+";");
// 			ResultSetMetaData meta = rs_tabelle.getMetaData();
// //			for(int i = 1; i <= meta.getColumnCount(); i++) {
// //				System.out.println(meta.getColumnLabel(i));
// //			}
			
// 			if (table.equals("t_mitarbeiter")) {
// 				while(rs_tabelle.next()){
	
// 					for (int i=1; i <= meta.getColumnCount(); i++) {
// 						System.out.print(rs_tabelle.getString(i)  + " ");
// 						}
// 					System.out.println("");
// 					}
// 			}
	
			
// 		} catch (SQLException e) {
// 			System.out.println(e.getMessage());
// 		} 
		
// 	}
//	Niklas' Ergänzungen
	public static ResultSet read_table(String table) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_tabelle_auslesen = con.createStatement();
		
			ResultSet rs_tabelle = stm_tabelle_auslesen.executeQuery("SELECT * FROM "+table+";");
			
			return rs_tabelle;
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	public static int read_int_value(String table, String value, int persNr) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_wert_auslesen = con.createStatement();
			ResultSet rs_wert = stm_wert_auslesen.executeQuery("SELECT "+value+" FROM "+table+" WHERE PersNr='"+persNr+"';");
			while (rs_wert.next()) {
				return rs_wert.getInt(value);
			}
			return -1;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

}
