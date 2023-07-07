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

public class Login3Controller extends Checker implements Initializable {


    ////////////////////////////////////////ImageViews
    @FXML
    public ImageView FoodImage31, FoodImage32, FoodImage33, FoodImage34;

    ////////////////////////////////////////TextFields
    @FXML
    public TextField FoodName31, FoodName32, FoodName33, FoodName34;
    @FXML
    public TextField FoodPrice31, FoodPrice32, FoodPrice33, FoodPrice34;
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
            File NameAndPrice3 = new File(FoodNameAndPrice3);
            Scanner scanner3 = new Scanner(NameAndPrice3);
            String foodName31 = null;
            String foodName32 = null;
            String foodName33 = null;
            String foodName34 = null;
            String foodPrice31 = null;
            String foodPrice32 = null;
            String foodPrice33 = null;
            String foodPrice34 = null;
            while (scanner3.hasNextLine()) {
                String line = scanner3.nextLine();
                String[] parts = line.split(" ");
                foodName31 = parts[1];
                foodName32 = parts[3];
                foodName33 = parts[5];
                foodName34 = parts[7];
                foodPrice31 = parts[9];
                foodPrice32 = parts[11];
                foodPrice33 = parts[13];
                foodPrice34 = parts[15];
            }
            FoodName31.setText(foodName31);
            FoodName32.setText(foodName32);
            FoodName33.setText(foodName33);
            FoodName34.setText(foodName34);
            FoodPrice31.setText(foodPrice31);
            FoodPrice32.setText(foodPrice32);
            FoodPrice33.setText(foodPrice33);
            FoodPrice34.setText(foodPrice34);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}