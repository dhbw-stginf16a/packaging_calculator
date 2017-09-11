package de.packagingcalculator.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFrame {

    private Stage primaryStage;

    public MainFrame(Stage primaryStage) {
        this.primaryStage = primaryStage;
        try {
            Scene scene = new Scene(FXMLLoader.load(MainFrame.class.getResource("mainFrame.fxml")));
            this.primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        primaryStage.show();
    }
}
