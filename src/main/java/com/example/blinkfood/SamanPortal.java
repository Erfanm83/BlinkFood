package com.example.blinkfood;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SamanPortal extends TheBigBankPortal{

    public SamanPortal(TextField cardNumber, TextField email, TextField captcha, PasswordField CVV2, PasswordField month, PasswordField year, PasswordField internetPassword) {
        super(cardNumber, email, captcha, CVV2, month, year, internetPassword);
    }

    public SamanPortal(double wage) {
        super(wage);
        Wage = 0.07;
    }

    public SamanPortal(long amountPayable) {
        super(amountPayable);
    }
}
