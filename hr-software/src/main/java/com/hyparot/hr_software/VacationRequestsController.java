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

    @FXML
    void ablehnen(ActionEvent event) {

    }

    @FXML
    void genehmigen(ActionEvent event) {

    }

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
        assert TVornameData != null : "fx:id=\"TVornameData\" was not injected: check your FXML file 'VacationRequests.fxml'.";
        assert TNachnameData != null : "fx:id=\"TNachnameData\" was not injected: check your FXML file 'VacationRequests.fxml'.";
        assert TPersnrData != null : "fx:id=\"TPersnrData\" was not injected: check your FXML file 'VacationRequests.fxml'.";
        assert TVonData != null : "fx:id=\"TVonData\" was not injected: check your FXML file 'VacationRequests.fxml'.";
        assert TBisData != null : "fx:id=\"TBisData\" was not injected: check your FXML file 'VacationRequests.fxml'.";
        assert BGenehmigen != null : "fx:id=\"BGenehmigen\" was not injected: check your FXML file 'VacationRequests.fxml'.";
        assert BAblehnen != null : "fx:id=\"BAblehnen\" was not injected: check your FXML file 'VacationRequests.fxml'.";
        assert TKuerzel != null : "fx:id=\"TKuerzel\" was not injected: check your FXML file 'VacationRequests.fxml'.";
        assert TVorname_Nachname != null : "fx:id=\"TVorname_Nachname\" was not injected: check your FXML file 'VacationRequests.fxml'.";
        assert TPersonalnummer != null : "fx:id=\"TPersonalnummer\" was not injected: check your FXML file 'VacationRequests.fxml'.";
        assert TStelle != null : "fx:id=\"TStelle\" was not injected: check your FXML file 'VacationRequests.fxml'.";
        assert TTelefonnummer != null : "fx:id=\"TTelefonnummer\" was not injected: check your FXML file 'VacationRequests.fxml'.";
        assert TE_Mail != null : "fx:id=\"TE_Mail\" was not injected: check your FXML file 'VacationRequests.fxml'.";
        assert BZurueck != null : "fx:id=\"BZurueck\" was not injected: check your FXML file 'VacationRequests.fxml'.";
        assert BLogout != null : "fx:id=\"BLogout\" was not injected: check your FXML file 'VacationRequests.fxml'.";

    }

	private Stage stage;
	private Employee user;

	public VacationRequestsController(Stage stage, Employee username) {
		this.stage = stage;
		this.user = username;
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


	}
	
	public void traverseVacations() {
		TVornameData.setText(null);
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
	
	public void acceptDeclineRequest(boolean decision) {
		
	}

}
