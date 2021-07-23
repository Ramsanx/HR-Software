package com.hyparot.hr_software.src.backend;

import java.io.File;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Logging {
	
	// Funktionen zum schreiben von Clientaktivitäten in den actlog.txt
	public static void writeActlog(String event, int id) {
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
			
			String massage = null;
			
			//AUS*** Meldungen für Useraktivitäten
			//AVC*** Meldungen für Urlaub
			//ASK*** Meldungen für Krankmeldungen 
			//ADB*** Meldungen für die Datenbank
			
			switch (event) {
				case "AUS001": 
					massage = today + event + " Ein neuer Benutzer mit der Personalnummer "+id+" wurde angelegt";
					break;
				case "AUS002":
					massage = today + event + " Der Benutzer mit der Personalnummer "+id+" wurde bearbeitet";
					break;
				case "AUS003":
					massage = today + event + " Der Benutzer mit der Personalnummer "+id+" wurde aus dem System entfernt";
					break;
				case "AUS004": 
					massage = today + event + " Der benutzer mit der Personalnummer " +id+ " konnte ich erfolgreich anmelden";
					break;
				case "AVC001":
					massage = today + event + " Der Benutzer mit der Personalnummer "+id+" hat einen neuen Urlaubsantrag gestellt";
					break;
				case "AVC002":
					massage = today + event + " Der Urlaubsantrag mit der ID "+id+" wurde vom Vorgesetzen genemigt";
					break;
				case "AVC003":
					massage = today + event + " Der Urlaubsantrag des Benutzers mit der Personalnummer "+id+" wurde vom Vorgesetzen abgelehnt";
					break;
				case "AVC004":
					massage = today + event + " Der Urlaubsantrag mit der ID " + id + " wurde erfolgreich storiert";
					break;
				case "ASK001":
					massage = today + event + " Der Benutzer mit der Personalnummer "+id+" hat eine Krankmeldung eingereicht";
					break;
				case "AZT001":
					massage = today + event + " Der Benutzer mit der Personalnummer "+id+" hat eine Arbeitszeit erfasst";
					break;
				case "ADB001":
					massage = today + event + " Die Datenbank konnte erfolgreich ausgelesen werden";
					break;
						
			}
			FileWriter actlog = new FileWriter("actlog.txt", true);
			actlog.write(massage+"\n");
			actlog.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
		
	
		// Funktionen zum schreiben von Softwarefehlern in den errlog.txt
		public static void writeErrlog(String event, int id, Exception error) {
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
					
					String massage = null;
					
					//EDB*** Fehlermeldungen für die Datenbank
					//EUS*** Fehlermeldungen für die Benutzer
					//EVC*** Fehlermeldungen für Urlaub
					//ESK*** Fehlermeldungen für Krankmeldungen 
					
					switch (event) {
						// Meldungen mit Fehlern
						case "EUS001":
							massage = today + event + " Der Benutzer mit der Personalnummer "+id+" konnte nicht angelegt werden. Exception: " + error.getMessage();
							break;
						case "EUS002":
							massage = today + event + " Beim bearbeiten des Benutzers mit der Personalnummer "+id+" gab es einen Fehler. Exception :" + error.getMessage();
							break;
						case "EUS003":
							massage = today + event + " Beim Löschen des Benutzers mit der Personalnummer "+id+" gab es einen Fehler. Exception " + error.getMessage();
							break;
						case "EVC001":
							massage = today + event + " Beim Urlaubsantrag dem Benutzer mit der Personalnummer "+id+" gab es einen Fehler. Exception " + error.getMessage();
							break;
						case "EVC002":
							massage = today + event + " Beim Bearbeiten des Urlaubsantrages mit der ID " +id+ " gab es einen Fehler. Exception "+ error.getMessage();
							break;
						case "EVC004":
							massage = today + event + " Der Urlaubsantrag mit der ID "+id+" konnte nicht storniert werden. Exception " + error.getMessage();
							break;
						case "EDB001":
							massage = today + event + " Es gab einen Fehler beim aufrufen der Datenbank: Exeption " + error;
							break;
								
					}
					FileWriter actlog = new FileWriter("errlog.txt", true);
					actlog.write(massage+"\n");
					actlog.close();
					
					
				} catch (Exception e) {
					System.out.println(e);
				}
		}


	}

