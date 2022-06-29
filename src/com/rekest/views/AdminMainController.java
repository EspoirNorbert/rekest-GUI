package com.rekest.views;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/***
 * MainController principale des windows admin
 * @author hp
 *
 */
public class AdminMainController  {
	
	private Stage primaryStage;
    private AnchorPane rootLayout;
    
    // controllers
	private AdminRootLayoutController adminRootLayoutController;
	
	public AdminMainController() {
		// TODO Auto-generated constructor stub
		adminRootLayoutController = new AdminRootLayoutController();
		System.out.println(adminRootLayoutController);
	}
	
	 /**
     * Initializes the Admin root layout.
     */
    public void initAdminRootLayout(Stage primaryStage) {
        try {
        	this.primaryStage = primaryStage;
        
        	// Load person overview.
        	FXMLLoader loader = new FXMLLoader ();
        	loader.setLocation(MainController.class.getResource("Acceuil.fxml"));
        	rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            this.primaryStage.setScene(scene);

            // Give the controller access to the main app.
//            adminRootLayoutController = loader.getController();       
//            adminRootLayoutController.setPrimaryStage(primaryStage);

            // show windows
            this.primaryStage.show();
            
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
    }
}