package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.hyparot.hr_software.src.backend.BusinessIntellegent;
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

	@FXML
	void cancel(ActionEvent event) throws IOException {
		cancelLogin();
	}

	@FXML
	void login(ActionEvent event) throws IOException {
		checkLogin();
	}

	@FXML
	void loginEnter(KeyEvent event) throws IOException {	
		if (event.getCode() == KeyCode.ENTER) {
			checkLogin();
		}

	}

	@FXML
	void initialize() {
		assert TFUsername != null : "fx:id=\"TFUsername\" was not injected: check your FXML file 'Sample.fxml'.";
		assert PFPassword != null : "fx:id=\"PFPassword\" was not injected: check your FXML file 'Sample.fxml'.";
		assert TFErrorMessage != null : "fx:id=\"TFErrorMessage\" was not injected: check your FXML file 'Sample.fxml'.";
		assert BLogin != null : "fx:id=\"BLogin\" was not injected: check your FXML file 'Sample.fxml'.";
		assert BCancel != null : "fx:id=\"BCancel\" was not injected: check your FXML file 'Sample.fxml'.";

	}

	public LoginController(Stage stage) {
		this.stage = stage;
	}


	private void checkLogin() throws IOException {

		if (TFUsername.getText() != null && PFPassword.getText() != null) {
			if(com.hyparot.hr_software.src.employee.Employee.loginUser(TFUsername.getText().toString(), PFPassword.getText().toString())) {
					changeSceneAfterLogin(BusinessIntellegent.getEmployeeByName(TFUsername.getText().toString()));
//			}
//			if (TFUsername.getText().toString().equals("u") && PFPassword.getText().toString().equals("p")) {
			}else {
					TFErrorMessage.setText("Falscher Nutzername oder Passwort.");
					//TFUsername.setText(null);
					PFPassword.setText(null);
			}
		}
	}

	private void cancelLogin() throws IOException {
		TFUsername.setText(null);
		PFPassword.setText(null);
		TFErrorMessage.setText(null);
	}

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
