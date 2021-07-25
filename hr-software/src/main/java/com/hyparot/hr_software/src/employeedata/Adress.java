package com.hyparot.hr_software.src.employeedata;


/**
 * ein Objekt der Klasse Adresse wird zum Anlegen eines Angestellten ben�tigt
 */
public class Adress {
	
	private int postcode; // in der Tabelle "t_mitarbeiter" Feld "PLZ" typ int
	private int houseNr; // in der Tabelle "t_mitarbeiter" Feld "Hausnummer" typ int
	
	private String country; // in der Tabelle "t_mitarbeiter" Feld "Land" typ String
	private String city; // in der Tabelle "t_mitarbeiter" Feld "Stadt" typ String
	private String street; // in der Tabelle "t_mitarbeiter" Feld "Straße" typ String
	private String housenumberSupplement; // in der Tabelle "t_mitarbeiter" Feld "HausnummerZusatz" typ String

	/**
	 * dient der Erstellung eines Objektes dieser Klasse
	 * 
	 * @param country the country in which a Person lives
	 * @param postcode the postcode of the Town in which a Person lives
	 * @param city the city in which a Person lives
	 * @param street the street in which a Person lives
	 * @param houseNr the housenumber of the house in which a Person lives
	 */
	public Adress(String country, 
				   int postcode, String city, 
				   String street, int houseNr) {
		
		this.setCountry(country);
		this.setPostcode(postcode);
		this.setCity(city);
		this.setStreet(street);
		this.setHouseNr(houseNr);
	}
	
	/**
	 * dient der Erstellung eines Objektes dieser Klasse
	 * 
	 * @param country the country in which a Person lives
	 * @param postcode the postcode of the Town in which a Person lives
	 * @param city the city in which a Person lives
	 * @param street the street in which a Person lives
	 * @param houseNr the housenumber of the house in which a Person lives
	 * @param housenumberSupplement the housenumberSupplement of the house in which a Person lives (e.g. a, b, c)
	 */
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
	/**
	 * dient dem Abruf der Variablen postcode
	 * 
	 * @return the postcode
	 */
	public int getPostcode() {
		return postcode;
	}

	/**
	 * dient der Manipulation der Variablen postcode
	 * 
	 * @param postcode the postcode to set
	 */
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	/**
	 * dient dem Abruf der Variablen houseNr
	 * 
	 * @return the houseNr
	 */
	public int getHouseNr() {
		return houseNr;
	}

	/**
	 * dient der Manipulation der Variablen houseNr
	 * 
	 * @param houseNr the housNr to set
	 */
	public void setHouseNr(int houseNr) {
		this.houseNr = houseNr;
	}

	/**
	 * dient dem Abruf der Variblen country
	 * 
	 * @return the country 
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * dient der Manipulation der Variablen country
	 * 
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * dient dem Abruf der Variablen city
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * dient der Manipulation der Variablen city
	 * 
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * dient dem Abruf der Variablen street
	 * 
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * dient der Manipulation der Variablen street
	 * 
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * dient dem Abruf der Variablen housenumberSupplement
	 * 
	 * @return the houseNrSupplement
	 */
	public String getHousenumberSupplement() {
		return housenumberSupplement;
	}

	/**
	 * dient der Manipulation der Variablen housenumberSupplement
	 * 
	 * @param housenumberSupplement the housenumberSupplement to set
	 */
	public void setHousenumberSupplement(String housenumberSupplement) {
		this.housenumberSupplement = housenumberSupplement;
	}
	//getter und setter Block ende
	//_________________________________________________________________________________________________________________________________
	
	
	/**
	 * dient der Manipulation der Variablen housenumberSupplement (löscht diesen falls vorhanden)
	 * 
	 * @return true if there was a housenumberSupplement to delete else false
	 */
	public boolean deleteHausnummernZusatz() {
		if(!this.housenumberSupplement.isEmpty()) {
			setHousenumberSupplement("");
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * dient der Wiedergabe einer String-Repräsentation des Objektes
	 * 
	 * @return a String reference of the object
	 */
	public String toString() {
		if(this.housenumberSupplement == null) {
			return(country + ", " + postcode + " " + city + ", " + street + " " + houseNr);
		}else {
			return(country + ", " + postcode + " " + city + ", " + street + " " + houseNr + housenumberSupplement);
		}
			
	}

}
