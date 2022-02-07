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
            Parent Scene = FXMLLoader.load(url);
            Scene ViewScene = new Scene(Scene);
            stage.setTitle("Attendance Manager");
            stage.setScene(ViewScene);
            stage.showAndWait();
        } catch (IOException IOex) {
            IOex.printStackTrace();
        }
    }
}
