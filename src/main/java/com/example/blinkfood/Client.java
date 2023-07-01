package com.example.blinkfood;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Client {
    private int port;
    private Socket socket;

    private Scanner scanner;
    private DataInputStream input;
    private DataOutputStream output;
    public Client(int port) {
        this.port = port;
        scanner = new Scanner(System.in);
        try {
            this.socket = new Socket("localhost",port);
            this.input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            this.output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            menu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void menu() throws IOException {
        String list = """
             * * * Menu * * *
             1.Download
             2.Upload
             3.List
             4.Exit""";
        mainWhile:
        while(true){
            System.out.println(list);
            System.out.print("Input > ");
            String strInput = scanner.nextLine();
            output.writeUTF(strInput);
            output.flush();
            switch (strInput){
                case "1" -> download();
                case "2" -> upload();
                case "3" -> list();
                case "4" -> {
                    break mainWhile;
                }
                default -> System.out.println("input invalid.");
            }
        }
    }
    public void download() throws IOException {
        System.out.print("Name File > ");
        String nameFile = scanner.nextLine();

        output.writeUTF(nameFile);
        output.flush();

        if (input.readUTF().equals("Start download.")){
            System.out.println("Downloading ...");
            FileOutputStream stream = new FileOutputStream("C:\\Users\\Admin\\IdeaProjects\\BlinkFood\\BlinkFood\\src\\main\\java\\com\\example\\Client\\"+nameFile);
            byte[] bytes = new byte[1024];
            while (true){
                input.read(bytes);
                if (new String(bytes).contains("finish"))
                    break;
                stream.write(bytes);
            }
            stream.close();
            System.out.println(nameFile + " Downloaded.");
        }else{
            System.out.println("File Not Exist.");
        }
    }
    public void upload() throws IOException {
        System.out.print("input file path> ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        if (file.exists()){
            String[] nameFile = filePath.split(Pattern.quote("\\"));
            output.writeUTF(nameFile[nameFile.length - 1]);
            FileInputStream stream = new FileInputStream(file);
            System.out.println("uploading...");
            int count=0;
            byte[] bytes = new byte[1024];
            while ((count = stream.read(bytes))>0){
                output.write(bytes,0,count);
                output.flush();
            }
            output.write("finish".getBytes());
            output.flush();
            stream.close();
            System.out.println("File uploaded successfully.");
        }else{
            System.out.println("file Not Exist.");
        }
    }
    public void list() throws IOException {
        System.out.println("* * * List Files * * *");
        String list = input.readUTF();
        System.out.println(list);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter port: ");
        int port = scanner.nextInt();
        new Client(port);
    }
}
