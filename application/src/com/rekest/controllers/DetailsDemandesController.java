package com.rekest.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class DetailsDemandesController implements Initializable {

	@FXML
	private Button btnAjouterNote;

	@FXML
	private Button btnEnvoyerNotifications;

	@FXML
	private Button btnFermer;

	@FXML
	private ComboBox<?> comboBoxEtatDemande;

	@FXML
	private Label labelFenetre;

	@FXML
	private TextField textFieldDescription;

	@FXML
	private TextField textFieldEmploye;

	@FXML
	private TextField textFieldNom;

	@FXML
	private TextField textFieldType;

	@FXML
	private TextField textFieldUtilisateur;

	@FXML
	void handleClickedRejecter(ActionEvent event) {

	}

	@FXML
	void handleClickedSoumettre(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}



}
