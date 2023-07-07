package com.example.blinkfood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Login4Controller extends Checker implements Initializable {


    ////////////////////////////////////////ImageViews
    @FXML
    public ImageView FoodImage41, FoodImage42, FoodImage43, FoodImage44;

    ////////////////////////////////////////TextFields
    @FXML
    public TextField FoodName41, FoodName42, FoodName43, FoodName44;
    @FXML
    public TextField FoodPrice41, FoodPrice42, FoodPrice43, FoodPrice44;
    @FXML
    private Pane UserDetails, Portals;

    public void LoginRestaurants(ActionEvent e) throws IOException {
        Loader(e, "LoginRestaurants.fxml", stage, scene, 10, 10);
    }


    ////////////////////////////////////////Portal Prices
    public void MellatPrice(MouseEvent event) throws IOException {
        MouseLoader(event, "MellatPortal.fxml", stage, scene);
    }

    public void MelliPrice(MouseEvent event) throws IOException {
        MouseLoader(event, "MelliPortal.fxml", stage, scene);
    }

    public void SamanPrice(MouseEvent event) throws IOException {
        MouseLoader(event, "SamanPortal.fxml", stage, scene);
    }

    ////////////////////////////////////////User Profile
    public void UserDetails(MouseEvent e) {
        UserDetails.setVisible(true);
        UserDetails.setDisable(false);
    }

    public void Portals(ActionEvent e) {
        Portals.setVisible(true);
        Portals.setDisable(false);
    }

    public void Back(ActionEvent e) {
        UserDetails.setVisible(false);
        UserDetails.setDisable(true);
        Portals.setVisible(false);
        Portals.setDisable(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            File NameAndPrice4 = new File(FoodNameAndPrice4);
            Scanner scanner4 = new Scanner(NameAndPrice4);
            String foodName41 = null;
            String foodName42 = null;
            String foodName43 = null;
            String foodName44 = null;
            String foodPrice41 = null;
            String foodPrice42 = null;
            String foodPrice43 = null;
            String foodPrice44 = null;
            while (scanner4.hasNextLine()) {
                String line = scanner4.nextLine();
                String[] parts = line.split(" ");
                foodName41 = parts[1];
                foodName42 = parts[3];
                foodName43 = parts[5];
                foodName44 = parts[7];
                foodPrice41 = parts[9];
                foodPrice42 = parts[11];
                foodPrice43 = parts[13];
                foodPrice44 = parts[15];
            }
            FoodName41.setText(foodName41);
            FoodName42.setText(foodName42);
            FoodName43.setText(foodName43);
            FoodName44.setText(foodName44);
            FoodPrice41.setText(foodPrice41);
            FoodPrice42.setText(foodPrice42);
            FoodPrice43.setText(foodPrice43);
            FoodPrice44.setText(foodPrice44);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}