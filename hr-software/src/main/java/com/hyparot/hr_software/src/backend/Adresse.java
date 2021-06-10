package backend;


//ein Objekt der Klasse Adresse wird zum Anlegen eines Angestellten benˆtigt
public class Adresse {
	
	private int Postleitzahl;
	private int Hausnummer;
	
	private String Land;
	private String Stadt;
	private String Straﬂe;
	private String HausnummernZusatz;

	public Adresse(String Land, 
				   int Postleitzahl, String Stadt, 
				   String Straﬂe, int Hausnummer) {
		
		this.Land = Land;
		this.Postleitzahl = Postleitzahl;
		this.Stadt = Stadt;
		this.Straﬂe = Straﬂe;
		this.Hausnummer = Hausnummer;
	}
	
	public Adresse(String Land, 
			   int Postleitzahl, String Stadt, 
			   String Straﬂe, int Hausnummer, String HausnummernZusatz) {
	
		this.Land = Land;
		this.Postleitzahl = Postleitzahl;
		this.Stadt = Stadt;
		this.Straﬂe = Straﬂe;
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

	public String getStraﬂe() {
		return this.Straﬂe;
	}
	
	public void setStraﬂe(String newStraﬂe) {
		this.Straﬂe = newStraﬂe;
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
			return(Land + ", " + Postleitzahl + " " + Stadt + ", " + Straﬂe + " " + Hausnummer);
		}else {
			return(Land + ", " + Postleitzahl + " " + Stadt + ", " + Straﬂe + " " + Hausnummer + HausnummernZusatz);
		}
			
	}
	
	public void print() {
		if(this.HausnummernZusatz.isEmpty()) {
			System.out.println("Land: " + Land +
					   "\nPostleitzahl: " + Postleitzahl +
					   "\nStadt: " + Stadt +
					   "\nStraﬂe: " + Straﬂe +
					   "\nHausnummer: " + Hausnummer);
		}else {
			System.out.println("Land: " + Land +
					   "\nPostleitzahl: " + Postleitzahl +
					   "\nStadt: " + Stadt +
					   "\nStraﬂe: " + Straﬂe +
					   "\nHausnummer: " + Hausnummer + HausnummernZusatz);
		}
		
	}
}
