package gui.Controllers;

import be.Student;
import gui.Models.StudentListModel;
import gui.util.SceneSwapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherMenuController implements Initializable {


    public ComboBox<String> cbClass;
    public TableView<Student> tvStudent;
    public TableColumn<Student, String> tcStudentID;
    public TableColumn<Student, String> tcName;
    public TableColumn<Student, String> tcAbsence;
    public Label lalCountCorrections;
    public ImageView imageStudent;
    public Label lalGPName;
    public Label lalGPStudentID;
    public Label lalGPAbsence;
    public BarChart barChart;

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

        cbClass.getItems().addAll("Dansk");


        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Most Popular Programming Language");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("# of developers x 1000");

        this.barChart = new BarChart(xAxis, yAxis);


        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Popular programming languages rated by GitHub");

        dataSeries1.getData().add(new XYChart.Data("JavaScript", 2300));
        dataSeries1.getData().add(new XYChart.Data("Python", 1000));
        dataSeries1.getData().add(new XYChart.Data("Java", 986));
        dataSeries1.getData().add(new XYChart.Data("Ruby", 870));
        dataSeries1.getData().add(new XYChart.Data("C++", 413));
        dataSeries1.getData().add(new XYChart.Data("C#", 326));
        barChart.getData().add(dataSeries1);




    }


    public void handleViewStudent(ActionEvent actionEvent) {
        if(cbClass.getValue().equals("Dansk")){
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
    }

    public void handleLogOut(ActionEvent actionEvent) {

    }

    private BarChart buildBarChart() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Most Popular Programming Language");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("# of developers x 1000");

        this.barChart = new BarChart(xAxis, yAxis);


        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Popular programming languages rated by GitHub");

        dataSeries1.getData().add(new XYChart.Data("JavaScript", 2300));
        dataSeries1.getData().add(new XYChart.Data("Python", 1000));
        dataSeries1.getData().add(new XYChart.Data("Java", 986));
        dataSeries1.getData().add(new XYChart.Data("Ruby", 870));
        dataSeries1.getData().add(new XYChart.Data("C++", 413));
        dataSeries1.getData().add(new XYChart.Data("C#", 326));
        barChart.getData().add(dataSeries1);

        return barChart;
    }
}
