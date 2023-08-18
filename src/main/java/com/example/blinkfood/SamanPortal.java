package com.example.blinkfood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SamanPortal extends Checker implements Initializable {

//    public SamanPortal(TextField cardNumber, TextField email, TextField captcha, PasswordField CVV2, PasswordField month, PasswordField year, PasswordField internetPassword) {
//        super(cardNumber, email, captcha, CVV2, month, year, internetPassword);
//    }
//
//    public SamanPortal(double wage) {
//        super(wage);
//        Wage = 0.07;
//    }
//
//    public SamanPortal(long amountPayable) {
//        super(amountPayable);
//    }
public void LoginRestaurants(ActionEvent e) throws IOException {
    Loader(e, "LoginRestaurants.fxml", stage, scene, 10, 10);
}

    public void PaymentSubmit(ActionEvent e) throws FileNotFoundException {
        try {
            File cash = new File(Cash);
            Scanner cashScanner = new Scanner(cash);
            int cashLabel = 0;
            while (cashScanner.hasNextLine()) {
                String line = cashScanner.nextLine();
                String[] parts = line.split(" ");
                cashLabel = Integer.parseInt(parts[0]);
            }
            File priseFile = new File(PriceFile);
            Scanner priseScanner = new Scanner(priseFile);
            int prise = 0;
            while (priseScanner.hasNextLine()) {
                String line = priseScanner.nextLine();
                String[] parts = line.split(" ");
                prise = Integer.parseInt(parts[0]);
            }
            File cardMoneyFile = new File(CardMoney);
            Scanner cardMoneyScanner = new Scanner(cardMoneyFile);
            int cardMoney = 0;
            while (cardMoneyScanner.hasNextLine()) {
                String line = cardMoneyScanner.nextLine();
                String[] parts = line.split(" ");
                cardMoney = Integer.parseInt(parts[0]);
            }

            cardMoney -= prise;
            cashLabel += prise;

            File cashWriter = new File(Cash);
            PrintWriter writer1 = new PrintWriter(cashWriter);
            String sCash = String.valueOf(cashLabel);
            writer1.write(sCash);
            writer1.close();

            File cardMoneyWriter = new File(CardMoney);
            PrintWriter writer2 = new PrintWriter(cardMoneyWriter);
            String sCardMoney = String.valueOf(cardMoney);
            writer2.write(sCardMoney);
            writer2.close();

        } catch (FileNotFoundException ev) {
            ev.printStackTrace();
        }
    }

    public void Captcha(MouseEvent event) throws Exception {
        try {
            String captchaText = generateCaptchaText();
            Captcha.setText(captchaText);
        } catch (Exception e) {
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

    public String Passwordgenerator(ActionEvent event) {
        Random random = new Random(10);
        StringBuilder sb = new StringBuilder(PASSWORD_LENGTH);
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            sb.append(random);
        }
        return sb.toString();
    }

    public void Password(ActionEvent event) throws Exception {
        try {
            CardPassword.setText(Passwordgenerator(event));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            File priceFile = new File(PriceFile);
            Scanner priceScanner = new Scanner(priceFile);
            String price = null;
            while (priceScanner.hasNextLine()) {
                String line = priceScanner.nextLine();
                String[] parts = line.split(" ");
                price = parts[0];
            }
            Price.setText(price);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
