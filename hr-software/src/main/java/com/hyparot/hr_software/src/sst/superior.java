package com.hyparot.hr_software.src.sst;

import com.hyparot.hr_software.src.employeedata.Absence;

/**
 * dient der Auflistung der nur an/mit Objekten der Klasse Employee ausführbaren Metoden
 */
public interface superior {

	/**
	 * dient dem akzeptieren von Urlaubsanträgen
	 * 
	 * @param vacation the vacation to be accepted
	 * @return true if there is such an vacation and can be accepted, else false
	 */
	public boolean acceptVacation(Absence vacation);
	
	
	
}
