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

public class TimeController {

	private Stage stage;
	
	private String user;
	
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private Text TResturlaubstage;

	    @FXML
	    private Button BArbeitszeitErfassen;

	    @FXML
	    private Button BKrankmelden;

	    @FXML
	    private Button BUrlaubBeantragen;

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
	    void zurück(ActionEvent event) throws IOException {
	    	changeSceneZurueck(user);
	    }

	    @FXML
	    void initialize() {
	        assert TResturlaubstage != null : "fx:id=\"TResturlaubstage\" was not injected: check your FXML file 'Time.fxml'.";
	        assert BArbeitszeitErfassen != null : "fx:id=\"BArbeitszeitErfassen\" was not injected: check your FXML file 'Time.fxml'.";
	        assert BKrankmelden != null : "fx:id=\"BKrankmelden\" was not injected: check your FXML file 'Time.fxml'.";
	        assert BUrlaubBeantragen != null : "fx:id=\"BUrlaubBeantragen\" was not injected: check your FXML file 'Time.fxml'.";
	        assert TKuerzel != null : "fx:id=\"TKuerzel\" was not injected: check your FXML file 'Time.fxml'.";
	        assert TVorname_Nachname != null : "fx:id=\"TVorname_Nachname\" was not injected: check your FXML file 'Time.fxml'.";
	        assert TPersonalnummer != null : "fx:id=\"TPersonalnummer\" was not injected: check your FXML file 'Time.fxml'.";
	        assert TStelle != null : "fx:id=\"TStelle\" was not injected: check your FXML file 'Time.fxml'.";
	        assert TTelefonnummer != null : "fx:id=\"TTelefonnummer\" was not injected: check your FXML file 'Time.fxml'.";
	        assert TE_Mail != null : "fx:id=\"TE_Mail\" was not injected: check your FXML file 'Time.fxml'.";
	        assert Bzurueck != null : "fx:id=\"Bzurueck\" was not injected: check your FXML file 'Time.fxml'.";
	        assert BLogout != null : "fx:id=\"BLogout\" was not injected: check your FXML file 'Time.fxml'.";

	    }

	public TimeController(Stage stage, String username) {
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
}
