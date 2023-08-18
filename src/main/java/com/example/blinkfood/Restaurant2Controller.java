package com.example.blinkfood;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Restaurant2Controller extends Checker implements Initializable {

    ////////////////////////////////////////Variables////////////////////////////////////////

    ////////////////////////////////////////Panes
    @FXML
    public Pane Food21, Food22, Food23, Food24;

    ////////////////////////////////////////ImageViews
    @FXML
    public ImageView FoodImage21, FoodImage22, FoodImage23, FoodImage24;

    ////////////////////////////////////////TextFields
    @FXML
    public TextField FoodName21, FoodName22, FoodName23, FoodName24;
    @FXML
    public TextField FoodPrice21, FoodPrice22, FoodPrice23, FoodPrice24;
    @FXML
    public TextField RestaurantName, RestaurantAddress;
    //////////////////////////////////////// *** Buttons *** ////////////////////////////////////////
    @FXML
    public Button FoodCreate21, FoodCreate22, FoodCreate23, FoodCreate24;
    @FXML
    public Button FoodDelete21, FoodDelete22, FoodDelete23, FoodDelete24;

    //////////////////////////////////////// *** Spinner *** ////////////////////////////////////////
    @FXML
    private Spinner<Integer> StartWorkHours, EndWorkHours , services;
    public int startworkhour, endworkhour , NumberOfServices;
    //////////////////////////////////////// *** RadioButton *** ////////////////////////////////////////
    @FXML
    private Label Services;
    @FXML
    private RadioButton GetOut , Lodge;

    public String restaurantkind;
//    final ToggleGroup Kind = new ToggleGroup();
    public void getFood(ActionEvent event) {
        if (GetOut.isSelected()){
            Services.setText("Bikes");
            restaurantkind = "GetOut";
        } else if (Lodge.isSelected()) {
            Services.setText("Tables");
            restaurantkind = "Lodge";
        }
    }
    ////////////////////////////////////////Methods////////////////////////////////////////

    public void AdminRestaurants(ActionEvent e) throws IOException {
        Loader(e, "AdminRestaurants.fxml", stage, scene, 10, 10);
    }

    //////////////////////////////////////// *** Constructor *** ////////////////////////////////////////

    public Restaurant2Controller() throws IOException {
        socket = new Socket("localhost", 12000);
        output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    }

    ////////////////////////////////////////Create Foods
    public void CreateFood21(ActionEvent event) {
        FoodCreate21.setVisible(false);
        FoodCreate21.setDisable(true);
        Food21.setVisible(true);
        Food21.setDisable(false);
    }

    public void CreateFood22(ActionEvent event) {
        FoodCreate22.setVisible(false);
        FoodCreate22.setDisable(true);
        Food22.setVisible(true);
        Food22.setDisable(false);
    }

    public void CreateFood23(ActionEvent event) {
        FoodCreate23.setVisible(false);
        FoodCreate23.setDisable(true);
        Food23.setVisible(true);
        Food23.setDisable(false);
    }

    public void CreateFood24(ActionEvent event) {
        FoodCreate24.setVisible(false);
        FoodCreate24.setDisable(true);
        Food24.setVisible(true);
        Food24.setDisable(false);
    }

    ////////////////////////////////////////Delete Foods
    public void DeleteFood21(ActionEvent event) {
        FoodCreate21.setVisible(true);
        FoodCreate21.setDisable(false);
        Food21.setVisible(false);
        Food21.setDisable(true);
    }

    public void DeleteFood22(ActionEvent event) {
        FoodCreate22.setVisible(true);
        FoodCreate22.setDisable(false);
        Food22.setVisible(false);
        Food22.setDisable(true);
    }

    public void DeleteFood23(ActionEvent event) {
        FoodCreate23.setVisible(true);
        FoodCreate23.setDisable(false);
        Food23.setVisible(false);
        Food23.setDisable(true);
    }

    public void DeleteFood24(ActionEvent event) {
        FoodCreate24.setVisible(true);
        FoodCreate24.setDisable(false);
        Food24.setVisible(false);
        Food24.setDisable(true);
    }

    public void ImageLoader() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files (*.png,*.jpg)", "*.png", "*.jpg");
        fileChooser.getExtensionFilters().add(extFilter);
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
//            FoodImage11.setImage(image);
//            foodImage11 = selectedFile.getAbsolutePath();
        }
    }

    public void Restaurant2Submit(ActionEvent e) throws IOException {
        if (Food21.isVisible() && Food22.isVisible() && Food22.isVisible() && Food22.isVisible()) {
            RestaurantComponentSaver(FoodNameAndPrice2);
        }
        Loader(e , "AdminRestaurants.fxml" , stage , scene , 260 , 10);
    }

    public void RestaurantComponentSaver(String address) throws IOException {
        try {
            //Send To Server
            String component = address;
            output.writeUTF("RestaurantComponent");
            output.flush();
            output.writeUTF("Save");
            output.flush();
            output.writeUTF(component);
            output.flush();

            output.writeUTF(FoodName21.getText());
            output.flush();
            output.writeUTF(FoodName22.getText());
            output.flush();
            output.writeUTF(FoodName23.getText());
            output.flush();
            output.writeUTF(FoodName24.getText());
            output.flush();
            output.writeUTF(FoodPrice21.getText());
            output.flush();
            output.writeUTF(FoodPrice22.getText());
            output.flush();
            output.writeUTF(FoodPrice23.getText());
            output.flush();
            output.writeUTF(FoodPrice24.getText());
            output.flush();
            output.writeUTF(RestaurantName.getText());
            output.flush();
            output.writeUTF(restaurantkind);
            output.flush();
            output.writeUTF(String.valueOf(startworkhour));
            output.flush();
            output.writeUTF(String.valueOf(endworkhour));
            output.flush();
            output.writeUTF(String.valueOf(NumberOfServices));
            output.flush();
            output.writeUTF(RestaurantAddress.getText());
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//////////////////////////////////////// *** Spinner *** ////////////////////////////////////////
        SpinnerValueFactory<Integer> StartValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(1 , 12);
//        StartValue.setValue(5);
        StartWorkHours.setValueFactory(StartValue);
        SpinnerValueFactory<Integer> EndValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(1 , 12);
//        EndValue.setValue(12);
        EndWorkHours.setValueFactory(EndValue);
        SpinnerValueFactory<Integer> servicesValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 15);
        servicesValue.setValue(0);
        services.setValueFactory(servicesValue);

        startworkhour = StartWorkHours.getValue();
        endworkhour = EndWorkHours.getValue();
        NumberOfServices = services.getValue();

        StartWorkHours.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                startworkhour = StartWorkHours.getValue();
            }
        });
        EndWorkHours.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                endworkhour = EndWorkHours.getValue();
            }
        });
        services.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                NumberOfServices = services.getValue();
            }
        });
        ///////////////////////////
//        GetOut.setToggleGroup(Kind);
//        Lodge.setToggleGroup(Kind);
        //////////////////////////
        try {
            /////////////////////////////////////////////////////////////////////////
            //Load From Server
            String component = FoodNameAndPrice2;
            output.writeUTF("RestaurantComponent");
            output.flush();
            output.writeUTF("Load");
            output.flush();
            output.writeUTF(component);
            output.flush();

            FoodName21.setText(input.readUTF());
            FoodName22.setText(input.readUTF());
            FoodName23.setText(input.readUTF());
            FoodName24.setText(input.readUTF());
            FoodPrice21.setText(input.readUTF());
            FoodPrice22.setText(input.readUTF());
            FoodPrice23.setText(input.readUTF());
            FoodPrice24.setText(input.readUTF());
            RestaurantName.setText(input.readUTF());
            restaurantkind = input.readUTF();
            if (restaurantkind.equals("Lodge"))
                Lodge.setSelected(true);
            else
                GetOut.setSelected(true);
            startworkhour = Integer.parseInt(input.readUTF());
            StartValue.setValue(startworkhour);
            endworkhour = Integer.parseInt(input.readUTF());
            EndValue.setValue(endworkhour);
            NumberOfServices = Integer.parseInt(input.readUTF());
            servicesValue.setValue(NumberOfServices);
            RestaurantAddress.setText(input.readUTF());
            /////////////////////////////////////////////////////////////////////////
//            Image image1 = new Image(foodImage11);
//            FoodImage11.setImage(image1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}