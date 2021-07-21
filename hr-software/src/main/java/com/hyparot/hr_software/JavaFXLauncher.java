package com.hyparot.hr_software;
	
import java.io.IOException;
import java.util.Iterator;

import com.hyparot.hr_software.src.backend.BIConnect;
import com.hyparot.hr_software.src.backend.SystemDBConnector;
import com.hyparot.hr_software.src.employee.Employee;
import com.hyparot.hr_software.src.employee.HR;
import com.hyparot.hr_software.src.employee.Person;
import com.hyparot.hr_software.src.employee.Superior;
import com.hyparot.hr_software.src.employeedata.Absence;
import com.hyparot.hr_software.src.employeedata.Date;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
			primaryStage.setTitle("HyparRot - HR Software");
			
			primaryStage.getIcons().add(new Image("/Icon_HyparRotIcon.png"));
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		SystemDBConnector.loadDBDataToLocal();
		
//		BIConnect bic = new BIConnect();
//		Superior user = (Superior)bic.getEmployeeByID(1007);
//		
//		Iterator<Absence> it = bic.getEmployeeByID(1001).getVacationOverview().keys().asIterator();
//		
//		while(it.hasNext()) {
//			Absence abs = it.next();
//			if(abs.getBegin().compare(new Date("2021-07-09")) == 0 && abs.getEnd().compare(new Date("2021-07-23")) == 0){
//				user.acceptVacation(abs);
//			}
//		}
//		
		//Absence vac = new Absence(user.getPersNr(), new Date("2021-08-09"), new Date("2021-08-23"), false);
		//System.out.println(user.applyForVacation(new Date("2021-08-09"), new Date("2021-08-23")));
//		Iterator<Absence> it = user.getVacationOverview().keys().asIterator();
//		while(it.hasNext()) {
//			Absence abs = it.next();
//			if(abs.getBegin().compare(new Date("2021-08-09")) == 0 && abs.getEnd().compare(new Date("2021-08-23")) == 0) {
//				user.cancelVacation(abs);
//			}
//			
//			System.out.println(abs);
//		}
//		Absence test = user.getAbsenceByDate(new Date("2021-08-09"), new Date("2021-08-23"));
		
		launch(args);
	}
}
