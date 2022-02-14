package gui.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class SceneSwapper {
    /**
     * switches the stage to a certain fxml file.
     *
     * @param stage         of stage wanted to be shown.
     * @param fxmlClassName the file that wanted to be shown
     */
    public void sceneSwitch(Stage stage, String fxmlClassName) {
        try {
            URL url = new File("src/gui/Views/" + fxmlClassName).toURI().toURL();
            Parent scene = FXMLLoader.load(url);
            Scene viewScene = new Scene(scene);
            stage.setTitle("Attendance Manager");
            stage.setScene(viewScene);
            stage.show();           // har lige lavet lidt rettelser, det var showAndWait(); før og det knækker lidt koden for at skifte vindue og få den til at lukke tidl.
        } catch (IOException IOex) {
            IOex.printStackTrace();
        }
    }
}
