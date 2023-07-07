package com.example.blinkfood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Login1Controller extends Checker implements Initializable {

    ////////////////////////////////////////ImageViews
    @FXML
    public ImageView FoodImage11, FoodImage12, FoodImage13, FoodImage14;

    ////////////////////////////////////////TextFields
    @FXML
    public TextField FoodName11, FoodName12, FoodName13, FoodName14;
    @FXML
    public TextField FoodPrice11, FoodPrice12, FoodPrice13, FoodPrice14;
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
            File NameAndPrice1 = new File(FoodNameAndPrice1);
            Scanner scanner = new Scanner(NameAndPrice1);
            String foodName1 = null;
            String foodName2 = null;
            String foodName3 = null;
            String foodName4 = null;
            String foodPrice1 = null;
            String foodPrice2 = null;
            String foodPrice3 = null;
            String foodPrice4 = null;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                foodName1 = parts[1];
                foodName2 = parts[3];
                foodName3 = parts[5];
                foodName4 = parts[7];
                foodPrice1 = parts[9];
                foodPrice2 = parts[11];
                foodPrice3 = parts[13];
                foodPrice4 = parts[15];
            }
            FoodName11.setText(foodName1);
            FoodName12.setText(foodName2);
            FoodName13.setText(foodName3);
            FoodName14.setText(foodName4);
            FoodPrice11.setText(foodPrice1);
            FoodPrice12.setText(foodPrice2);
            FoodPrice13.setText(foodPrice3);
            FoodPrice14.setText(foodPrice4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
