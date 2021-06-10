package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FRController {

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
    void initialize() {
        assert BCalendarShow != null : "fx:id=\"BCalendarShow\" was not injected: check your FXML file 'afterLogin.fxml'.";
        assert BLogout != null : "fx:id=\"BLogout\" was not injected: check your FXML file 'afterLogin.fxml'.";

    }
	
	public FRController(Stage stage) {
		this.stage = stage;
	}

	public void changeSceneCalendar() throws IOException {
		var loader = new FXMLLoader();
		var CalendarController = new calendarController(stage);
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
