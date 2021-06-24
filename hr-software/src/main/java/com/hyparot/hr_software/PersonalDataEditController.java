package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.hyparot.hr_software.src.backend.SystemDBConnector;
import com.hyparot.hr_software.src.mitarbeiter.Date;
import com.hyparot.hr_software.src.mitarbeiter.Employee;

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
	private TextField TFPLZ;

	@FXML
	private TextField TFStadt;

	@FXML
	private TextField TFStraße;

	@FXML
	private TextField TFHausnummer;

	@FXML
	private TextField TFZusatz;

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

	@FXML
	void logout(ActionEvent event) throws IOException {
		changeSceneLogout();
	}

	@FXML
	void save(ActionEvent event) throws IOException {
		saveChanges();
	}

	@FXML
	void verwerfen(ActionEvent event) throws IOException {
		changeSceneVerwerfen(user);
	}

	@FXML
	void initialize() {
		assert TFVorname != null : "fx:id=\"TFVorname\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TFNachname != null : "fx:id=\"TFNachname\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TStelleData != null : "fx:id=\"TStelleData\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TTelefonnummerData != null : "fx:id=\"TTelefonnummerData\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TPersonalnummerData != null : "fx:id=\"TPersonalnummerData\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TFGeburtstag != null : "fx:id=\"TFGeburtstag\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TEinstellungsdatumData != null : "fx:id=\"TEinstellungsdatumData\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert BSpeichern != null : "fx:id=\"BSpeichern\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TFLand != null : "fx:id=\"TFLand\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TFPLZ != null : "fx:id=\"TFPLZ\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TFStadt != null : "fx:id=\"TFStadt\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TFStraße != null : "fx:id=\"TFStraße\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TFHausnummer != null : "fx:id=\"TFHausnummer\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TFZusatz != null : "fx:id=\"TFZusatz\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TKuerzel != null : "fx:id=\"TKuerzel\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TVorname_Nachname != null : "fx:id=\"TVorname_Nachname\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TPersonalnummer != null : "fx:id=\"TPersonalnummer\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TStelle != null : "fx:id=\"TStelle\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TTelefonnummer != null : "fx:id=\"TTelefonnummer\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert TE_Mail != null : "fx:id=\"TE_Mail\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert BVerwerfen != null : "fx:id=\"BVerwerfen\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";
		assert BLogout != null : "fx:id=\"BLogout\" was not injected: check your FXML file 'PersonalDataEdit.fxml'.";

	}

	private Stage stage;
	private String user;

	public PersonalDataEditController(Stage stage, String username) {
		this.stage = stage;
		this.user = username;
		//schreiben();

	}

	public void schreiben() {
		Employee user = com.hyparot.hr_software.src.backend.BusinessIntellegent.getEmployeeByName(this.user);
		//Uneditable Text
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

		//Editable Textfields

		TFVorname.setText(user.getFirstname());
		TFNachname.setText(user.getLastname());

		TFGeburtstag.setText(user.getBirthday().toString());

		TFLand.setText(user.getAdress().getCountry());
		TFPLZ.setText(String.valueOf(user.getAdress().getPostcode()));
		TFStadt.setText(user.getAdress().getCity());
		TFStraße.setText(user.getAdress().getStreet());
		TFHausnummer.setText(String.valueOf(user.getAdress().getHouseNr()));
		TFZusatz.setText(user.getAdress().getHousenumberSupplement());
		TFZusatz.setText(user.getAdress().getHousenumberSupplement());
	}


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


	public void changeSceneVerwerfen(String Username) throws IOException {
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

	public void saveChanges() throws IOException {
		Employee userNew = com.hyparot.hr_software.src.backend.BusinessIntellegent.getEmployeeByName(this.user);
		String firstNameNew = TFVorname.getText();
		String lastNameNew = TFNachname.getText();


		String countryNew = TFLand.getText();
		String cityNew = TFStadt.getText();
		String streetNew = TFStraße.getText();
		String housenrSupplementNew = TFZusatz.getText();
		int postCodeNew;
		int housenrNew;
		Date birthdayNew;

		if (TFGeburtstag.getText().charAt(4) == '-' && TFGeburtstag.getText().charAt(7) == '-' && TFGeburtstag.getText().length() == 10) {
			birthdayNew = new Date(TFGeburtstag.getText());
		} else {
			TFGeburtstag.setStyle("-fx-text-fill: red;");
			TFGeburtstag.setText("Falsches Format!");
			return;
		}

		try {
			postCodeNew = Integer.parseInt(TFPLZ.getText());
		} catch (Exception E) {
			TFPLZ.setStyle("-fx-text-fill: red;");
			TFPLZ.setText("Falscher Eingabetyp!");
			return;
		}

		try {
			housenrNew = Integer.parseInt(TFHausnummer.getText());
		} catch (Exception E) {
			TFHausnummer.setStyle("-fx-text-fill: red;");
			TFHausnummer.setText("Falscher Eingabetyp!");
			return;
		}



		userNew.editEmployee(firstNameNew, lastNameNew, userNew.getEMail(), userNew.getPhoneNumber(), birthdayNew, countryNew, cityNew, postCodeNew, streetNew, housenrNew, housenrSupplementNew);
		SystemDBConnector.loadLocalDataToDB();

		changeSceneVerwerfen(user);
	}
}
