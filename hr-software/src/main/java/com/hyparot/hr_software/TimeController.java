package com.hyparot.hr_software;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.Vector;

import com.hyparot.hr_software.src.backend.BusinessIntelligence;
import com.hyparot.hr_software.src.backend.LocalStorage;
import com.hyparot.hr_software.src.backend.SystemDBConnector;
import com.hyparot.hr_software.src.employee.Employee;
import com.hyparot.hr_software.src.employeedata.Absence;
import com.hyparot.hr_software.src.employeedata.Date;

import impl.com.calendarfx.view.NumericTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TimeController {

	private Stage stage;

	private Employee user;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Text TResturlaubstage;

	@FXML
	private Text TReststunden;

	@FXML
	private NumericTextField TFVonH;

	@FXML
	private NumericTextField TFVonM;

	@FXML
	private NumericTextField TFBisH;

	@FXML
	private NumericTextField TFBisM;

	@FXML
	private Button BArbeitszeitErfassen;

	@FXML
	private Text TErfolgreichArbeitszeit;

	@FXML
	private NumericTextField TFKrankmeldenTage;

	@FXML
	private Button BKrankmelden;

	@FXML
	private Text TErfolgreichKrank;

	@FXML
	private TextField TFVon;

	@FXML
	private TextField TFBis;

	@FXML
	private Button BUrlaubBeantragen;

	@FXML
	private Text TErfolgreich;

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
	private Button Bzurueck;

	@FXML
	private Button BLogout;

	@FXML
	void arbeitszeitErfassen(ActionEvent event) {
		setWorkingTime();
	}

	@FXML
	void krankmelden(ActionEvent event) {
		setSick();
	}

	@FXML
	void logout(ActionEvent event) throws IOException {
		changeSceneLogout();
	}

	@FXML
	void zurück(ActionEvent event) throws IOException {
		changeSceneZurueck(user);
	}

	@FXML
	void requestVacation(ActionEvent event) {
		requestVacation1();

	}

	@FXML
	void restrictLength(KeyEvent event) {
		if (TFVonH.getText().length() > 1) {
			TFVonH.setText(TFVonH.getText().substring(0,2));
			TFVonH.positionCaret(2);
		}
		if (TFVonM.getText().length() > 1) {
			TFVonM.setText(TFVonM.getText().substring(0,2));
			TFVonM.positionCaret(2);
		}
		if (TFBisH.getText().length() > 1) {
			TFBisH.setText(TFBisH.getText().substring(0,2));
			TFBisH.positionCaret(2);
		}
		if (TFBisM.getText().length() > 1) {
			TFBisM.setText(TFBisM.getText().substring(0,2));
			TFBisM.positionCaret(2);
		}
	}

	@FXML
	void initialize() {
		assert TResturlaubstage != null : "fx:id=\"TResturlaubstage\" was not injected: check your FXML file 'Time.fxml'.";
		assert BArbeitszeitErfassen != null : "fx:id=\"BArbeitszeitErfassen\" was not injected: check your FXML file 'Time.fxml'.";
		assert BKrankmelden != null : "fx:id=\"BKrankmelden\" was not injected: check your FXML file 'Time.fxml'.";
		assert TFVon != null : "fx:id=\"TFVon\" was not injected: check your FXML file 'Time.fxml'.";
		assert TFBis != null : "fx:id=\"TFBis\" was not injected: check your FXML file 'Time.fxml'.";
		assert BUrlaubBeantragen != null : "fx:id=\"BUrlaubBeantragen\" was not injected: check your FXML file 'Time.fxml'.";
		assert TKuerzel != null : "fx:id=\"TKuerzel\" was not injected: check your FXML file 'Time.fxml'.";
		assert TVorname_Nachname != null : "fx:id=\"TVorname_Nachname\" was not injected: check your FXML file 'Time.fxml'.";
		assert TPersonalnummer != null : "fx:id=\"TPersonalnummer\" was not injected: check your FXML file 'Time.fxml'.";
		assert TStelle != null : "fx:id=\"TStelle\" was not injected: check your FXML file 'Time.fxml'.";
		assert TTelefonnummer != null : "fx:id=\"TTelefonnummer\" was not injected: check your FXML file 'Time.fxml'.";
		assert TE_Mail != null : "fx:id=\"TE_Mail\" was not injected: check your FXML file 'Time.fxml'.";
		assert Bzurueck != null : "fx:id=\"Bzurueck\" was not injected: check your FXML file 'Time.fxml'.";
		assert BLogout != null : "fx:id=\"BLogout\" was not injected: check your FXML file 'Time.fxml'.";
		
		Hashtable<Absence, String> absenceTable = BusinessIntelligence.getAbsenceOf(user);
		
//		TableView.setItems(FXCollections.observableList(absenceTable));
//		
//		TCAbsenceID.setCellValueFactory(new PropertyValueFactory<>("absenceID"));
//		TCBeginDate.setCellValueFactory(new PropertyValueFactory<>("begin"));
//		TCEndDate.setCellValueFactory(new PropertyValueFactory<>("end"));
//		TCIsAccepted.setCellValueFactory(new PropertyValueFactory<>("isAccepted"));

	}

	public TimeController(Stage stage, Employee username) {
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
		TReststunden.setText(String.valueOf(user.getWorkingTime_left()));
		TResturlaubstage.setText(String.valueOf(user.getVacation_left()));
	}


	public void changeSceneZurueck(Employee Username) throws IOException {
		var loader = new FXMLLoader();
		var fRController = new FRController(stage, Username);
		loader.setLocation(getClass().getResource("/AfterLogin.fxml"));
		loader.setController(fRController);
		stage.getScene().setRoot(loader.load());
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.centerOnScreen();
		stage.setResizable(false);
		fRController.schreiben();
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

	public void setWorkingTime() {
		int VonH = Integer.parseInt(TFVonH.getText().toString());
		int VonM = Integer.parseInt(TFVonM.getText().toString());
		int BisH = Integer.parseInt(TFBisH.getText().toString());
		int BisM = Integer.parseInt(TFBisM.getText().toString());

		if (VonH <= 24 && VonH >= 0 && VonM >= 0 && VonM <= 60 &&
				BisH <= 24 && BisH >= 0 && BisM >= 0 && BisM <= 60) {
			if ((BisH*60 + BisM) - (VonH*60 + VonM) > 0) {
				if ((BisH*60 + BisM) - (VonH*60 + VonM) <= 720) {
					int workedTime = Math.round(((BisH*60 + BisM) - (VonH*60 + VonM))/60);
					TErfolgreichArbeitszeit.setStyle("-fx-text-fill: #36c740;");
					TErfolgreichArbeitszeit.setText("Arbeitsstunden erfolgreich erfasst: " + workedTime + "h.");
					
					user.setWorkingTime_left(user.getWorkingTime_left()-workedTime);
					TReststunden.setText(String.valueOf(user.getWorkingTime_left()));
				} else {
					TErfolgreichArbeitszeit.setStyle("-fx-text-fill: red;");
					TErfolgreichArbeitszeit.setText("Sie können nicht über 12h arbeiten!");
				}
			} else {
				TErfolgreichArbeitszeit.setStyle("-fx-text-fill: red;");
				TErfolgreichArbeitszeit.setText("Sie können nicht über Nacht arbeiten!");
			}
		} else {
			TErfolgreichArbeitszeit.setStyle("-fx-text-fill: red;");
			TErfolgreichArbeitszeit.setText("Bitte korrekte Uhrzeiten angeben!");
		}
	}

	//Krankmelden
	public void setSick() {
		int duration = Integer.parseInt(TFKrankmeldenTage.getText());
		user.setSick(duration);
		TFKrankmeldenTage.clear();
		TErfolgreichKrank.setText("Erfolgreich eingetragen!");
	}

	//Urlaub beantragen
	public void requestVacation1() {
		Date VacationFrom;
		Date VacationUntil;
		TErfolgreich.setText("");
		TErfolgreichKrank.setText("");

		//Vacation FROM Textfield
		if (!TFVon.getText().isBlank() && TFVon.getText().length() > 7) {
			if (TFVon.getText().charAt(4) == '-' && TFVon.getText().charAt(7) == '-' && TFVon.getText().length() == 10) {
				//Get Vacation FROM
				try {
					VacationFrom = new Date(TFVon.getText());
					TFVon.setStyle("-fx-text-fill: black;");
				} catch (Exception e) {
					TFVon.setStyle("-fx-text-fill: red;");
					TFVon.setText("Format: jjjj-mm-tt");
					return;
				}
			} else {
				TFVon.setStyle("-fx-text-fill: red;");
				TFVon.setText("Format: jjjj-mm-tt");
				return;
			}
		} else {
			TFVon.setStyle("-fx-text-fill: red;");
			TFVon.setText("Format: jjjj-mm-tt");
			return;
		}


		//Vacation UNTIL Textfield
		if (!TFBis.getText().isBlank() && TFBis.getText().length() > 7) {
			if (TFBis.getText().charAt(4) == '-' && TFBis.getText().charAt(7) == '-' && TFVon.getText().length() == 10) {
				//Get Vacation UNTIL
				try {
					VacationUntil = new Date(TFBis.getText());
					TFBis.setStyle("-fx-text-fill: black;");
				} catch (Exception e) {
					TFBis.setStyle("-fx-text-fill: red;");
					TFBis.setText("Format: jjjj-mm-tt");
					return;
				}
			} else {
				TFBis.setStyle("-fx-text-fill: red;");
				TFBis.setText("Format: jjjj-mm-tt");
				return;
			}
		} else {
			TFBis.setStyle("-fx-text-fill: red;");
			TFBis.setText("Format: jjjj-mm-tt");
			return;
		}

		if (VacationUntil.isGreater(VacationFrom)) {
			TFVon.clear();
			TFBis.clear();
			TErfolgreich.setText("Erfolgreich beantragt!");
			user.applyForVacation(VacationFrom, VacationUntil);
		} else {
			TFVon.setText("Von!");
			TFBis.setText("Bis!");
		}
	}
}
