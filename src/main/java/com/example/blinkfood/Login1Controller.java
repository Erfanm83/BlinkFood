package com.example.blinkfood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Login1Controller extends Checker implements Initializable {

    ////////////////////////////////////////ImageViews
    @FXML
    public ImageView FoodImage11, FoodImage12, FoodImage13, FoodImage14;

    ////////////////////////////////////////TextFields
    @FXML
    public TextField RestaurantName, RestaurantAddress;
    @FXML
    public TextField FoodName11, FoodName12, FoodName13, FoodName14;
    @FXML
    public TextField FoodPrice11, FoodPrice12, FoodPrice13, FoodPrice14;
    @FXML
    public TextField Price;
    @FXML
    private Pane UserDetails, Portals;
    //////////////////////////////////////// *** Spinner *** ////////////////////////////////////////
    @FXML
    private Spinner<Integer> StartWorkHours, EndWorkHours, services;
    public int startworkhour, endworkhour, NumberOfServices;
    //////////////////////////////////////// *** RadioButton *** ////////////////////////////////////////
    @FXML
    private Label Services, Name , CashLabel;
    @FXML
    private RadioButton GetOut, Lodge;

    public String restaurantkind;


    public void LoginRestaurants(ActionEvent e) throws IOException {
        Loader(e, "LoginRestaurants.fxml", stage, scene, 10, 10);
    }

    //////////////////////////////////////// *** User Profile *** ////////////////////////////////////////
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

    //////////////////////////////////////// *** Constructor *** ////////////////////////////////////////

    public Login1Controller() throws IOException {
        socket = new Socket("localhost", 12000);
        output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    }

    /////////////////////////////////////// *** Portal Prices *** ///////////////////////////////////////
    public void MellatPrice(MouseEvent event) throws IOException{
        if (!Price.getText().isEmpty()) {
            try {
                File priceFile = new File(PriceFile);
                PrintWriter writer = new PrintWriter(priceFile);
                writer.write(Price.getText());
                writer.close();
                MouseLoader(event, "MellatPortal.fxml", stage, scene);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    //////////////////////////////////////// *** Portal Prices *** ////////////////////////////////////////
    public void MelliPrice(MouseEvent event) throws IOException {
        if (!Price.getText().isEmpty()) {
            File cardMoneyFile = new File(CardMoney);
            Scanner cardMoneyScanner = new Scanner(cardMoneyFile);
            int cardMoney = 0;
            while (cardMoneyScanner.hasNextLine()) {
                String line = cardMoneyScanner.nextLine();
                String[] parts = line.split(" ");
                cardMoney = Integer.parseInt(String.valueOf(parts[0]));
            }
            if (cardMoney >= 100000)
                MouseLoader(event, "MelliPortal.fxml", stage, scene);
        }
    }

    public void SamanPrice(MouseEvent event) throws IOException {
        if (!Price.getText().isEmpty())
            MouseLoader(event, "SamanPortal.fxml", stage, scene);
    }

    public void Buy1(ActionEvent e) throws FileNotFoundException {
        File NameAndPrice1 = new File(FoodNameAndPrice1);
        Scanner scanner1 = new Scanner(NameAndPrice1);
        int foodPrice1 = 0;
        while (scanner1.hasNextLine()) {
            String line = scanner1.nextLine();
            String[] parts = line.split(" ");
            foodPrice1 = Integer.parseInt(parts[9]);
        }
        File cash = new File(Cash);
        Scanner cashScanner = new Scanner(cash);
        int cashLabel = 0;
        while (cashScanner.hasNextLine()) {
            String line = cashScanner.nextLine();
            String[] parts = line.split(" ");
            cashLabel = Integer.parseInt(parts[0]);
        }
        cashLabel -= foodPrice1;
//        File NameAndPrice1Writer = new File(FoodNameAndPrice1);
//        PrintWriter writer1 = new PrintWriter(NameAndPrice1Writer);
//        String sCash = String.valueOf(cashLabel);
//        writer1.write(sCash);
//        writer1.close();

        File cardMoneyWriter = new File(Cash);
        PrintWriter writer = new PrintWriter(cardMoneyWriter);
        String sCash = String.valueOf(cashLabel);
        writer.write(cashLabel);
        writer.close();
    }
    public void Buy2(ActionEvent e){

    }
    public void Buy3(ActionEvent e){

    }
    public void Buy4(ActionEvent e){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
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

        try {
            File filer= new File(FoodImages1);
            Scanner scanner1 = new Scanner(filer);
            String str = null;
            while (scanner1.hasNextLine()){
                String line = scanner1.nextLine();
                String[] parts = line.split(" ");
                str = parts [1];
            }
            Image image = new Image(str);
            FoodImage11.setImage(image);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            File filer= new File(FoodImages2);
            Scanner scanner1 = new Scanner(filer);
            String str = null;
            while (scanner1.hasNextLine()){
                String line = scanner1.nextLine();
                String[] parts = line.split(" ");
                str = parts [1];
            }
            Image image = new Image(str);
            FoodImage12.setImage(image);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            File filer= new File(FoodImages3);
            Scanner scanner1 = new Scanner(filer);
            String str = null;
            while (scanner1.hasNextLine()){
                String line = scanner1.nextLine();
                String[] parts = line.split(" ");
                str = parts [1];
            }
            Image image = new Image(str);
            FoodImage13.setImage(image);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            File filer= new File(FoodImages4);
            Scanner scanner1 = new Scanner(filer);
            String str = null;
            while (scanner1.hasNextLine()){
                String line = scanner1.nextLine();
                String[] parts = line.split(" ");
                str = parts [1];
            }
            Image image = new Image(str);
            FoodImage14.setImage(image);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
