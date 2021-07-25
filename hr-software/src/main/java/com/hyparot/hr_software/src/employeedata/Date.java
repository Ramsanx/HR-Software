package com.hyparot.hr_software.src.employeedata;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Klasse für die im Programm verwendeten Daten (Daten als Mehrzahl von Datum ((Jahr-Monat-Tag))
 */
public class Date {

	private int year;
	private int month;
	private int day;
	
	/**
	 * dient der Erstellung eines Objektes dieser Klasse
	 * 
	 * @param year 
	 * @param month
	 * @param day
	 */
	public Date(int year, int month, int day) {
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
	}
	
	/**
	 * dient der Erstellung eines Objektes dieser Klasse
	 * 
	 * @param date (in the format year-month-day)
	 */
	public Date(String date) {
		String[] parts = date.split("-");
		this.setYear(Integer.parseInt(parts[0]));
		this.setMonth(Integer.parseInt(parts[1]));
		this.setDay(Integer.parseInt(parts[2]));
	}
	
	/**
	 * dient der Abfrage der Variablen year
	 * 
	 * @return the year 
	 */
	public int getYear() {
		return year;
	}

	/**
	 * dient der Manipulation der Variablen year
	 * 
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}


	/**
	 * dient der Abfrage der Variablen month
	 * 
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}


	/**
	 * dient der Manipulation der Variablen month
	 * 
	 * @param month the month to set (1-12)
	 */
	public void setMonth(int month) {
		this.month = month;
	}


	/**
	 * dient der Abfrage der Variablen day
	 * 
	 * @return the day 
	 */
	public int getDay() {
		return day;
	}


	/**
	 * dient der Manipulation der Variablen day
	 * 
	 * @param day the day to set (1-31)
	 */
	public void setDay(int day) {
		this.day = day;
	}
	
	/**
	 * dient der Abfrage der Variablen
	 * 
	 * @return an object of these class for today's date
	 */
	public static Date getToday() {
		return new Date(LocalDateTime.now().toString().substring(0, 10));
	}
	
	/**
	 * dient der Abfrage der Variablen
	 * 
	 * @param daysFromNow the number of days the date lies in the future
	 * @return an object of these class for a date daysFromNow in the future
	 */
	public static Date getFutureDate(long daysFromNow) {
		return new Date(LocalDateTime.now().plusDays(daysFromNow).toString().substring(0, 10));
	}
	
	/**
	 * dient der Abfrage einer String Repräsentation dieses Objektes
	 *
	 * @return a string reference of the object
	 */
	public String toString() {
		if(getMonth() < 10 && getDay() < 10) {
			return (getYear() + "-" + "0" + getMonth() + "-" + "0" + getDay());
		}else if(getMonth() >= 10 && getDay() < 10) {
			return (getYear() + "-" + getMonth() + "-" + "0" + getDay());
		}else if(getMonth() < 10 && getDay() >= 10) {
			return (getYear() + "-" + "0" + getMonth() + "-" + getDay());
		}
		return (getYear() + "-" + getMonth() + "-" + getDay());
	}

	/**
	 * dient der Überprüfung, ob es sich bei dem Datum dieses Objektes um einen Werktag handelt
	 * 
	 * @return true if the date of these object is a weekday (monday - friday), else false
	 */
	public boolean isWeekday () {
		
		GregorianCalendar date_g = new GregorianCalendar(this.getYear(), this.getMonth(), this.getDay());
		int weekday = date_g.get(Calendar.DAY_OF_WEEK);
		if (weekday == 2 || weekday == 3) {
			return false;
		}
		else {
		 	return true;
		}
	}

	/**
	 * dient dem Vergleich zweier Objekte dieser Klasse
	 * 
	 * @param anotherDate the date with which this is to be compared
	 * @return true if the date (of this object) is greater than the date of 'anotherDate', else false
	 */
	public boolean isGreater(Date anotherDate) {
		if(this.year < anotherDate.getYear()) {
			return false;
		}else if(this.year == anotherDate.getYear() && this.month < anotherDate.getMonth()) {
			return false;
		}else if(this.year == anotherDate.getYear() && this.month == anotherDate.getMonth() && this.day < anotherDate.getDay()) {
			return false;
		}else if(this.year == anotherDate.getYear() && this.month == anotherDate.getMonth() && this.day == anotherDate.getDay()) {
			return false;
		}
		else {
			return true;
		}

	}

	/**
	 * dient der Ermittlung der benötigten (abzuziehenden) Tage bei der Beantragung einer Abwesenheit (Wochenenden werden nicht 
	 * von den Urlaubstagen abgezogen)
	 * 
	 * @param start the start of an absence
	 * @param end the end of an absence
	 * @return the days (vacation_left) needed for an absence
	 */
	public static int getVacDays (Date start, Date end) {
		GregorianCalendar date_1 = new GregorianCalendar(start.getYear(), start.getMonth(), start.getDay());
		GregorianCalendar date_2 = new GregorianCalendar(end.getYear(), end.getMonth(), end.getDay());
		int date_1_day = date_1.get(Calendar.DAY_OF_YEAR);
		int date_2_day = date_2.get(Calendar.DAY_OF_YEAR);

		int days = 0;

		for (int i = date_1_day; i<= date_2_day; i++) {

			Calendar day = Calendar.getInstance();
			day.set(Calendar.YEAR, start.getYear());
			day.set(Calendar.DAY_OF_YEAR, i);
			
			Date date = new Date (day.get(Calendar.YEAR), day.get(Calendar.MONTH), day.get(Calendar.DAY_OF_MONTH));

			boolean weekday = date.isWeekday();
			if (weekday == true) {
				days++;
			} 
		}

		return days;
	}
	
	/**
	 * dient dem Vergleich zweier Objekte dieser Klasse 
	 * 
	 * @param date the date with which this is to be compared 
	 * @return 1 if this date is greater than the date it was compared with, 0 if the both dates are equal and -1 if this date is 
	 * smaller than the date is was compared with
	 */
	public int compare(Date date) {
		if(this.year == date.year && this.month == date.month && this.day == date.day) {
			return 0;
		}
		if(this.isGreater(date)) {
			return 1;
		}else {
			return -1;
		}
	}
	
}
