package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.hyparot.hr_software.src.mitarbeiter.Employee;

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
    private Text TGehaltData;

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
    	changeSceneZurueck(user);
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
        assert TGehaltData != null : "fx:id=\"TGehaltData\" was not injected: check your FXML file 'ContractData.fxml'.";
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
	private String user;

	public ContractDataController(Stage stage, String username) {
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
		//------------------------------------------------------------------------
		TGehaltData.setText("ERGÄNZEN!");
		TArbeitszeitData.setText(String.valueOf(user.getWorkingTime_contract()));
		TUrlaubstageData.setText(String.valueOf(user.getVacation_contract()));
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
}

