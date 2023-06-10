package com.example.blinkfood;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class Controller extends Checker{
    private Stage stage;
    private Scene scene;
    /////////////////////////////////////////////////////// Identification garbages
    @FXML
    private TextField Username, Email, PhoneNumber, Age, AdminUsername, LoginUsername, JujeCost, BargCost, SoltaniCost, BakhtiyariCost, NotellaCost, SushiCost, PeperoniCost, PastaCost,
            ShinselCost, MorghCost, GharchCost, KentakiCost, SibZaminiCost, RoastBeafCost, MakhlutCost, FalafelCost,
            HamburgerCost, DoubleburgerCost, KhurakCost, GushtoGharchCost,
            AbgushtCost, DizimessiCost, DiziahaniCost, DizisangiCost;
    @FXML
    private PasswordField Password, ConfirmPassword, AdminPassword, LoginPassword;
    @FXML
    private Rectangle RectAnimation;
    @FXML
    private Label Name, CashLabel, ErrorLabel;
    @FXML
    private Button Charge, Juje, Barg, Soltani, Bakhtiyari, Sushi, Pasta, Notella, Shinsel, Morgh, Gharch, Kentaki, SibZamini, RoastBeaf,
            Peperoni, GushtoGharch, Makhlut, Falafel, Hamburger, Doubleburger, Khurak, Abgusht, Dizimessi, Diziahani, Dizisangi, Back;

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

    Customer customer = new Customer(phoneNumber, username, password, email, age);
//    Applicant costomer = new Applicant(phoneNumber , username, password , confirmPassword , email , age) {};
        ///////////////////////////////// logout garbages
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Button ButtonlogoutButton;
    //////////////////////////////////////////////
    @FXML
    public void Submit(ActionEvent e) {
        //Submit should implements as well
        //dakhel restuarnt
    }
    public void CreateAccountSubmit(ActionEvent e) throws IOException {
//        Customer customer = new Customer(phoneNumber, username, password, email, age);
        try {
            username = Username.getText();
            email = Email.getText();
            phoneNumber = PhoneNumber.getText();
            password = Password.getText();
            confirmPassword = ConfirmPassword.getText();
            age = Integer.parseInt(Age.getText());
            customer.setUsername(username);
            customer.setAge(age);
            customer.setEmail(email);
            customer.setPassword(password);
            customer.setConfirmpassword(confirmPassword);
            customer.setPhoneNumber(phoneNumber);
            System.out.println("customer username : " + customer.getUsername());
            System.out.println("customer password : " + customer.getPassword());
//            costumer = new Applicant(phoneNumber , username , password , confirmPassword ,email ,age);
            if (!AgeChecker(customer.getAge()))
                ErrorLabel.setText("*You Should Be +18 to sign up");
            if (!PasswordChecker(customer.getPassword(), customer.getConfirmpassword()))
                ErrorLabel.setText("*ConfirmPass doesn't match Password");
            if (!EmailChecker(customer.getEmail()))
                ErrorLabel.setText("*Unvalid Email");
            if (!PhoneNumberChecker(customer.getPhoneNumber()))
                ErrorLabel.setText("*Plz Enter Valid Phonenumber");
        } catch (Exception ev) {
            ErrorLabel.setText("*Plz Enter Valid Input");
        }
        if (UsernameChecker(customer.getUsername()) && EmailChecker(customer.getEmail()) && PhoneNumberChecker(customer.getPhoneNumber())
                && AgeChecker(customer.getAge()) && PasswordChecker(customer.getPassword(), customer.getConfirmpassword()))
            loader(e, "Login.fxml", stage, scene);
    }
    public void LoginSubmit(ActionEvent e) throws IOException {
        try {
            loginUsername = LoginUsername.getText();
            loginPassword = LoginPassword.getText();
            if (!LoginUsernameChecker(loginUsername, customer.getUsername()))
                ErrorLabel.setText("*Plz enter a valid username");
            if (!LoginPasswordChecker(loginPassword, customer.getPassword()) ) {
                ErrorLabel.setText("*Plz enter a valid password");
                System.out.println("customer password tu login : " + customer.getPassword());
                System.out.println("customer username tu login : " + customer.getUsername());
            }
        } catch (Exception ev) {
            ErrorLabel.setText("*Plz Enter Valid Input");
        }
        if (LoginUsernameChecker(loginUsername , customer.getUsername()) && LoginPasswordChecker(loginPassword, customer.getPassword()))
            loader(e, "Login.fxml", stage, scene);
    }

    public void AdminSubmit(ActionEvent e) throws IOException {
        try {
            adminUsername = AdminUsername.getText();
            adminPassword = AdminPassword.getText();
            if (!AdminUsernameChecker(adminUsername)) {
                ErrorLabel.setText("*Plz Enter a Valid Username");
            }
            if (!AdminPasswordChecker(adminPassword)) {
                ErrorLabel.setText("*Plz Enter a Valid Password");
            }
        } catch (Exception ev) {
            ErrorLabel.setText("*Plz Enter a Valid Input");
        }
        if (AdminUsernameChecker(adminUsername) && AdminPasswordChecker(adminPassword)) {
            loader(e, "Restaurants.fxml", stage, scene);
        }
    }

    public void CreateAccount(ActionEvent e) throws IOException {
        loader(e, "CreateAccount.fxml", stage, scene);
    }

    public void Login(ActionEvent e) throws IOException {
        loader(e, "Login.fxml", stage, scene);
    }

    public void Admin(ActionEvent e) throws IOException {
        loader(e, "Admin.fxml", stage, scene);
    }

    public void Restaurants(ActionEvent e) throws IOException {
        loader(e, "Restaurants.fxml", stage, scene);
    }

    public void loader(ActionEvent e, String address, Stage stage, Scene scene) throws IOException {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource(address)));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setX(10);
            stage.setY(10);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ev) {
            System.out.println(ev);
        }
    }

    public void mouseloader(MouseEvent mouseevent, String address, Stage stage, Scene scene) throws IOException {
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

    public void Sonnati(MouseEvent event) throws IOException {
        mouseloader(event, "Sonnati.fxml", stage, scene);
    }

    public void Pizza(MouseEvent event) throws IOException {
        mouseloader(event, "Pizza.fxml", stage, scene);
    }

    public void Fastfood(MouseEvent event) throws IOException {
        mouseloader(event, "Fastfood.fxml", stage, scene);
    }

    public void Sandwich(MouseEvent event) throws IOException {
        mouseloader(event, "Sandwich.fxml", stage, scene);
    }

    public void Cafe(MouseEvent event) throws IOException {
        mouseloader(event, "Cafe.fxml", stage, scene);
    }

    public void Akbarjuje(MouseEvent event) throws IOException {
        mouseloader(event, "Akbarjuje.fxml", stage, scene);
    }

    public void UserDetails() {
        RectAnimation.setX(0);
        Name.setLayoutX(5);
        Back.setLayoutX(5);
        Charge.setLayoutX(230);
        CashLabel.setLayoutX(230);
    }

    public void Backto() {
        RectAnimation.setX(-440);
        Name.setLayoutX(-420);
        Charge.setLayoutX(-220);
        Back.setLayoutX(-420);
        CashLabel.setLayoutX(-420);
    }

    public void ChargeAccount(ActionEvent e) throws IOException {
        //Directiong to Bank Portal
        Parent root = FXMLLoader.load(Objects.requireNonNull(ControllerPayment.class.getResource("bankPortal.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setX(10);
        stage.setY(10);
        stage.setScene(scene);
        stage.show();
        //Amount of Money That is Payable
    }

    //تابع خرید کردم و محسابه باقیمانده
    private void Buy(TextField Food, Label CashLabel) {
        long remain;
        if (AccountChecker(CashLabel.getText(), Food.getText())) {
            remain = Integer.parseInt(CashLabel.getText()) - Integer.parseInt(Food.getText());
            CashLabel.setText(String.valueOf(remain));
            System.out.println("Kharidammmm"); //// چرت
        } else {
            Alert accountalert = new Alert(Alert.AlertType.ERROR);
            accountalert.setTitle("Account Error !");
            accountalert.setHeaderText("Not Enough Cash to Buy");
            accountalert.setContentText("Pease Charge Your Account");
            if (accountalert.showAndWait().get() == ButtonType.OK) {
                accountalert.close();
            }
        }
    }

    //چک میکنه که داری کدوم غذا رو خرید میکنی
//    @FXML
//    public void handleButtonClick(ActionEvent event) throws IOException {
//        Button clickedButton = (Button) event.getSource();
//        String buttonId = clickedButton.getId();
//        System.out.println(buttonId + " Mikhay Bekhari ?");   // // چرت
//        try {
//            BuyHandler(buttonId, JujeCost, CashLabel);
//            BuyHandler(buttonId, BargCost, CashLabel);
//            BuyHandler(buttonId, SoltaniCost, CashLabel);
//            BuyHandler(buttonId, BakhtiyariCost, CashLabel);
//        } catch (Exception e) {
//            System.out.println(e);   /// اگه ارور داد چاپ کن
//        }
//    }
    @FXML
    public void AkbarJujehandlebutton(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();
        System.out.println(buttonId + " Mikhay Bekhari ?");   // // چرت
        try {
            BuyHandler(buttonId, JujeCost, CashLabel);
            BuyHandler(buttonId, BargCost, CashLabel);
            BuyHandler(buttonId, SoltaniCost, CashLabel);
            BuyHandler(buttonId, BakhtiyariCost, CashLabel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void Cafehandlebutton(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();
        System.out.println(buttonId + " Mikhay Bekhari ?");   // // چرت
        try {
            BuyHandler(buttonId, SushiCost, CashLabel);
            BuyHandler(buttonId, ShinselCost, CashLabel);
            BuyHandler(buttonId, NotellaCost, CashLabel);
            BuyHandler(buttonId, PastaCost, CashLabel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void Fastfoodhandlebutton(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();
        System.out.println(buttonId + " Mikhay Bekhari ?");   // // چرت
        try {
            BuyHandler(buttonId, MorghCost, CashLabel);
            BuyHandler(buttonId, GharchCost, CashLabel);
            BuyHandler(buttonId, SibZaminiCost, CashLabel);
            BuyHandler(buttonId, KentakiCost, CashLabel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void Pizzahandlebutton(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();
        System.out.println(buttonId + " Mikhay Bekhari ?");   // // چرت
        try {
            BuyHandler(buttonId, MakhlutCost, CashLabel);
            BuyHandler(buttonId, PeperoniCost, CashLabel);
            BuyHandler(buttonId, GushtoGharchCost, CashLabel);
            BuyHandler(buttonId, RoastBeafCost, CashLabel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void Sandwichhandlebutton(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();
        System.out.println(buttonId + " Mikhay Bekhari ?");   // // چرت
        try {
            BuyHandler(buttonId, HamburgerCost, CashLabel);
            BuyHandler(buttonId, KhurakCost, CashLabel);
            BuyHandler(buttonId, DoubleburgerCost, CashLabel);
            BuyHandler(buttonId, FalafelCost, CashLabel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void Sonnatihandlebutton(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();
        System.out.println(buttonId + " Mikhay Bekhari ?");   // // چرت
        try {
            BuyHandler(buttonId, DiziahaniCost, CashLabel);
            BuyHandler(buttonId, DizimessiCost, CashLabel);
            BuyHandler(buttonId, DizisangiCost, CashLabel);
            BuyHandler(buttonId, AbgushtCost, CashLabel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // چک میکنه ببینه حسابت موجودی داره که خرید کنی یا نه
    private Boolean AccountChecker(String Cash, String Cost) {
        if (Integer.parseInt(Cash) >= Integer.parseInt(Cost))
            return true;
        return false;
    }

    private void BuyHandler(String buttonId, TextField Food, Label CashLabel) {
        if (Objects.equals(buttonId.concat("Cost"), Food.getId()))
            Buy(Food, CashLabel);
    }
    //The Logout
//    public void logout(ActionEvent event) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Logout");
//        alert.setHeaderText("You 're about to logout");
//        alert.setContentText("Do you want to save before exiting ?:");
//
//        if (alert.showAndWait().get() == ButtonType.OK) {
//            stage = (Stage) scenePane.getScene().getWindow();
//            stage.close();
//        }
//    }

}