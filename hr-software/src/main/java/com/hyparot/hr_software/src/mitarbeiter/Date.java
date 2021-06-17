package com.hyparot.hr_software.src.mitarbeiter;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {

	private int year;
	private int month;
	private int day;
	
	
	public Date(int year, int month, int day) {
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
	}
	
	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		this.day = day;
	}
	
	
	public Date(String date) {
		try{
			String[] parts = date.split("-");
			this.setYear(Integer.parseInt(parts[0]));
			this.setMonth(Integer.parseInt(parts[1]));
			this.setDay(Integer.parseInt(parts[2]));
		}catch(Exception e) {
			
		}
		
	}
	
	
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

//	public int getVacDays (Date anotherDate) {
//		GregorianCalendar date_1 = new GregorianCalendar(this.year, this.month, this.day);
//		GregorianCalendar date_2 = new GregorianCalendar(anotherDate.getYear(), anotherDate.getMonth(), anotherDate.getDay());
//		int date_1_day = date_1.get(Calendar.DAY_OF_YEAR);
//		int date_2_day = date_2.get(Calendar.DAY_OF_YEAR);
//		
//		for (int i = date_1_day; i<=date_1_day; i++) {
//
//			Date dayoF = 
//			day.isWeekday();
//		}
//		int date_1_day;
//
//
//		int days = date_2_day - date_1_day;
//
//
//
//		return days;
//	}
}
