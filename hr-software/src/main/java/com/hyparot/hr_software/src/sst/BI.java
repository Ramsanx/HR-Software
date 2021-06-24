package com.hyparot.hr_software.src.sst;

import com.hyparot.hr_software.src.employee.Employee;
import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Date;

public interface BI {
	
	public static Employee getEmployeeByName(String username) {
		return null;
	};
	
	public static Employee getEmployeeByID(int persNr) {
		return null;
	};
	
	
	private static int findHighestPersNr() {
		return 0;
	};
	
}
