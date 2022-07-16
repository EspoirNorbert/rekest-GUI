package com.rekest.controllers;

import com.rekest.entities.Service;
import com.rekest.entities.employes.Employe;
import com.rekest.feature.IFeature;
import com.rekest.utils.Utilitaire;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EmployeController {

	@FXML
	private Button btnAjouter;

	@FXML
	private Button btnModifier;

	@FXML
	private Button btnRecherche;

	@FXML
	private Button btnSupprimer;

	@FXML
	private TableColumn<Employe, String> columnAdresse;

	@FXML
	private TableColumn<Employe, String> columnEmail;

	@FXML
	private TableColumn<Employe, String> columnLogin;

	@FXML
	private TableColumn<Employe, String> columnNom;

	@FXML
	private TableColumn<Employe, String> columnPrenom;

	@FXML
	private TableColumn<Employe, String> columnProfil;

	@FXML
	private TableColumn<Service, String> columnService;

	@FXML
	private TableColumn<Employe, String> columnTelephone;

	@FXML
	private Label countEmployes;

	@FXML
	private TableView<Employe> tableViewEmployes;

	@FXML
	private TextField textRecherche;

	public Stage primaryStage;

	private IFeature service;


	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}


	private EmployeEditDialogController employeDialogController;


	private void addEmployeeObservableListToTheTable() {
		// Add observable list data to the table
		ObservableList<Employe> employes;
		employes = service.loadEmployesObservableList();
		tableViewEmployes.setItems(employes);
		//service.refresh();
		if (employes.size() > 0)
			tableViewEmployes.getSelectionModel().select(0);	

	}

	@FXML
	void handleClickedAjouter(ActionEvent event) {
		Employe tempEmploye = new Employe();
		boolean okClicked = showEmployeEditDialog(tempEmploye);
		if (okClicked) {
			service.creerEmploye(tempEmploye);
		}
	}

	@FXML
	void handleClickedModifier(ActionEvent event) {
		Employe selectedEmploye = tableViewEmployes.getSelectionModel().getSelectedItem();        

		if (selectedEmploye != null) {
			boolean okClicked = this.showEmployeEditDialog(selectedEmploye);
			if (okClicked)
				service.modifierEmploye(selectedEmploye);
		
		} else {
			// Nothing selected.
			Utilitaire.alert(AlertType.WARNING, primaryStage,
					"No Selection", 
					"No Employee Selected", 
					"Please select a person in the table.");
		}
	}

	@FXML
	void handleClickedSupprimer(ActionEvent event) {
		int selectedIndex = Utilitaire.getCurrentIndexTableView(tableViewEmployes, primaryStage);
		service.supprimerEmploye(tableViewEmployes.getSelectionModel().getSelectedItem());
	}

	@FXML
	void handleClickedRecherche(ActionEvent event) {}


	/**
	 * Opens a dialog to edit details for the specified person. If the user
	 * clicks OK, the changes are saved into the provided person object and true
	 * is returned.
	 *
	 * @param person the person object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showEmployeEditDialog(Employe department) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = Utilitaire.initFXMLoader("EmployeEditDialog");
			AnchorPane root = (AnchorPane) Utilitaire.loadFXMLFile(loader, false);

			// Create the dialog Stage.
			Stage dialogStage = Utilitaire.createDialog(root, primaryStage, "Creation de Employe");

			// Set the department into the controller.
			employeDialogController = loader.getController();
			employeDialogController.setDialogStage(dialogStage);
			employeDialogController.setEmploye(department);

			// Show the dialog and wait until the user closes it
			Utilitaire.showDialog(dialogStage);

			return employeDialogController.isOkClicked();
		} catch (Exception e) {
			Utilitaire.alert(AlertType.WARNING, 
					null, 
					"REKEST ERROR","Echec ",e.getMessage());
		}

		return false;
	}


}
