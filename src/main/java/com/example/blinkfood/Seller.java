//package com.example.blinkfood;
//
//
//import java.util.*;
//
//public class Seller extends Applicant {
//    public String workplace;
//
//    public ArrayList<Item> items = new ArrayList<>();
//
//    public Seller(String phoneNumber, String username, String password, String email , int age, String workplace) {
//        super(phoneNumber, username, password, email , age);
//        this.workplace = workplace;
//        applicantKind = "seller";
//    }
//
//    public Seller(String username) {
//        super(username);
//    }
//
//    public boolean equals(Object other) {
//        if (other instanceof Seller) {
//            Seller s = (Seller) other;
//            return Objects.equals(this.getUsername(), s.getUsername());
//        }
//        return false;
//    }
//
//}
