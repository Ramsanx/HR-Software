package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import com.hyparot.hr_software.src.backend.LocalStorage;
import com.hyparot.hr_software.src.employee.Employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

	//Button logout - Szenenwechsel
	@FXML
	void logout(ActionEvent event) throws IOException {
		changeSceneLogout();
	}

	//Button Zurück zum Hauptfenster - Szenenwechsel
	@FXML
	void zurueck(ActionEvent event) throws IOException {
		changeSceneZurueck(user);
	}

	//Daten in Tabelle einfügen
	@FXML
	void initialize() {
		//Vektor der Employees erhalten
		Vector<Employee> employeeTable = LocalStorage.employees;
		TableView.setItems(FXCollections.observableList(employeeTable));

		//Einfügen
		TCPersNr.setCellValueFactory(new PropertyValueFactory<>("persNr"));
		TCSName.setCellValueFactory(new PropertyValueFactory<>("firstname"));
		TCLName.setCellValueFactory(new PropertyValueFactory<>("lastname"));
		TCMail.setCellValueFactory(new PropertyValueFactory<>("eMail"));
		TCphonenumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		TCJobTitle.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
	}

	private Employee user;
	private Stage stage;

	//Konstruktor
	public PhonebookController(Stage stage, Employee username) {
		this.stage = stage;
		this.user = username;
	}

	//Alternative zu Initialize
	public void schreiben() {
		//Uneditable Text rechts einfügen (Daten des akt. Users)
		TVorname_Nachname.setText(user.getFirstname() + " " + user.getLastname());
		TPersonalnummer.setText((String.valueOf(user.getPersNr()))); 
		TStelle.setText(user.getJobTitle());
		TTelefonnummer.setText(user.getPhoneNumber());
		TE_Mail.setText(user.getEMail());
		TKuerzel.setText(user.getFirstname().charAt(0) + "" + user.getLastname().charAt(0));

		final ObservableList<Employee> data = FXCollections.observableArrayList();
	}

	//Szenenwechsel: Logout
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

	//Szenenwechsel: Zurück zum Hauptfenster
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
		fRController.schreiben();
	}
}