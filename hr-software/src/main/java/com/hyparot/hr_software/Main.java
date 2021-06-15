package com.hyparot.hr_software;

//import java.util.Iterator;
//import java.util.Vector;
import java.util.Scanner;
import com.hyparot.hr_software.src.backend.*;
//import com.hyparot.hr_software.src.mitarbeiter.Angestellte;




public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BusinessIntellegent.loadDBDataToLocal();
		
		Scanner eingabe = new Scanner(System.in);
		
		System.out.print("Geben Sie ihren Vornamen ein: ");
		String Vorname = eingabe.next();
		
		System.out.print("\n\nGeben Sie ihren Nachnamen ein: ");
		String Nachname = eingabe.next();
		
		System.out.print("\n\nGeben Sie ihren Benutzernamen ein: ");
		String Benutzername = eingabe.next();
		
		System.out.print("\n\nGeben Sie ihr Passwort ein: ");
		String Passwort = eingabe.next();
		eingabe.close();
		
		BusinessIntellegent.createEmployee("HR", Benutzername, Passwort, Vorname, Nachname, "Dozent", "017633620", 37, new Datum("2009-04-01"), new Datum("2021-06-16"),
										   new Adresse("Deutschland", 
												       10315,
												       "Berlin", 
												       "Alt-Friedrichsfelde",
												       60,
												   	   ""));
		
		System.out.println(BusinessIntellegent.getEmployees().get(BusinessIntellegent.getEmployees().size()-1));
		BusinessIntellegent.loadLocalDataToDB();
		

		
		JavaFXLauncher.main(args);
		
		
			
	}

}
