//package com.example.blinkfood;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
//import javafx.scene.image.Image;
//import javafx.stage.Stage;
//
//import java.io.*;
//import java.net.Socket;
//import java.util.Objects;
//import java.util.Scanner;
//import java.util.regex.Pattern;
//
//public class Client {
//    private int port;
//    private Socket socket ;
//    private Scanner scanner;
//    private DataInputStream input;
//    private DataOutputStream output;
//    private FileOutputStream fileOutputStream;
//    private FileInputStream fileInputStream;
//    public Client(int port) {
//        this.port = port;
//        scanner = new Scanner(System.in);
//        try {
//            this.socket = new Socket("localhost",port);
//            this.input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
//            this.output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
////            menu();
////            download("Admin.fxml");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
////    public void menu() throws IOException {
////        String list = """
////             * * * Menu * * *
////             1.Download
////             2.Upload
////             3.List
////             4.Exit""";
////        mainWhile:
////        while(true){
////            System.out.println(list);
////            System.out.print("Input > ");
////            String strInput = scanner.nextLine();
////            output.writeUTF(strInput);
////            output.flush();
////            switch (strInput){
////                case "1" -> download();
////                case "2" -> upload();
////                case "3" -> list();
////                case "4" -> {
////                    break mainWhile;
////                }
////                default -> System.out.println("input invalid.");
////            }
////        }
////    }
//    public void download(String nameFile) throws IOException {
//        output.writeUTF(nameFile);
//        output.flush();
//
//        if (input.readUTF().equals("Start download.")){
//            System.out.println("Downloading ...");
//            fileOutputStream = new FileOutputStream("C:\\Users\\Admin\\IdeaProjects\\BlinkFood\\BlinkFood\\src\\main\\resources\\com\\example\\blinkfood\\"+ nameFile);
//
//        ///////////////////////////////////////////////////////
//            int bytes = 0;
//
//            long size = input.readLong();     // read file size
//            byte[] buffer = new byte[4*1024];
//            while (size > 0 && (bytes = input.read(buffer, 0, (int)Math.min(buffer.length, size))) != -1) {
//                fileOutputStream.write(buffer,0,bytes);
//                size -= bytes;      // read upto file size
//            }
//            System.out.println(nameFile + " Downloaded.");
//            fileOutputStream.close();
//         ///////////////////////////////////////////////////////////////
//
////            byte[] bytes = new byte[1024];
////            while (true){
////                fileInputStream.read(bytes);
////                if (new String(bytes).contains("finish"))
////                    break;
////                fileOutputStream.write(bytes);
////            }
////            fileOutputStream.close();
//        }else{
//            System.out.println("File Not Exist.");
//        }
//    }
//    public void upload() throws IOException {
//        System.out.print("input file path> ");
//        String filePath = scanner.nextLine();
//
//        File file = new File(filePath);
//        if (file.exists()){
//            String[] nameFile = filePath.split(Pattern.quote("\\"));
//            output.writeUTF(nameFile[nameFile.length - 1]);
//            FileInputStream stream = new FileInputStream(file);
//            System.out.println("uploading...");
//            int count = 0;
//            byte[] bytes = new byte[1024];
//            while ((count = stream.read(bytes))>0){
//                output.write(bytes,0,count);
//                output.flush();
//            }
//            output.write("finish".getBytes());
//            output.flush();
//            stream.close();
//            System.out.println("File uploaded successfully.");
//        }else{
//            System.out.println("file Not Exist.");
//        }
//    }
//    public void list() throws IOException {
//        System.out.println("* * * List Files * * *");
//        String list = input.readUTF();
//        System.out.println(list);
//    }
//    public void exit(Stage stage) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Exit");
//        alert.setHeaderText("Do you want to exit ?");
//        if (alert.showAndWait().get() == ButtonType.OK) {
//            stage.close();
//        }
//    }
//}
