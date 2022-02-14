package gui.Controllers;

import be.Student;
import gui.Models.StudentListModel;
import gui.util.SceneSwapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class TeacherMenuController implements Initializable {


    @FXML
    private GridPane GridPaneParent;

    @FXML
    private ComboBox<String> cbClass;

    @FXML
    private TableView<Student> tvStudent;
    @FXML
    private TableColumn<Student, String> tcStudentID;
    @FXML
    private TableColumn<Student, String> tcName;
    @FXML
    private TableColumn<Student, String> tcAbsence;

    @FXML
    private ImageView imageStudent;

    @FXML
    private Label lalGPName;
    @FXML
    private Label lalGPStudentID;
    @FXML
    private Label lalGPAbsence;

    @FXML
    private BarChart<String, Double> barChart;


    private StudentListModel studentListModel;
    private ObservableList<Student> viewStudent;
    private SceneSwapper sceneSwapper;


    public TeacherMenuController() {
        sceneSwapper = new SceneSwapper();
        studentListModel = new StudentListModel();
        this.viewStudent = FXCollections.observableArrayList();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tvStudent.setItems(viewStudent);
        tcName.setCellValueFactory(student -> student.getValue().getfullName());
        tcStudentID.setCellValueFactory(student -> student.getValue().getStudentID());
        tcAbsence.setCellValueFactory(student -> student.getValue().getAbsentInPercent());


        cbClass.getItems().addAll("ITO");
    }


    public void handleViewStudent(ActionEvent actionEvent) {
        if(cbClass.getValue().equals("ITO")){
            viewStudent.clear();
            viewStudent.addAll(studentListModel.getStudents());
        }
    }

    public void handleAbsences(ActionEvent actionEvent) {
        sceneSwapper.sceneSwitch(new Stage(), "RequestsView.fxml");

    }

    public void handleClick(MouseEvent mouseEvent) {

        lalGPName.setText(tvStudent.getSelectionModel().getSelectedItem().getfullName().getValue());
        lalGPStudentID.setText(tvStudent.getSelectionModel().getSelectedItem().getStudentID().getValue());
        lalGPAbsence.setText(tvStudent.getSelectionModel().getSelectedItem().getAbsentInPercent().getValue());
        buildBarChart();
    }

    public void handleLogOut(ActionEvent actionEvent) {


    }

    private void buildBarChart() {
        barChart.getData().clear();

        Axis<String> xAxis = barChart.getXAxis();
        xAxis.setLabel("Dage");
        Axis<Double> yAxis = barChart.getYAxis();
        yAxis.setLabel("Fravær i %");


        XYChart.Series<String, Double> dataSeries1 = new XYChart.Series<>();
        dataSeries1.setName("Fravær");
        dataSeries1.getData().add(new XYChart.Data("Mandag", randomDouble()));
        dataSeries1.getData().add(new XYChart.Data("Tirsdag", randomDouble()));
        dataSeries1.getData().add(new XYChart.Data("Onsdag", randomDouble()));
        dataSeries1.getData().add(new XYChart.Data("Torsdag", randomDouble()));
        dataSeries1.getData().add(new XYChart.Data("Fredag", randomDouble()));
        barChart.getData().add(dataSeries1);
    }

    private Double randomDouble(){
        Random random = new Random();
        return  random.nextDouble(100);
    }
}
