package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.hyparot.hr_software.src.backend.BIConnect;
import com.hyparot.hr_software.src.employee.Employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FRController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button BZeiterfassung;

	@FXML
	private Button BPhonebook;

	@FXML
	private Button BVacationRequests;

	@FXML
	private ChoiceBox<String> CBGroup;

	@FXML
	private Button BCreateUser;

	@FXML
	private Button BEditOtherEmployee;

	@FXML
	private TextField TFPersnr;
	
    @FXML
    private ImageView IVCreateUser;
    
    @FXML
    private ImageView IVEditUser;
    
    @FXML
    private ImageView IVVacationRequests;

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

	ObservableList<String> availableChoices = FXCollections.observableArrayList("HR", "Superior", "Employee"); 

	//Button Urlaub beantragen - Szenenwechsel
	@FXML
	void VacationRequests(ActionEvent event) throws IOException {
		changeSceneVacationRequests(user);
	}

	//Button User erstellen - Szenenwechsel
	@FXML
	void createUser(ActionEvent event) throws IOException {
		changeSceneCreateEmployee(user);
	}

	//Button anderen User bearbeiten - Szenenwechsel
	@FXML
	void editOtherEmployee(ActionEvent event) throws IOException {
		try {
			BIConnect bic = new BIConnect();
			//Wenn User mit eingegebener Persnr. existiert
			if (bic.getEmployeeByID(Integer.parseInt(TFPersnr.getText().toString())) != null) {
				Employee userEdit = bic.getEmployeeByID(Integer.parseInt(TFPersnr.getText().toString()));
				//Szenenwechsel mit anderen User als Parameter (userEdit)
				changeScenePersonalDataOther(user, userEdit);
			} else {
				//Ansonsten Fehlermeldung
				TFPersnr.setText("Falsche Persnummer!");
				TFPersnr.setStyle("-fx-text-fill: red;");
			}
		} catch (Exception E) { 
			TFPersnr.setText("Falsche Persnummer!");
		}
	}

	//Button logout - Szenenwechsel
	@FXML
	void logout(ActionEvent event) throws IOException {
		changeSceneLogout();
	}

	//Button persönliche Daten - Szenenwechsel
	@FXML
	void personalData(ActionEvent event) throws IOException {
		changeScenePersonalData(user);
	}

	//Button Telefonbuch - Szenenwechsel
	@FXML
	void phonebook(ActionEvent event) throws IOException {
		changeScenePhonebook(user);
	}

	//Button Zeiten verwalten - Szenenwechsel
	@FXML
	void zeiterfassen(ActionEvent event) throws IOException {
		changeSceneTime(user);
	}

    @FXML
    void initialize() {

    }

	private Employee user;
	private Stage stage;

	//Konstruktor
	public FRController(Stage stage, Employee username) {
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

		//Falls der User HR ist
		if (user.getGroup().equals("HR")) {
			//Andere User bearbeiten und Erstellen sichtbar machen 
			BEditOtherEmployee.setVisible(true);
			TFPersnr.setVisible(true);
			IVEditUser.setVisible(true);
			
			BCreateUser.setVisible(true);
			CBGroup.setVisible(true);
			IVCreateUser.setVisible(true);
			
			BVacationRequests.setVisible(true);
			IVVacationRequests.setVisible(true);
		}
		//Falls der User Vorgesetzter ist
		if (user.getGroup().equals("Superior")) {
			//Urlaubsanträge einsehen sichtbar machen 
			BVacationRequests.setVisible(true);
			IVVacationRequests.setVisible(true);
			BVacationRequests.setDisable(false);
		}
		
		//Auswahlfeld für Erstellen eines Users initialiseren
		CBGroup.setItems(availableChoices);
		CBGroup.setValue("Gruppe des Users");
	}
	
	//Aufruf nach erfolgreichem Erstellen eines Users
	public void confirmCreation() {
		CBGroup.setValue("Erfolgreich erstellt!");
	}
	
	//Aufruf nach erfolgreichem Löschen eines Users
	public void confirmDeletion() {
		TFPersnr.setText("Erfolgreich gelöscht!");
		TFPersnr.setStyle("-fx-text-fill: green;");
	}

	//Logout Szenenwechsel
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

	//User erstellen Szenenwechsel
	public void changeSceneCreateEmployee(Employee Username) throws IOException {
		//Art des zu Erstellenden Users erfassen: HR, Vorgesetzter oder Mitarbeiter
		String group = CBGroup.getSelectionModel().getSelectedItem().toString();
		//Falls ungültige Auswahl: Fehlermeldung
		if (group.equals("Gruppe des Users") || group.equals("Ungültige Eingabe") || group.equals("Erfolgreich erstellt!")) {
			CBGroup.setValue("Ungültige Eingabe");
			CBGroup.setStyle("-fx-text-fill: red;");
			//Bei richtiger Auswahl: Szenenwechsel
		} else {
			var loader = new FXMLLoader();
			var createUserController = new CreateUserController(stage, Username, group);
			loader.setLocation(getClass().getResource("/CreateEmployee.fxml"));
			loader.setController(createUserController);
			stage.getScene().setRoot(loader.load());
			stage.setWidth(1280);
			stage.setHeight(720);
			stage.centerOnScreen();
			stage.setResizable(false);
			createUserController.schreiben();
		}
	}

	public void changeScenePhonebook(Employee Username) throws IOException {
		var loader = new FXMLLoader();
		var phonebookController = new PhonebookController(stage, Username);
		loader.setLocation(getClass().getResource("/Phonebook.fxml"));
		loader.setController(phonebookController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		phonebookController.schreiben();
	}

	public void changeSceneTime(Employee Username) throws IOException {
		var loader = new FXMLLoader();
		var timeController = new TimeController(stage, Username);
		loader.setLocation(getClass().getResource("/Time.fxml"));
		loader.setController(timeController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		timeController.schreiben();
	}

	public void changeScenePersonalDataOther(Employee Username, Employee UsernameEdit) throws IOException {
		var loader = new FXMLLoader();
		var personalDataController = new PersonalDataController(stage, Username, UsernameEdit);
		loader.setLocation(getClass().getResource("/PersonalData.fxml"));
		loader.setController(personalDataController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		personalDataController.schreiben();
	}

	public void changeScenePersonalData(Employee Username) throws IOException {
		var loader = new FXMLLoader();
		var personalDataController = new PersonalDataController(stage, Username);
		loader.setLocation(getClass().getResource("/PersonalData.fxml"));
		loader.setController(personalDataController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		personalDataController.schreiben();
	}
	
	public void changeSceneVacationRequests(Employee Username) throws IOException {
		var loader = new FXMLLoader();
		var vacationRequestsController = new VacationRequestsController(stage, Username);
		loader.setLocation(getClass().getResource("/VacationRequests.fxml"));
		loader.setController(vacationRequestsController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		vacationRequestsController.schreiben();
	}
	
	
}
