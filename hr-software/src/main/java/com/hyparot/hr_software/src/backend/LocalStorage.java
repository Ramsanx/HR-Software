package com.hyparot.hr_software.src.backend;

import java.util.Vector;
import java.util.Hashtable;
import com.hyparot.hr_software.src.mitarbeiter.Employee;


public class LocalStorage {

	private static Vector<Employee> employees = new Vector<Employee>();
	private static Hashtable<Integer, String> changes = new Hashtable<Integer, String>();
	
	protected static boolean addToEmployees(Employee employee) {
		return employees.add(employee);
	}
	
	
	protected static boolean removeFromEmployees(Employee employee) {
		return employees.remove(employee);
	}
	
	
	protected static void addToChanges(int persNr, String change) {
		changes.put(persNr, change);
	}
	
	
	protected static boolean removeFromChanges(int persNr) {
		if(changes.containsKey(persNr)) {
			changes.remove(persNr);
			return true;
		}else {
			return false;
		}
	}
	
	
	protected static Vector<Employee> getStorage() {
		return employees;
	}
	
	
	protected static Hashtable<Integer, String> getChangeTable(){
		return changes;
	}
	
	
	
}
