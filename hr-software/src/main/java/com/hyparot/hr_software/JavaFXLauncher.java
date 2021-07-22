package com.hyparot.hr_software;

import com.hyparot.hr_software.src.backend.SystemDBConnector;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;


public class JavaFXLauncher extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Ausgangsklasse
			var loader = new FXMLLoader();
			var mainController = new LoginController(primaryStage);       

			//Loginscreen initialisieren
	        loader.setLocation(getClass().getResource("/Sample.fxml"));
			loader.setController(mainController);  
	        Parent root = loader.load();     
	        Scene scene = new Scene(root);
	        
			scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			//Titel und Icon setzen
			primaryStage.setTitle("HyparRot - HR Software");
			primaryStage.getIcons().add(new Image("/Icon_HyparRotIcon.png"));
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		SystemDBConnector.loadDBDataToLocal();	
		launch(args);
	}
}
