package com.example.blinkfood;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Thread {
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private ServerSocket serverSocket;
    private int port;
    private boolean running = false;

    public Server(int port) {
        this.port = port;
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            this.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stopServer() throws IOException {
        running = false;
        output.writeUTF("Exit");
        output.flush();
        this.interrupt();
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            System.out.println("Listening for a connection");
            try {
                Socket socket = serverSocket.accept();
                RequestServerHandler handler = new RequestServerHandler(socket);
                handler.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


//        running = true;
//        System.out.println("Listening for a connection");
//        try {
//            socket = serverSocket.accept();
//            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
//            output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
//            System.out.println("received a connection .");
//            String createaccount;
//            String adminaccount;
//            String loginaccount;
//            String request = null;
//            try {
//                while (running) {
//                    try {
//                        request = input.readUTF();
//                    } catch (IOException e) {
//                        throw new RuntimeException();
//                    }
//                    switch (request) {
//                        case "AdminSubmit" -> {
//                            adminaccount = input.readUTF();
//                            String[] parts = adminaccount.split(" ", 1);
//                            adminaccountchecker(parts[0], parts[1]);
//                        }
//                        case "CreateAccountSubmit" -> {
//                            createaccount = input.readUTF();
//                            String[] parts = createaccount.split(" ", 5);
//                            createaccountchecker(parts[0], parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]));
//                        }
//                        case "LoginAccountSubmit" -> {
//                            loginaccount = input.readUTF();
//                            String[] parts = loginaccount.split(" ", 2);
//                            loginaccountchecker(parts[0], parts[1]);
//                        }
//                        case "Exit" -> {
//                            running = false;
//                        }
//                        default -> {
//                            try {
//                                output.writeUTF("request invalid.");
//                                output.flush();
//                            } catch (IOException e) {
//                                throw new RuntimeException(e);
//                            }
//                        }
//                    }
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
////                    RequestServerHandler handler = new RequestServerHandler(socket);
////                    handler.start();
////                output.writeUTF("request invalid. ");
////                output.flush();
//            input.close();
//            output.close();
//            socket.close();
//            System.out.println("Connection closed");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public static void main(String[] args) {
//        System.out.println("Start server on port: 12000");
//        Server server = new Server(12000);
//        server.startServer();
//        try {
//            Thread.sleep(1200000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        server.stopServer();
//    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//
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
}