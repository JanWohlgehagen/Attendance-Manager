package gui.Controllers;

import gui.util.SceneSwapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentMenuController {

    @FXML
    private Button meldAnkomstButton;
    @FXML
    private Button anmodRettelseButton;
    @FXML
    private Button logUdBotton;

    private SceneSwapper sceneSwapper;

    public StudentMenuController() {
        sceneSwapper = new SceneSwapper();
    }

    public void meldAnkomst(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Du har nu meldt din ankomst", ButtonType.OK);
        alert.show();
    }

    public boolean anmodRettelse(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Er du sikker på, at du vil sende rettelsen til godkendelse?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.YES;
    }

    public void logUd(ActionEvent actionEvent) {
        Stage stage = (Stage) logUdBotton.getScene().getWindow();
        sceneSwapper.sceneSwitch(new Stage(),"LoginScreenView.fxml");
        stage.close();
    }
}