package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import com.hyparot.hr_software.src.backend.BusinessIntelligence;
import com.hyparot.hr_software.src.backend.SystemDBConnector;
import com.hyparot.hr_software.src.employee.Employee;
import com.hyparot.hr_software.src.employee.HR;
import com.hyparot.hr_software.src.employeedata.Adress;
import com.hyparot.hr_software.src.employeedata.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.text.Text;

public class CreateUserController {

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
	private TextField TFTelefonnummer;

	@FXML
	private ChoiceBox<String> CBArbeitszeit;

	@FXML
	private TextField TFGeburtstag;

	@FXML
	private Text TUsername;

	@FXML
	private Button BUserErstellen;

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
	private TextField TFPasswort;

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

	ObservableList<String> availableChoices = FXCollections.observableArrayList("40", "36");

	@FXML
	void createUser(ActionEvent event) throws IOException {
		createEmployee();
	}

	@FXML
	void logout(ActionEvent event) throws IOException {
		changeSceneLogout();
	}

	@FXML
	void verwerfen(ActionEvent event) throws IOException {
		changeSceneVerwerfen(user);
	}

	@FXML
	void createUsername(KeyEvent event) throws IOException {
		if (TFVorname.getText().toString().equals("") || TFNachname.getText().toString().equals("")) {
			return;
		} else {
			TUsername.setText(TFVorname.getText().substring(0,1).toLowerCase() + "" + TFNachname.getText().toString().toLowerCase());
		}
	}

	@FXML
	void initialize() {
		assert TFVorname != null : "fx:id=\"TFVorname\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TFNachname != null : "fx:id=\"TFNachname\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TFStelle != null : "fx:id=\"TFStelle\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TFTelefonnummer != null : "fx:id=\"TFTelefonnummer\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert CBArbeitszeit != null : "fx:id=\"CBArbeitszeit\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TFGeburtstag != null : "fx:id=\"TFGeburtstag\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TUsername != null : "fx:id=\"TUsername\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert BUserErstellen != null : "fx:id=\"BUserErstellen\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TFLand != null : "fx:id=\"TFLand\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TFPLZ != null : "fx:id=\"TFPLZ\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TFStadt != null : "fx:id=\"TFStadt\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TFStraße != null : "fx:id=\"TFStraße\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TFHausnummer != null : "fx:id=\"TFHausnummer\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TFZusatz != null : "fx:id=\"TFZusatz\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TFPasswort != null : "fx:id=\"TFPasswort\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TKuerzel != null : "fx:id=\"TKuerzel\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TVorname_Nachname != null : "fx:id=\"TVorname_Nachname\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TPersonalnummer != null : "fx:id=\"TPersonalnummer\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TStelle != null : "fx:id=\"TStelle\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TTelefonnummer != null : "fx:id=\"TTelefonnummer\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert TE_Mail != null : "fx:id=\"TE_Mail\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert BVerwerfen != null : "fx:id=\"BVerwerfen\" was not injected: check your FXML file 'CreateEmployee.fxml'.";
		assert BLogout != null : "fx:id=\"BLogout\" was not injected: check your FXML file 'CreateEmployee.fxml'.";

	}

	private Stage stage;
	private HR user;
	private String group;

	public CreateUserController(Stage stage, Employee username, String group) {
		this.stage = stage;
		this.user = (HR) username;
		this.group = group;
	}

	public void schreiben() {
		//Uneditable Text
		TVorname_Nachname.setText(user.getFirstname() + " " + user.getLastname());
		TPersonalnummer.setText((String.valueOf(user.getPersNr()))); 
		TStelle.setText(user.getJobTitle());
		TTelefonnummer.setText(user.getPhoneNumber());
		TE_Mail.setText(user.getEMail());
		TKuerzel.setText(user.getFirstname().charAt(0) + "" + user.getLastname().charAt(0));

		CBArbeitszeit.setItems(availableChoices);
		CBArbeitszeit.setValue("Arbeitszeit");
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

	public void changeSceneVerwerfen(Employee Username) throws IOException {
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

	public void createEmployee() throws IOException {
		String firstNameNew = TFVorname.getText();
		String lastNameNew = TFNachname.getText();
		String jobTitleNew = TFStelle.getText();
		String countryNew = TFLand.getText();
		String cityNew = TFStadt.getText();
		String streetNew = TFStraße.getText();
		String housenrSupplementNew = TFZusatz.getText();
		String stelleNew = TFStelle.getText();
		String phonenumberNew = TFTelefonnummer.getText();
		String usernameNew = TUsername.getText();
		String passwordNew = TFPasswort.getText();
		

		String workingTimeNew2 = CBArbeitszeit.getSelectionModel().getSelectedItem().toString();
		if (workingTimeNew2.equals("Arbeitszeit") || workingTimeNew2.equals("Ungültige Auswahl")) {
			CBArbeitszeit.setValue("Ungültige Auswahl");
		}
		int workingTimeNew = Integer.parseInt(workingTimeNew2);

		int postCodeNew;
		int housenrNew;
		Date birthdayNew;
		Adress adressNew;

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

		if (housenrSupplementNew == null) {
			adressNew = new Adress(countryNew, postCodeNew, cityNew, streetNew, housenrNew);
		} else {
			adressNew = new Adress(countryNew, postCodeNew, cityNew, streetNew, housenrNew, housenrSupplementNew);
		}
		
		Calendar today = new GregorianCalendar();
		Date startDateNew = new Date(today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DAY_OF_MONTH));

		user.setNewEmployee(group, usernameNew, passwordNew, firstNameNew, lastNameNew, jobTitleNew, phonenumberNew, workingTimeNew, birthdayNew, startDateNew, adressNew);
		SystemDBConnector.loadLocalDataToDB();

		changeSceneVerwerfen(user);

	}
}
