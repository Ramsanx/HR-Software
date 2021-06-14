package com.hyparot.hr_software;

import com.hyparot.hr_software.src.backend.*;




public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Datum Geburtstag = new Datum(2002, 3, 3);
		Datum Ein = new Datum(2021, 14, 6);
		
		Adresse Ort = new Adresse("Deutschland", 10315, "Berlin", "Alt-Friedrichsfelde", 60);
		
		// Stellung, Benutzername, Passwort, Vorname, Nachname, Gruppenbezeichnung, Stellenbezeichnung, 
		// Telefonnummer, SollArbeitszeit, Geburtstag, Einstellungsdatum, Adresse, Vertrag (if Adress == null){Vertrag == null}
		BusinessIntellegent.createEmployee("HR", "nwulsch", "*NaLosTippSchon", "Niklas", "Wulsch", "msp-t", "Student",
											"01761111111", 37, Geburtstag, Ein, Ort);
		System.out.println((BusinessIntellegent.getEmployeeByName("nwulsch")));
		System.out.println(BusinessIntellegent.getEmployeeByName("nwulsch").getAdresse());
		JavaFXLauncher.main(args);
		
		

	}

}
