package com.hyparot.hr_software.src.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
		//anlegen_Benutzer(2000, "Niklas", "Wulsch", "2002-03-03", "Berliner Straße", 1, "c", "Berlin", 12689, "Deutschland", "0176...", "nwulsch@unsere-firma.de", "Student", "HR", "2021-06-14");
		anlegen_Benutzer(1536, "Max", "Mustermann", "2000-02-20", "Musterstraße", 7, "-", "Musterhausen", 10365, "Musterland", "+49 306524685", "m.mustermann@mail.de", "CEO", "Vorgesetzter", "2020-05-06", 1569, "mamu", "123456", 12856, 30, 140, 12568, 6000, 5896);  
		anlegen_Benutzer(1537, "Erik", "Mustermann", "2000-04-20", "Musterstraße", 7, "-", "Musterhausen", 10365, "Musterland", "+49 306524696", "e.mustermann@mail.de", "HR-Agent", "HR", "2020-06-06", 1570, "ermu", "123456", 12857, 30, 140, 12569, 6000, 5897);  
		//wert_update("t_mitarbeiter", "Gruppe", "HR", 2000);
		
		
		tabelle_auslesen("t_mitarbeiter");
		tabelle_auslesen("t_zugaenge");
		
	}
	
	public static void anlegen_Benutzer(int persNr, String vorname, String nachname, String geburtsdatum, String Straße, int hausnummer, String hausnummernzusatz, String ort, int plz, String land, String telefonnummer, String mail, String position,String gruppe, String einstellungsdatum, int z_ID, String nutzername, String pwd, int uk_ID, int u_tage_gesamt, int ist_Arbeitszeit, int v_Nr, int gehalt, int entgeltabrNr){
		try {
			// hier wird eine Verbindung zur Datenbank aufgebaut 
			
			Connection con = DriverManager.getConnection(db_url, user, pass);
		    System.out.println("Verbindung zur Datenbank erfolgreich hergestellt");
		    
		    // hier für ein neues Objekt vom typ Statement damit kann die Datenbank verändert werden erstellt (kann wie beim Scanner mehrmals verwendet werden)
		    Statement stm_anlegen = con.createStatement();
		    
			stm_anlegen.executeUpdate("INSERT INTO t_mitarbeiter VALUES ('"+persNr+"', '"+vorname+"', '"+nachname+"', '"+geburtsdatum+"', '"+Straße+"', '"+hausnummer+"', '"+hausnummernzusatz+"', '"+ort+"', '"+plz+"', '"+land+"', '"+telefonnummer+"', '"+mail+"', '"+position+"', '"+einstellungsdatum+"', '"+gruppe+"')");
			stm_anlegen.executeUpdate("INSERT INTO t_zugaenge VALUES ('"+z_ID+"', '"+persNr+"', '"+nutzername+"', '"+pwd+"')");
			stm_anlegen.executeUpdate("INSERT INTO t_urlaub_krankheit ('"+uk_ID+"', '"+persNr+"', '"+u_tage_gesamt+"', '"+u_tage_gesamt+"', '"+0+"', '"+ist_Arbeitszeit+"', '"+false+"')");
			stm_anlegen.executeUpdate("INSERT INTO t_vertragsdaten ('"+v_Nr+", '"+persNr+"', '"+gehalt+"', '"+entgeltabrNr+"')");
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
			ResultSetMetaData meta = rs_tabelle.getMetaData();
//			for(int i = 1; i <= meta.getColumnCount(); i++) {
//				System.out.println(meta.getColumnLabel(i));
//			}
			
			if (tabelle.equals("t_mitarbeiter")) {
				while(rs_tabelle.next()){
	
					for (int i=1; i <= meta.getColumnCount(); i++) {
						System.out.print(rs_tabelle.getString(i)  + " ");
						}
					System.out.println("");
					}
			}
	
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		
	}
//	Niklas' Ergänzungen
	public static ResultSet read_table(String tabelle) {
		try {
			Connection con = DriverManager.getConnection(db_url, user, pass);
			Statement stm_tabelle_auslesen = con.createStatement();
		
			ResultSet rs_tabelle = stm_tabelle_auslesen.executeQuery("SELECT * FROM "+tabelle+";");
			
			return rs_tabelle;
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
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
