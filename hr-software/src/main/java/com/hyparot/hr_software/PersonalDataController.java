package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.hyparot.hr_software.src.employee.Employee;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PersonalDataController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Text TVornameData;

	@FXML
	private Text TNachnameData;

	@FXML
	private Text TStelleData;

	@FXML
	private Text TTelefonnummerData;

	@FXML
	private Text TPersonalnummerData;

	@FXML
	private Text TGeburtstagData;

	@FXML
	private Text TEinstellungsdatumData;

	@FXML
	private Button BBearbeiten;

	@FXML
	private Text TLandData;

	@FXML
	private Text TPLZData;

	@FXML
	private Text TStadtData;

	@FXML
	private Text TStrasseData;

	@FXML
	private Text THausnummerData;

	@FXML
	private Text TZusatzData;

	@FXML
	private Button BVertragsdaten;

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

	@FXML
	void contract(ActionEvent event) throws IOException {
		changeSceneContract(user);
	}

	@FXML
	void logout(ActionEvent event) throws IOException {
		changeSceneLogout();
	}

	@FXML
	void personalDataEdit(ActionEvent event) throws IOException {
		changeScenePersonalDataEdit(user);
	}


	@FXML
	void zurueck(ActionEvent event) throws IOException {
		changeSceneZurueck(user);
	}

	@FXML
	void initialize() {
		assert TVornameData != null : "fx:id=\"TVornameData\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TNachnameData != null : "fx:id=\"TNachnameData\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TStelleData != null : "fx:id=\"TStelleData\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TTelefonnummerData != null : "fx:id=\"TTelefonnummerData\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TPersonalnummerData != null : "fx:id=\"TPersonalnummerData\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TGeburtstagData != null : "fx:id=\"TGeburtstagData\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TEinstellungsdatumData != null : "fx:id=\"TEinstellungsdatumData\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert BBearbeiten != null : "fx:id=\"BBearbeiten\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TLandData != null : "fx:id=\"TLandData\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TPLZData != null : "fx:id=\"TPLZData\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TStadtData != null : "fx:id=\"TStadtData\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TStrasseData != null : "fx:id=\"TStrasseData\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert THausnummerData != null : "fx:id=\"THausnummerData\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TZusatzData != null : "fx:id=\"TZusatzData\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert BVertragsdaten != null : "fx:id=\"BVertragsdaten\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TKuerzel != null : "fx:id=\"TKuerzel\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TVorname_Nachname != null : "fx:id=\"TVorname_Nachname\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TPersonalnummer != null : "fx:id=\"TPersonalnummer\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TStelle != null : "fx:id=\"TStelle\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TTelefonnummer != null : "fx:id=\"TTelefonnummer\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert TE_Mail != null : "fx:id=\"TE_Mail\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert Bzurueck != null : "fx:id=\"Bzurueck\" was not injected: check your FXML file 'PersonalData.fxml'.";
		assert BLogout != null : "fx:id=\"BLogout\" was not injected: check your FXML file 'PersonalData.fxml'.";

	}




	private Stage stage;
	private String user;

	public PersonalDataController(Stage stage, String username) {
		this.stage = stage;
		this.user = username;
	}

	public void schreiben() {
		Employee user = com.hyparot.hr_software.src.backend.BusinessIntellegent.getEmployeeByName(this.user);
		TVorname_Nachname.setText(user.getFirstname() + " " + user.getLastname());
		TPersonalnummer.setText((String.valueOf(user.getPersNr()))); 
		TStelle.setText(user.getJobTitle());
		TTelefonnummer.setText(user.getPhoneNumber());
		TE_Mail.setText(user.getEMail());
		TKuerzel.setText(user.getFirstname().charAt(0) + "" + user.getLastname().charAt(0));

		TVornameData.setText(user.getFirstname());
		TNachnameData.setText(user.getLastname());
		TStelleData.setText(user.getJobTitle());
		TTelefonnummerData.setText(user.getPhoneNumber());
		TPersonalnummerData.setText(String.valueOf(user.getPersNr()));
		TGeburtstagData.setText(String.valueOf(user.getBirthday().toString()));
		TEinstellungsdatumData.setText(user.getStartDate().toString());

		TLandData.setText(user.getAdress().getCountry());
		TPLZData.setText(String.valueOf(user.getAdress().getPostcode()));
		TStadtData.setText(user.getAdress().getCity());
		TStrasseData.setText(user.getAdress().getStreet());
		THausnummerData.setText(String.valueOf(user.getAdress().getHouseNr()));
		TZusatzData.setText(user.getAdress().getHousenumberSupplement());
		if (user.getAdress().getHousenumberSupplement().isEmpty()) {
			TZusatzData.setText("-");
		} else {
			TZusatzData.setText(user.getAdress().getHousenumberSupplement());
		}
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

	public void changeSceneZurueck(String Username) throws IOException {
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

	public void changeScenePersonalDataEdit(String Username) throws IOException {
		var loader = new FXMLLoader();
		var personalDataEditController = new PersonalDataEditController(stage, Username);
		loader.setLocation(getClass().getResource("/PersonalDataEdit.fxml"));
		loader.setController(personalDataEditController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		personalDataEditController.schreiben();
	}
	
	public void changeSceneContract(String Username) throws IOException {
		var loader = new FXMLLoader();
		var contractDataController = new ContractDataController(stage, Username);
		loader.setLocation(getClass().getResource("/ContractData.fxml"));
		loader.setController(contractDataController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		contractDataController.schreiben();
	}
}
