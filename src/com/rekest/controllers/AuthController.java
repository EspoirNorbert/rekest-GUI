package com.rekest.controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AuthController {
	
    public Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
    
    @FXML
    public void handLaunchApp() {
    	 	System.out.println("Lancement de l'application");
    }
    
    
}