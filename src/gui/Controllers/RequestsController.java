package gui.Controllers;

import be.Request;
import gui.Models.RequestListModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class RequestsController implements Initializable {

    @FXML
    private TableView<Request> tvRequests;
    @FXML
    private TableColumn<Request, String> tcName;
    @FXML
    private TableColumn<Request, Date> tcDate;
    @FXML
    private TableColumn<Request, String> tcClass;
    @FXML
    private TableColumn<Request, String> tcPresent;

    RequestListModel requestListModel = new RequestListModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tvRequests.setItems(requestListModel.getRequests());

        tcName.setCellValueFactory(param -> param.getValue().fullNameProperty());
        tcDate.setCellValueFactory(param -> param.getValue().dateProperty());
        tcClass.setCellValueFactory(param -> param.getValue().subjectProperty());
        tcPresent.setCellValueFactory(param -> param.getValue().absentProperty());
    }

    public void handleApprovedRequest(ActionEvent actionEvent) {
        if(tvRequests.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Du har ikke valgt en elev");
            alert.showAndWait();
        }else{
            requestListModel.removeRequest(tvRequests.getSelectionModel().getSelectedItem());
        }
    }

    public void handleRejectRequest(ActionEvent actionEvent) {
        if(tvRequests.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Du har ikke valgt en elev");
            alert.showAndWait();
        }else{
            requestListModel.removeRequest(tvRequests.getSelectionModel().getSelectedItem());
        }
    }
}
