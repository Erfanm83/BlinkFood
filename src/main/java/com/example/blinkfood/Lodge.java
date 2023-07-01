package com.example.blinkfood;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Objects;

public class Lodge extends TheBigRestaurant {

    //تعداد میز
    private int TableNumbers;
    private boolean Available;
    private boolean Visible;
    public Lodge(String name, ArrayList<String> foodList, int startWorkHours, int endWorkHours, Image restaurantImage, String restaurantkind) {
        super(name, foodList, startWorkHours, endWorkHours, restaurantImage, restaurantkind);
        RestaurantKind = "FamilyLodge";
    }

    public Lodge(int tableNumbers) {
        super(tableNumbers);
        TableNumbers = tableNumbers;
    }

    public Lodge(boolean available , boolean visible) {
        super(available , visible);
        Available = available;
        Visible = visible;
    }
}