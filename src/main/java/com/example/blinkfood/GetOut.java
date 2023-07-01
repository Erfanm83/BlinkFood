package com.example.blinkfood;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class GetOut extends TheBigRestaurant {

    //تعداد پیک
    private int DeloveryNumbers;
    private boolean Available;
    private boolean Visible;

    public GetOut(String name, ArrayList<String> foodList, int startWorkHours, int endWorkHours, Image restaurantImage, String restaurantkind) {
        super(name, foodList, startWorkHours, endWorkHours, restaurantImage, restaurantkind);
        RestaurantKind = "GetOut";
    }

    public GetOut(int number, int deloveryNumbers) {
        super(number);
        DeloveryNumbers = deloveryNumbers;
    }

    public GetOut(boolean available , boolean visible) {
        super(available , visible);
        Available = available;
        Visible = visible;
    }
}