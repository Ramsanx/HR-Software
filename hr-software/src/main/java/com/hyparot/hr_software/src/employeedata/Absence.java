package com.hyparot.hr_software.src.employeedata;

/*
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
	 * @param persNr
	 * @param begin
	 * @param end
	 * @param isSick
	 */
	public Absence(int persNr, Date begin, Date end, boolean isSick) {
		this.setPersNr(persNr);
		this.setBegin(begin);
		this.setEnd(end);
		this.setSick(isSick);
	}
	
	/**
	 * dient dem Abruf des Parameters begin
	 * 
	 * @return
	 */
	public Date getBegin() {
		return begin;
	}

	/**
	 * dient der Manipulation des Parameters begin
	 * 
	 * @param begin
	 */
	public void setBegin(Date begin) {
		this.begin = begin;
	}

	/**
	 * dient dem Abruf des Parameters end
	 * 
	 * @return
	 */
	public Date getEnd() {
		return end;
	}

	/**
	 * dient der Manipulation des Parameters end
	 * 
	 * @param end
	 */
	public void setEnd(Date end) {
		this.end = end;
	}

	/**
	 * dient dem Abruf des Parameters persNr
	 * 
	 * @return
	 */
	public int getPersNr() {
		return persNr;
	}

	/**
	 * dient der Manipulation des Parameters persNr
	 * 
	 * @param persNr
	 */
	private void setPersNr(int persNr) {
		this.persNr = persNr;
	}

	/**
	 * dient dem Abruf des Parameters absenceId
	 * 
	 * @return
	 */
	public int getAbsenceID() {
		return absenceID;
	}

	/**
	 * dient der Manipulation des Parameters absenceId
	 * 
	 * @param absenceID
	 */
	public void setAbsenceID(int absenceID) {
		this.absenceID = absenceID;
	}

	/**
	 * dient dem Abruf des Parameters isSick
	 * 
	 * @return
	 */
	public boolean isSick() {
		return isSick;
	}

	/**
	 * dient der Manipulation des Parameters isSick
	 * 
	 * @param isSick
	 */
	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}
	
	/**
	 * dient dem Abruf der Dauer einer Abwesenheit (Differenz zwischen begin und end)
	 * 
	 * @return
	 */
	public int getAbsenceDuration() {
		return Date.getVacDays(this.begin, this.end);
	}
	
	/**
	 * dient der Wiedergabe einer String-Repräsentation des Objektes
	 */
	public String toString() {
		return ("\nAbsent from " + this.begin.toString() + " till " + this.end.toString());
	}

	/**
	 * dient dem Abruf des Parameters isAccepted
	 * 
	 * @return
	 */
	public boolean isAccepted() {
		return isAccepted;
	}

	/**
	 * dient der Manipulation des Parameters isAccepted
	 * 
	 * @param isAccepted
	 */
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	
	/**
	 * dient der Manipulation des Parameters begin
	 * 
	 * @param abs
	 * @return
	 */
	public boolean isOverlapping(Absence abs) {
		if(this.getBegin().compare(abs.getEnd()) == 1 || this.getEnd().compare(abs.getBegin()) == -1) {
			return false;
		}else {
			return true;
		}
	}
}
