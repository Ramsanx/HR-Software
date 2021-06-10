package com.hyparot.hr_software.src.db;

import java.io.IOException;
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
		
		// anlegen_Benutzer(1235,"Bob", "Baumeister", "1999-12-03", "BaumeisterStraße", 7, "Bauarbeiterhausen", 13591, 5687512, "bob@baumeister.de", "Bauarbeiter", "2015-06-09");
		// System.out.println(wert_auslesen("t_mitarbeiter", "Nachname", 1235));
		wert_update("t_mitarbeiter", "Ort", "Berlin", 1538);
		
		tabelle_auslesen("t_mitarbeiter");
		
	}
	
	public static void anlegen_Benutzer(int persNr, String vorname, String nachname, String geburtsdatum, String Straße, int hausnummer, String ort,int plz, long telefonnummer, String mail, String position, String einstellungsdatum){
		try {
			// hier wird eine Verbindung zur Datenbank aufgebaut 
			Connection con = DriverManager.getConnection(db_url, user, pass);
		    System.out.println("Verbindung zur Datenbank erfolgreich hergestellt");
		    
		    // hier für ein neues Objekt vom typ Statement damit kann die Datenbank verändert werden erstellt (kann wie beim Scanner mehrmals verwendet werden)
		    Statement stm_anlegen = con.createStatement();
		    
			stm_anlegen.executeUpdate("INSERT INTO t_mitarbeiter " + "VALUES ('"+persNr+"', '"+vorname+"', '"+nachname+"', '"+geburtsdatum+"', '"+Straße+"', '"+hausnummer+"', '"+ort+"', '"+plz+"', '"+telefonnummer+"', '"+mail+"', '"+position+"', '"+einstellungsdatum+"')");
			
			System.out.println("Benutzer mit der Personalnummer "+persNr+" wurde angelegt");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void löschen_Benutzer(int persNr) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_loeschen = con.createStatement();
			stm_loeschen.executeUpdate("DELETE FROM t_mitarbeiter WHERE PersNr = "+persNr+"");
			System.out.println("Benutzer mit der Personalnummer "+persNr+" wurde erfolgreich gel�scht");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static String wert_auslesen(String tabelle, String wert, int persNr) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_wert_auslesen = con.createStatement();
			ResultSet rs_wert = stm_wert_auslesen.executeQuery("SELECT "+wert+" FROM "+tabelle+" WHERE PersNr='"+persNr+"';");
			// System.out.println(rs_tabelle);
			String wert_ausgelesen;
			while (rs_wert.next()) {
				return rs_wert.getString(wert);
			}
			return "Fehler";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "Fehler";
		}
	}
	
	public static void wert_update(String tabelle, String spalte, String wert_neu, int persNr) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_update = con.createStatement();
			stm_update.executeUpdate("UPDATE "+tabelle+" SET "+spalte+" = '"+wert_neu+"' WHERE PersNr = "+persNr+"");
			System.out.println("Benutzer mit der Personalnummer "+persNr+" wurde erfolgreich geändert");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void tabelle_auslesen(String tabelle) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_tabelle_auslesen = con.createStatement();
			
			ResultSet rs_tabelle = stm_tabelle_auslesen.executeQuery("SELECT * FROM "+tabelle+";");
			
			if (tabelle.equals("t_mitarbeiter")) {
				while(rs_tabelle.next()){
					for (int i=1; i<=12; i++) {
						System.out.print(rs_tabelle.getString(i)  + " ");
						}
					System.out.println("");
					}
			}
	
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
// Eriks Testzeilen bitte erstmal nicht löschen
	
//	 // So lest ihr die Inhalte aus der DB aus
//	ResultSet rs_test = stm.executeQuery("SELECT * FROM t_mitarbeiter;");
//	
//	while(rs_test.next()){
//		for (int i=1; i<=11; i++) {
//			System.out.print(rs_test.getString(i)  + " ");
//			}
//		System.out.println("");
//		}
	// Hiermit löscht ihr einen Eintrag
	 //stm.executeUpdate("DELETE FROM t_mitarbeiter WHERE PersNr = 1254");
	// Hiermit könnt ihr einen neuen Mittarbeiter anlegen (der muss immer als erstes erstellt werden, danach erst Vertrag, Zugang usw.)
			// In dem Schema fügt ihr etwas ein: (PersNr, Vorname, Nachname, Geburtsdatum, Straße, Hausnummer, PLZ, Telefonnummer, Mail, Position, Einstellungsdatum)
	 //stm.executeUpdate("INSERT INTO t_mitarbeiter " + "VALUES (1254, 'Dominik', 'Lau', '2001-05-01', 'Straße', 7, 12354, 123547856, 'lau@bla', 'Knecht', '2021-04-01')");
	 //stm.executeUpdate("INSERT INTO t_mitarbeiter " + "VALUES (1538, 'Radsam', 'Dadiev', '2001-05-31', 'Straße', 9, 12444, 636954, 'ramzan@bla', 'Doktor', '2021-04-02')");

}
