package com.rekest.runtime;

import com.rekest.views.MainController;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	//public static final String APPLICATION_ICON_URL = "file:resources/images/address_book_32.png"; 	
    private Stage primaryStage;
    private MainController mainController;
    
    public Main() {
    	mainController = new MainController();
	}
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("REKEST - Authentication");
        // init authentication
        mainController.initAuthentication(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
