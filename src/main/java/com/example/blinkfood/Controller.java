package com.example.blinkfood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Controller extends Checker {
    private Stage stage;
    private Scene scene;
    /////////////////////////////////////////////////////// Identification garbages
    @FXML
    private Label ErrorLabel;
    @FXML
    private TextField Username;
    @FXML
    private TextField Email;
    @FXML
    private TextField PhoneNumber;
    @FXML
    private TextField Age;
    @FXML
    private PasswordField Password;
    @FXML
    private PasswordField ConfirmPassword;
    @FXML
    private TextField AdminUsername;
    @FXML
    private PasswordField AdminPassword;
    @FXML
    private TextField LoginUsername;
    @FXML
    private PasswordField LoginPassword;
    @FXML
    private Rectangle RectAnimation;
    @FXML
    private Label Name;
    @FXML
    private Label Cash;
    @FXML
    private Button Charge;
    @FXML
    private Button Back;
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
    //    ///////////////////////////////// logout garbages
//    @FXML
//    private AnchorPane scenePane;
//    @FXML
//    private Button ButtonlogoutButton;
//    //////////////////////////////////////////////
//    @FXML
//    public void Submit(ActionEvent e) {
//        //Submit should implements as well
//        //dakhel restuarnt
//    }
    public void CreateAccountSubmit(ActionEvent e) throws IOException {
        try {
            username = Username.getText();
            email = Email.getText();
            phoneNumber = PhoneNumber.getText();
            password = Password.getText();
            confirmPassword = ConfirmPassword.getText();
            age = Integer.parseInt(Age.getText());
            if (!AgeChecker(age))
                ErrorLabel.setText("*You Should Be +18 to sign up");
            if (!PasswordChecker(password, confirmPassword))
                ErrorLabel.setText("*ConfirmPass doesn't match Password");
            if (!EmailChecker(email))
                ErrorLabel.setText("*Unvalid Email");
            if (!PhoneNumberChecker(phoneNumber))
                ErrorLabel.setText("*Plz Enter Valid Phonenumber");
        } catch (Exception ev) {
            ErrorLabel.setText("*Plz Enter Valid Input");
        }
        if (UsernameChecker(username) && EmailChecker(email) && PhoneNumberChecker(phoneNumber)
                && AgeChecker(age) && PasswordChecker(password, confirmPassword))
            loader(e , "Login.fxml", stage , scene);
    }

    public void LoginSubmit(ActionEvent e) throws IOException {
        try {
            loginUsername = LoginUsername.getText();
            loginPassword = LoginPassword.getText();
            if (!LoginUsernameChecker(loginUsername, username))
                ErrorLabel.setText("*Plz enter a valid username");
            if (!LoginPasswordChecker(loginPassword, password))
                ErrorLabel.setText("*Plz enter a valid password");
        } catch (Exception ev) {
            ErrorLabel.setText("*Plz Enter Valid Input");
        }
        if (LoginUsernameChecker(loginUsername, username) && LoginPasswordChecker(loginPassword, password))
            loader(e , "Login.fxml" , stage , scene);
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
            loader(e ,"Restaurants.fxml", stage , scene);
        }
    }

    public void CreateAccount(ActionEvent e) throws IOException {
        loader(e , "CreateAccount.fxml" , stage , scene);
    }

    public void Login(ActionEvent e) throws IOException {
        loader(e , "Login.fxml" , stage , scene);
    }

    public void Admin(ActionEvent e) throws IOException {
        loader(e , "Admin.fxml" , stage , scene);
    }
    public void Restaurants(ActionEvent e) throws IOException {
        loader(e , "Restaurants.fxml" , stage , scene);
    }
    public void loader(ActionEvent e, String address , Stage stage , Scene scene) throws IOException {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource(address)));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setX(10);
            stage.setY(10);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception ev){
            System.out.println(ev);
        }
    }
    public void mouseloader(MouseEvent mouseevent, String address , Stage stage , Scene scene) throws IOException {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource(address)));
            stage = (Stage) ((Node) mouseevent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setX(10);
            stage.setY(10);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception ev){
            System.out.println(ev);
        }
    }
    public void Sonnati(MouseEvent event) throws IOException {
        mouseloader(event , "Sonnati.fxml" , stage , scene);
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
    public void UserDetails(){
        RectAnimation.setX(0);
        Name.setLayoutX(5);
        Back.setLayoutX(5);
        Charge.setLayoutX(230);
        CashLabel.setLayoutX(230);
    }
    public void Backto(){
        RectAnimation.setX(-440);
        Name.setLayoutX(-420);
        Charge.setLayoutX(-220);
        Back.setLayoutX(-420);
        CashLabel.setLayoutX(-420);
    }
    public void ChargeAccount(ActionEvent e){
        System.out.println("Charge konam Barat ?");  ///چرت
        ///Safhe Dargah
    }
    //تابع خرید کردم و محسابه باقیمانده
    private void Buy(TextField Juje , Label CashLabel){
        long remain;
        if (AccountChecker(CashLabel.getText() , Juje.getText())) {
            remain = Integer.parseInt(CashLabel.getText()) - Integer.parseInt(Juje.getText());
            CashLabel.setText(String.valueOf(remain));
            System.out.println("Kharidammmm"); //// چرت
        }
        else {
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
    @FXML
    public void handleButtonClick(ActionEvent event) throws IOException{
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();
        System.out.println(buttonId + " Mikhay Bekhari ?");   // // چرت
        try {
            BuyHandler(buttonId , JujeCost , CashLabel);
            BuyHandler(buttonId , BargCost , CashLabel);
            BuyHandler(buttonId , SoltaniCost , CashLabel);
            BuyHandler(buttonId , BakhtiyariCost , CashLabel);
        }
        catch (Exception e){
            System.out.println(e);   /// اگه ارور داد چاپ کن
        }
    }
    // چک میکنه ببینه حسابت موجودی داره که خرید کنی یا نه
    private Boolean AccountChecker(String Cash , String Cost) {
        if (Integer.parseInt(Cash) >= Integer.parseInt(Cost))
            return true;
        return false;
    }
    private void BuyHandler(String buttonId , TextField Food , Label CashLabel){
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