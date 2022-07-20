package com.rekest.controllers;

import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rekest.utils.Utilitaire;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

/**
 * RootLayout des windows Admins
 * @author Fatoumata DICKO
 */
public class AdminRootLayoutController implements Initializable {

	public final static Logger logger = LogManager.getLogger(AdminRootLayoutController.class);

	private DepartementController departementController; 
	private ServiceController serviceController;      
	private MainController mainController;

	private Stage primaryStage;

	private BorderPane rootLayout;

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
	private Button btnProduit;
	
    @FXML
    private Button btnProfil;

	@FXML
	private Button btnRole;

	@FXML
	private Button btnService;

    @FXML
    private Button btnUtlisateurs;
	
	@FXML
	private Circle circleProfil;

	@FXML
	private ImageView imageLogo;

	@FXML
	private Label labelProfil;

	@FXML
	private Label labelUsername;
	
	private Boolean isCurrentPage = false;
	
	public void setIsCurrentPage(Boolean isCurrentPage) {
		this.isCurrentPage = isCurrentPage;
	}


	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Espace d'administration - Admin connect�");
	}

	@FXML
	void handleClickedAccueil(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "AdminOverview");
		String style = btnAccueil.getStyle().toString();
		System.out.println("Is pressed : " + btnAccueil.isManaged());
		if(btnAccueil.isManaged()) {
			btnAccueil.setStyle("-fx-background-color: #202332;-fx-font-size: 8pt;");
		} else {
			btnAccueil.setStyle(style);
		}
		
	}

	@FXML
	void handleClickedDemande(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Demandes");
		String style = btnDemande.getStyle().toString();
		if(btnDemande.isManaged()) {
			btnDemande.setStyle("-fx-background-color: #202332;-fx-font-size: 8pt;");
		} else {
			btnDemande.setStyle(style);
		}
	}

	@FXML
	void handleClickedDepartement(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Departement");

	}

	@FXML
	void handleClickedEmploye(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Employes");
	}

	@FXML
	void handleClickedProduit(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Produits");
	}
	
    @FXML
    void handleClickedProfil(MouseEvent event) {
    	Utilitaire.loadPageInRootLayout(rootLayout, "Profil");
    }

	@FXML
	void handleClickedRole(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Roles");
	}

	@FXML
	void handleClickedService(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Services");
	}
	
    @FXML
    void handleClickedUtilisateur(MouseEvent event) {
    	Utilitaire.loadPageInRootLayout(rootLayout, "Utilisateurs");
    }

	@FXML
	void handleClicledNotification(MouseEvent event) {
		Utilitaire.loadPageInRootLayout(rootLayout, "Notifications");
	}

	@FXML
	void handleClickedLogOut(MouseEvent event) {
		mainController.initAuthentication(primaryStage);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mainController = new MainController();
	}

	public DepartementController getDepartementController() {
		return departementController;
	}

	public void setDepartementController(DepartementController departementController) {
		this.departementController = departementController;
	}

	public ServiceController getServiceController() {
		return serviceController;
	}

	public void setServiceController(ServiceController serviceController) {
		this.serviceController = serviceController;
	}

	public MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}

	public AnchorPane getAnchorPaneCenter() {
		return anchorPaneCenter;
	}

	public void setAnchorPaneCenter(AnchorPane anchorPaneCenter) {
		this.anchorPaneCenter = anchorPaneCenter;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}
}