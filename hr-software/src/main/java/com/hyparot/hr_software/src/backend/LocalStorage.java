package com.hyparot.hr_software.src.backend;

import java.util.Vector;

import com.hyparot.hr_software.src.employee.Employee;

import java.util.Hashtable;

/**
 * diese Klasse dient als lokaler Speicher 
 */
public class LocalStorage {

	/**
	 * Funktion: lokaler Speicher aller Angestellten
	 */
	public static Vector<Employee> employees = new Vector<Employee>();
	
	/**
	 * Funktion: lokaler Speicher aller vorgenommenen Änderungen die in die Datenbank übertragen werden müssen
	 */
	private static Hashtable<Integer, String> changes = new Hashtable<Integer, String>();
	
	
	/**
	 * dient dem Hinzufügen eines Angestellten zum lokalen Speicher
	 * 
	 * @param employee the employee to be added
	 * @return true if it was possible to add, else false
	 */
	protected static boolean addToEmployees(Employee employee) {
		return employees.add(employee);
	}
	
	
	/**
	 * dient dem Entfernen eines Angestllten aus dem lokalen Speicher
	 * 
	 * @param employee
	 * @return
	 */
	protected static boolean removeFromEmployees(Employee employee) {
		return employees.remove(employee);
	}
	
	
	/**
	 * dient dem Hinzufügen des Vermerks einer vorgenommenen Änderung
	 * 
	 * @param persNr the persNr of the employee which was changed (persNr is used as key)
	 * @param change the type of change which was performed ("created", "changed", "deleted" or "workingTimeChange")
	 */
	protected static void addToChanges(int persNr, String change) {
		changes.put(persNr, change);
	}
	
	
	/**
	 * dient dem Entfernen einer Änderungsbenachrichtigung
	 * 
	 * @param persNr the key of the change message 
	 * @return true if such a key existed, else false
	 */
	protected static boolean removeFromChanges(int persNr) {
		if(changes.containsKey(persNr)) {
			changes.remove(persNr);
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 * dient dem Auslesen aller lokal gespeicherter Angestellten
	 * 
	 * @return Vector<Employee> with all local stored employees
	 */
	protected static Vector<Employee> getStorage() {
		return employees;
	}
	
	
	/**
	 * dient dem Auslesen aller vorgenommenen und noch nicht gelöschten Änderungen
	 * 
	 * @return Hashtable<Integer, String> (<persNr, type of change>) 
	 */
	protected static Hashtable<Integer, String> getChangeTable(){
		return changes;
	}
	
	
	
}
