package gui.Controllers;

import gui.util.SceneSwapper;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.PrimitiveIterator;
import java.util.ResourceBundle;

public class LoginScreenController implements Initializable {

    @FXML
    private StackPane stackPaneParent;
    @FXML
    private VBox vBoxLoginBox;

    @FXML
    private TextField txtUserID;
    @FXML
    private TextField txtUserPassword;

    private SceneSwapper sceneSwapper;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sceneSwapper = new SceneSwapper();
    }


    public void handleCancel(ActionEvent actionEvent) {
        txtUserID.clear();
        txtUserPassword.clear();
        closeWindow();
    }

    public void handleSignIn(ActionEvent actionEvent) {
        if (txtUserID.getText().contains("student")){
            sceneSwapper.sceneSwitch(new Stage(), "StudentMenuView.fxml");
        } else {
            sceneSwapper.sceneSwitch(new Stage(), "TeacherMenuView.fxml");
        }
        closeWindow();
    }

    private void closeWindow(){
        Stage stage = (Stage) stackPaneParent.getScene().getWindow();
        stage.close();
    }
}
