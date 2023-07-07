package com.example.blinkfood;

import java.io.IOException;
import java.util.TreeMap;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class ThreadExample {

    public static void main (String[] args) throws InterruptedException {
        //Bad Thread
//        System.out.println("Salam");
//        Mythread t = new Mythread();
//        t.start();
//        System.out.println("Khodafez");

        ///Good Thread
        Thread r = new Thread(new MyRunnable());
        r.start();

        //نخ جاری
        Thread t1 = Thread.currentThread();

        ////////////////  *** join ***  ////////////////

        Thread tread = new Mythread();
        tread.start();
        /// method GOOOZ
        tread.join(); // sabr kon GOOOZ karesh tamum beshe
        /// method SHAGHIGHE

        ////////////////  *** priority ***  ////////////////
        Mythread mythread = new Mythread();
        mythread.setPriority(Thread.MAX_PRIORITY);
        mythread.start();
        ////////////////  *** Daemon ***  ////////////////
        Mythread mythread1 = new Mythread();
        mythread1.setDaemon(true);
        mythread1.start();
        ///////////////// *** Practice *** //////////////////
        new Thread(new Mythread()).start();
        for (char c= 'A' ; c <= 'Z' ; c++){
            try {
                Thread.sleep(10);
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
            System.out.println(c);
        }
        Thread currentthread = Thread.currentThread();
        System.out.println(currentthread.getName());
    }
}
