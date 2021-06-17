package com.hyparot.hr_software.src.backend;

import java.io.File;
import java.util.*;

public class Logging {
	
	public static void main (String[] args) {
		writeActlog("AU001", 1234);
	}
	public static void writeActlog(String event, int PersNr) {
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
			System.out.println(today);
			
		} catch (Exception e) {
			System.out.println("UPS... da ist wohl was falsch gelaufen");
		}
	}
}
