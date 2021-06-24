package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.hyparot.hr_software.src.mitarbeiter.Employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FRController {

	private String user;
	
	private Stage stage;
		
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private Button BZeiterfassung;

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
	    private Button BLogout;
	    
	    @FXML
	    private Button BPersonalData;

	    @FXML
	    void logout(ActionEvent event) throws IOException {
	    	changeSceneLogout();
	    }

	    @FXML
	    void zeiterfassen(ActionEvent event) throws IOException {
	    	changeSceneTime(user);
	    }

	    @FXML
	    void personalData(ActionEvent event) throws IOException {
	    	changeScenePersonalData(user);
	    }
	    
	    @FXML
	    void initialize() {
	        assert BZeiterfassung != null : "fx:id=\"BZeiterfassung\" was not injected: check your FXML file 'afterLogin.fxml'.";
	        assert TKuerzel != null : "fx:id=\"TKuerzel\" was not injected: check your FXML file 'afterLogin.fxml'.";
	        assert TVorname_Nachname != null : "fx:id=\"TVorname_Nachname\" was not injected: check your FXML file 'afterLogin.fxml'.";
	        assert TPersonalnummer != null : "fx:id=\"TPersonalnummer\" was not injected: check your FXML file 'afterLogin.fxml'.";
	        assert TStelle != null : "fx:id=\"TStelle\" was not injected: check your FXML file 'afterLogin.fxml'.";
	        assert TTelefonnummer != null : "fx:id=\"TTelefonnummer\" was not injected: check your FXML file 'afterLogin.fxml'.";
	        assert TE_Mail != null : "fx:id=\"TE_Mail\" was not injected: check your FXML file 'afterLogin.fxml'.";
	        assert BLogout != null : "fx:id=\"BLogout\" was not injected: check your FXML file 'afterLogin.fxml'.";
	        assert BPersonalData != null : "fx:id=\"BLogout\" was not injected: check your FXML file 'afterLogin.fxml'.";
	    }
    	
	public FRController(Stage stage, String username) {
		this.stage = stage;
		this.user = username;
		//schreiben();
		
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
	
	public void changeSceneTime(String Username) throws IOException {
		var loader = new FXMLLoader();
		var timeController = new TimeController(stage, Username);
		loader.setLocation(getClass().getResource("/Time.fxml"));
		loader.setController(timeController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		timeController.schreiben();
	}
	
	public void changeScenePersonalData(String Username) throws IOException {
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
