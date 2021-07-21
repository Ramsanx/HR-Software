package com.hyparot.hr_software.src.employeedata;


public class Absence {
	//Klasse für die Objekte der Abwesenheit (Urlaub und Krankheit)
	
	private int persNr;
	private int absenceID;
	private Date begin;
	private Date end;
	private boolean isSick;
	private boolean isAccepted = false;
	
	public Absence(int persNr, Date begin, Date end, boolean isSick) {
		this.setPersNr(persNr);
		this.setBegin(begin);
		this.setEnd(end);
		this.setSick(isSick);
	}

	public void setIsAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	
	public boolean getIsAccepted() {
		return isAccepted;
	}
	
	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getPersNr() {
		return persNr;
	}

	public void setPersNr(int persNr) {
		this.persNr = persNr;
	}

	public int getAbsenceID() {
		return absenceID;
	}

	public void setAbsenceID(int absenceID) {
		this.absenceID = absenceID;
	}

	public boolean isSick() {
		return isSick;
	}

	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}
	
	public int getAbsenceDuration() {
		return Date.getVacDays(this.begin, this.end);
	}
	
	public String toString() {
		return ("\nAbsent from " + this.begin.toString() + " till " + this.end.toString());
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	
	public boolean isOverlapping(Absence abs) {
		if(this.getBegin().compare(abs.getEnd()) == 1 || this.getEnd().compare(abs.getBegin()) == -1) {
			return false;
		}else {
			return true;
		}
	}
}
