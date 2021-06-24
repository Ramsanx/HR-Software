package com.hyparot.hr_software.employeedata;


//ein Objekt der Klasse Adresse wird zum Anlegen eines Angestellten ben�tigt
public class Adress {
	
	private int postcode; // in der Tabelle "t_mitarbeiter" Feld "PLZ" typ int
	private int houseNr; // in der Tabelle "t_mitarbeiter" Feld "Hausnummer" typ int
	
	private String country; // in der Tabelle "t_mitarbeiter" Feld "Land" typ String
	private String city; // in der Tabelle "t_mitarbeiter" Feld "Stadt" typ String
	private String street; // in der Tabelle "t_mitarbeiter" Feld "Straße" typ String
	private String housenumberSupplement; // in der Tabelle "t_mitarbeiter" Feld "HausnummerZusatz" typ String

	public Adress(String country, 
				   int postcode, String city, 
				   String street, int houseNr) {
		
		this.setCountry(country);
		this.setPostcode(postcode);
		this.setCity(city);
		this.setStreet(street);
		this.setHouseNr(houseNr);
	}
	
	public Adress(String country, 
			   int postcode, String city, 
			   String street, int houseNr, String housenumberSupplement) {
	
		this.setCountry(country);
		this.setPostcode(postcode);
		this.setCity(city);
		this.setStreet(street);
		this.setHouseNr(houseNr);
		this.setHousenumberSupplement(housenumberSupplement);
	}
	
	//getter und setter Block beginn
	//__________________________________________________________________________________________________________________________________
	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public int getHouseNr() {
		return houseNr;
	}

	public void setHouseNr(int houseNr) {
		this.houseNr = houseNr;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHousenumberSupplement() {
		return housenumberSupplement;
	}

	public void setHousenumberSupplement(String housenumberSupplement) {
		this.housenumberSupplement = housenumberSupplement;
	}
	//getter und setter Block ende
	//_________________________________________________________________________________________________________________________________
	
	
	public boolean deleteHausnummernZusatz() {
		if(!this.housenumberSupplement.isEmpty()) {
			setHousenumberSupplement("");
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		if(this.housenumberSupplement == null) {
			return(country + ", " + postcode + " " + city + ", " + street + " " + houseNr);
		}else {
			return(country + ", " + postcode + " " + city + ", " + street + " " + houseNr + housenumberSupplement);
		}
			
	}
	
	// public void print() {
	// 	if(this.housenumberSupplement == null) {
	// 		System.out.println("Land: " + country +
	// 				   "\nPostleitzahl: " + postcode +
	// 				   "\nStadt: " + city +
	// 				   "\nStraße: " + street +
	// 				   "\nHausnummer: " + houseNr);
	// 	}else {
	// 		System.out.println("Land: " + country +
	// 				   "\nPostleitzahl: " + postcode +
	// 				   "\nStadt: " + city +
	// 				   "\nStraße: " + street +
	// 				   "\nHausnummer: " + houseNr + housenumberSupplement);
	// 	}
		
	// }


}
