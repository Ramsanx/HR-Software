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
	private Button BCalendarShow;
	
	@FXML
	private Button BLogout;

	@FXML
	void calendarShow(ActionEvent event) throws IOException {
		changeSceneCalendar();
	}
	
	@FXML
    void logout(ActionEvent event) throws IOException {
		changeSceneLogout();
    }
	
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
    void initialize() {
        assert BCalendarShow != null : "fx:id=\"BCalendarShow\" was not injected: check your FXML file 'afterLogin.fxml'.";
        assert BLogout != null : "fx:id=\"BLogout\" was not injected: check your FXML file 'afterLogin.fxml'.";
        //assert BLogout != null : "fx:id=\"BLogout\" was not injected: check your FXML file 'afterLogin.fxml'.";
        assert TVorname_Nachname != null : "fx:id=\"TVorname_Nachname\" was not injected: check your FXML file 'afterLogin.fxml'.";
		assert TPersonalnummer != null : "fx:id=\"TPersonalnummer\" was not injected: check your FXML file 'afterLogin.fxml'.";
		assert TStelle != null : "fx:id=\"TStelle\" was not injected: check your FXML file 'afterLogin.fxml'.";
		assert TTelefonnummer != null : "fx:id=\"TTelefonnummer\" was not injected: check your FXML file 'afterLogin.fxml'.";
		assert TE_Mail != null : "fx:id=\"TE_Mail\" was not injected: check your FXML file 'afterLogin.fxml'.";
		

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
	}
		
		
	public void changeSceneCalendar() throws IOException {
		var loader = new FXMLLoader();
		var CalendarController = new calendarController(stage, user);
		loader.setLocation(getClass().getResource("/calendar.fxml"));
		loader.setController(CalendarController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
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
