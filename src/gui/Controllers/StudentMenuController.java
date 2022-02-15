package gui.Controllers;

import be.AbsentDay;
import be.Student;
import gui.util.SceneSwapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentMenuController implements Initializable {
    @FXML
    private Label lblStudentName;
    @FXML
    private AreaChart areaChart;
    @FXML
    private TableColumn<AbsentDay,String> tcFag;
    @FXML
    private TableColumn<AbsentDay, Date> tcDag;
    @FXML
    private TableColumn<AbsentDay, Boolean> tcVerserende;
    @FXML
    private TableView<AbsentDay> tvSickDays;
    @FXML
    private Button meldAnkomstButton;
    @FXML
    private Button anmodRettelseButton;
    @FXML
    private Button logUdBotton;

    private SceneSwapper sceneSwapper;
    private Student student;


    public StudentMenuController() {
        sceneSwapper = new SceneSwapper();
        student = new Student("105", "Hans", "Petersen");

    }

    public void meldAnkomst(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Du har nu meldt din ankomst", ButtonType.OK);
        alert.show();
    }

    public void anmodRettelse(ActionEvent actionEvent) {
        if (tvSickDays.getSelectionModel().getSelectedItem() == null)
        {
            Alert alertCheck = new Alert(Alert.AlertType.CONFIRMATION, "Vælg en dag.", ButtonType.OK);
            alertCheck.showAndWait();
        }
        else if(tvSickDays.getSelectionModel().getSelectedItem().getCorrectionPending().getValue() == false)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Er du sikker på, at du vil sende rettelsen til godkendelse?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES)
            {
                tvSickDays.getSelectionModel().getSelectedItem().setCorrectionPending();
            }
        }
        else
        {
            Alert alertCheck = new Alert(Alert.AlertType.CONFIRMATION, "Denne dag er anmodet", ButtonType.OK);
            alertCheck.showAndWait();
        }


    }

    public void logUd(ActionEvent actionEvent) {
        Stage stage = (Stage) logUdBotton.getScene().getWindow();
        sceneSwapper.sceneSwitch(new Stage(),"LoginScreenView.fxml");
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tvSickDays.setItems(student.getAbsentDays());
        tcDag.setCellValueFactory(absentDay -> absentDay.getValue().getDate());
        tcFag.setCellValueFactory(absentDay -> absentDay.getValue().getSubject());
        tcVerserende.setCellValueFactory(absentDay->absentDay.getValue().getCorrectionPending());
        setAreaChartData();

        lblStudentName.setText(student.getfullName().getValue());
    }

    @FXML
    private void setAreaChartData()
    {
        Axis<String> xAxis = areaChart.getXAxis();
        xAxis.setLabel("Dage");
        Axis<Double> yAxis = areaChart.getYAxis();
        yAxis.setLabel("Fravær i %");


        XYChart.Series<String, Double> dataSeries1 = new XYChart.Series<>();
        dataSeries1.setName("Fravær");
        dataSeries1.getData().add(new XYChart.Data("4/1", 0));
        dataSeries1.getData().add(new XYChart.Data("31/1", 10));
        dataSeries1.getData().add(new XYChart.Data("28/2", 4));
        dataSeries1.getData().add(new XYChart.Data("31/3", 15));
        dataSeries1.getData().add(new XYChart.Data("30/4", 6));
        dataSeries1.getData().add(new XYChart.Data("31/5", 4));
        dataSeries1.getData().add(new XYChart.Data("30/6", 2));

        areaChart.getYAxis().setAutoRanging(false);
        areaChart.getData().add(dataSeries1);
    }
}