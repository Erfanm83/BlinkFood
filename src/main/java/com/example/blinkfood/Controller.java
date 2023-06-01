package com.example.blinkfood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Line;

public class Controller {
    @FXML
    private Line line = new Line();
    @FXML
    public void Submit(ActionEvent e) {
        System.out.println("Hello");
        //Submit should done
    }

    public void ChangeUser(ActionEvent e) {
        line.setLayoutX(579);
        System.out.println("Changeuser clicked");
    }
    public void ChangeServer(ActionEvent e){
        line.setLayoutX(505);
        System.out.println("Changeserver clicked");
    }
}
