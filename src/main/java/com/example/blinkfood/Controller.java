package com.example.blinkfood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller extends Checker implements Initializable {

    //////////////////////////////////////// *** Variables *** ////////////////////////////////////////
    private Stage stage;
    private Scene scene;
    Socket socket;
    Scanner scanner;
    DataInputStream input;
    DataOutputStream output;
//    FileOutputStream AdminRestaurantsBackground;
//    FileOutputStream LoginRestaurantsBackground;
//    FileOutputStream LoginBackground;
//    FileOutputStream AdminBackground;
//    FileOutputStream CreateAccountBackground;

    ///////////////////////////////////////// *** Strings *** //////////////////////////////////////////
    String username;
    String email;
    String phoneNumber;
    int age;
    String password;
    String confirmPassword;
    String loginUsername;
    String loginPassword;
    String adminUsername;
    String adminPassword;

    //////////////////////////////////////// *** Tags *** ////////////////////////////////////////
    @FXML
    private PasswordField Password, ConfirmPassword, AdminPassword, LoginPassword;
    @FXML
    private Rectangle RectAnimation, RectAnimation2;
    @FXML
    private Label ErrorLabel, Name, CashLabel;
    @FXML
    private ImageView MellatLogo, SamanLogo, SepahLogo;

    //////////////////////////////////////// *** Buttons *** ////////////////////////////////////////
    @FXML
    private Button KookooSabzi, Kotlet, Omlet, Soosis,
            Bandari, Burger, Kentucky, SibZamini,
            Jigar, Joojeh, Kabab, Shishlik,
            Italian, Makhloot, Peperoni, Sabzijat,
            AshReshteh, Dizi, Kashk, Sholeh,
            Gheymeh, GhormehSabzi, Makaroni, Morgh;
    @FXML
    private Button Back, Charge;

    //////////////////////////////////////// *** Text Fields *** ////////////////////////////////////////
    @FXML
    private TextField Username, Email, PhoneNumber, Age;
    @FXML
    private TextField AdminUsername, LoginUsername;
    @FXML
    private TextField KookooSabziCost, KotletCost, OmletCost, SoosisCost,
            BandariCost, BurgerCost, KentuckyCost, SibZaminiCost,
            JigarCost, JoojehCost, KababCost, ShishlikCost,
            ItalianCost, MakhlootCost, PeperoniCost, SabzijatCost,
            AshReshtehCost, DiziCost, KashkCost, SholehCost,
            GheymehCost, GhormehSabziCost, MakaroniCost, MorghCost;

    public Controller() throws IOException {
        socket = new Socket("localhost", 12000);
        output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    }

    //////////////////////////////////////// *** Methods *** ////////////////////////////////////////

    //////////////////////////////////////// *** Pages *** ////////////////////////////////////////
    public void CreateAccount(ActionEvent e) throws IOException {
        Loader(e, "CreateAccount.fxml", stage, scene, 350, 70);
    }

    public void Login(ActionEvent e) throws IOException {
//        DownloadComponent("Login.png" , socket , LoginBackground);
        Loader(e, "Login.fxml", stage, scene, 350, 70);
    }

    public void Admin(ActionEvent e) throws IOException {
        Loader(e, "Admin.fxml", stage, scene, 350, 70);
    }

    public void LoginRestaurants(ActionEvent e) throws IOException {
        Loader(e, "LoginRestaurants.fxml", stage, scene, 260, 10);
    }

    public void AdminRestaurants(ActionEvent e) throws IOException {
        Loader(e, "AdminRestaurants.fxml", stage, scene, 260, 10);
    }

    //////////////////////////////////////// *** Login Restaurants Pages *** ////////////////////////////////////////
    public void LoginCafe(MouseEvent event) throws IOException {
        MouseLoader(event, "LoginCafe.fxml", stage, scene);
    }

    public void LoginFastFood(MouseEvent event) throws IOException {
        MouseLoader(event, "LoginFastFood.fxml", stage, scene);
    }

    public void LoginKababi(MouseEvent event) throws IOException {
        MouseLoader(event, "LoginKababi.fxml", stage, scene);
    }

    public void LoginPizza(MouseEvent event) throws IOException {
        MouseLoader(event, "LoginPizza.fxml", stage, scene);
    }

    public void LoginSonnati(MouseEvent event) throws IOException {
        MouseLoader(event, "LoginSonnati.fxml", stage, scene);
    }

    public void LoginZeytoon(MouseEvent event) throws IOException {
        MouseLoader(event, "LoginZeytoon.fxml", stage, scene);
    }

    //////////////////////////////////////// *** Admin Restaurants Pages *** ////////////////////////////////////////
    public void AdminCafe(MouseEvent event) throws IOException {
        MouseLoader(event, "AdminCafe.fxml", stage, scene);
    }

    public void AdminFastFood(MouseEvent event) throws IOException {
        MouseLoader(event, "AdminFastFood.fxml", stage, scene);
    }

    public void AdminPizza(MouseEvent event) throws IOException {
        MouseLoader(event, "AdminPizza.fxml", stage, scene);
    }

    public void AdminSonnati(MouseEvent event) throws IOException {
        MouseLoader(event, "AdminSonnati.fxml", stage, scene);
    }

    //////////////////////////////////////// *** Submits *** ////////////////////////////////////////
    public void CreateAccountSubmit(ActionEvent e) throws IOException {
        try {
            username = Username.getText();
            password = Password.getText();
            confirmPassword = ConfirmPassword.getText();
            email = Email.getText();
            phoneNumber = PhoneNumber.getText();
            age = Integer.parseInt(Age.getText());
            String checkcomponents = username + " " + password + " " + confirmPassword + " " + email + " " + phoneNumber + " " + age;
            //send to server
            output.writeUTF("CreateAccountSubmit");
            output.flush();
            output.writeUTF(checkcomponents);
            output.flush();

            switch (input.readUTF()) {
                case "Successfull" -> Loader(e, "Login.fxml", stage, scene, 350, 70);
                case "UsernameError" -> ErrorLabel.setText("*Plz enter a valid username");
                case "EmailError" -> ErrorLabel.setText("*Plz enter a valid Email");
                case "PhonenumberError" -> ErrorLabel.setText("*Plz enter valid Phone Number");
                case "AgeError" -> ErrorLabel.setText("*Only +18 can SignUp");
                case "ConfirmpassError" -> ErrorLabel.setText("*ConfirmPass doesn't match Password");
            }
        } catch (Exception ev) {
            ErrorLabel.setText("*Plz Enter a Valid Input*");
        }
    }

    public void LoginSubmit(ActionEvent e) throws IOException {
        try {
            loginUsername = LoginUsername.getText();
            loginPassword = LoginPassword.getText();
            //Send To Server
//            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
//            output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            output.writeUTF("LoginSubmit");
            output.flush();
            output.writeUTF(loginUsername + " " + loginPassword);
            output.flush();
            switch (input.readUTF()) {
                case "Successfull" -> Loader(e, "LoginRestaurants.fxml", stage, scene, 260, 10);
                case "Error" -> ErrorLabel.setText("*Plz Enter Valid Username or Password");
            }
        } catch (Exception ev) {
            ErrorLabel.setText("*Plz Enter a Valid Input*");
        }
    }

    public void AdminSubmit(ActionEvent e) throws IOException {
        try {
            adminUsername = AdminUsername.getText();
            adminPassword = AdminPassword.getText();
            String admincomponents = adminUsername + " " + adminPassword;
            //Send To Server
            output.writeUTF("AdminSubmit");
            output.flush();
            output.writeUTF(admincomponents);
            output.flush();
            switch (input.readUTF()) {
                case "Successfull" -> Loader(e, "AdminRestaurants.fxml", stage, scene, 260, 10);
                case "Error" -> ErrorLabel.setText("*Plz Enter Valid Username Or Password");
            }
        } catch (Exception ev) {
            ErrorLabel.setText("*Plz Enter a Valid Input*");
        }
    }

    //////////////////////////////////////// *** Handle Buttons *** ////////////////////////////////////////
//    public void CafeHandleButton(ActionEvent event) throws IOException {
//        Button clickedButton = (Button) event.getSource();
//        String buttonId = clickedButton.getId();
//        try {
//            BuyHandler(buttonId, KookooSabziCost, CashLabel);
//            BuyHandler(buttonId, KotletCost, CashLabel);
//            BuyHandler(buttonId, OmletCost, CashLabel);
//            BuyHandler(buttonId, SoosisCost, CashLabel);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public void FastFoodHandleButton(ActionEvent event) throws IOException {
//        Button clickedButton = (Button) event.getSource();
//        String buttonId = clickedButton.getId();
//        try {
//            BuyHandler(buttonId, BandariCost, CashLabel);
//            BuyHandler(buttonId, BurgerCost, CashLabel);
//            BuyHandler(buttonId, KentuckyCost, CashLabel);
//            BuyHandler(buttonId, SibZaminiCost, CashLabel);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public void KababiHandleButton(ActionEvent event) throws IOException {
//        Button clickedButton = (Button) event.getSource();
//        String buttonId = clickedButton.getId();
//        try {
//            BuyHandler(buttonId, JigarCost, CashLabel);
//            BuyHandler(buttonId, JoojehCost, CashLabel);
//            BuyHandler(buttonId, KababCost, CashLabel);
//            BuyHandler(buttonId, ShishlikCost, CashLabel);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public void PizzaHandleButton(ActionEvent event) throws IOException {
//        Button clickedButton = (Button) event.getSource();
//        String buttonId = clickedButton.getId();
//        try {
//            BuyHandler(buttonId, ItalianCost, CashLabel);
//            BuyHandler(buttonId, MakhlootCost, CashLabel);
//            BuyHandler(buttonId, PeperoniCost, CashLabel);
//            BuyHandler(buttonId, SabzijatCost, CashLabel);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public void SonnatiHandleButton(ActionEvent event) throws IOException {
//        Button clickedButton = (Button) event.getSource();
//        String buttonId = clickedButton.getId();
//        try {
//            BuyHandler(buttonId, AshReshtehCost, CashLabel);
//            BuyHandler(buttonId, DiziCost, CashLabel);
//            BuyHandler(buttonId, KashkCost, CashLabel);
//            BuyHandler(buttonId, SholehCost, CashLabel);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public void ZeytoonHandleButton(ActionEvent event) throws IOException {
//        Button clickedButton = (Button) event.getSource();
//        String buttonId = clickedButton.getId();
//        try {
//            BuyHandler(buttonId, GheymehCost, CashLabel);
//            BuyHandler(buttonId, GhormehSabziCost, CashLabel);
//            BuyHandler(buttonId, MakaroniCost, CashLabel);
//            BuyHandler(buttonId, MorghCost, CashLabel);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

    ////////////////////////////////////////Portal Prices

    public void MellatPrice(MouseEvent event) throws IOException {
        MouseLoader(event, "MellatPortal.fxml", stage, scene);
    }

    public void SamanPrice(MouseEvent event) throws IOException {
        MouseLoader(event, "SamanPortal.fxml", stage, scene);
    }

    public void SepahPrice(MouseEvent event) throws IOException {
        MouseLoader(event, "SepahPortal.fxml", stage, scene);
    }

    ////////////////////////////////////////User Profile
    public void UserDetails() {
        RectAnimation.setLayoutX(0);
        Name.setLayoutX(20);
        Back.setLayoutX(20);
        Charge.setLayoutX(230);
        CashLabel.setLayoutX(230);
    }

    public void Backto() {
        RectAnimation.setLayoutX(-440);
        Name.setLayoutX(-420);
        Back.setLayoutX(-420);
        Charge.setLayoutX(-210);
        CashLabel.setLayoutX(-210);
        RectAnimation2.setLayoutX(-440);
        MellatLogo.setLayoutX(-420);
        SamanLogo.setLayoutX(-280);
        SepahLogo.setLayoutX(-140);
    }

    public void Portals() {
        RectAnimation2.setLayoutX(530);
        MellatLogo.setLayoutX(550);
        SamanLogo.setLayoutX(690);
        SepahLogo.setLayoutX(830);
    }

    ////////////////////////////////////////Buy
    private void Buy(TextField Food, Label CashLabel) {
        long remain;
        if (AccountChecker(CashLabel.getText(), Food.getText())) {
            remain = Integer.parseInt(CashLabel.getText()) - Integer.parseInt(Food.getText());
            CashLabel.setText(String.valueOf(remain));
        } else {
            Alert accountalert = new Alert(Alert.AlertType.ERROR);
            accountalert.setTitle("Account Error !");
            accountalert.setHeaderText("Not Enough Cash to Buy");
            accountalert.setContentText("Please Charge Your Account");
            if (accountalert.showAndWait().get() == ButtonType.OK)
                accountalert.close();
        }
    }

    private void BuyHandler(String buttonId, TextField Food, Label CashLabel) {
        if (Objects.equals(buttonId.concat("Cost"), Food.getId()))
            Buy(Food, CashLabel);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        DownloadComponent("Login.png" , socket , LoginBackground);
//        DownloadComponent("Admin.png" , socket , AdminBackground);
//        DownloadComponent("CreateAccount.png" , socket , CreateAccountBackground);
    }
}