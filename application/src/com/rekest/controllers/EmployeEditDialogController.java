package com.rekest.controllers;

import com.rekest.entities.employes.Employe;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class EmployeEditDialogController {

    @FXML
    private Button btnAnnuler;

    @FXML
    private Button btnOk;

    @FXML
    private Circle circlePhoto;

    @FXML
    private ComboBox<?> comboBoxProfil;

    @FXML
    private ComboBox<?> comboBoxService;

    @FXML
    private Label labelFenetre;

    @FXML
    private TextField textFieldAdresse;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldNom;

    @FXML
    private TextField textFieldPrenom;

    @FXML
    private TextField textFieldTelephone;


	private Stage dialogStage;
	
	private Employe employe;
	
	private boolean okClicked = false;

	/**
	 * Sets the stage of this dialog.
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Sets the department to be edited in the dialog.
	 *
	 * @param department
	 */
	public void setEmploye(Employe employe) {
		this.employe = employe;
		textFieldNom.setText(employe.getNom());
	}

	/**
	 * Returns true if the department clicked OK, false otherwise.
	 *
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the department clicks ok.
	 */
	@FXML
	private void handleClickedOk() {
		if (isInputValid()) {
			employe.setNom(textFieldNom.getText());
			okClicked = true;
			dialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleClickedAnnuler() {
		dialogStage.close();
	}

	/**
	 * Validates the user input in the text fields.
	 *
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (textFieldNom.getText() == null || textFieldNom.getText().length() == 0) {
			errorMessage += "Le nom du employe est invalid!\n";
		}


		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			com.rekest.utils.Utilitaire.alert(AlertType.WARNING, 
					dialogStage, 
					"Invalid Fields", 
					"Please correct invalid fields", 
					errorMessage);

			return false;
		}
	}

}

