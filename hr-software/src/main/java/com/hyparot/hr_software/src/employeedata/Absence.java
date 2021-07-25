package com.hyparot.hr_software.src.employeedata;

/**
 * Klasse für die Objekte der Abwesenheit (Urlaub und Krankheit)
 */
public class Absence {
	
	private int persNr;
	private int absenceID;
	private Date begin;
	private Date end;
	private boolean isSick;
	private boolean isAccepted = false;
	
	
	/**
	 * dient der Konstruktion eines Objektes
	 * 
	 * @param persNr the persNr of the person for which the absence is
	 * @param begin the begin of the absence
	 * @param end the end of the absence
	 * @param isSick the reason for the absence (true for illness, false for everything else)
	 */
	public Absence(int persNr, Date begin, Date end, boolean isSick) {
		this.setPersNr(persNr);
		this.setBegin(begin);
		this.setEnd(end);
		this.setSick(isSick);
	}
	
	/**
	 * dient dem Abruf der Variablen begin
	 * 
	 * @return the begin of the Absence
	 */
	public Date getBegin() {
		return begin;
	}

	/**
	 * dient der Manipulation der Variablen begin
	 * 
	 * @param begin the begin to set
	 */
	public void setBegin(Date begin) {
		this.begin = begin;
	}

	/**
	 * dient dem Abruf der Variablen end
	 * 
	 * @return the end of the Absence
	 */
	public Date getEnd() {
		return end;
	}

	/**
	 * dient der Manipulation der Variablen end
	 * 
	 * @param end the end to set
	 */
	public void setEnd(Date end) {
		this.end = end;
	}

	/**
	 * dient dem Abruf der Variablen persNr
	 * 
	 * @return the persNr of the person for which the absence is
	 */
	public int getPersNr() {
		return persNr;
	}

	/**
	 * dient der Manipulation der Variablen persNr
	 * 
	 * @param persNr the persNr to set
	 */
	private void setPersNr(int persNr) {
		this.persNr = persNr;
	}

	/**
	 * dient dem Abruf der Variablen absenceId
	 * 
	 * @return the absenceID (the unique ID of the object)
	 */
	public int getAbsenceID() {
		return absenceID;
	}

	/**
	 * dient der Manipulation der Variablen absenceId
	 * 
	 * @param absenceID the absenceID to set
	 */
	public void setAbsenceID(int absenceID) {
		this.absenceID = absenceID;
	}

	/**
	 * dient dem Abruf der Variablens isSick
	 * 
	 * @return isSick (reason for absence (true for illness, false for everything else))
	 */
	public boolean isSick() {
		return isSick;
	}

	/**
	 * dient der Manipulation der Variablen isSick
	 * 
	 * @param isSick the sick status to set
	 */
	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}
	
	/**
	 * dient dem Abruf der Dauer einer Abwesenheit (Differenz zwischen begin und end)
	 * 
	 * @return the duration of the object (duration = days between start and end)
	 */
	public int getAbsenceDuration() {
		return Date.getVacDays(this.begin, this.end);
	}
	
	/**
	 * dient der Wiedergabe einer String-Repräsentation des Objektes
	 * 
	 * @return a string reference of the object
	 */
	public String toString() {
		return ("\nAbsent from " + this.begin.toString() + " till " + this.end.toString());
	}

	/**
	 * dient dem Abruf der Variablen isAccepted
	 * 
	 * @return the acceptance status of the absence
	 */
	public boolean isAccepted() {
		return isAccepted;
	}

	/**
	 * dient der Manipulation der Variablen isAccepted
	 * 
	 * @param isAccepted the acceptance status to set
	 */
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	
	/**
	 * testet ob sich zwei Objekte dieser Klasse zeitlich überschneiden
	 * 
	 * @param abs the absence object with which this is to be aligned
	 * @return true if the absences overlap, else false
	 */
	public boolean isOverlapping(Absence abs) {
		if(this.getBegin().compare(abs.getEnd()) == 1 || this.getEnd().compare(abs.getBegin()) == -1) {
			return false;
		}else {
			return true;
		}
	}
}
