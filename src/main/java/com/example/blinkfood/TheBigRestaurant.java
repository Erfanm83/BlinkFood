package com.example.blinkfood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public abstract class TheBigRestaurant {

    //نوع رستوران
    String RestaurantKind;

    // غیرفعال بودن یا نبودن
    private boolean Available;
    // وجود داشتن یا نداشتن
    private boolean Visible;
    //نام رستوران
    private String Name;
    //لیست غذا ها
    private ArrayList<String> FoodList;
    //آدرس
    private String address;
    // ساعت کاری
    private int StartWorkHours;
    private int EndWorkHours;
    // عکس رستوران
    private Image RestaurantImage;
    //تعداد پیک
    private int DeliveryNumbers;
    //لژ خانوادگی
    private int FamilyLodge;
    // نوبت
    private int number;

    //constructors
    public TheBigRestaurant(String name, ArrayList<String> foodList, int startWorkHours, int endWorkHours, Image restaurantImage) {
        this.Name = name;
        this.FoodList = foodList;
        this.StartWorkHours = startWorkHours;
        this.EndWorkHours = endWorkHours;
        this.RestaurantImage = restaurantImage;
    }

    public TheBigRestaurant(int number) {
        this.number = number;
    }

    public TheBigRestaurant(boolean available, boolean visible) {
        Available = available;
        Visible = visible;
    }

    //Getters & Setters
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<String> getFoodList() {
        return FoodList;
    }

    public void setFoodList(ArrayList<String> foodList) {
        FoodList = foodList;
    }

    public int getStartWorkHours() {
        return StartWorkHours;
    }

    public void setStartWorkHours(int startWorkHours) {
        StartWorkHours = startWorkHours;
    }

    public int getEndWorkHours() {
        return EndWorkHours;
    }

    public void setEndWorkHours(int endWorkHours) {
        EndWorkHours = endWorkHours;
    }

    public Image getRestaurantImage() {
        return RestaurantImage;
    }

    public void setRestaurantImage(Image restaurantImage) {
        RestaurantImage = restaurantImage;
    }

    public String getRestaurantKind() {
        return RestaurantKind;
    }

    public void setRestaurantKind(String restaurantKind) {
        RestaurantKind = restaurantKind;
    }

    public int getDeliveryNumbers() {
        return DeliveryNumbers;
    }

    public void setDeliveryNumbers(int deliveryNumbers) {
        DeliveryNumbers = deliveryNumbers;
    }

    public int getFamilyLodge() {
        return FamilyLodge;
    }

    public void setFamilyLodge(int familyLodge) {
        FamilyLodge = familyLodge;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}