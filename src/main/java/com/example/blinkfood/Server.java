package com.example.blinkfood;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Thread{
    private ServerSocket serverSocket;
    private int port;
    private boolean running = false;

    public Server(int port) {
        this.port = port;
    }
    public void startServer(){
        try {
            serverSocket = new ServerSocket(port);
            this.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void stopServer(){
        running = false;
        this.interrupt();
    }
    @Override
    public void run(){
        running = true;
        while (running){
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter port : ");
        int port = scanner.nextInt();

        System.out.println("Start server on port: " + port);

        Server server = new Server(port);
        server.startServer();

        try {
            Thread.sleep(1200000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        server.stopServer();

    }
}
