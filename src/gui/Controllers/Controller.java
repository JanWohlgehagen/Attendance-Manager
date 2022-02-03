package gui.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private BorderPane parentBorderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        parentBorderPane.setCenter(buildBarChart());
    }

    public void handleShowBarChart(ActionEvent actionEvent) {
        // Add barchart to the parent pane
        parentBorderPane.setCenter(buildBarChart());
    }

    public void handleShowPieChart(ActionEvent actionEvent) {

        // Observable list of piechart data
        ObservableList<PieChart.Data> pieChartDataList = FXCollections.observableArrayList(
            new PieChart.Data("Lemons", 3000),
            new PieChart.Data("Oranges", 450),
            new PieChart.Data("Bananas", 1500)
        );

        // create pieChart object
        PieChart pieChart = new PieChart(pieChartDataList);
        pieChart.setTitle("Products Sold");
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(50);
        pieChart.setLabelsVisible(true);
        pieChart.setStartAngle(180);

        // create context menu for piechart
        ContextMenu contextMenu = new ContextMenu();
        MenuItem miSwitchToBarChart = new MenuItem("Switch to BarChart");
        contextMenu.getItems().add(miSwitchToBarChart);

        pieChart.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.SECONDARY){
                    contextMenu.show(pieChart, event.getScreenX(), event.getScreenY());
                }
            }
        });

        miSwitchToBarChart.setOnAction((ActionEvent event) -> {
            parentBorderPane.setCenter(buildBarChart());
        });

        parentBorderPane.setCenter(pieChart);

    }

    public void handleUpdateData(ActionEvent actionEvent) {
        Node node = parentBorderPane.getCenter();

        if(node instanceof PieChart){
            PieChart pc = (PieChart) node;

            pc.getData().get(0).setPieValue(2500);
            pc.getData().get(1).setPieValue(1000);
            pc.getData().get(2).setPieValue(2300);
        }
    }

    public void handleClose(ActionEvent actionEvent) {
        System.exit(0);
    }

    /**
     * Builds a barchart with static data
     */
    private BarChart buildBarChart(){
        CategoryAxis xAxis = new CategoryAxis();
        //xAxis.setLabel("Products");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Quantity Sold");

        BarChart barChart = new BarChart(xAxis, yAxis);

        XYChart.Series data = new XYChart.Series();
        data.setName("Products Sold");

        //Fill data set
        data.getData().add(new XYChart.Data("Lemons", 3000));
        data.getData().add(new XYChart.Data("Oranges", 450));
        data.getData().add(new XYChart.Data("Bananas", 1500));

        // Add data set to barchart
        barChart.getData().add(data);

        // Add barchart to the parent pane
        return barChart;
    }
}
