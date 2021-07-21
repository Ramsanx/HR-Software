package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.hyparot.hr_software.src.employee.Employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContractDataController {

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
	private Text TArbeitszeitData;

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
	private Text TUrlaubstageData;

	@FXML
	private Text TVertragsdaten;

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
	void logout(ActionEvent event) throws IOException {
		changeSceneLogout();
	}

	@FXML
	void zurueck(ActionEvent event) throws IOException {
		if (this.userEdit == null) {
			changeSceneZurueck(user);
		} else {
			changeSceneZurueckOther(user, userEdit);
		}
	}

	@FXML
	void initialize() {
		assert TVornameData != null : "fx:id=\"TVornameData\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TNachnameData != null : "fx:id=\"TNachnameData\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TStelleData != null : "fx:id=\"TStelleData\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TTelefonnummerData != null : "fx:id=\"TTelefonnummerData\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TPersonalnummerData != null : "fx:id=\"TPersonalnummerData\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TGeburtstagData != null : "fx:id=\"TGeburtstagData\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TEinstellungsdatumData != null : "fx:id=\"TEinstellungsdatumData\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TArbeitszeitData != null : "fx:id=\"TArbeitszeitData\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TLandData != null : "fx:id=\"TLandData\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TPLZData != null : "fx:id=\"TPLZData\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TStadtData != null : "fx:id=\"TStadtData\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TStrasseData != null : "fx:id=\"TStrasseData\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert THausnummerData != null : "fx:id=\"THausnummerData\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TZusatzData != null : "fx:id=\"TZusatzData\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TUrlaubstageData != null : "fx:id=\"TUrlaubstageData\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TKuerzel != null : "fx:id=\"TKuerzel\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TVorname_Nachname != null : "fx:id=\"TVorname_Nachname\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TPersonalnummer != null : "fx:id=\"TPersonalnummer\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TStelle != null : "fx:id=\"TStelle\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TTelefonnummer != null : "fx:id=\"TTelefonnummer\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert TE_Mail != null : "fx:id=\"TE_Mail\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert Bzurueck != null : "fx:id=\"Bzurueck\" was not injected: check your FXML file 'ContractData.fxml'.";
		assert BLogout != null : "fx:id=\"BLogout\" was not injected: check your FXML file 'ContractData.fxml'.";

	}

	private Stage stage;
	private Employee user;
	private Employee userEdit;
	private Employee userC;


	public ContractDataController(Stage stage, Employee username) {
		this.stage = stage;
		this.user = username;
		this.userC = username;
	}

	public ContractDataController(Stage stage, Employee username, Employee userEdit) {
		this.stage = stage;
		this.user = username;
		this.userC = userEdit;
		this.userEdit = userEdit;
	}

	public void schreiben() {
		TVorname_Nachname.setText(user.getFirstname() + " " + user.getLastname());
		TPersonalnummer.setText((String.valueOf(user.getPersNr()))); 
		TStelle.setText(user.getJobTitle());
		TTelefonnummer.setText(user.getPhoneNumber());
		TE_Mail.setText(user.getEMail());
		TKuerzel.setText(user.getFirstname().charAt(0) + "" + user.getLastname().charAt(0));

		TVornameData.setText(userC.getFirstname());
		TNachnameData.setText(userC.getLastname());
		TStelleData.setText(userC.getJobTitle());
		TTelefonnummerData.setText(userC.getPhoneNumber());
		TPersonalnummerData.setText(String.valueOf(userC.getPersNr()));
		TGeburtstagData.setText(String.valueOf(userC.getBirthday().toString()));
		TEinstellungsdatumData.setText(userC.getStartDate().toString());

		TLandData.setText(userC.getAdress().getCountry());
		TPLZData.setText(String.valueOf(userC.getAdress().getPostcode()));
		TStadtData.setText(userC.getAdress().getCity());
		TStrasseData.setText(userC.getAdress().getStreet());
		THausnummerData.setText(String.valueOf(userC.getAdress().getHouseNr()));
		TZusatzData.setText(userC.getAdress().getHousenumberSupplement());
		if (userC.getAdress().getHousenumberSupplement().isEmpty()) {
			TZusatzData.setText("-");
		} else {
			TZusatzData.setText(userC.getAdress().getHousenumberSupplement());
		}
		TArbeitszeitData.setText(String.valueOf(userC.getWorkingTime_contract()));
		TUrlaubstageData.setText(String.valueOf(userC.getVacation_contract()));

		setContractInformation();
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
		stage.setTitle("HyparRot - HR Software");
	}

	public void changeSceneZurueckOther(Employee Username, Employee UserEdit) throws IOException {
		var loader = new FXMLLoader();
		var personalDataController = new PersonalDataController(stage, Username, UserEdit);
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

	public void changeSceneZurueck(Employee Username) throws IOException {
		var loader = new FXMLLoader();
		var personalDataController = new PersonalDataController(stage, Username);
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

	public void setContractInformation() {
		TVertragsdaten.setText("Allgemeine Vertragsbedingungen \n"
				+ "\nI. Angebot und Vertragsabschluss \n"
				+ "Der vom Arbeitnehmer unterzeichnete Vertrag ist eine bindende Verbindlichkeit.\n"
				+ "\nII. Überlassene Unterlagen"
				+ "An allen im Zusammenhang mit dem geschlossenen Vertrag \n mit dem Arbeitnehmer "
				+ "überlassenen Unterlagen – auch in elektronischer Form - behalten wir uns das Eigentums- \n"
				+ " und Urheberrecht vor. Diese Unterlagen dürfen Dritten nicht zugänglich gemacht werden, es \n"
				+ " sei denn, wir erteilen dem Arbeitnehmer unsere ausdrückliche schriftliche Zustimmung. \n"
				+ "\nIII. Kündigungsrechte \n"
				+ "Dem Angestellten steht das Recht zur Auflösung des Vertragsverhältnis zu. Die schriftliche \n"
				+ "Kündigung muss mindestens 4 Wochen vor Beendigungsschluss vorliegen. Bei einem \n"
				+ "Verstoß gegen die Datenschutzrechte sowie die betriebliche Schweigepflicht darf es zu einer \n"
				+ "sofortigen Beendigung durch den Arbeitgeber kommen.\n"
				+ "\nIV. Sonstiges \n"
				+ "1. Sollten einzelne Bestimmungen dieses Vertrages unwirksam sein oder \n"
				+ "werden oder eine Lücke enthalten, so bleiben die übrigen Bestimmungen hiervon unberührt.");
	}
}

