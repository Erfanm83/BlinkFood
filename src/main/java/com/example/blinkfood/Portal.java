package com.example.blinkfood;

public abstract class Portal {

    private String cardNumber;
    private String cvv2;
    private String month;
    private String year;
    private String captcha;
    private String internetPassword;
    private String email;
    private int Wage;

    public Portal(String cardNumber, String cvv2, String month, String year, String captcha, String internetPassword, String email, int wage) {
        this.cardNumber = cardNumber;
        this.cvv2 = cvv2;
        this.month = month;
        this.year = year;
        this.captcha = captcha;
        this.internetPassword = internetPassword;
        this.email = email;
        Wage = wage;
    }

    public Portal(int wage) {
        Wage = wage;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getInternetPassword() {
        return internetPassword;
    }

    public void setInternetPassword(String internetPassword) {
        this.internetPassword = internetPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWage() {
        return Wage;
    }

    public void setWage(int wage) {
        Wage = wage;
    }
}