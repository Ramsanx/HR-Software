package com.hyparot.hr_software;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.hyparot.hr_software.src.backend.*;
import com.hyparot.hr_software.src.mitarbeiter.Adress;
import com.hyparot.hr_software.src.mitarbeiter.Date;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String[] optionen = {"Programm starten", "neuen Nutzer anlegen und Programm starten"};
//		
//		int Fenster = JOptionPane.showOptionDialog(null, "Wähle eine Option aus", "Auswahlfesnter", JOptionPane.OK_CANCEL_OPTION,
//								     JOptionPane.PLAIN_MESSAGE, null, optionen, optionen[0]);
//		
//		if(Fenster == JOptionPane.OK_OPTION){
//			
//			BusinessIntellegent.loadDBDataToLocal();
//			JavaFXLauncher.main(args);
//			
//		}else {
//			
//			BusinessIntellegent.loadDBDataToLocal();
//		
//			Scanner eingabe = new Scanner(System.in);
//		
//			System.out.print("Geben Sie ihren Vornamen ein: ");
//			String Vorname = eingabe.next();
//		
//			System.out.print("\n\nGeben Sie ihren Nachnamen ein: ");
//			String Nachname = eingabe.next();
//		
//			System.out.print("\n\nGeben Sie ihren Benutzernamen ein: ");
//			String Benutzername = eingabe.next();
//		
//			System.out.print("\n\nGeben Sie ihr Passwort ein: ");
//			String Passwort = eingabe.next();
//			eingabe.close();
//		
//			BusinessIntellegent.createEmployee("HR", Benutzername, Passwort, Vorname, Nachname, "Dozent", "017612345678", 37, 
//										   	   new Date("2009-04-01"), new Date("2021-06-16"),
//										   	   new Adress("Deutschland", 
//										   			   	   10315,
//										   			   	   "Berlin", 
//										   			   	   "Alt-Friedrichsfelde",
//										   			   	   60,
//												   	   	   ""));
//		
//			System.out.println(BusinessIntellegent.getEmployees().get(BusinessIntellegent.getEmployees().size()-1));
//			
//			BusinessIntellegent.loadLocalDataToDB();
			SystemDBConnector.loadDBDataToLocal();
			JavaFXLauncher.main(args);
//		}

			
	}

}
