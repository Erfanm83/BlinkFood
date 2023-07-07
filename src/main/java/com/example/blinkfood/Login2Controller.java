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

public class Login2Controller extends Checker implements Initializable {


    ////////////////////////////////////////ImageViews
    @FXML
    public ImageView FoodImage21, FoodImage22, FoodImage23, FoodImage24;

    ////////////////////////////////////////TextFields
    @FXML
    public TextField FoodName21, FoodName22, FoodName23, FoodName24;
    @FXML
    public TextField FoodPrice21, FoodPrice22, FoodPrice23, FoodPrice24;

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
            File NameAndPrice2 = new File(FoodNameAndPrice2);
            Scanner scanner2 = new Scanner(NameAndPrice2);
            String foodName21 = null;
            String foodName22 = null;
            String foodName23 = null;
            String foodName24 = null;
            String foodPrice21 = null;
            String foodPrice22 = null;
            String foodPrice23 = null;
            String foodPrice24 = null;
            while (scanner2.hasNextLine()) {
                String line = scanner2.nextLine();
                String[] parts = line.split(" ");
                foodName21 = parts[1];
                foodName22 = parts[3];
                foodName23 = parts[5];
                foodName24 = parts[7];
                foodPrice21 = parts[9];
                foodPrice22 = parts[11];
                foodPrice23 = parts[13];
                foodPrice24 = parts[15];
            }
            FoodName21.setText(foodName21);
            FoodName22.setText(foodName22);
            FoodName23.setText(foodName23);
            FoodName24.setText(foodName24);
            FoodPrice21.setText(foodPrice21);
            FoodPrice22.setText(foodPrice22);
            FoodPrice23.setText(foodPrice23);
            FoodPrice24.setText(foodPrice24);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}