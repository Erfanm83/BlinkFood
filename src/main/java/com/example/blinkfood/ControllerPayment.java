package com.example.blinkfood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class ControllerPayment extends Checker{
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int CAPTCHA_LENGTH = 6;
    private static final int PASSWORD_LENGTH = 8;
    @FXML
    private TextField txtcaptchavinput , Cardnumber , Email;
    @FXML
    private PasswordField CVV2 , CardPassword , ExpirationMonth ,ExpirationYear;
    @FXML
    private Label txtCaptcha;
    @FXML
    public Button PooyaPassword;
    public void captcha(MouseEvent event) throws Exception {
        try {
            String captchaText = generateCaptchaText();
            txtCaptcha.setText(captchaText);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    private String generateCaptchaText() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(CAPTCHA_LENGTH);
        for (int i = 0; i < CAPTCHA_LENGTH; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
    //Submit Payment
    public void PaymentSubmit (ActionEvent e) throws IOException {
        try {
            //Successfully Done
            if ( EmailChecker(Email.getText()) && CardPasswordChecker(CardPassword.getText()) &&
                    CaptchaChecker(txtCaptcha.getText() , txtcaptchavinput.getText()) &&
                    ExpirationChecker(ExpirationMonth.getText() , ExpirationYear.getText()) &&
            CVV2Checker(CVV2.getText())){
                // Successfull Message
                Alert Successfullalert = new Alert(Alert.AlertType.INFORMATION);
                Successfullalert.setTitle("Payment Successfully Done !");
                Successfullalert.setHeaderText("Thanks For Payment !");
                Successfullalert.setContentText("You Now Redirected to Restaurants Panel...");
                if (Successfullalert.showAndWait().get() == ButtonType.OK)
                    Successfullalert.close();
                // Redirectiong To Restaurants Panel
                Parent root = FXMLLoader.load(Objects.requireNonNull(ControllerPayment.class.getResource("Restaurants.fxml")));
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setX(10);
                stage.setY(10);
                stage.setScene(scene);
                stage.show();
            }
            //Failed
            else {
                Alert Paymentalert = new Alert(Alert.AlertType.ERROR);
                Paymentalert.setTitle("Payment Error !");
                Paymentalert.setHeaderText("Not Valid Input");
                Paymentalert.setContentText("Please enter Valid Input");
                if (Paymentalert.showAndWait().get() == ButtonType.OK) {
                    Paymentalert.close();
                }
            }
        }
        catch (Exception exception){
            System.out.println(exception);
        }
    }
    //Cancel Payment
    public void PaymentCancel(ActionEvent e) throws IOException {
        try {
            // Cancel Message
            Alert Successfullalert = new Alert(Alert.AlertType.INFORMATION);
            Successfullalert.setTitle("Cancel Payment");
            Successfullalert.setHeaderText("Payment Process Canceled !");
            Successfullalert.setContentText("You Now Redirected to Restaurants Panel...");
            if (Successfullalert.showAndWait().get() == ButtonType.OK)
                Successfullalert.close();
            // Redirectiong To Restaurants Panel
            Parent root = FXMLLoader.load(Objects.requireNonNull(ControllerPayment.class.getResource("Restaurants.fxml")));
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setX(10);
            stage.setY(10);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
    public String Passwordgenerator(ActionEvent event){
        Random random = new Random(10);
        StringBuilder sb = new StringBuilder(PASSWORD_LENGTH);
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            sb.append(random);
        }
        return sb.toString();
    }
    public void password(ActionEvent event) throws Exception {
        try {
            CardPassword.setText(Passwordgenerator(event));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
