package backend;


//ein Objekt der Klasse Adresse wird zum Anlegen eines Angestellten ben�tigt
public class Adresse {
	
	private int Postleitzahl;
	private int Hausnummer;
	
	private String Land;
	private String Stadt;
	private String Stra�e;
	private String HausnummernZusatz;

	public Adresse(String Land, 
				   int Postleitzahl, String Stadt, 
				   String Stra�e, int Hausnummer) {
		
		this.Land = Land;
		this.Postleitzahl = Postleitzahl;
		this.Stadt = Stadt;
		this.Stra�e = Stra�e;
		this.Hausnummer = Hausnummer;
	}
	
	public Adresse(String Land, 
			   int Postleitzahl, String Stadt, 
			   String Stra�e, int Hausnummer, String HausnummernZusatz) {
	
		this.Land = Land;
		this.Postleitzahl = Postleitzahl;
		this.Stadt = Stadt;
		this.Stra�e = Stra�e;
		this.Hausnummer = Hausnummer;
		this.HausnummernZusatz = HausnummernZusatz;
	}
	
	public int getPostleitzahl() {
		return this.Postleitzahl;
	}
	
	public void setPostleitzahl(int newPostleitzahl) {
		this.Postleitzahl = newPostleitzahl;
	}
	
	public int getHausnummer() {
		return this.Hausnummer;
	}
	
	public void setHausnummer(int newHausnummer) {
		this.Hausnummer = newHausnummer;
	}

	public String getLand() {
		return this.Land;
	}
	
	public void setLand(String newLand) {
		this.Land = newLand;
	}

	public String getStadt() {
		return this.Stadt;
	}
	
	public void setStadt(String newStadt) {
		this.Stadt = newStadt;
	}

	public String getStra�e() {
		return this.Stra�e;
	}
	
	public void setStra�e(String newStra�e) {
		this.Stra�e = newStra�e;
	}

	public String getHausnummernZusatz() {
		return this.HausnummernZusatz;
	}
	
	public void setHausnummernZusatz(String newHausnummernZusatz) {
		this.HausnummernZusatz = newHausnummernZusatz;
	}
	
	public boolean deleteHausnummernZusatz() {
		if(!this.HausnummernZusatz.isEmpty()) {
			setHausnummernZusatz("");
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		if(this.HausnummernZusatz.isEmpty()) {
			return(Land + ", " + Postleitzahl + " " + Stadt + ", " + Stra�e + " " + Hausnummer);
		}else {
			return(Land + ", " + Postleitzahl + " " + Stadt + ", " + Stra�e + " " + Hausnummer + HausnummernZusatz);
		}
			
	}
	
	public void print() {
		if(this.HausnummernZusatz.isEmpty()) {
			System.out.println("Land: " + Land +
					   "\nPostleitzahl: " + Postleitzahl +
					   "\nStadt: " + Stadt +
					   "\nStra�e: " + Stra�e +
					   "\nHausnummer: " + Hausnummer);
		}else {
			System.out.println("Land: " + Land +
					   "\nPostleitzahl: " + Postleitzahl +
					   "\nStadt: " + Stadt +
					   "\nStra�e: " + Stra�e +
					   "\nHausnummer: " + Hausnummer + HausnummernZusatz);
		}
		
	}
}
