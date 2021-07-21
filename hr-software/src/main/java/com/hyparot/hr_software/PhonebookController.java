package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

import com.hyparot.hr_software.src.backend.BusinessIntelligence;
import com.hyparot.hr_software.src.backend.LocalStorage;
import com.hyparot.hr_software.src.backend.SystemDBConnector;
import com.hyparot.hr_software.src.employee.Employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class PhonebookController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<Employee> TableView;
	
    @FXML
    private TableColumn<Employee, Integer> TCPersNr;

	@FXML
	private TableColumn<Employee, String> TCSName;
	
    @FXML
    private TableColumn<Employee, String> TCLName;

	@FXML
	private TableColumn<Employee, String> TCMail;

	@FXML
	private TableColumn<Employee, String> TCphonenumber;

	@FXML
	private TableColumn<Employee, String> TCJobTitle;

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
	private Button BPersonalData;

	@FXML
	private Button BLogout;

	@FXML
	void logout(ActionEvent event) throws IOException {
		changeSceneLogout();
	}

	@FXML
	void zurueck(ActionEvent event) throws IOException {
		changeSceneZurueck(user);
	}

	@FXML
	void initialize() {
        assert TableView != null : "fx:id=\"TableView\" was not injected: check your FXML file 'Phonebook.fxml'.";
        assert TCPersNr != null : "fx:id=\"TCPersNr\" was not injected: check your FXML file 'Phonebook.fxml'.";
        assert TCSName != null : "fx:id=\"TCSName\" was not injected: check your FXML file 'Phonebook.fxml'.";
        assert TCLName != null : "fx:id=\"TCLName\" was not injected: check your FXML file 'Phonebook.fxml'.";
        assert TCMail != null : "fx:id=\"TCMail\" was not injected: check your FXML file 'Phonebook.fxml'.";
        assert TCphonenumber != null : "fx:id=\"TCphonenumber\" was not injected: check your FXML file 'Phonebook.fxml'.";
        assert TCJobTitle != null : "fx:id=\"TCJobTitle\" was not injected: check your FXML file 'Phonebook.fxml'.";
        assert TKuerzel != null : "fx:id=\"TKuerzel\" was not injected: check your FXML file 'Phonebook.fxml'.";
        assert TVorname_Nachname != null : "fx:id=\"TVorname_Nachname\" was not injected: check your FXML file 'Phonebook.fxml'.";
        assert TPersonalnummer != null : "fx:id=\"TPersonalnummer\" was not injected: check your FXML file 'Phonebook.fxml'.";
        assert TStelle != null : "fx:id=\"TStelle\" was not injected: check your FXML file 'Phonebook.fxml'.";
        assert TTelefonnummer != null : "fx:id=\"TTelefonnummer\" was not injected: check your FXML file 'Phonebook.fxml'.";
        assert TE_Mail != null : "fx:id=\"TE_Mail\" was not injected: check your FXML file 'Phonebook.fxml'.";
        assert BPersonalData != null : "fx:id=\"BPersonalData\" was not injected: check your FXML file 'Phonebook.fxml'.";
        assert BLogout != null : "fx:id=\"BLogout\" was not injected: check your FXML file 'Phonebook.fxml'.";
	
		Vector<Employee> employeeTable = LocalStorage.employees;
		TableView.setItems(FXCollections.observableList(employeeTable));
		
		TCPersNr.setCellValueFactory(new PropertyValueFactory<>("persNr"));
		TCSName.setCellValueFactory(new PropertyValueFactory<>("firstname"));
		TCLName.setCellValueFactory(new PropertyValueFactory<>("lastname"));
		TCMail.setCellValueFactory(new PropertyValueFactory<>("eMail"));
		TCphonenumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		TCJobTitle.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
	
	
		
	}

	private Employee user;
	private Stage stage;


	public PhonebookController(Stage stage, Employee username) {
		this.stage = stage;
		this.user = username;
		
	}

	

	public void schreiben() {
		TVorname_Nachname.setText(user.getFirstname() + " " + user.getLastname());
		TPersonalnummer.setText((String.valueOf(user.getPersNr()))); 
		TStelle.setText(user.getJobTitle());
		TTelefonnummer.setText(user.getPhoneNumber());
		TE_Mail.setText(user.getEMail());
		TKuerzel.setText(user.getFirstname().charAt(0) + "" + user.getLastname().charAt(0));

			final ObservableList<Employee> data = FXCollections.observableArrayList();
	
		
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
			stage.setTitle("HyparRot - HR Software");
			stage.setResizable(false);

		}

		public void changeSceneZurueck(Employee user) throws IOException {
			var loader = new FXMLLoader();
			var fRController = new FRController(stage, user);
			loader.setLocation(getClass().getResource("/afterLogin.fxml"));
			loader.setController(fRController);
			stage.getScene().setRoot(loader.load());
			stage.setWidth(1280);
			stage.setHeight(720);
			stage.centerOnScreen();
			stage.setResizable(false);
			stage.setTitle("HyparRot - HR Software");
			fRController.schreiben();
		}
	}