package com.rekest.views;

import javafx.stage.Stage;
import lombok.Data;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

/**
 * RootLayout des windows Admins
 * @author hp
 */
@Data
public class AdminRootLayoutController {

	private DepartementController departementController; // MainController de UI Department
	private ServiceController serviceController;         // MainController de UI Servicr

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
	private AnchorPane anchorPaneCenter;

	@FXML
	private Button btnAccueil;

	@FXML
	private Button btnDemande;

	@FXML
	private Button btnDepartement;

	@FXML
	private Button btnEmploye;

	@FXML
	private Button btnLogOut;

	@FXML
	private Button btnNotifications;

	@FXML
	private Button btnParametre;

	@FXML
	private Button btnProduit;

	@FXML
	private Button btnRole;

	@FXML
	private Button btnService;

	@FXML
	private Circle circleProfil;

	@FXML
	private ImageView imageLogo;

	@FXML
	private Label labelProfil;

	@FXML
	private Label labelUsername;

	@FXML
	void handleClickedAccueil(MouseEvent event) {

	}

	@FXML
	void handleClickedDemande(MouseEvent event) {

	}

	@FXML
	void handleClickedDepartement(MouseEvent event) {

	}

	@FXML
	void handleClickedEmploye(MouseEvent event) {

	}

	@FXML
	void handleClickedLogOut(MouseEvent event) {

	}

	@FXML
	void handleClickedParametre(MouseEvent event) {

	}

	@FXML
	void handleClickedProduit(MouseEvent event) {

	}

	@FXML
	void handleClickedRole(MouseEvent event) {

	}

	@FXML
	void handleClickedService(MouseEvent event) {

	}

	@FXML
	void handleClicledNotification(MouseEvent event) {

	}

}