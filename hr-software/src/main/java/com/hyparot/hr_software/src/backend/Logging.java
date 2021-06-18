package com.hyparot.hr_software.src.backend;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Logging {
	
	public static void main (String[] args) {
		writeActlog("AUS002", 1234);
	}
	public static void writeActlog(String event, int persNr) {
		try {
			Calendar c = new GregorianCalendar();
			String minute = null;
			if(c.get(Calendar.MINUTE)<10) {
				minute =  "0"+String.valueOf(c.get(Calendar.MINUTE));
			}
			else {
				minute =  String.valueOf(c.get(Calendar.MINUTE));
			}
			
			String today = String.valueOf(c.get(Calendar.YEAR))+"-"+String.valueOf(c.get(Calendar.MONTH)+1)+"-"+String.valueOf(c.get(Calendar.DAY_OF_MONTH))+" ("+String.valueOf(c.get(Calendar.HOUR_OF_DAY))+":"+minute+"): ";
			// System.out.println(today);
			
			String massage = null;
			
			//AUS*** Meldungen für Useraktivitäten
			//AVC*** Meldungen für Urlaub
			//ASK*** Meldungen für Krankmeldungen 
			
			switch (event) {
				// Meldungen mit Aktivitäten
				case "AUS001": 
					massage = today + event + " Ein neuer Benutzer mit der Personalnummer "+persNr+" wurde angelegt";
					break;
				case "AUS002":
					massage = today + event + " Der Benutzer mit der Personalnummer "+persNr+" wurde bearbeitet";
					break;
				case "AUS003":
					massage = today + event + " Der Benutzer mit der Personalnummer "+persNr+" wurde aus dem System entfernt";
					break;
				case "AVC001":
					massage = today + event + " Der Benutzer mit der Personalnummer "+persNr+" hat einen neuen Urlaubsantrag gestellt";
					break;
				case "AVC002":
					massage = today + event + " Der Urlaubsantrag des Benutzers mit der Personalnummer "+persNr+" wurde an den Vorgesetzten versendet";
					break;
				case "AVC003":
					massage = today + event + " Der Urlaubsantrag des Benutzers mit der Personalnummer "+persNr+" wurde vom Vorgesetzen genemigt";
					break;
				case "AVC004":
					massage = today + event + " Der Urlaubsantrag des Benutzers mit der Personalnummer "+persNr+" wurde vom Vorgesetzen abgelehnt";
					break;
				case "ASK001":
					massage = today + event + " Der Benutzer mit der Personalnummer "+persNr+" hat eine Krankmeldung eingereicht";
					break;
				case "AZT001":
					massage = today + event + " Der Benutzer mit der Personalnummer "+persNr+" hat eine Arbeitszeit erfasst";
				
				// Meldungen mit Fehlern
				case "EDB001":
					massage = today + event + " Der Benutzer mit der Personalnummer "+persNr+" konnte keine Verbindung zur Datenbank aufbauen";
					break;
				case "EDB002":
					massage = today + event + " Bei der Eingabe des Benutzers mit der Personalnummer "+persNr+" war ungültig mit der SQL Syntax";
					break;
				case "EDB003":
					massage = today + event + " Bei der Verbindung mit der Datenbank des Nutzers "+persNr+ " gab es einen Fehler";
					break;
						
			}
			FileWriter actlog = new FileWriter("actlog.txt", true);
			actlog.write(massage+"\n");
			actlog.close();
			
			if (event.substring(0,1).equals("E")) {
				FileWriter errlog = new FileWriter("errlog.txt", true);
				errlog.write(massage+"\n");
				errlog.close();
			}
			
			
		} catch (Exception e) {
			System.out.println("UPS... da ist wohl was falsch gelaufen");
		}
	}
}
