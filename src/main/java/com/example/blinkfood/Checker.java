package com.example.blinkfood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Checker {
    ///////////////////////////////////////
    @FXML
    public TextField amountpayable = null;
//    public TextField getAmountpayable() {
//        return amountpayable;
//    }
    //////////////////////////////////////

    ////////////////////////////////////////Files
    String CreateAccountFile = "D:\\Codes\\Java\\Blink Food\\src\\main\\java\\com\\example\\Files\\CreateAccount.txt";
    String AdminFile = "D:\\Codes\\Java\\Blink Food\\ReadMe.txt";


    ////////////////////////////////////////Methods////////////////////////////////////////

    ////////////////////////////////////////Loaders
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

    ////////////////////////////////////////Create Account Check
    public boolean UsernameChecker(String username) {
        return !username.isEmpty() ? true : false;
    }

    public boolean EmailChecker(String email) {
        return !email.isEmpty() ? true : false;
    }

    public boolean PhoneNumberChecker(String phoneNumber) {
        if (phoneNumber.length() != 11) {
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean AgeChecker(int age) {
        return age >= 18 ? true : false;
    }

    public boolean PasswordChecker(String password, String confirmPassword) {
        return password.equals(confirmPassword) ? true : false;
    }

    ////////////////////////////////////////Admin & Login Check
    public boolean LoginChecker(String loginUsername, String loginPassword) {
        try {
            File LoginChecker = new File(CreateAccountFile);
            Scanner scanner = new Scanner(LoginChecker);
            String user = null;
            String pass = null;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                user = parts[1];
                pass = parts[3];
            }
            if (loginUsername.equals(user) && loginPassword.equals(pass))
                return true;
            return false;
        } catch (FileNotFoundException exception) {
            System.out.println("File not found: ");
            return false;
        }
    }

    public boolean AdminChecker(String adminUsername, String adminPassword) {
        try {
            File AdminChecker = new File(AdminFile);
            Scanner scanner = new Scanner(AdminChecker);
            String user = null;
            String pass = null;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                user = parts[1];
                pass = parts[3];
            }
            if (adminUsername.equals(user) && adminPassword.equals(pass))
                return true;
            return false;
        } catch (FileNotFoundException exception) {
            System.out.println("File not found: ");
            return false;
        }
    }

    ////////////////////////////////////////Buy Check
    public boolean AccountChecker(String Cash, String Cost) {
        if (Integer.parseInt(Cash) >= Integer.parseInt(Cost))
            return true;
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////

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
}