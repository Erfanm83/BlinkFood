package com.example.blinkfood;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main extends Application {
    Server server;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            System.out.println("Start server on port: 12000");
            server = new Server(12000);
            server.startServer();
//            try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin.fxml")));
            Image icon = new Image("Icon.png");
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
//                Thread.sleep(1200000);

//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }


//            Download( "AdminPage" , "Icon.png", socket, IconFileStream);
//            Download("AdminPage" , "Admin.png", socket, AdminPageStream);
//            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin.fxml")));
//            Image icon = new Image("C:\\Users\\Admin\\IdeaProjects\\BlinkFood\\BlinkFood\\src\\main\\resources\\com\\example\\Client\\Image\\Icon.png");
//            Scene scene = new Scene(root);
//            stage.setX(350);
//            stage.setY(70);
//            stage.getIcons().add(icon);
//            stage.setTitle("Blink Food");
//            stage.setResizable(false);
//            stage.setScene(scene);
//            stage.show();
//            stage.setOnCloseRequest(windowEvent -> {
//                windowEvent.consume();
//                exit(stage);
//            });
//            IconFileStream.close();
//            AdminPageStream.close();
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

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Download( "AdminPage" , "Icon.png", socket, IconFileStream);
//        Download("AdminPage" , "Admin.png", socket, AdminPageStream);
//    }

//    public void Download( String request , String Filename ,  Socket socket, FileOutputStream fileoutputstream) {
//        try {
//            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
//            output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
//            output.writeUTF(request);
//            output.flush();
//            output.writeUTF(Filename);
//            output.flush();
//            if (input.readUTF().equals("Start download.")) {
//                System.out.println("Downloading ...");
//                fileoutputstream = new FileOutputStream("C:\\Users\\Admin\\IdeaProjects\\BlinkFood\\BlinkFood\\src\\main\\resources\\com\\example\\Client\\Image\\" + Filename);
//                int bytes = 0;
//
//                long size = input.readLong();     // read file size
//                byte[] buffer = new byte[4 * 1024];
//                while (size > 0 && (bytes = input.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
//                    fileoutputstream.write(buffer, 0, bytes);
//                    size -= bytes;      // read upto file size
//                }
//                System.out.println(Filename + " Downloaded.");
//                fileoutputstream.close();
//            } else {
//                System.out.println("File Not Exist.");
//            }
//        } catch (Exception exception) {
//            System.out.println(exception);
//        }
//    }
}