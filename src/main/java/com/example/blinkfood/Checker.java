package com.example.blinkfood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Checker {

    public Stage stage;
    public Scene scene;

    ///////////////////////////////////////////////////////// *** Files *** ///////////////////////////////////////////////////////////
//    String CreateAccountFile = "C:\\Users\\Admin\\IdeaProjects\\BlinkFood\\BlinkFood\\src\\main\\resources\\com\\example\\Data\\Files\\CreateAccount.txt";
//    String AdminFile = "ReadMe.txt";

    String FoodNameAndPrice1 = "BlinkFood\\src\\Files\\FoodName&Price1.txt";
    String FoodNameAndPrice2 = "BlinkFood\\src\\Files\\FoodName&Price2.txt";
    String FoodNameAndPrice3 = "BlinkFood\\src\\Files\\FoodName&Price3.txt";
    String FoodNameAndPrice4 = "BlinkFood\\src\\Files\\FoodName&Price4.txt";

    String FoodImages1 = "BlinkFood\\src\\Files\\FoodImages1.txt" ;
    String FoodImages2 = "BlinkFood\\src\\Files\\FoodImages2.txt" ;
    String FoodImages3 = "BlinkFood\\src\\Files\\FoodImages3.txt" ;
    String FoodImages4 = "BlinkFood\\src\\Files\\FoodImages4.txt" ;
    String Cash = "src\\Files\\Cash.txt";
    String PriceFile = "src\\Files\\Price.txt";
    String CardMoney = "src\\Files\\CardMoney.txt";

    public static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static final int CAPTCHA_LENGTH = 6;
    public static final int PASSWORD_LENGTH = 8;
    @FXML
    public PasswordField CardPassword;
    @FXML
    public Label Captcha;
    @FXML
    public TextField Price;

    //////////////////////////////////////// *** Methods *** ////////////////////////////////////////
    Socket socket;
    Scanner scanner;
    DataInputStream input;
    DataOutputStream output;

    //////////////////////////////////////// *** Loaders *** ////////////////////////////////////////
    public void Loader(ActionEvent e, String address, Stage stage, Scene scene, int x, int y) throws IOException {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource(address)));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setX(x);
            stage.setY(y);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ev) {
            System.out.println(ev);
        }
    }

    public void MouseLoader(MouseEvent mouseevent, String address, Stage stage, Scene scene) throws IOException {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource(address)));
            stage = (Stage) ((Node) mouseevent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setX(10);
            stage.setY(10);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ev) {
            System.out.println(ev);
        }
    }

    //////////////////////////////////////// *** Buy Check *** ////////////////////////////////////////
    public boolean AccountChecker(String Cash, String Cost) {
        if (Integer.parseInt(Cash) >= Integer.parseInt(Cost))
            return true;
        return false;
    }

    public boolean CaptchaChecker(String Captcha, String Captchatxt) {
        return Captcha.equals(Captchatxt) ? true : false;
    }

    public boolean CVV2Checker(String CVV2) {
        return CVV2.length() >= 3 && !CVV2.equals(0) ? true : false;
    }

    public boolean CardPasswordChecker(String Cardpassword) {
        return Cardpassword.length() >= 8 ? true : false;
    }

    public boolean ExpirationChecker(String Month, String Year) {
        if (Month.length() == 2 && Year.length() == 2 && Integer.parseInt(Year) >= 2 && Integer.parseInt(Month) >= 1
                && Integer.parseInt(Month) <= 12)
            return true;
        return false;
    }

    public boolean CardnumChecker(String CardNum) {
        return CardNum.length() == 16 ? true : false;
    }


    public void RestaurantComponentLoader(String address, TextField t1, TextField t2, TextField t3, TextField t4, TextField t5,
                                          TextField t6, TextField t7, TextField t8, TextField t9, String s, int i1, int i2,
                                          int i3, TextField t10) throws IOException {
        try {
            //Load From Server
            String component = address;
            output.writeUTF("RestaurantComponent");
            output.flush();
            output.writeUTF("Load");
            output.flush();
            output.writeUTF(component);
            output.flush();

            t1.setText(input.readUTF());
            t2.setText(input.readUTF());
            t3.setText(input.readUTF());
            t4.setText(input.readUTF());
            t5.setText(input.readUTF());
            t6.setText(input.readUTF());
            t7.setText(input.readUTF());
            t8.setText(input.readUTF());
            t9.setText(input.readUTF());
            s = input.readUTF();
            i1 = Integer.parseInt(input.readUTF());
            i2 = Integer.parseInt(input.readUTF());
            i3 = Integer.parseInt(input.readUTF());
            t10.setText(input.readUTF());
//            Image image1 = new Image(foodImage11);
//            FoodImage11.setImage(image1);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void RestaurantComponentSaver(String address, TextField t1, TextField t2, TextField t3, TextField t4, TextField t5,
                                         TextField t6, TextField t7, TextField t8, TextField t9, String s, int i1, int i2,
                                         int i3, TextField t10) throws IOException {
        try {
            //Send To Server
            String component = address;
            output.writeUTF("RestaurantComponent");
            output.flush();
            output.writeUTF("Save");
            output.flush();
            output.writeUTF(component);
            output.flush();

            output.writeUTF(t1.getText());
            output.flush();
            output.writeUTF(t2.getText());
            output.flush();
            output.writeUTF(t3.getText());
            output.flush();
            output.writeUTF(t4.getText());
            output.flush();
            output.writeUTF(t5.getText());
            output.flush();
            output.writeUTF(t6.getText());
            output.flush();
            output.writeUTF(t7.getText());
            output.flush();
            output.writeUTF(t8.getText());
            output.flush();
            output.writeUTF(t9.getText());
            output.flush();
            output.writeUTF(s);
            output.flush();
            output.writeUTF(String.valueOf(i1));
            output.flush();
            output.writeUTF(String.valueOf(i2));
            output.flush();
            output.writeUTF(String.valueOf(i3));
            output.flush();
            output.writeUTF(t10.getText());
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Download Components From Server
//    protected void DownloadComponent(String Filename , Socket socket , FileOutputStream fileOutputStream){
//        try {
//            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
//            output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
//            output.writeUTF(Filename);
//            output.flush();
//            if (input.readUTF().equals("Start download.")) {
//                System.out.println("Downloading ...");
//                fileOutputStream = new FileOutputStream("C:\\Users\\Admin\\IdeaProjects\\BlinkFood\\BlinkFood\\src\\main\\resources\\com\\example\\Client\\Image\\" + Filename);
//                int bytes = 0;
//
//                long size = input.readLong();     // read file size
//                byte[] buffer = new byte[4 * 1024];
//                while (size > 0 && (bytes = input.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
//                    fileOutputStream.write(buffer, 0, bytes);
//                    size -= bytes;      // read upto file size
//                }
//                System.out.println( Filename + " Downloaded.");
//                fileOutputStream.close();
//            } else {
//                System.out.println("File Not Exist.");
//            }
//        }catch (Exception exception){
//            System.out.println(exception);
//        }
//    }
}