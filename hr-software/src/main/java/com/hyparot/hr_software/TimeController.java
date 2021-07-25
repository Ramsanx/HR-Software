package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Vector;

import com.hyparot.hr_software.src.backend.BIConnect;
import com.hyparot.hr_software.src.backend.SystemDBConnector;
import com.hyparot.hr_software.src.employee.Employee;
import com.hyparot.hr_software.src.employeedata.Absence;
import com.hyparot.hr_software.src.employeedata.Date;

import impl.com.calendarfx.view.NumericTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TimeController {

	private Stage stage;

	private Employee user;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Text TResturlaubstage;

	@FXML
	private Text TReststunden;

	@FXML
	private NumericTextField TFVonH;

	@FXML
	private NumericTextField TFVonM;

	@FXML
	private NumericTextField TFBisH;

	@FXML
	private NumericTextField TFBisM;

	@FXML
	private Button BArbeitszeitErfassen;

	@FXML
	private Button BCancelVacation;

	@FXML
	private Text TErfolgreichArbeitszeit;

	@FXML
	private NumericTextField TFKrankmeldenTage;

	@FXML
	private Button BKrankmelden;

	@FXML
	private Text TErfolgreichKrank;

	@FXML
	private Text TErfolgreichStornieren;

	@FXML
	private TextField TFVon;

	@FXML
	private TextField TFBis;

	@FXML
	private TableView<Absence> TableView;

	@FXML
	private TableColumn<Absence, Integer> TCAbsenceID;

	@FXML
	private TableColumn<Absence, Date> TCBeginDate;

	@FXML
	private TableColumn<Absence, Date> TCEndDate;

	@FXML
	private TableColumn<Absence, Boolean> TCEndDate1;

	@FXML
	private NumericTextField TFCancelVacationID;

	@FXML
	private Button BUrlaubBeantragen;

	@FXML
	private Text TErfolgreich;

	@FXML
	private Text TKuerzel;

	@FXML
	private Text TVorname_Nachname;

	@FXML
	private Text TPersonalnummer;

	@FXML
	private Text TStelle;

	@FXML
	private Text TTelefonnummer;

	@FXML
	private Text TE_Mail;

	@FXML
	private Button Bzurueck;

	@FXML
	private Button BLogout;

	//Button: Arbeitszeit erfassen
	@FXML
	void arbeitszeitErfassen(ActionEvent event) {
		setWorkingTime();
	}

	//Button: krankmelden
	@FXML
	void krankmelden(ActionEvent event) {
		setSick();
	}

	//Button: logout - Szenenwechsel
	@FXML
	void logout(ActionEvent event) throws IOException {
		changeSceneLogout();
	}

	//Button: Zurück - Szenenwechsel zum Hauptfenster
	@FXML
	void zurück(ActionEvent event) throws IOException {
		changeSceneZurueck(user);
	}

	//Button: Urlaub beantragen
	@FXML
	void requestVacation(ActionEvent event) {
		requestVacation1();
	}

	//Button: Urlaub stornieren
	@FXML
	void cancelVacationByID(ActionEvent event) {
		cancelVacationByID2();
	}

	//Button: Eintragung der Arbeitszeit auf 2 Ziffern beschränken (Felder für Stunden und Minuten)
	@FXML
	void restrictLength(KeyEvent event) {
		//Feld "Von" in Stunden
		if (TFVonH.getText().length() > 1) { //Falls bereits 2 Ziffern lang
			TFVonH.setText(TFVonH.getText().substring(0,2)); //Eingabe beibehalten
			TFVonH.positionCaret(2); //Cursor an aktuelle Position bewegen
		}
		//Feld "Von" in Minuten
		if (TFVonM.getText().length() > 1) {
			TFVonM.setText(TFVonM.getText().substring(0,2));
			TFVonM.positionCaret(2);
		}
		//Feld "Bis" in Stunden
		if (TFBisH.getText().length() > 1) {
			TFBisH.setText(TFBisH.getText().substring(0,2));
			TFBisH.positionCaret(2);
		}
		//Feld "Bis" in Minuten
		if (TFBisM.getText().length() > 1) {
			TFBisM.setText(TFBisM.getText().substring(0,2));
			TFBisM.positionCaret(2);
		}
	}

	@FXML
	void initialize() {
		loadVacationTable(); //Urlaubsliste anzeigen
	}

	//Konstruktor
	public TimeController(Stage stage, Employee username) {
		this.stage = stage;
		this.user = username;
	}

	//Alternative zu Initialize
	public void schreiben() {
		//Uneditable Text rechts einfügen (Daten des akt. Users)
		TVorname_Nachname.setText(user.getFirstname() + " " + user.getLastname());
		TPersonalnummer.setText((String.valueOf(user.getPersNr()))); 
		TStelle.setText(user.getJobTitle());
		TTelefonnummer.setText(user.getPhoneNumber());
		TE_Mail.setText(user.getEMail());
		TKuerzel.setText(user.getFirstname().charAt(0) + "" + user.getLastname().charAt(0));
		TReststunden.setText(String.valueOf(user.getWorkingTime_left()));
		TResturlaubstage.setText(String.valueOf(user.getVacation_left()));
	}

	//Szenenwechsel: Zurück zum Hauptfenster
	public void changeSceneZurueck(Employee Username) throws IOException {
		var loader = new FXMLLoader();
		var fRController = new FRController(stage, Username);
		loader.setLocation(getClass().getResource("/AfterLogin.fxml"));
		loader.setController(fRController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		fRController.schreiben();
	}

	//Szenenwechsel: Logout
	public void changeSceneLogout() throws IOException {
		var loader = new FXMLLoader();
		var loginController = new LoginController(stage);
		loader.setLocation(getClass().getResource("/Sample.fxml"));
		loader.setController(loginController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(800);
		stage.setHeight(500);
		stage.centerOnScreen();
		stage.setResizable(false);
	}

	//Urlaubsanträge des Users laden und anzeigen
	public void loadVacationTable() {
		BIConnect bic = new BIConnect(this.user.getPersNr());
		//Alle Urlaube und Anträge des Users in Vektor speichern
		Vector<Absence> absenceTable = bic.getVacationOverview();
		//In Tabelle darstellen
		TableView.setItems(FXCollections.observableList(absenceTable));
		TCAbsenceID.setCellValueFactory(new PropertyValueFactory<>("absenceID"));
		TCBeginDate.setCellValueFactory(new PropertyValueFactory<>("begin"));
		TCEndDate.setCellValueFactory(new PropertyValueFactory<>("end"));
		TCEndDate1.setCellValueFactory(new PropertyValueFactory<>("isAccepted"));
	}

	//Urlaub/Antrag stornieren
	public void cancelVacationByID2() {
		BIConnect bic = new BIConnect(this.user.getPersNr());
		Absence abs;
		//Heutiges Kalenderdatum erfassen
		Calendar c = new GregorianCalendar();
		Date today = new Date(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH));
		//Alle Urlaube und Anträge des Users in Vektor speichern
		Iterator<Absence> it = bic.getVacationOverview().iterator();

		while(it.hasNext()) { //Solange Einträge vorhanden sind
			abs = it.next();
			if (abs.getAbsenceID() == Integer.parseInt(TFCancelVacationID.getText())) { //Nur wenn zu stornierender Urlaub diesem User zugehörig ist
				//Nur wenn Urlaub noch nicht angebrochen ist und nicht in der Vergangenheit liegt 
				if (abs.getBegin().isGreater(today) && !abs.getBegin().toString().equals(today.toString())) {
					bic.cancelVacation(Integer.parseInt(TFCancelVacationID.getText())); //Urlaub stornieren
					//Übrige Urlaubstage korrigieren
					user.setVacation_left(user.getVacation_left()+Date.getVacDays(abs.getBegin(), abs.getEnd()));
					bic.correctVacation_left(user.getPersNr());
					//In DB hochladen
					SystemDBConnector.loadLocalDataToDB();
					TResturlaubstage.setText(String.valueOf(user.getVacation_left())); //Urlaubstage Anzeige aktualiseren
					loadVacationTable(); //Tabelle aktualiseren
					//Meldung anzeigen
					TErfolgreichStornieren.setText("Erfolgreich storniert!");
					TFCancelVacationID.clear();
				} else {
					TErfolgreichStornieren.setText("Urlaub bereits angefangen!");
				}
			}
		}
	}

	//Arbeitszeit erfassen
	public void setWorkingTime() {
		//Einträge erfassen
		int VonH = Integer.parseInt(TFVonH.getText().toString());
		int VonM = Integer.parseInt(TFVonM.getText().toString());
		int BisH = Integer.parseInt(TFBisH.getText().toString());
		int BisM = Integer.parseInt(TFBisM.getText().toString());

		//Nur wenn Einträge richtiges Format besitzen
		if (VonH <= 24 && VonH >= 0 && VonM >= 0 && VonM <= 60 &&
				BisH <= 24 && BisH >= 0 && BisM >= 0 && BisM <= 60) {
			//Nur wenn Arbeitszeit über 0min ist
			if ((BisH*60 + BisM) - (VonH*60 + VonM) > 0) {
				//Nur wenn weniger als 12h gearbeitet wurde
				if ((BisH*60 + BisM) - (VonH*60 + VonM) <= 720) {
					int workedTime = Math.round(((BisH*60 + BisM) - (VonH*60 + VonM))/60); //Arbeitsstunden erfassen
					//Erfolgreich Meldung
					TErfolgreichArbeitszeit.setStyle("-fx-text-fill: #36c740;");
					TErfolgreichArbeitszeit.setText("Arbeitsstunden erfolgreich erfasst: " + workedTime + "h.");

					user.setWorkTime(workedTime);
//					BIConnect bic = new BIConnect();
//					//Übrige Arbeitszeit des Users updaten
//					user.setWorkingTime_left(user.getWorkingTime_left()-workedTime);
//					bic.addToChanges(user.getPersNr());
//					//In DB hochladen
//					SystemDBConnector.loadLocalDataToDB();
					//Restliche bzw. aktuelle Arbeitsstundenanzeige aktualisieren
					TReststunden.setText(String.valueOf(user.getWorkingTime_left()));
				} else {
					//Warnung
					TErfolgreichArbeitszeit.setStyle("-fx-text-fill: red;");
					TErfolgreichArbeitszeit.setText("Sie können nicht über 12h arbeiten!");
				}
			} else {
				//Warnung
				TErfolgreichArbeitszeit.setStyle("-fx-text-fill: red;");
				TErfolgreichArbeitszeit.setText("Sie können nicht über Nacht arbeiten!");
			}
		} else {
			//Warnung
			TErfolgreichArbeitszeit.setStyle("-fx-text-fill: red;");
			TErfolgreichArbeitszeit.setText("Bitte korrekte Uhrzeiten angeben!");
		}
	}

	//Krankmelden
	public void setSick() {
		int duration;
		try {
			duration = Integer.parseInt(TFKrankmeldenTage.getText()); //Dauer erfassen
		} catch (Exception e) {
			TErfolgreichKrank.setText("Ungültige Eingabe!");
			return;
		}
		user.setSick(duration); //Krankmeldung eintragen als Abwesenheit
		TFKrankmeldenTage.clear();
		//Meldung
		TErfolgreichKrank.setText("Erfolgreich eingetragen!");
	}

	//Urlaub beantragen
	public void requestVacation1() {
		Date VacationFrom;
		Date VacationUntil;
		TErfolgreich.setText("");
		TErfolgreichKrank.setText("");
		TFVon.setStyle("-fx-text-fill: black;");
		TFBis.setStyle("-fx-text-fill: black;");

		//Urlaub "Von" Textfeld
		if (!TFVon.getText().isBlank() && TFVon.getText().length() > 7) { //Nicht leer und mehr als 7 Zeichen
			if (TFVon.getText().charAt(4) == '-' && TFVon.getText().charAt(7) == '-' && TFVon.getText().length() == 10) { //Prüfen auf korrektes Format
				//Urlaubsdatum "Von"
				try {
					VacationFrom = new Date(TFVon.getText());
				} catch (Exception e) {
					//Warnung
					TFVon.setStyle("-fx-text-fill: red;");
					TFVon.setText("Format: jjjj-mm-tt");
					return;
				}
			} else {
				//Warnung
				TFVon.setStyle("-fx-text-fill: red;");
				TFVon.setText("Format: jjjj-mm-tt");
				return;
			}
		} else {
			//Warnung
			TFVon.setStyle("-fx-text-fill: red;");
			TFVon.setText("Format: jjjj-mm-tt");
			return;
		}


		//Urlaubs "Bis" Textfeld
		if (!TFBis.getText().isBlank() && TFBis.getText().length() > 7) { //Nicht leer und mehr als 7 Zeichen
			if (TFBis.getText().charAt(4) == '-' && TFBis.getText().charAt(7) == '-' && TFVon.getText().length() == 10) { //Prüfen auf korrektes Format
				//Urlaubsdatum "Bis"
				try {
					VacationUntil = new Date(TFBis.getText());
				} catch (Exception e) {
					//Warnung
					TFBis.setStyle("-fx-text-fill: red;");
					TFBis.setText("Format: jjjj-mm-tt");
					return;
				}
			} else {
				//Warnung
				TFBis.setStyle("-fx-text-fill: red;");
				TFBis.setText("Format: jjjj-mm-tt");
				return;
			}
		} else {
			//Warnung
			TFBis.setStyle("-fx-text-fill: red;");
			TFBis.setText("Format: jjjj-mm-tt");
			return;
		}

		//Check ob gültige Daten
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			format.setLenient(false);
			format.parse(VacationFrom.toString());		
			format.parse(VacationUntil.toString());	
		} catch (Exception e) {
			//Warnung
			TErfolgreich.setStyle("-fx-text-fill: red;");
			TErfolgreich.setText("Ungültiges Format!");
			return;
		}

		//Heutiges Datum erfassen
		Calendar c = new GregorianCalendar();
		Date today = new Date(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH));

		//Urlaubs darf nicht angebrochen sein oder bis heute andauern
		if (VacationFrom.isGreater(today) && !VacationFrom.toString().equals(today.toString()) && !VacationUntil.toString().equals(today.toString())) {
			//Urlaubsende muss nach Urlaubsanfang sein oder am selben Tag
			if (VacationUntil.isGreater(VacationFrom) || VacationUntil.toString().equals(VacationFrom.toString())) {
				//Es müssen genug Urlaubstage über sein
				if (user.getVacation_left() - Date.getVacDays(VacationFrom, VacationUntil) >= 0) {
					if (user.applyForVacation(VacationFrom, VacationUntil)) {//Wenn erfolgreich beantragt werden kann
						
						BIConnect bic = new BIConnect();
						//Ziehe Resturlaubstage ab
						user.setVacation_left(user.getVacation_left()-Date.getVacDays(VacationFrom, VacationUntil));
						bic.correctVacation_left(user.getPersNr());
						//In DB hochladen
						SystemDBConnector.loadLocalDataToDB();
						//Resturlaubstage Anzeige aktualisieren
						TResturlaubstage.setText(String.valueOf(user.getVacation_left()));
						//Urlaubstabelle aktualiseren
						loadVacationTable();
						//Einträge leeren
						TFVon.clear();
						TFBis.clear();
						TErfolgreich.setText("Erfolgreich beantragt!");
						TErfolgreich.setStyle("-fx-text-fill: green;");
					} else {
						//Warnung
						TErfolgreich.setStyle("-fx-text-fill: red;");
						TErfolgreich.setText("Überlappende Abwesenheit!"); 
					}
				} else {
					//Warnung
					TErfolgreich.setStyle("-fx-text-fill: red;");
					TErfolgreich.setText("Zu wenig Urlaubstage!");
				}

			} else {
				//Warnung
				TErfolgreich.setStyle("-fx-text-fill: red;");
				TFVon.setText("Von!");
				TFBis.setText("Bis!");
				TErfolgreich.setText("Ungültiger Zeitraum!");
			}
		} else {
			//Warnung
			TFVon.clear();
			TFBis.clear();
			TErfolgreich.setStyle("-fx-text-fill: red;");
			TErfolgreich.setText("Unzulässiger Zeitraum!");
		}
	}
}
