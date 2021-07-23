package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.hyparot.hr_software.src.backend.BIConnect;
import com.hyparot.hr_software.src.employee.Employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController {

	private Stage stage;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField TFUsername;

	@FXML
	private PasswordField PFPassword;

	@FXML
	private Label TFErrorMessage;

	@FXML
	private Button BLogin;

	@FXML
	private Button BCancel;

	//Button Eingaben zurücksetzen
	@FXML
	void cancel(ActionEvent event) throws IOException {
		cancelLogin();
	}

	//Button einloggen
	@FXML
	void login(ActionEvent event) throws IOException {
		checkLogin();
	}

	//Button checken ob Enterknopf gedrückt wird (Zum einloggen)
	@FXML
	void loginEnter(KeyEvent event) throws IOException {	
		if (event.getCode() == KeyCode.ENTER) {
			checkLogin();
		}
	}

	@FXML
	void initialize() {

	}

	//Konstruktor
	public LoginController(Stage stage) {
		this.stage = stage;
	}

	//Prüfen ob Logindaten korrekt
	private void checkLogin() throws IOException {
		if (TFUsername.getText() != null && PFPassword.getText() != null) {
			BIConnect bic = new BIConnect();
			//Username und Passwort prüfen
			if(bic.loginUser(TFUsername.getText().toString(), PFPassword.getText().toString())) {
				//Falls korrekt: Einloggen
				
				changeSceneAfterLogin(bic.getEmployeeByName(TFUsername.getText().toString()));
			}else {
				//Falls inkorrekt: Fehlermeldung
				TFErrorMessage.setText("Falscher Nutzername oder Passwort.");
				PFPassword.setText(null);
			}
		}
	}

	//Eingaben zurücksetzen
	private void cancelLogin() throws IOException {
		TFUsername.setText(null);
		PFPassword.setText(null);
		TFErrorMessage.setText(null);
	}

	//Szenenwechsel zu Hauptfenster nach Login
	public void changeSceneAfterLogin(Employee Username) throws IOException {
		var loader = new FXMLLoader();
		var frController = new FRController(stage, Username);
		loader.setLocation(getClass().getResource("/afterLogin.fxml"));
		loader.setController(frController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		frController.schreiben();
	}
}
