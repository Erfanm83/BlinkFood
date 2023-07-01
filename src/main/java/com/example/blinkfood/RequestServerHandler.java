package com.example.blinkfood;

import java.io.*;
import java.net.Socket;

public class RequestServerHandler extends Thread{
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
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
    public void run(){
        System.out.println("Received a connection");
        String request ;
        try {
            mainWhile :
            while (true){
                try {
                    request = input.readUTF();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                switch (request){
                    case "1" -> upload();
                    case "2" -> download();
                    case "3" -> list();
                    case "4" -> {
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
    public void upload() throws IOException {
        String nameFile = input.readUTF();

        File file = new File("C:\\Users\\Admin\\IdeaProjects\\BlinkFood\\BlinkFood\\src\\main\\java\\com\\example\\Data\\"+nameFile);

        if(file.exists()){
            output.writeUTF("Start download.");
            output.flush();

            FileInputStream stream = new FileInputStream(file);
            int count=0;
            byte[] bytes = new byte[1024];
            while ((count = stream.read(bytes))>0){
                output.write(bytes,0,count);
                output.flush();
            }
            output.write("finish".getBytes());
            output.flush();
            stream.close();
        }else{
            output.writeUTF("File not exist.");
            output.flush();
        }
    }
    public void download() throws IOException {
        String nameFile = input.readUTF();
        FileOutputStream stream = new FileOutputStream("C:\\Users\\Admin\\IdeaProjects\\BlinkFood\\BlinkFood\\src\\main\\java\\com\\example\\Data\\"+nameFile);
        byte[] bytes = new byte[1024];
        while (true){
            input.read(bytes);
            if (new String(bytes).contains("finish"))
                break;
            stream.write(bytes);
        }
        stream.close();
    }
    public void list() throws IOException {
        String[] listFile = new File("C:\\Users\\Admin\\IdeaProjects\\BlinkFood\\BlinkFood\\src\\main\\java\\com\\example\\Data\\").list();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listFile.length; i++) {
            sb.append((i+1)+" -> "+listFile[i]+"\n");
        }
        output.writeUTF(sb.toString());
        output.flush();
    }
}
