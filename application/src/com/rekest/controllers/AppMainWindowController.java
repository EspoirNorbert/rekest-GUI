package com.rekest.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class AppMainWindowController {
	
	public final static Logger logger = LogManager.getLogger(AuthenticationController.class);
	
	public Stage primaryStage;
	private AuthenticationController authenticationController;

    @FXML
    private Button btnAuthentification;
    
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
   @FXML
    void handleClickedAuthentification(ActionEvent event) {
		authenticationController = new AuthenticationController();
		authenticationController.showAuthenticationController();
    }

}
