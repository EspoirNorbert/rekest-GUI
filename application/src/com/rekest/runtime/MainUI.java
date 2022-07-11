package com.rekest.runtime;

import com.rekest.views.MainController;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
//import javafx.stage.StageStyle;

public class MainUI extends Application {

	public static final String APPLICATION_ICON_URL = "file:resources/images/rekest_logo.png"; 	
    private Stage primaryStage;
    private MainController mainController;
    
    public MainUI() {
    	mainController = new MainController();
	}
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("REKEST - Authentication");
        this.primaryStage.getIcons().add(new Image(APPLICATION_ICON_URL));
        //this.primaryStage.initStyle(StageStyle.UNDECORATED);
        mainController.initAuthentication(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
