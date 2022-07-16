package com.rekest.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.rekest.dao.impl.HibernateDao;
import com.rekest.feature.IFeature;
import com.rekest.feature.impl.Feature;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ManagerOverviewController implements Initializable {

	private Stage primaryStage;

	@FXML
	private BarChart<?, ?> barChartDemandes;

	@FXML
	private Label countDemandes;

	@FXML
	private Label countJour;

	@FXML
	private Label countNonValides;

	@FXML
	private Label countSemaine;

	@FXML
	private Label countValides;

	@FXML
	private PieChart pieChartDemandes;
	
	private IFeature service = Feature.getCurrentInstance();;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.initDemandCount();
	}
	
	private void initDemandCount() {
		// obtenir les donnees vers le service
		/***
		 * service.getTotalDemande() //
		 */
		countDemandes.setText("0");
		countJour.setText("0");
		countValides.setText("0");
		countNonValides.setText("0");
		countSemaine.setText("0");
	}
	
	public void refreshDemandCounter() {
	   	this.initDemandCount();
	}
}
