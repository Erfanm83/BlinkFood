package com.example.blinkfood;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MellatPortal extends TheBigBankPortal{

    public MellatPortal(TextField cardNumber, TextField email, TextField captcha, PasswordField CVV2, PasswordField month, PasswordField year, PasswordField internetPassword) {
        super(cardNumber, email, captcha, CVV2, month, year, internetPassword);
    }

    public MellatPortal(double wage) {
        super(wage);
        Wage = 0.02;
    }

    public MellatPortal(long amountPayable) {
        super(amountPayable);
    }
}
