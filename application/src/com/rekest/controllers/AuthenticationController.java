package com.rekest.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rekest.feature.IFeature;
import com.rekest.feature.impl.Feature;
import com.rekest.utils.Utilitaire;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AuthenticationController implements Initializable {
	
	public final static Logger logger = LogManager.getLogger(AuthenticationController.class);
	
	public Stage primaryStage;
	private AdminMainController adminMainController;
	private ManagerMainController managerMainController;
	private GestionnaireMainController gestionnaireMainController;

	@FXML
	private Button btnConnexion;

	@FXML
	private Button btnPasswordForget;

	@FXML
	private Button btnQuitter;

	@FXML
	private TextField txtLogin;

	@FXML
	private PasswordField txtPassword;
	
	private IFeature service = Feature.getCurrentInstance();
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
	void handleClickedConnexion(ActionEvent event) {
		String login = txtLogin.getText();
		String password = txtLogin.getText();

		if (login.equals("") || password.equals(""))
			Utilitaire.alert(AlertType.ERROR, 
					null, "AddressApp", "About", "Veuillez remplir tous les champs");

		if (login.equals("admin") && password.equals("admin")) {
			Utilitaire.alert(AlertType.INFORMATION, null, "AddressApp","Connexion success","Vous allez vous connecter en tant que Admin");
			this.primaryStage.close();
			adminMainController = new AdminMainController();
			adminMainController.initAdminRootLayout(primaryStage);
			adminMainController.showAdminOverview();
		} 
		
		else if (login.equals("manager") && password.equals("manager")) {
			Utilitaire.alert(AlertType.INFORMATION, null, "AddressApp","Connexion success",
					"Vous allez vous connecter en tant que Manager");
			this.primaryStage.close();
			managerMainController = new ManagerMainController();
			managerMainController.initManagerRootLayout(primaryStage);
			managerMainController.showManagerOverview();
		}
		
		else if (login.equals("gestionnaire") && password.equals("gestionnaire")) {
			Utilitaire.alert(AlertType.INFORMATION, null, "AddressApp","Connexion success",
					"Vous allez vous connecter en tant que Gestionnaire");
			this.primaryStage.close();
			gestionnaireMainController = new GestionnaireMainController();
			gestionnaireMainController.initGestionnaireRootLayout(primaryStage);
			gestionnaireMainController.showGestionnaireOverview();
		}
		
		else   {
			Utilitaire.alert(AlertType.INFORMATION, 
					null, 
					"AddressApp","Echec de connexion","Informations non correctes !");
		}
	}

	@FXML
	void handleClickedPasswordForget(ActionEvent event) {

	}

	@FXML
	void handleClickedQuitter(ActionEvent event) {
		System.exit(0);
	}
	
	public AuthenticationController() {
		logger.info("Instance of {} is created" , this.getClass().getName());
		//service.initAllEntity();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public void showAuthenticationController() {}

}