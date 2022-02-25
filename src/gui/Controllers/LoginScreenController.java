package gui.Controllers;

import gui.util.SceneSwapper;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
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
    }

    public void handleSignIn(ActionEvent actionEvent) {
        if (txtUserID.getText().contains("student") || txtUserPassword.getText().contains("123")){
            sceneSwapper.sceneSwitch(new Stage(), "StudentMenuView.fxml");
            closeWindow();
            txtUserID.clear();
            txtUserPassword.clear();
        }
        else if (txtUserID.getText().contains("teacher") || txtUserPassword.getText().contains("123")){
            sceneSwapper.sceneSwitch(new Stage(), "TeacherMenuView.fxml");
            closeWindow();
            txtUserID.clear();
            txtUserPassword.clear();
        }else{
            Alert alertCheck = new Alert(Alert.AlertType.ERROR, "Login error\n" +
                    "Username or Password incorrect", ButtonType.OK);
            alertCheck.showAndWait();
        }

    }

    private void closeWindow(){
        Stage stage = (Stage) stackPaneParent.getScene().getWindow();
        stage.close();
    }
}
