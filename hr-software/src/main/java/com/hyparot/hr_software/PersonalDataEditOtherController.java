package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.hyparot.hr_software.src.backend.BIConnect;
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

public class PersonalDataEditOtherController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField TFVorname;

	@FXML
	private TextField TFNachname;

	@FXML
	private TextField TFStelle;

	@FXML
	private NumericTextField TFTelefonnummer;

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
	private Button BDeleteUser;

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
	void deleteUser(ActionEvent event) throws IOException {
		BIConnect bi = new BIConnect();
		if (user.getPersNr() != userEdit.getPersNr()) {
			bi.deleteEmployee(userEdit.getPersNr());
			SystemDBConnector.loadLocalDataToDB();
			changeSceneDeleteUser(user);
		} else {
			TWarning.setText("Selbst löschen nicht möglich!");
		}
	}

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
		changeSceneVerwerfen(user, userEdit);
	}

	@FXML
	void initialize() {
		assert TFVorname != null : "fx:id=\"TFVorname\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TFNachname != null : "fx:id=\"TFNachname\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TFStelle != null : "fx:id=\"TFStelle\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TFTelefonnummer != null : "fx:id=\"TFTelefonnummer\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TPersonalnummerData != null : "fx:id=\"TPersonalnummerData\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TFGeburtstag != null : "fx:id=\"TFGeburtstag\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TEinstellungsdatumData != null : "fx:id=\"TEinstellungsdatumData\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert BSpeichern != null : "fx:id=\"BSpeichern\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TFLand != null : "fx:id=\"TFLand\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TFPLZ != null : "fx:id=\"TFPLZ\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TFStadt != null : "fx:id=\"TFStadt\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TFStraße != null : "fx:id=\"TFStraße\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TFHausnummer != null : "fx:id=\"TFHausnummer\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TFZusatz != null : "fx:id=\"TFZusatz\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert BDeleteUser != null : "fx:id=\"BDeleteUser\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TKuerzel != null : "fx:id=\"TKuerzel\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TVorname_Nachname != null : "fx:id=\"TVorname_Nachname\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TPersonalnummer != null : "fx:id=\"TPersonalnummer\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TStelle != null : "fx:id=\"TStelle\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TTelefonnummer != null : "fx:id=\"TTelefonnummer\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert TE_Mail != null : "fx:id=\"TE_Mail\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert BVerwerfen != null : "fx:id=\"BVerwerfen\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";
		assert BLogout != null : "fx:id=\"BLogout\" was not injected: check your FXML file 'PersonalDataEditOther.fxml'.";

	}

	private Stage stage;
	private Employee user;
	private Employee userEdit;
	private Employee userC;

	public PersonalDataEditOtherController(Stage stage, Employee username, Employee userEdit) {
		this.stage = stage;
		this.user = username;
		this.userEdit = userEdit;
		this.userC = userEdit;

		//schreiben();
	}

	public void schreiben() {
		//Uneditable Text
		TVorname_Nachname.setText(user.getFirstname() + " " + user.getLastname());
		TPersonalnummer.setText((String.valueOf(user.getPersNr()))); 
		TStelle.setText(user.getJobTitle());
		TTelefonnummer.setText(user.getPhoneNumber());
		TE_Mail.setText(user.getEMail());
		TKuerzel.setText(user.getFirstname().charAt(0) + "" + user.getLastname().charAt(0));

		//		TStelleData.setText(userC.getJobTitle());
		//		TTelefonnummerData.setText(userC.getPhoneNumber());
		TPersonalnummerData.setText(String.valueOf(userC.getPersNr()));
		TEinstellungsdatumData.setText(userC.getStartDate().toString());

		//Editable Textfields

		TFVorname.setText(userC.getFirstname());
		TFNachname.setText(userC.getLastname());

		TFGeburtstag.setText(userC.getBirthday().toString());

		TFStelle.setText(userC.getJobTitle());
		TFTelefonnummer.setText(userC.getPhoneNumber());
		TFLand.setText(userC.getAdress().getCountry());
		TFPLZ.setText(String.valueOf(userC.getAdress().getPostcode()));
		TFStadt.setText(userC.getAdress().getCity());
		TFStraße.setText(userC.getAdress().getStreet());
		TFHausnummer.setText(String.valueOf(userC.getAdress().getHouseNr()));
		TFZusatz.setText(userC.getAdress().getHousenumberSupplement());
		TFZusatz.setText(userC.getAdress().getHousenumberSupplement());
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
		stage.setTitle("HyparRot - HR Software");
		stage.setResizable(false);
	}

	public void changeSceneVerwerfen(Employee Username, Employee userEdit) throws IOException {
		var loader = new FXMLLoader();
		var personalDataController = new PersonalDataController(stage, Username, userEdit);
		loader.setLocation(getClass().getResource("/PersonalData.fxml"));
		loader.setController(personalDataController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		stage.setTitle("HyparRot - HR Software");
		personalDataController.schreiben();
	}

	public void changeSceneDeleteUser(Employee Username) throws IOException {
		var loader = new FXMLLoader();
		var fRController = new FRController(stage, Username);
		loader.setLocation(getClass().getResource("/afterLogin.fxml"));
		loader.setController(fRController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		stage.setTitle("HyparRot - HR Software");
		fRController.schreiben();
		fRController.confirmDeletion();
	}

	public void saveChanges() throws IOException {
		String firstNameNew = TFVorname.getText();
		String lastNameNew = TFNachname.getText();


		String countryNew = TFLand.getText();
		String cityNew = TFStadt.getText();
		String streetNew = TFStraße.getText();
		String housenrSupplementNew = TFZusatz.getText();
		String stelleNew = TFStelle.getText();
		String telefonnummerNew = TFTelefonnummer.getText();
		Date birthdayNew;
		int postCodeNew;
		int housenrNew;

		//Falls NumericFields blank sind (Workaround mit try-catch)
		try {
			postCodeNew = Integer.parseInt(TFPLZ.getText().toString());
			housenrNew = Integer.parseInt(TFHausnummer.getText().toString());
		} catch (Exception e) {
			TWarning.setText("Bitte alles ausfüllen!");
			return;
		}


		if (firstNameNew.isBlank() || lastNameNew.isBlank() || countryNew.isBlank() 
				|| cityNew.isBlank() || streetNew.isBlank() || stelleNew.isBlank()
				|| telefonnummerNew.isBlank()) {
			TWarning.setText("Bitte alles ausfüllen!");
			return;
		} TWarning.setText("");

		////////PLZ ohne NumericField
		//		if (!TFPLZ.getText().isBlank()) {
		//			try {
		//				postCodeNew = Integer.parseInt(TFPLZ.getText());
		//				TFPLZ.setStyle("-fx-text-fill: black;");
		//			} catch (Exception E) {
		//				TFPLZ.setStyle("-fx-text-fill: red;");
		//				TFPLZ.setText("Falscher Eingabetyp!");
		//				return;
		//			} 
		//		} else {
		//			TFPLZ.setStyle("-fx-text-fill: red;");
		//			TFPLZ.setText("Bitte ausfüllen!");
		//			return;
		//		}

		/////////Hausnummer ohne NumericField
		//				if (!TFHausnummer.getText().isBlank()) {
		//					try {
		//						housenrNew = Integer.parseInt(TFHausnummer.getText());
		//						TFHausnummer.setStyle("-fx-text-fill: black;");
		//					} catch (Exception E) {
		//						TFHausnummer.setStyle("-fx-text-fill: red;");
		//						TFHausnummer.setText("Falscher Eingabetyp!");
		//						return;
		//					}
		//				} else {
		//					TFHausnummer.setStyle("-fx-text-fill: red;");
		//					TFHausnummer.setText("Bitte ausfüllen!");
		//					return;
		//				}

		//Geburtstag
		if (!TFGeburtstag.getText().isBlank() && TFGeburtstag.getText().length() > 7) {
			if (TFGeburtstag.getText().charAt(4) == '-' && TFGeburtstag.getText().charAt(7) == '-' && TFGeburtstag.getText().length() == 10) {
				try {
					birthdayNew = new Date(TFGeburtstag.getText());
					TFGeburtstag.setStyle("-fx-text-fill: black;");
				} catch (Exception e) {
					TFGeburtstag.setStyle("-fx-text-fill: red;");
					TFGeburtstag.setText("Format: jjjj-mm-tt");
					return;
				}
			} else {
				TFGeburtstag.setStyle("-fx-text-fill: red;");
				TFGeburtstag.setText("Format: jjjj-mm-tt");
				return;
			}
		} else {
			TFGeburtstag.setStyle("-fx-text-fill: red;");
			TFGeburtstag.setText("Format: jjjj-mm-tt");
			return;
		}



		//Erstellen
		userEdit.setPersonaldata(firstNameNew, lastNameNew, user.getEMail(), telefonnummerNew, birthdayNew, countryNew, cityNew, postCodeNew, streetNew, housenrNew, housenrSupplementNew);
		SystemDBConnector.loadLocalDataToDB();

		changeSceneVerwerfen(user, userEdit);

	}
}


