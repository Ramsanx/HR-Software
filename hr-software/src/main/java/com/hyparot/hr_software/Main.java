package com.hyparot.hr_software;

import java.util.Iterator;
import java.util.Vector;

import com.hyparot.hr_software.src.backend.*;
import com.hyparot.hr_software.src.mitarbeiter.Angestellte;




public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BusinessIntellegent.loadDBDataToLocal();
		System.out.println(BusinessIntellegent.getEmployees());
		BusinessIntellegent.createEmployee("HR", "nwulsch", "Passwort", "Niklas", "Wulsch", "Student", "0176", 37, new Datum("2002-03-03"), new Datum("2021-06-15"),
										   new Adresse("Deutschland", 
												       12689,
												       "Berlin", 
												       "Berliner Straße",
												       1,
												   	   "c"));
		Vector<Angestellte> test = BusinessIntellegent.getEmployees();
		Iterator<Angestellte> test2 = test.iterator();
		while(test2.hasNext()) {
			Angestellte nutzer = test2.next();
			if(nutzer.getBenutzername().equals("nwulsch")) {
				nutzer.setEinstellungsDatum(new Datum("2021-06-15"));
			}
		}
		System.out.println(BusinessIntellegent.loadLocalDataToDB());
		
		//BusinessIntellegent.loadDBDataToLocal();
		
		JavaFXLauncher.main(args);
		
		
			
	}

}
