package com.example.blinkfood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.ResourceBundle;
import java.net.URL;

public class AdminController extends Checker implements Initializable {
    //////////////////////////////////////// *** Panes *** ////////////////////////////////////////
    @FXML
    public Pane Restaurant1, Restaurant2, Restaurant3, Restaurant4;

    ///////////////////////////////////// *** ImageViews *** /////////////////////////////////////
    @FXML
    public ImageView Hide1 = new ImageView("Hide.png");
    @FXML
    public ImageView Hide2 = Hide1;
    @FXML
    public ImageView Hide3 = Hide1;
    @FXML
    public ImageView Hide4 = Hide1;
    @FXML
    public ImageView Show1 = new ImageView("Show.png");
    @FXML
    public ImageView Show2 = Show1;
    @FXML
    public ImageView Show3 = Show1;
    @FXML
    public ImageView Show4 = Show1;
    //////////////////////////////////////// *** Variables *** ////////////////////////////////////////
    Socket socket;
    DataInputStream input;
    DataOutputStream output;
    Stage stage;
    Scene scene;
    String Delete1File = "BlinkFood\\src\\Files\\DeleteOrPlus1.txt";
    String Delete2File = "BlinkFood\\src\\Files\\DeleteOrPlus2.txt";
    String Delete3File = "BlinkFood\\src\\Files\\DeleteOrPlus3.txt";
    String Delete4File = "BlinkFood\\src\\Files\\DeleteOrPlus4.txt";
    String HideOrShow1 = "BlinkFood\\src\\Files\\HideOrShow1.txt";
    String HideOrShow2 = "BlinkFood\\src\\Files\\HideOrShow2.txt";
    String HideOrShow3 = "BlinkFood\\src\\Files\\HideOrShow3.txt";
    String HideOrShow4 = "BlinkFood\\src\\Files\\HideOrShow4.txt";

    //////////////////////////////////////// *** Back On Action *** ////////////////////////////////////////
    public void Admin(ActionEvent e) throws IOException {
        Loader(e, "Admin.fxml", stage, scene, 350, 70);
    }

    public void AdminRestaurants(ActionEvent e) throws IOException {
        Loader(e, "AdminRestaurants.fxml", stage, scene, 10, 10);
    }
    //////////////////////////////////////// *** Constructor *** ////////////////////////////////////////

    public AdminController() throws IOException {
        socket = new Socket("localhost", 12000);
        output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    }

    //////////////////////////////////////// *** Admin Restaurants Pages *** ////////////////////////////////////////
    public void AdminRestaurant1(MouseEvent event) throws IOException {
        MouseLoader(event, "AdminRestaurant1.fxml", stage, scene);
    }

    public void AdminRestaurant2(MouseEvent event) throws IOException {
        MouseLoader(event, "AdminRestaurant2.fxml", stage, scene);
    }

    public void AdminRestaurant3(MouseEvent event) throws IOException {
        MouseLoader(event, "AdminRestaurant3.fxml", stage, scene);
    }

    public void AdminRestaurant4(MouseEvent event) throws IOException {
        MouseLoader(event, "AdminRestaurant4.fxml", stage, scene);
    }

    //////////////////////////////////////// *** Deletes *** ////////////////////////////////////////
    public void Delete1(MouseEvent event) throws FileNotFoundException {
        Delete(event, Delete1File, 1, Restaurant1);
    }

    public void Delete2(MouseEvent event) throws FileNotFoundException {
        Delete(event, Delete2File, 2, Restaurant2);
    }

    public void Delete3(MouseEvent event) throws FileNotFoundException {
        Delete(event, Delete3File, 3, Restaurant3);
    }

    public void Delete4(MouseEvent event) throws FileNotFoundException {
        Delete(event, Delete4File, 4, Restaurant4);
    }

    //////////////////////////////////////// *** Pluses *** ////////////////////////////////////////
    public void Plus1(MouseEvent event) throws FileNotFoundException {
        Plus(event, Delete1File, 1, Restaurant1);
    }

    public void Plus2(MouseEvent event) throws FileNotFoundException {
        Plus(event, Delete2File, 2, Restaurant2);
    }

    public void Plus3(MouseEvent event) throws FileNotFoundException {
        Plus(event, Delete3File, 3, Restaurant3);
    }

    public void Plus4(MouseEvent event) throws FileNotFoundException {
        Plus(event, Delete4File, 4, Restaurant4);
    }

    //////////////////////////////////////// *** Shows *** ////////////////////////////////////////
    public void Show1(MouseEvent event) throws FileNotFoundException {
        Show(event, HideOrShow1, 1, Hide1, Show1);
    }

    public void Show2(MouseEvent event) throws FileNotFoundException {
        Show(event, HideOrShow2, 2, Hide2, Show2);
    }

    public void Show3(MouseEvent event) throws FileNotFoundException {
        Show(event, HideOrShow3, 3, Hide3, Show3);
    }

    public void Show4(MouseEvent event) throws FileNotFoundException {
        Show(event, HideOrShow4, 4, Hide4, Show4);
    }

    //////////////////////////////////////// *** Hides *** ////////////////////////////////////////
    public void Hide1(MouseEvent event) throws FileNotFoundException {
        Hide(event, HideOrShow1, 1, Hide1, Show1);
    }

    public void Hide2(MouseEvent event) throws FileNotFoundException {
        Hide(event, HideOrShow2, 2, Hide2, Show2);
    }

    public void Hide3(MouseEvent event) throws FileNotFoundException {
        Hide(event, HideOrShow3, 3, Hide3, Show3);
    }

    public void Hide4(MouseEvent event) throws FileNotFoundException {
        Hide(event, HideOrShow4, 4, Hide4, Show4);
    }

    public void Hide(MouseEvent event, String address, int i, ImageView hide, ImageView show) throws FileNotFoundException {
        File filer = new File(address);
        PrintWriter writer = new PrintWriter(filer);
        writer.write("Hide" + i + "Visible: true");
        writer.write(" Hide" + i + "Disable: false");
        writer.write(" Show" + i + "Visible: false");
        writer.write(" Show" + i + "Disable: true");
        writer.close();
        hide.setVisible(true);
        hide.setDisable(false);
        show.setVisible(false);
        show.setDisable(true);
    }

    public void Show(MouseEvent event, String address, int i, ImageView hide, ImageView show) throws FileNotFoundException {
        File filer = new File(address);
        PrintWriter writer = new PrintWriter(filer);
        writer.write("Hide" + i + "Visible: false");
        writer.write(" Hide" + i + "Disable: true");
        writer.write(" Show" + i + "Visible: true");
        writer.write(" Show" + i + "Disable: false");
        writer.close();
        hide.setVisible(false);
        hide.setDisable(true);
        show.setVisible(true);
        show.setDisable(false);
    }

    public void Plus(MouseEvent event, String address, int i, Pane Restaurant) {
        try {
            File file = new File(address);
            PrintWriter writer = new PrintWriter(file);
            writer.write("Delete" + i + "Visible: true");
            writer.write(" Delete" + i + "Disable: false");
            writer.close();
            Restaurant.setVisible(true);
            Restaurant.setDisable(false);
        } catch (FileNotFoundException exception) {
            System.out.println("Error writing to file: " + address);
        }
    }

    public void Delete(MouseEvent event, String address, int i, Pane Restaurant) {
        try {
            File file = new File(address);
            PrintWriter writer = new PrintWriter(file);
            writer.write("Delete" + i + "Visible: false");
            writer.write(" Delete" + i + "Disable: true");
            writer.close();
            Restaurant.setVisible(false);
            Restaurant.setDisable(true);
        } catch (FileNotFoundException exception) {
            System.out.println("Error writing to file: " + address);
        }
    }

    public void HideOrShowComponents(String address, ImageView Hide, ImageView Show) {
        try {
            String hideorshowcomponent = address;
            output.writeUTF("HideOrShow");
            output.flush();
            output.writeUTF(hideorshowcomponent);
            output.flush();

            switch (input.readUTF()) {
                case "false" -> {
                    Hide.setVisible(false);
                    Hide.setDisable(true);
                    Show.setVisible(true);
                    Show.setDisable(false);
                }
                case "true" -> {
                    Hide.setVisible(true);
                    Hide.setDisable(false);
                    Show.setVisible(false);
                    Show.setDisable(true);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void DeleteComponents(String address, Pane Restaurant) {
        try {
            String deletecomponent = address;
            output.writeUTF("DeleteOrPlus");
            output.flush();
            output.writeUTF(deletecomponent);
            output.flush();

            switch (input.readUTF()) {
                case "true" -> {
                    Restaurant.setVisible(true);
                    Restaurant.setDisable(false);
                }
                case "false" -> {
                    Restaurant.setVisible(false);
                    Restaurant.setDisable(true);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        DownloadComponent("Delete.png", socket, DeleteImage);
//        DownloadComponent("Hide.png", socket, HideImage);
//        DownloadComponent("Edit.png", socket, EditImage);
//        DownloadComponent("Show.png", socket, ShowImage);
//        DownloadComponent("AdminRestaurants.jpg", socket, AdminRestaurantImage);
        /// دانلود کردن عکس هایی که یوزر چوز کزده است

        //Load Delete Or Plus Situation of Components
        DeleteComponents(Delete1File, Restaurant1);
        DeleteComponents(Delete2File, Restaurant2);
        DeleteComponents(Delete3File, Restaurant3);
        DeleteComponents(Delete4File, Restaurant4);

        //Load Show Or Hide Situation of Components
        HideOrShowComponents(HideOrShow1, Hide1, Show1);
        HideOrShowComponents(HideOrShow2, Hide2, Show2);
        HideOrShowComponents(HideOrShow3, Hide3, Show3);
        HideOrShowComponents(HideOrShow4, Hide4, Show4);

    }
}