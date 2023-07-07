package com.example.blinkfood;

public class Mythread extends Thread{


    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
            System.out.println("Hello");
            System.out.println("Bye");
        }
    }
}
