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

	//Button Vertragsdaten einsehen - Szenenwechsel
	@FXML
	void contract(ActionEvent event) throws IOException {
		//Eigene Vertragsdaten einsehen
		if (this.userEdit == null) {
			changeSceneContract(user);
		} else {
			//Fremde Vertragsdaten einsehen (userEdit)
			changeSceneContractOther(user, userEdit);
		}
	}

	//Button Logout - Szenenwechsel
	@FXML
	void logout(ActionEvent event) throws IOException {
		changeSceneLogout();
	}

	//Button persönliche Daten einsehen - Szenenwechsel
	@FXML
	void personalDataEdit(ActionEvent event) throws IOException {
		//Eigene persönliche Daten einsehen
		if (userEdit == null) {
			changeScenePersonalDataEdit(user);
		} else {
			//Fremde persönliche Daten einsehen (userEdit)
			changeScenePersonalDataEditOther(user, userEdit);
		}
	}

	//Button Zurück zum Hauptfenster - Szenenwechsel
	@FXML
	void zurueck(ActionEvent event) throws IOException {
		changeSceneZurueck(user);
	}

	@FXML
	void initialize() {

	}

	private Stage stage;
	private Employee user;
	private Employee userEdit; //Fremder User, dessen Daten eingesehen werden sollen
	private Employee userC; //Hilfsobjekt zur Darstellung

	//Konstruktor: Eigene persönliche Daten
	public PersonalDataController(Stage stage, Employee username) {
		this.stage = stage;
		this.user = username;
		this.userC = username;
	}

	//Konstruktor: Fremde persönliche Daten
	public PersonalDataController(Stage stage, Employee username, Employee usernameEdit) {
		this.stage = stage;
		this.user = username;
		this.userC = usernameEdit;
		this.userEdit = usernameEdit;
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

		//Persönliche Daten des gewählten Users einfügen (eigene oder fremde)
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
		//Falls kein Zusatz vorhanden: Mit "-" ausfüllen
		if (userC.getAdress().getHousenumberSupplement().isEmpty()) {
			TZusatzData.setText("-");
		} else {
			TZusatzData.setText(userC.getAdress().getHousenumberSupplement());
		}
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
		loader.setLocation(getClass().getResource("/AfterLogin.fxml"));
		loader.setController(fRController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		fRController.schreiben();
	}

	//Szenenwechsel: Daten bearbeiten (eigene)
	public void changeScenePersonalDataEdit(Employee Username) throws IOException {
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

	//Szenenwechsel: Daten bearbeiten (fremde)
	public void changeScenePersonalDataEditOther(Employee Username, Employee userEdit) throws IOException {
		var loader = new FXMLLoader();
		var personalDataEditOtherController = new PersonalDataEditOtherController(stage, Username, userEdit);
		loader.setLocation(getClass().getResource("/PersonalDataEditOther.fxml"));
		loader.setController(personalDataEditOtherController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		personalDataEditOtherController.schreiben();
	}

	//Szenenwechsel: Vertragsdaten einsehen (eigene)
	public void changeSceneContract(Employee Username) throws IOException {
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

	//Szenenwechsel: Vertragsdaten einsehen (fremde)
	public void changeSceneContractOther(Employee Username, Employee UserEdit) throws IOException {
		var loader = new FXMLLoader();
		var contractDataController = new ContractDataController(stage, Username, UserEdit);
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
