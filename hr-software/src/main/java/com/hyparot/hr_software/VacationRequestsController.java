package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.hyparot.hr_software.src.backend.BIConnect;
import com.hyparot.hr_software.src.employee.Employee;
import com.hyparot.hr_software.src.employeedata.Absence;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VacationRequestsController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Text TVornameData;

	@FXML
	private Text TNachnameData;

	@FXML
	private Text TPersnrData;

	@FXML
	private Text TVonData;

	@FXML
	private Text TBisData;

	@FXML
	private Button BGenehmigen;

	@FXML
	private Button BAblehnen;

	@FXML
	private Text TEmpty;

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
	private Button BZurueck;

	@FXML
	private Button BLogout;

	//Button Antrag ablehnen
	@FXML
	void ablehnen(ActionEvent event) {
		acceptDeclineRequest(false);
	}

	//Button Antrag genehmigen
	@FXML
	void genehmigen(ActionEvent event) {
		acceptDeclineRequest(true);
	}

	//Button logout - Szenenwechsel
	@FXML
	void logout(ActionEvent event) throws IOException {
		changeSceneLogout();
	}

	//Button Zurück - Szenenwechsel zum Hauptfenster
	@FXML
	void zurueck(ActionEvent event) throws IOException {
		changeSceneZurueck(user);
	}

	@FXML
	void initialize() {

	}

	private Stage stage;
	private Employee user;
	//Akt. Urlaubsantrag
	private Absence vacation;

	//Konstruktor
	public VacationRequestsController(Stage stage, Employee username) {
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

		//Aktuellen Urlaubsantrag anzeigen
		traverseVacations();
	}

	//Nicht genehmigte Urlaubsanträge durchlaufen und nächsten anzeigen
	public void traverseVacations() {
		//Absence
		BIConnect bic = new BIConnect();
		//Iterator für alle Abwesenheiten initialisieren
		Iterator<Absence> it = bic.getVacationRequests().iterator();

		//Solange Abwesenheiten vorhanden
		if (it.hasNext()) {
			//Abwesenheiten durchlaufen
			Absence abs = it.next();

			//Falls 1. Eintrag eine noch nicht genehmigte Abwesenheit ist
			if (abs.isAccepted() == false) {
				//Urlaubsantragsdaten anzeigen
				TPersnrData.setText(String.valueOf(abs.getPersNr()));
				TVornameData.setText(bic.getEmployeeByID(abs.getPersNr()).getFirstname());
				TNachnameData.setText(bic.getEmployeeByID(abs.getPersNr()).getLastname());
				TVonData.setText(abs.getBegin().toString());
				TBisData.setText(abs.getEnd().toString());

				//Aktuellen Antrag benennen, um ihn bestätigen oder ablehnen zu können
				this.vacation = abs;
			} 
			//Falls 1. Eintrag eine genehmigte Abwesenheit ist: Durchlaufen bis nicht genehmigte Abwesenheit gefunden
			else if (abs.isAccepted() == true) {
				while (abs.isAccepted() == true) {

					//Falls keine Anträge: Funktion beenden
					if (!it.hasNext()) {
						clearEntries();
						return;
					}
					abs = it.next();
				}
				//Falls letzter Eintrag eine noch nicht genehmigte Abwesenheit ist: Anzeigen
				System.out.println("1");
				TPersnrData.setText(String.valueOf(abs.getPersNr()));
				TVornameData.setText(bic.getEmployeeByID(abs.getPersNr()).getFirstname());
				TNachnameData.setText(bic.getEmployeeByID(abs.getPersNr()).getLastname());
				TVonData.setText(abs.getBegin().toString());
				TBisData.setText(abs.getEnd().toString());

				//Aktuellen Antrag benennen, um ihn bestätigen oder ablehnen zu können
				this.vacation = abs;
			} else {
				clearEntries();
			} 
		} else {
			clearEntries();
		}
	}

	//Unterfunktion zu traverseVacations(): Felder leeren, falls kein aktueller Antrag vorhanden ist
	public void clearEntries() {
		TPersnrData.setText("-");
		TVornameData.setText("-");
		TNachnameData.setText("-");
		TVonData.setText("-");
		TBisData.setText("-");
		TEmpty.setVisible(true);
		BGenehmigen.setDisable(true);
		BAblehnen.setDisable(true);
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

	//Szenenwechsel: Zurück zum Hauptfenster
	public void changeSceneZurueck(Employee Username) throws IOException {
		var loader = new FXMLLoader();
		var fRController = new FRController(stage, Username);
		loader.setLocation(getClass().getResource("/afterLogin.fxml"));
		loader.setController(fRController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		fRController.schreiben();
	}

	//Aktuellen Eintrag genehmigen oder ablehnen
	public void acceptDeclineRequest(boolean decision) {
		BIConnect bic = new BIConnect(this.vacation.getPersNr());
		if (decision) { //Annehmen
			bic.acceptVacation(vacation);
			//Nächsten Antrag anzeigen lassen
			traverseVacations();
			System.out.println("ACCEPTED");
		} else { //Ablehnen
			bic.cancelVacation(vacation.getAbsenceID());
			//Abgezogene übrige Urlaubstage des Angestellten wieder hinzufügen
			bic.getEmployeeByID(vacation.getPersNr()).setVacation_left(bic.getEmployeeByID(vacation.getPersNr()).getVacation_left() + vacation.getAbsenceDuration());
			//Nächsten Antrag anzeigen lassen
			traverseVacations();
			System.out.println("DECLINED");
		}
	}
}
