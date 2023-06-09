package com.example.blinkfood;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Checker {
    @FXML
    public TextField amountpayable ;

    public TextField getAmountpayable() {
        return amountpayable;
    }

    //Create Account Check
    public boolean EmailChecker(String email) {
        return !email.isEmpty() ? true : false;
    }

    public static boolean PhoneNumberChecker(String phoneNumber) {
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
        return age > 18 ? true : false;
    }

    public boolean PasswordChecker(String password, String confirmPassword) {
        return password.equals(confirmPassword) ? true : false;
    }

    public boolean UsernameChecker(String username) {
        return !username.isEmpty() ? true : false;
    }

    /////////////////////////////////////////// kharab ////////////////////////////
    //Login Check
    public boolean LoginUsernameChecker(String loginUsername, String username) {
        return !loginUsername.isEmpty() && loginUsername.equals(username) ? true : false;
    }

    public boolean LoginPasswordChecker(String loginPassword, String password) {
        return !loginPassword.isEmpty() && loginPassword.equals(password) ? true : false;
    }

    //////////////////////////////////////////////////////////
    //Admin Check
    public boolean AdminUsernameChecker(String adminUsername) {
        return !adminUsername.isEmpty() && adminUsername.equals("85") ? true : false;
    }

    public boolean AdminPasswordChecker(String adminPassword) {
        return !adminPassword.isEmpty() && adminPassword.equals("85") ? true : false;
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
        return CardNum.length() == 16 ? true : false ;
    }
}
