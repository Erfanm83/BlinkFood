package com.example.blinkfood;

import javafx.scene.layout.Pane;

import java.io.*;
import java.net.Socket;
import java.net.URISyntaxException;
import java.util.Scanner;

public class RequestServerHandler extends Thread {
    String CreateAccountFile = "BlinkFood\\src\\Files\\CreateAccount.txt";
    String AdminFile = "BlinkFood\\src\\ReadMe.txt";
    private Socket socket;
    private File UploadFileDirectory;
    private File DownloadFileDirectory;
    private DataInputStream input;
    private FileInputStream fileInputStream;
    private DataOutputStream output;
    private FileOutputStream fileOutputStream;

    public RequestServerHandler(Socket socket) {
        this.socket = socket;
        try {
            this.input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            this.output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        System.out.println("Received a connection");
        String request;
        String createaccount;
        String adminaccount;
        String loginaccount;
        String deleteorplus;
        String hideorshow;
        String restaurantcomponent;
        try {
            mainWhile:
            while (true) {
                try {
                    request = input.readUTF();
                } catch (IOException e) {
                    break mainWhile;
                }
                switch (request) {
                    case "AdminSubmit" -> {
                        adminaccount = input.readUTF();
                        String[] parts = adminaccount.split(" ", 2);
                        adminaccountchecker(parts[0], parts[1]);
                    }
                    case "LoginSubmit" -> {
                        loginaccount = input.readUTF();
                        String[] parts = loginaccount.split(" ", 2);
                        loginaccountchecker(parts[0], parts[1]);
                    }
                    case "CreateAccountSubmit" -> {
                        createaccount = input.readUTF();
                        String[] parts = createaccount.split(" ");
                        createaccountchecker(parts[0], parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]));
                    }
                    case "DeleteOrPlus" -> {
                        deleteorplus = input.readUTF();
                        DeleteOrPlus(deleteorplus);
                    }
                    case "HideOrShow" -> {
                        hideorshow = input.readUTF();
                        HideOrShow(hideorshow);
                    }
                    case "RestaurantComponent" -> {
                        String r = input.readUTF();
                        switch (r){
                            case "Save" -> {
                                restaurantcomponent = input.readUTF();
                                RestaurantSaver(restaurantcomponent);
                            }
                            case "Load" -> {
                                restaurantcomponent = input.readUTF();
                                RestaurantLoader(restaurantcomponent);
                            }
                        }
                    }
                    case "Exit" -> {
                        break mainWhile;
                    }
                    default -> {
                        try {
                            output.writeUTF("request invalid.");
                            output.flush();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            input.close();
            output.close();
            socket.close();
            System.out.println("Connection closed");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public void upload(String Filename) throws IOException {
//
//        UploadFileDirectory = new File("C:\\Users\\Admin\\IdeaProjects\\BlinkFood\\BlinkFood\\src\\main\\resources\\com\\example\\Data\\image\\" + Filename);
//
//        if (UploadFileDirectory.exists()) {
//            output.writeUTF("Start download.");
//            output.flush();
//
//            fileInputStream = new FileInputStream(UploadFileDirectory);
//            int bytes = 0;
//            // send file size
//            output.writeLong(UploadFileDirectory.length());
//            // break file into chunks
//            byte[] buffer = new byte[4 * 1024];
//            while ((bytes = fileInputStream.read(buffer)) != -1) {
//                output.write(buffer, 0, bytes);
//                output.flush();
//            }
//            output.write("finish".getBytes());
//            output.flush();
//            fileInputStream.close();
//        } else {
//            output.writeUTF("File not exist.");
//            output.flush();
//        }
//    }

    public void createaccountchecker(String username, String password, String confirmpassword, String email, String phonenumber, int age) throws IOException {
        try {
            //Check components
            if (UsernameChecker(username) && PasswordChecker(password, confirmpassword) && EmailChecker(email) && PhoneNumberChecker(phonenumber)
                    && AgeChecker(age)) {
                //Successfull Log
                System.out.println("User : " + socket.getInetAddress() + " " + "Account Successfully Created");
                //Send Successfull message
                output.writeUTF("Successfull");
                output.flush();
                //Save to files
                File outputFile = new File(CreateAccountFile);
                PrintWriter writer = new PrintWriter(outputFile);
                writer.write("Username: " + username);
                writer.write(" Password: " + password);
                writer.write(" ConfirmPassword: " + confirmpassword);
                writer.write(" Email: " + email);
                writer.write(" PhoneNumber: " + phonenumber);
                writer.write(" Age: " + Integer.parseInt(String.valueOf(age)));
                writer.close();
            } else {
                if (!UsernameChecker(username)) {
                    output.writeUTF("UsernameError");
                    output.flush();
                }
                if (!EmailChecker(email)) {
                    output.writeUTF("EmailError");
                    output.flush();
                }
                if (!PhoneNumberChecker(phonenumber)) {
                    output.writeUTF("PhonenumberError");
                    output.flush();
                }
                if (!AgeChecker(age)) {
                    output.writeUTF("AgeError");
                    output.flush();
                }
                if (!PasswordChecker(password, confirmpassword)) {
                    output.writeUTF("ConfirmpassError");
                    output.flush();
                }
            }
        } catch (java.io.IOException exception) {
            System.out.println("Error writing to file: " + CreateAccountFile);
        }
    }

    public void loginaccountchecker(String username, String password) {
        try {
            //Check Component
            if (LoginChecker(username, password)) {
                //Successfull Log
                System.out.println("User : " + socket.getInetAddress() + " " + "Successfully Logged in .");
                //Send Successfull Message
                output.writeUTF("Successfull");
                output.flush();
            } else if (!LoginChecker(username, password)) {
                output.writeUTF("Error");
                output.flush();
            }
        } catch (java.io.IOException exception) {
            System.out.println("Error Checking LogIn Details " + exception);
        }
    }

    public void adminaccountchecker(String username, String password) {
        try {
            //Check components
            if (AdminChecker(username, password)) {
                //Successfull Log
                System.out.println("Admin : " + socket.getInetAddress() + " " + "Successfully Logged in .");
                //Successfull Message
                output.writeUTF("Successfull");
                output.flush();
            } else if (!AdminChecker(username, password)) {
                output.writeUTF("Error");
                output.flush();
            }
        } catch (java.io.IOException exception) {
            System.out.println("Error Checking Admin LogIn Details  " + exception);
        }
    }

    //////////////////////////////////////// *** Create Account Check *** ////////////////////////////////////////
    public boolean UsernameChecker(String username) {
        //Load From File
        try {
            File LoginFileChecker = new File(CreateAccountFile);
            Scanner scanner = new Scanner(LoginFileChecker);
            String user = null;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                user = parts[1];
            }
            //Check if Not to have repetitive username
            if (!username.equals(user) && !username.isEmpty())
                return true;
            return false;
        } catch (FileNotFoundException exception) {
            System.out.println("File not found: ");
            return false;
        }
    }

    public boolean EmailChecker(String email) {
        return !email.isEmpty() ? true : false;
    }

    public boolean PhoneNumberChecker(String phoneNumber) {
        if (phoneNumber.length() != 11) {
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean AgeChecker(int age) {
        return age >= 18 ? true : false;
    }

    public boolean PasswordChecker(String password, String confirmPassword) {
        return password.equals(confirmPassword) ? true : false;
    }

    ///////////////////////////////////// ***  Admin Check *** /////////////////////////////////////
    public boolean AdminChecker(String adminUsername, String adminPassword) {
        try {
            File AdminChecker = new File(AdminFile);
            Scanner scanner = new Scanner(AdminChecker);
            String user = null;
            String pass = null;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                user = parts[1];
                pass = parts[3];
            }
            if (adminUsername.equals(user) && !adminUsername.isEmpty() && adminPassword.equals(pass) && !adminPassword.isEmpty())
                return true;
            return false;
        } catch (FileNotFoundException exception) {
            System.out.println("File not found: " + AdminFile);
            return false;
        }
    }

    public boolean LoginChecker(String loginUsername, String loginPassword) {
        try {
            File LoginFileChecker = new File(CreateAccountFile);
            Scanner scanner = new Scanner(LoginFileChecker);
            String user = null;
            String confirmpass = null;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                user = parts[1];
                confirmpass = parts[5];
            }
            if (loginUsername.equals(user) && loginPassword.equals(confirmpass))
                return true;
            return false;
        } catch (FileNotFoundException exception) {
            System.out.println("File not found: " + exception);
            return false;
        }
    }

    public void DeleteOrPlus(String address) throws FileNotFoundException {
        try {
            File filer = new File(address);
            Scanner scanner = new Scanner(filer);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts[1].equals("false")) {
                    output.writeUTF("false");
                    output.flush();
                }
                if (parts[1].equals("true")) {
                    output.writeUTF("true");
                    output.flush();
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Error writing to file: " + address);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void HideOrShow(String address) throws IOException {
        try {
            File filer = new File(address);
            Scanner scan = new Scanner(filer);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(" ");
                if (parts[1].equals("false")) {
                    output.writeUTF("false");
                    output.flush();
                }
                if (parts[1].equals("true")) {
                    output.writeUTF("true");
                    output.flush();
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Error writing to file: " + address);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void RestaurantLoader(String address) throws IOException{
        try {
            File filer = new File(address);
            Scanner scanner = new Scanner(filer);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                output.writeUTF(parts[1]);
                output.flush();
                output.writeUTF(parts[3]);
                output.flush();
                output.writeUTF(parts[5]);
                output.flush();
                output.writeUTF(parts[7]);
                output.flush();
                output.writeUTF(parts[9]);
                output.flush();
                output.writeUTF(parts[11]);
                output.flush();
                output.writeUTF(parts[13]);
                output.flush();
                output.writeUTF(parts[15]);
                output.flush();
                output.writeUTF(parts[17]);
                output.flush();
                output.writeUTF(parts[19]);
                output.flush();
                output.writeUTF(parts[21]);
                output.flush();
                output.writeUTF(parts[23]);
                output.flush();
                output.writeUTF(parts[25]);
                output.flush();
                output.writeUTF(parts[27]);
                output.flush();
                //Successfull Log
                System.out.println("User : " + socket.getInetAddress() + " " + "Successfully Restaurants details Loaded .");
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Error writing to file: " + address);
        }
    }

    public void RestaurantSaver(String address) throws IOException{
        //Check Component
            try {
                File filer = new File(address);
                PrintWriter writer = new PrintWriter(filer);
                writer.write("FoodName11: " + input.readUTF());
                writer.write(" FoodName12: " + input.readUTF());
                writer.write(" FoodName13: " + input.readUTF());
                writer.write(" FoodName14: " + input.readUTF());
                writer.write(" FoodPrice11: " +  input.readUTF());
                writer.write(" FoodPrice12: " +  input.readUTF());
                writer.write(" FoodPrice13: " +  input.readUTF());
                writer.write(" FoodPrice14: " +  input.readUTF());
                writer.write(" RestaurantName: " +  input.readUTF());
                writer.write(" RestaurantKind: " + input.readUTF());
                writer.write(" StartWorkHours: " + input.readUTF());
                writer.write(" EndWorkHours: " +  input.readUTF());
                writer.write(" NumberofServices: " + input.readUTF());
                writer.write(" RestaurantAddress: " + input.readUTF());
                writer.close();
                //Successfull Log
                System.out.println("User : " + socket.getInetAddress() + " " + "Successfully Restaurants details Saved .");
            } catch (java.io.IOException exception) {
                System.out.println("Error writing to file:");
            }
    }

}
