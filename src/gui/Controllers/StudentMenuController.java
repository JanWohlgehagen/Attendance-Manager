package gui.Controllers;

import gui.Models.StudentListModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class StudentMenuController implements Initializable {

    @FXML
    private TableView<StudentListModel> tvFraværsDage;
    @FXML
    private TableColumn<StudentListModel, String> tcFag;
    @FXML
    private TableColumn<StudentListModel, Date> tcDag;
    @FXML
    private TableColumn<StudentListModel, String> tcVerserende;

    @FXML
    private AreaChart acFravær;

    @FXML
    private ImageView imvStudentFoto;
    private Image image = new Image("gui/util/images/StudentFoto.jpg");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imvStudentFoto.setImage(image);
    }

    @FXML
    private void handelMeldAnkomst(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Tak for det :)");
        alert.show();
    }

    @FXML
    private void handelAnmodRettelse(ActionEvent actionEvent) {
    }
}
