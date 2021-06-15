package com.hyparot.hr_software;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class calendarController {

	private String User;
	
	private Stage stage;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BZurueck;

    @FXML
    void back(ActionEvent event) throws IOException {
    	changeSceneAfterLogin(User);
    }

    @FXML
    void initialize() {
        assert BZurueck != null : "fx:id=\"BZurueck\" was not injected: check your FXML file 'calendar.fxml'.";

    }
    
	public calendarController(Stage stage, String Username) {
		this.stage = stage;
		this.User = Username;
	}
	
	public void changeSceneAfterLogin(String Username) throws IOException {
		var loader = new FXMLLoader();
		var fRController = new FRController(stage, Username);
		loader.setLocation(getClass().getResource("/afterLogin.fxml"));
		loader.setController(fRController);
		stage.getScene().setRoot(loader.load());
	}
	
}

