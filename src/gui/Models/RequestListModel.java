package gui.Models;

import be.Request;
import be.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Calendar;
import java.util.Date;

public class RequestListModel {

    private ObservableList<Request> requests = FXCollections.observableArrayList();


    public RequestListModel() {

        requests.add(new Request("Mark Rasmussen", new Date(2022, Calendar.JULY,20), "ITO", "JA"));
        requests.add(new Request("Tobias Jensen", new Date(2022, Calendar.JULY,14), "ITO", "JA"));
        requests.add(new Request("Thomas Bolds", new Date(2022, Calendar.JULY,16), "ITO", "JA"));
        requests.add(new Request("Lars Q", new Date(2022, Calendar.JULY,20), "ITO", "JA"));

    }

    public ObservableList<Request> getRequests(){
        return requests;
    }

    public void removeRequest(Request request){
        requests.remove(request);
    }
}
