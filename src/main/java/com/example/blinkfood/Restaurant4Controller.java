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

public class Restaurant4Controller extends Checker implements Initializable {

    ////////////////////////////////////////Variables////////////////////////////////////////

    ////////////////////////////////////////Panes
    @FXML
    public Pane Food41, Food42, Food43, Food44;

    ////////////////////////////////////////ImageViews
    @FXML
    public ImageView FoodImage41, FoodImage42, FoodImage43, FoodImage44;

    ////////////////////////////////////////TextFields
    @FXML
    public TextField FoodName41, FoodName42, FoodName43, FoodName44;
    @FXML
    public TextField FoodPrice41, FoodPrice42, FoodPrice43, FoodPrice44;
    @FXML
    public TextField RestaurantName, RestaurantAddress;
    ////////////////////////////////////////Buttons
    @FXML
    public Button FoodDelete41, FoodDelete42, FoodDelete43, FoodDelete44;

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
    final ToggleGroup Kind = new ToggleGroup();
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

    public Restaurant4Controller() throws IOException {
        socket = new Socket("localhost", 12000);
        output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
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

    public void Restaurant4Submit(ActionEvent e) throws IOException {
        if (Food41.isVisible() && Food42.isVisible() && Food42.isVisible() && Food42.isVisible()) {
            RestaurantComponentSaver(FoodNameAndPrice1);
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

            output.writeUTF(FoodName41.getText());
            output.flush();
            output.writeUTF(FoodName42.getText());
            output.flush();
            output.writeUTF(FoodName43.getText());
            output.flush();
            output.writeUTF(FoodName44.getText());
            output.flush();
            output.writeUTF(FoodPrice41.getText());
            output.flush();
            output.writeUTF(FoodPrice42.getText());
            output.flush();
            output.writeUTF(FoodPrice43.getText());
            output.flush();
            output.writeUTF(FoodPrice44.getText());
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
        GetOut.setToggleGroup(Kind);
        Lodge.setToggleGroup(Kind);
        //////////////////////////
        try {
            /////////////////////////////////////////////////////////////////////////
            //Load From Server
            String component = FoodNameAndPrice4;
            output.writeUTF("RestaurantComponent");
            output.flush();
            output.writeUTF("Load");
            output.flush();
            output.writeUTF(component);
            output.flush();

            FoodName41.setText(input.readUTF());
            FoodName42.setText(input.readUTF());
            FoodName43.setText(input.readUTF());
            FoodName44.setText(input.readUTF());
            FoodPrice41.setText(input.readUTF());
            FoodPrice42.setText(input.readUTF());
            FoodPrice43.setText(input.readUTF());
            FoodPrice44.setText(input.readUTF());
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