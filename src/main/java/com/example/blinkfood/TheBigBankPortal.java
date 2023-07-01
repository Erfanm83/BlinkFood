package com.example.blinkfood;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public abstract class TheBigBankPortal {

    private TextField CardNumber;
    private TextField Email;
    private TextField Captcha;
    private PasswordField CVV2;
    private PasswordField Month;
    private PasswordField Year;
    private PasswordField InternetPassword;
    public double Wage;

    private long AmountPayable;

    public TheBigBankPortal(TextField cardNumber, TextField email, TextField captcha, PasswordField CVV2, PasswordField month, PasswordField year, PasswordField internetPassword) {
        CardNumber = cardNumber;
        Email = email;
        Captcha = captcha;
        this.CVV2 = CVV2;
        Month = month;
        Year = year;
        InternetPassword = internetPassword;
    }

    public TheBigBankPortal(long amountPayable) {
        AmountPayable = amountPayable;
    }

    public TheBigBankPortal(double wage) {
        this.Wage = wage;
    }

    public TextField getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(TextField cardNumber) {
        CardNumber = cardNumber;
    }

    public TextField getEmail() {
        return Email;
    }

    public void setEmail(TextField email) {
        Email = email;
    }

    public TextField getCaptcha() {
        return Captcha;
    }

    public void setCaptcha(TextField captcha) {
        Captcha = captcha;
    }

    public PasswordField getCVV2() {
        return CVV2;
    }

    public void setCVV2(PasswordField CVV2) {
        this.CVV2 = CVV2;
    }

    public PasswordField getMonth() {
        return Month;
    }

    public void setMonth(PasswordField month) {
        Month = month;
    }

    public PasswordField getYear() {
        return Year;
    }

    public void setYear(PasswordField year) {
        Year = year;
    }

    public PasswordField getInternetPassword() {
        return InternetPassword;
    }

    public void setInternetPassword(PasswordField internetPassword) {
        InternetPassword = internetPassword;
    }

    public long getAmountPayable() {
        return AmountPayable;
    }

    public void setAmountPayable(long amountPayable) {
        AmountPayable = amountPayable;
    }
}
