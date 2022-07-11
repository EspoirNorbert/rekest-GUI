package com.rekest.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class DirecteurAccueilController implements Initializable {
	
	@FXML
    private LineChart<?, ?> lineChart;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		iniLineChart();
		
	}
	
	private void iniLineChart() {
		XYChart.Series series = new XYChart.Series();
		series.getData().add(new XYChart.Data("Lundi", 12));
		series.getData().add(new XYChart.Data("Mardi", 8));
		series.getData().add(new XYChart.Data("Mercredi", 5));
		series.getData().add(new XYChart.Data("Jeudi", 6));
		series.getData().add(new XYChart.Data("Vendredi", 34));
		series.getData().add(new XYChart.Data("Samedi", 21));
		series.getData().add(new XYChart.Data("Dimanche", 2));
		lineChart.getData().add(series);
		
	}

}
