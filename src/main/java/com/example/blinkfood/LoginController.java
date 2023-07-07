package com.example.blinkfood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LoginController extends Checker implements Initializable {

    ////////////////////////////////////////Panes
    @FXML
    public Pane Restaurant1, Restaurant2, Restaurant3, Restaurant4;

    ////////////////////////////////////////Methods////////////////////////////////////////

    ////////////////////////////////////////Back On Action
    public void Login(ActionEvent e) throws IOException {
        Loader(e, "Login.fxml", stage, scene, 350, 70);
    }

    ////////////////////////////////////////Admin Restaurants Pages
    public void LoginRestaurant1(MouseEvent event) throws IOException {
        MouseLoader(event, "LoginRestaurant1.fxml", stage, scene);
    }

    public void LoginRestaurant2(MouseEvent event) throws IOException {
        MouseLoader(event, "LoginRestaurant2.fxml", stage, scene);
    }

    public void LoginRestaurant3(MouseEvent event) throws IOException {
        MouseLoader(event, "LoginRestaurant3.fxml", stage, scene);
    }

    public void LoginRestaurant4(MouseEvent event) throws IOException {
        MouseLoader(event, "LoginRestaurant4.fxml", stage, scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            File DeleteOrPlus1 = new File(Delete1File);
//            Scanner scanner1 = new Scanner(DeleteOrPlus1);
//            String deleteOrPlus1 = null;
//            while (scanner1.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] parts = line.split(" ");
//                deleteOrPlus1 = parts[1];
//            }
//            File DeleteOrPlus2 = new File(Delete2File);
//            Scanner scanner2 = new Scanner(DeleteOrPlus2);
//            String deleteOrPlus2 = null;
//            while (scanner2.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] parts = line.split(" ");
//                deleteOrPlus2 = parts[1];
//            }
//            File DeleteOrPlus3 = new File(Delete3File);
//            Scanner scanner3 = new Scanner(DeleteOrPlus3);
//            String deleteOrPlus3 = null;
//            while (scanner3.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] parts = line.split(" ");
//                deleteOrPlus3 = parts[1];
//            }
//            File DeleteOrPlus4 = new File(Delete4File);
//            Scanner scanner4 = new Scanner(DeleteOrPlus4);
//            String deleteOrPlus4 = null;
//            while (scanner4.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] parts = line.split(" ");
//                deleteOrPlus4 = parts[1];
//            }
//            //            String foodName2 = null;
////            String foodName3 = null;
////            String foodName4 = null;
//        }catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}