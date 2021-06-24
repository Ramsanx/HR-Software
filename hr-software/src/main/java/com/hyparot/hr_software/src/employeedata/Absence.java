package com.hyparot.hr_software.src.employeedata;

public class Absence {
	//Klasse für die Objekte der Abwesenheit (Urlaub und Krankheit)
	
	private Date begin;
	private Date end;
	private boolean isVac;
	
	public Absence(Date begin, Date end, boolean isVac) {
		this.setBegin(begin);
		this.setEnd(end);
		this.setVac(isVac);
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

	public boolean isVac() {
		return isVac;
	}

	public void setVac(boolean isVac) {
		this.isVac = isVac;
	}
	
	public int getAbsenceDuration() {
		return Date.getVacDays(this.begin, this.end);
	}
	
	public String toString() {
		return ("Absent from " + this.begin.toString() + " till " + this.end.toString());
	}
}
