package com.example.blinkfood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
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
            Login(e);
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
            Restaurants(e);
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
        if (AdminUsernameChecker(adminUsername) && AdminPasswordChecker(adminPassword))
            Restaurants(e);
    }

    public void CreateAccount(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreateAccount.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setX(350);
        stage.setY(70);
        stage.setScene(scene);
        stage.show();
    }

    public void Login(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setX(350);
        stage.setY(70);
        stage.setScene(scene);
        stage.show();
    }

    public void Admin(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setX(350);
        stage.setY(70);
        stage.setScene(scene);
        stage.show();
    }

    public void Restaurants(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Restaurants.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setX(10);
        stage.setY(10);
        stage.setScene(scene);
        stage.show();
    }
    public void Sandwich(ActionEvent e){

    }
    public void Sonnati(ActionEvent e){

    }
    public void Pizza(ActionEvent e){

    }
    public void Fastfood(ActionEvent e){

    }
    public void Akbarjuje(ActionEvent e){

    }
    public void Cafe(ActionEvent e){

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