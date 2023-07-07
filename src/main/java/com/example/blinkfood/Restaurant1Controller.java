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

public class Restaurant1Controller extends Checker implements Initializable {

    ////////////////////////////////////////Variables////////////////////////////////////////

    ////////////////////////////////////////Panes
    @FXML
    public Pane Food11, Food12, Food13, Food14;

    ////////////////////////////////////////ImageViews
    @FXML
    public ImageView FoodImage11, FoodImage12, FoodImage13, FoodImage14;

    ////////////////////////////////////////TextFields
    @FXML
    public TextField FoodName11, FoodName12, FoodName13, FoodName14;
    @FXML
    public TextField FoodPrice11, FoodPrice12, FoodPrice13, FoodPrice14;
    @FXML
    public TextField RestaurantName, RestaurantAddress;

    ////////////////////////////////////////Buttons
    @FXML
    public Button FoodCreate11, FoodCreate12, FoodCreate13, FoodCreate14;
    @FXML
    public Button FoodDelete11, FoodDelete12, FoodDelete13, FoodDelete14;

    //////////////////////////////////////// *** Spinner *** ////////////////////////////////////////
    @FXML
    private Spinner<Integer> StartWorkHours, EndWorkHours, services;
    public int startworkhour, endworkhour, NumberOfServices;
    //////////////////////////////////////// *** RadioButton *** ////////////////////////////////////////
    @FXML
    private Label Services;
    @FXML
    private RadioButton GetOut, Lodge;

    public String restaurantkind;
    final ToggleGroup Kind = new ToggleGroup();

    public void getFood(ActionEvent event) {
        if (GetOut.isSelected()) {
            Services.setText("Bikes");
            restaurantkind = "GetOut";
        } else if (Lodge.isSelected()) {
            Services.setText("Tables");
            restaurantkind = "Lodge";
        }
    }
    //////////////////////////////////////// *** Methods *** ////////////////////////////////////////

    public void AdminRestaurants(ActionEvent e) throws IOException {
        Loader(e, "AdminRestaurants.fxml", stage, scene, 10, 10);
    }

    //////////////////////////////////////// *** Constructor *** ////////////////////////////////////////

    public Restaurant1Controller() throws IOException {
        socket = new Socket("localhost", 12000);
        output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    }


    ////////////////////////////////////////Create Foods
    public void CreateFood11(ActionEvent event) {
        FoodCreate11.setVisible(false);
        FoodCreate11.setDisable(true);
        Food11.setVisible(true);
        Food11.setDisable(false);
    }

    public void CreateFood12(ActionEvent event) {
        FoodCreate12.setVisible(false);
        FoodCreate12.setDisable(true);
        Food12.setVisible(true);
        Food12.setDisable(false);
    }

    public void CreateFood13(ActionEvent event) {
        FoodCreate13.setVisible(false);
        FoodCreate13.setDisable(true);
        Food13.setVisible(true);
        Food13.setDisable(false);
    }

    public void CreateFood14(ActionEvent event) {
        FoodCreate14.setVisible(false);
        FoodCreate14.setDisable(true);
        Food14.setVisible(true);
        Food14.setDisable(false);
    }

    ////////////////////////////////////////Delete Foods
    public void DeleteFood11(ActionEvent event) {
        FoodCreate11.setVisible(true);
        FoodCreate11.setDisable(false);
        Food11.setVisible(false);
        Food11.setDisable(true);
    }

    public void DeleteFood12(ActionEvent event) {
        FoodCreate12.setVisible(true);
        FoodCreate12.setDisable(false);
        Food12.setVisible(false);
        Food12.setDisable(true);
    }

    public void DeleteFood13(ActionEvent event) {
        FoodCreate13.setVisible(true);
        FoodCreate13.setDisable(false);
        Food13.setVisible(false);
        Food13.setDisable(true);
    }

    public void DeleteFood14(ActionEvent event) {
        FoodCreate14.setVisible(true);
        FoodCreate14.setDisable(false);
        Food14.setVisible(false);
        Food14.setDisable(true);
    }

    //    public void ImageLoader() {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Open Image File");
//        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files (*.png,*.jpg)", "*.png", "*.jpg");
//        fileChooser.getExtensionFilters().add(extFilter);
//        File selectedFile = fileChooser.showOpenDialog(new Stage());
//        if (selectedFile != null) {
//            Image image = new Image(selectedFile.toURI().toString());
////            FoodImage11.setImage(image);
////            foodImage11 = selectedFile.getAbsolutePath();
//        }
//    }
    ////////////////////////////////////////////////////////////////////////
//    public void ImageLoader1(MouseEvent event) throws FileNotFoundException {
//        try {
//            FileChooser fileChooser = new FileChooser();
//            fileChooser.setTitle("Open Image File");
//            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files (.png,.jpg)", ".png", ".jpg");
//            fileChooser.getExtensionFilters().add(extFilter);
//            File selectedFile = fileChooser.showOpenDialog(new Stage());
//            if (selectedFile != null) {
//                Image image = new Image(selectedFile.toURI().toString());
//                FoodImage11.setImage(image);
//                String path1 = (String) selectedFile.getAbsolutePath();
//                File pathFiler = new File(imageFoods1);
//                PrintWriter writer = new PrintWriter(pathFiler);
//                writer.write("Food1Path: ".concat(path1));
////                writer.write("Food1Path: ".concat(path1));
//                writer.close();
//            }
//        } catch (java.io.IOException exception) {
//            System.out.println("Image Exception");
//        }
//    }
    ////////////////////////////////////////////////////////////////////////
    public void Restaurant1Submit(ActionEvent e) throws IOException {
        if (Food11.isVisible() && Food12.isVisible() && Food12.isVisible() && Food12.isVisible()) {
            RestaurantComponentSaver(FoodNameAndPrice1);
        }
        Loader(e, "AdminRestaurants.fxml", stage, scene, 260, 10);
    }

//    Tartib
//          FoodName11.setText(input.readUTF());
//            FoodName12.setText(input.readUTF());
//            FoodName13.setText(input.readUTF());
//            FoodName14.setText(input.readUTF());
//            FoodPrice11.setText(input.readUTF());
//            FoodPrice12.setText(input.readUTF());
//            FoodPrice13.setText(input.readUTF());
//            FoodPrice14.setText(input.readUTF());
//            RestaurantName.setText(input.readUTF());
//    restaurantkind = input.readUTF();
//    startworkhour = Integer.parseInt(input.readUTF());
//    endworkhour = Integer.parseInt(input.readUTF());
//    NumberOfServices = Integer.parseInt(input.readUTF());
//            RestaurantAddress.setText(input.readUTF());

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

            output.writeUTF(FoodName11.getText());
            output.flush();
            output.writeUTF(FoodName12.getText());
            output.flush();
            output.writeUTF(FoodName13.getText());
            output.flush();
            output.writeUTF(FoodName14.getText());
            output.flush();
            output.writeUTF(FoodPrice11.getText());
            output.flush();
            output.writeUTF(FoodPrice12.getText());
            output.flush();
            output.writeUTF(FoodPrice13.getText());
            output.flush();
            output.writeUTF(FoodPrice14.getText());
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
        SpinnerValueFactory<Integer> StartValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12);
//        StartValue.setValue(5);
        StartWorkHours.setValueFactory(StartValue);
        SpinnerValueFactory<Integer> EndValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12);
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
            String component = FoodNameAndPrice1;
            output.writeUTF("RestaurantComponent");
            output.flush();
            output.writeUTF("Load");
            output.flush();
            output.writeUTF(component);
            output.flush();

            FoodName11.setText(input.readUTF());
            FoodName12.setText(input.readUTF());
            FoodName13.setText(input.readUTF());
            FoodName14.setText(input.readUTF());
            FoodPrice11.setText(input.readUTF());
            FoodPrice12.setText(input.readUTF());
            FoodPrice13.setText(input.readUTF());
            FoodPrice14.setText(input.readUTF());
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