package com.example.blinkfood;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
//        Group root1 = new Group();
        Image icon = new Image("C:\\Users\\Admin\\IdeaProjects\\BlinkFood\\BlinkFood\\src\\main\\resources\\com\\example\\image\\Icon.png");

        stage.getIcons().add(icon);
        stage.setTitle("Blink_Food");
        //********************************************** The Kharab *************************************************
        ///For fullscreeen
//        stage.setFullScreen(true);
//        stage.setFullScreenExitHint("Press Esc to escape");
//        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("Esc"));
        //***********************************************************************************************************
        stage.setResizable(false);
//        stage.setScene(scene);
//        stage.show();
    }
}