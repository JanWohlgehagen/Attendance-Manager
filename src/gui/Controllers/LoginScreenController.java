package gui.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void handleCancel(ActionEvent actionEvent) {
        txtUserID.clear();
        txtUserPassword.clear();
    }

    public void handleSignIn(ActionEvent actionEvent) {
    }
}
