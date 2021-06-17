package com.hyparot.hr_software;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class JavaFXLauncher extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			Parent root = FXMLLoader.load(getClass().getResource("/Sample.fxml"));
			var loader = new FXMLLoader();
			var mainController = new LoginController(primaryStage);       

	        loader.setLocation(getClass().getResource("/Sample.fxml"));
			loader.setController(mainController);  
	        Parent root = loader.load();     
	        Scene scene = new Scene(root);
	        
			scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
