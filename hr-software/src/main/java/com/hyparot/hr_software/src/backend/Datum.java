package com.hyparot.hr_software.src.backend;

public class Datum {

	private int Jahr;
	private int Monat;
	private int Tag;
	
	
	public Datum(int Jahr, int Monat, int Tag) {
		this.Jahr = Jahr;
		this.Monat = Monat;
		this.Tag = Tag;
	}
	
	
	public Datum(String datum) {
		try{
			String[] teile = datum.split("-");
			this.Jahr = Integer.parseInt(teile[0]);
			this.Monat = Integer.parseInt(teile[1]);
			this.Tag = Integer.parseInt(teile[2]);
		}catch(Exception e) {
			
		}
		
	}
	
	
	public String toString() {
		if(Monat < 10 && Tag < 10) {
			return (Jahr + "-" + "0" + Monat + "-" + "0" + Tag);
		}else if(Monat >= 10 && Tag < 10) {
			return (Jahr + "-" + Monat + "-" + "0" + Tag);
		}else if(Monat < 10 && Tag >= 10) {
			return (Jahr + "-" + "0" + Monat + "-" + Tag);
		}
		return (Jahr + "-" + Monat + "-" + Tag);
	}
}
