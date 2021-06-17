package com.hyparot.hr_software.src.backend;

import java.io.File;
import java.util.*;

public class Logging {
	
	public static void main (String[] args) {
		writeActlog("AU001", 1234);
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
			
			switch (event) {
				case "AU001": 
					massage = today + event + "Ein neuer Benutzer mit der Personalnummer "+persNr+" wurde angelegt";
					break;
				case "AU002":
					massage = today + event + "Der Benutzer mit der Personalnummer "+persNr+" wurde bearbeitet";
					break;
				case "AU003":
					massage = today + event + "Der Benutzer mit der Personalnummer "+persNr+" wurde aus dem System entfernt";
					break;
				case "AV001":
					massage = today + event + "Der Benutzer mit der Personalnummer "+persNr+" hat einen neuen Urlaubsantrag gestellt";
					break;
				case "AV002":
					massage = today + event + "Der Urlaubsantrag des Benutzers mit der Personalnummer "+persNr+" wurde erfolgreich an den Vorgesetzten versendet";
					break;
				case "AV003":
					massage = today + event + "Der Urlaubsantrag des Benutzers mit der Personalnummer "+persNr+" wurde vom Vorgesetzen genemigt";
					break;
				case "AV004":
					massage = today + event + "Der Urlaubsantrag des Benutzers mit der Personalnummer "+persNr+" wurde vom Vorgesetzen abgelehnt";
					break;
				
				
				case "ED001":
					massage = today + event + "Es konnte keine Verbindung zur Datenbank hergestellt werden";
					break;
				case "ED002":
					massage = today + event + "Die SQL Syntax hat einen Fehler";
					break;
				
			}
			
		} catch (Exception e) {
			System.out.println("UPS... da ist wohl was falsch gelaufen");
		}
	}
}
