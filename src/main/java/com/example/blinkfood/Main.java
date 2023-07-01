package com.example.blinkfood;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin.fxml")));
            Image icon = new Image("D:\\Codes\\Java\\Blink Food\\src\\main\\resources\\com\\example\\image\\Icon.png");
            Scene scene = new Scene(root);
            stage.setX(350);
            stage.setY(70);
            stage.getIcons().add(icon);
            stage.setTitle("Blink Food");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(windowEvent -> {
                windowEvent.consume();
                exit(stage);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void exit(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Do you want to exit ?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
        }
    }
}