package com.rekest.views;

import java.net.URL;
import java.util.ResourceBundle;

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
	
	public Stage primaryStage;
	private AdminMainController adminMainController;

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
	
	private IFeature service;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
	void handleClickedConnexion(ActionEvent event) {
		/*System.out.println("Login OKK");*/
		String login = txtLogin.getText();
		String password = txtLogin.getText();

		/*
		System.out.println("Login: " + login);
		System.out.println("Password: " + password);*/

		if (login.equals("") || password.equals(""))
			Utilitaire.alert(AlertType.ERROR, 
					null, "AddressApp", "About", "Veuillez remplir tous les champs");

		if (login.equals("admin") && password.equals("admin")) {
			Utilitaire.alert(AlertType.INFORMATION, 
					null, "AddressApp","Connexion success","Connexion avec success");
			this.primaryStage.close();
			adminMainController = new AdminMainController();
			adminMainController.initAdminRootLayout(primaryStage);
			adminMainController.showAdminOverview();
		} else {
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//service = Feature.getCurrentInstance();
		//service.initAllEntity();
	}

}