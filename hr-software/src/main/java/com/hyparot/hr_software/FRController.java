package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.hyparot.hr_software.src.mitarbeiter.Angestellte;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FRController {

	private String User;
	
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
    private Text TVorname_Nachname = new Text();
	
	@FXML
    private Text TPersonalnummer = new Text();
	
	@FXML
    private Text TStelle = new Text();
	
	@FXML
    private Text TTelefonnummer = new Text();
	
	@FXML
    private Text TE_Mail = new Text();

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
    
    
	
	public FRController(Stage stage, String Username) {
		this.stage = stage;
		this.User = Username;
		schreiben();
		
	}
	
	private void schreiben() {
		Angestellte nutzer = com.hyparot.hr_software.src.backend.BusinessIntellegent.getEmployeeByName(User);
		TVorname_Nachname.setText(nutzer.getVorname() + " " + nutzer.getNachname());
		TPersonalnummer.setText((String.valueOf(nutzer.getPersonalNummer()))); 
		TStelle.setText(nutzer.getStellenBezeichnung());
		TTelefonnummer.setText(nutzer.getTelefonNummer());
		TE_Mail.setText(nutzer.getEmailAdresse());
	}
		
		
	public void changeSceneCalendar() throws IOException {
		var loader = new FXMLLoader();
		var CalendarController = new calendarController(stage, User);
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
