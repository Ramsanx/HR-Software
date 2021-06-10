package com.hyparot.hr_software;

import java.util.Calendar;

import com.hyparot.hr_software.src.backend.BusinessIntellegent;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar Geburtstag = null;
		Calendar Ein = null;
		
		BusinessIntellegent.createMitarbeiter("nwulsch", "p", "jan", "Wulsch", "msp-t", "Student",
				0176, 37, 
				 Geburtstag, Ein,
				null,
				null);
		
		JavaFXLauncher.main(args);
		
		

	}

}
