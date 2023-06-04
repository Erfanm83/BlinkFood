package com.example.blinkfood;

public class Checker {
    //Create Account Check
    public boolean EmailChecker(String email) {
        if (!email.isEmpty())
            return true;
        return false;
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
        if (age > 18)
            return true;
        return false;
    }

    public boolean PasswordChecker(String password, String confirmPassword) {
        if (password.equals(confirmPassword))
            return true;
        return false;
    }

    public boolean UsernameChecker(String username) {
        if (!username.isEmpty())
            return true;
        return false;
    }
    /////////////////////////////////////////// kharab ////////////////////////////
    //Login Check
    public boolean LoginUsernameChecker(String loginUsername, String username) {
        if (!loginUsername.isEmpty() && loginUsername.equals(username))
            return true;
        return false;
    }

    public boolean LoginPasswordChecker(String loginPassword, String password) {
        if (!loginPassword.isEmpty() && loginPassword.equals(password))
            return true;
        return false;
    }
    //////////////////////////////////////////////////////////

    //Admin Check
    public boolean AdminUsernameChecker(String adminUsername) {
        if (!adminUsername.isEmpty() && adminUsername.equals("85"))
            return true;
        return false;
    }

    public boolean AdminPasswordChecker(String adminPassword) {
        if (!adminPassword.isEmpty() && adminPassword.equals("85"))
            return true;
        return false;
    }
}
