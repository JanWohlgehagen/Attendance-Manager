package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Views/LoginScreenView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 400);
        primaryStage.setTitle("Attendance Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
