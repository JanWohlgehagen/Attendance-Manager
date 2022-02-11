package gui.Controllers;

import be.Student;
import gui.Models.StudentListModel;
import gui.Models.TeacherListModel;
import gui.util.SceneSwapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
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
}
