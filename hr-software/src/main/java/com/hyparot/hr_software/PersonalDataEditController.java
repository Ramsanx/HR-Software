package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import com.hyparot.hr_software.src.backend.SystemDBConnector;
import com.hyparot.hr_software.src.employeedata.Date;

import impl.com.calendarfx.view.NumericTextField;

import com.hyparot.hr_software.src.employee.Employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PersonalDataEditController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField TFVorname;

	@FXML
	private TextField TFNachname;

	@FXML
	private Text TStelleData;

	@FXML
	private Text TTelefonnummerData;

	@FXML
	private Text TPersonalnummerData;

	@FXML
	private TextField TFGeburtstag;

	@FXML
	private Text TEinstellungsdatumData;

	@FXML
	private Button BSpeichern;

	@FXML
	private TextField TFLand;

	@FXML
	private NumericTextField TFPLZ;

	@FXML
	private TextField TFStadt;

	@FXML
	private TextField TFStraße;

	@FXML
	private NumericTextField TFHausnummer;

	@FXML
	private TextField TFZusatz;

	@FXML
	private Text TWarning;

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
	private Button BVerwerfen;

	@FXML
	private Button BLogout;

	//Button logout - Szenenwechsel
	@FXML
	void logout(ActionEvent event) throws IOException {
		changeSceneLogout();
	}

	//Button Änderungen speichern + Szenenwechsel
	@FXML
	void save(ActionEvent event) throws IOException {
		saveChanges();
	}

	//Button Änderungen verwerfen + Szenenwechsel
	@FXML
	void verwerfen(ActionEvent event) throws IOException {
		changeSceneVerwerfen(user);
	}

	@FXML
	void initialize() {

	}

	private Stage stage;
	private Employee user;

	//Konstruktor
	public PersonalDataEditController(Stage stage, Employee username) {
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
		TStelleData.setText(user.getJobTitle());
		TTelefonnummerData.setText(user.getPhoneNumber());
		TPersonalnummerData.setText(String.valueOf(user.getPersNr()));
		TEinstellungsdatumData.setText(user.getStartDate().toString());

		//Editable Textfelder ausfüllen
		TFVorname.setText(user.getFirstname());
		TFNachname.setText(user.getLastname());
		TFGeburtstag.setText(user.getBirthday().toString());
		TFLand.setText(user.getAdress().getCountry());
		TFPLZ.setText(String.valueOf(user.getAdress().getPostcode()));
		TFStadt.setText(user.getAdress().getCity());
		TFStraße.setText(user.getAdress().getStreet());
		TFHausnummer.setText(String.valueOf(user.getAdress().getHouseNr()));
		TFZusatz.setText(user.getAdress().getHousenumberSupplement());
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

	//Szenenwechsel: Änderungen verwerfen (Zu persönliche Daten)
	public void changeSceneVerwerfen(Employee Username) throws IOException {
		var loader = new FXMLLoader();
		var personalDataController = new PersonalDataController(stage, Username);
		loader.setLocation(getClass().getResource("/PersonalData.fxml"));
		loader.setController(personalDataController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		personalDataController.schreiben();
	}

	//Änderungen speichern
	public void saveChanges() throws IOException {
		//Eingegebene Daten erfassen
		String firstNameNew = TFVorname.getText();
		String lastNameNew = TFNachname.getText();
		String countryNew = TFLand.getText();
		String cityNew = TFStadt.getText();
		String streetNew = TFStraße.getText();
		String housenrSupplementNew = TFZusatz.getText();
		int postCodeNew;
		int housenrNew;
		Date birthdayNew;

		//Falls NumericFields blank sind (Workaround mit try-catch)
		try {
			postCodeNew = Integer.parseInt(TFPLZ.getText().toString());
			housenrNew = Integer.parseInt(TFHausnummer.getText().toString());
		} catch (Exception e) {
			TWarning.setText("Bitte alles ausfüllen!");
			return;
		}

		//Falls die restlichen Eingabefelder leer sind: Warnung
		if (firstNameNew.isBlank() || lastNameNew.isBlank() || countryNew.isBlank() 
				|| cityNew.isBlank() || streetNew.isBlank()) {
			TWarning.setText("Bitte ausfüllen!");
			return;
		} TWarning.setText("");

		//Geburtstag erfassen
		if (!TFGeburtstag.getText().isBlank() && TFGeburtstag.getText().length() > 7) { //Nicht leer und über 7 Zeichen
			if (TFGeburtstag.getText().charAt(4) == '-' && TFGeburtstag.getText().charAt(7) == '-' && TFGeburtstag.getText().length() == 10) { //Richtiges Format prüfen
				try {
					birthdayNew = new Date(TFGeburtstag.getText());
					TFGeburtstag.setStyle("-fx-text-fill: black;");
				} catch (Exception e) {
					TFGeburtstag.setStyle("-fx-text-fill: red;");
					TFGeburtstag.setText("Format: jjjj-mm-tt");
					return;
				}
			} else { // else von: Richtiges Format prüfen
				//Warnung
				TFGeburtstag.setStyle("-fx-text-fill: red;");
				TFGeburtstag.setText("Format: jjjj-mm-tt");
				return;
			}
		} else { // else von: Nicht leer und über 7 Zeichen
			//Warnung
			TFGeburtstag.setStyle("-fx-text-fill: red;");
			TFGeburtstag.setText("Format: jjjj-mm-tt");
			return;
		}

		//Check ob gültiges Datum
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			format.setLenient(false);
			format.parse(birthdayNew.toString());		
		} catch (Exception e) {
			//Warnung
			TFGeburtstag.setStyle("-fx-text-fill: red;");
			TFGeburtstag.setText("Ungültiges Datum!");
			return;
		}

		//User erstellen und überschreiben
		user.setPersonaldata(firstNameNew, lastNameNew, user.getEMail(), user.getPhoneNumber(), birthdayNew, countryNew, cityNew, postCodeNew, streetNew, housenrNew, housenrSupplementNew);
		//In DB hochladen
		SystemDBConnector.loadLocalDataToDB();
		//Szenenwechsel zum Hauptfenster
		changeSceneVerwerfen(user);
	}
}
