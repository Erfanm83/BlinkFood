package com.example.blinkfood;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FileProcessing {
    public static void main(String[] args) {
        String inputFileName = "D:\\Codes\\Java\\Blink Food\\src\\main\\java\\com\\example\\Files\\input.txt"; // input file name
        String outputFileName = "D:\\Codes\\Java\\Blink Food\\src\\main\\java\\com\\example\\Files\\output.txt"; // output file name

        //cos sher
        int numberOfMen = 0;
        int numberOfWomen = 0;
        int numberOfDeads = 0;
        int numberOfPeopleOver30 = 0;

        try {
            // faghat login
            File inputFile = new File(inputFileName);
            Scanner scanner = new Scanner(inputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");

                // read informations from file
                String firstName = parts[1];
                String lastName = parts[3];
                String gender = parts[5];
                String birthday = parts[7];

                // calculate age
                int age = calculateAge(birthday);

                // calculate number of men
                if (gender.equals("M")) {
                    numberOfMen++;
                } else if (gender.equals("F")) {
                    numberOfWomen++;
                }

                // caclculate number of dead people
                if (isDead(age)) {
                    numberOfDeads++;
                }

                // بررسی سن و تعداد افراد بالای ۳۰ سال
                if (age > 30) {
                    numberOfPeopleOver30++;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFileName);
            return;
        }

        //////////////////////////////////////////////////////


        // create account
        try {
            File outputFile = new File(outputFileName);
            PrintWriter writer = new PrintWriter(outputFile);

            // write informations
            writer.write("Number of Men: " + numberOfMen + "\n");
            writer.write("Number of Women: " + numberOfWomen + "\n");
            writer.write("Number of Dead People: " + numberOfDeads + "\n");
            writer.write("Number of people over 30 years old: " + numberOfPeopleOver30 + "\n");

            writer.close();
        } catch (java.io.IOException e) {
            System.out.println("Error writing to file: " + outputFileName);
            return;
        }

        System.out.println("Output written to file: " + outputFileName);
    }

    // محاسبه سن بر اساس تاریخ تولد
    public static int calculateAge(String birthday) {
        String[] parts = birthday.split("/");
        String year = parts[0];
        int age = 2023 - Integer.parseInt(year);
        return age;
    }

    // بررسی وضعیت مرگ بر اساس سن
    public static boolean isDead(int age) {
        if (age > 150)
            return true;
        return false;
    }
}
