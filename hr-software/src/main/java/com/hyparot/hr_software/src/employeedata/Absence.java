package com.hyparot.hr_software.src.employeedata;

public class Absence {
	//Klasse für die Objekte der Abwesenheit (Urlaub und Krankheit)
	
	private int persNr;
	private Date begin;
	private Date end;
	private boolean isIll;
	
	public Absence(int persNr, Date begin, Date end, boolean isIll) {
		this.setPersNr(persNr);
		this.setBegin(begin);
		this.setEnd(end);
		this.setVac(isIll);
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

	public boolean isIll() {
		return isIll;
	}

	public void setVac(boolean isIll) {
		this.isIll = isIll;
	}
	
	public int getAbsenceDuration() {
		return Date.getVacDays(this.begin, this.end);
	}
	
	public String toString() {
		return ("\nAbsent from " + this.begin.toString() + " till " + this.end.toString());
	}
}
