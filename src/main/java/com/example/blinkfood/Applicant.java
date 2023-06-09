package com.example.blinkfood;

public abstract class Applicant {

    private int age;
    private String phoneNumber;
    private String username;
    private String password;
    private String confirmpassword;
    private String email;

    public String applicantKind;

    public Applicant(String phoneNumber, String username, String password, String confirmpassword, String email, int age) {
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.email = email;
    }

    public Applicant(String username) {
        this.username = username;
    }

    public Applicant(String phoneNumber, String username, String password, String email, int age) {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String toString() {
        return username + " " + age + " " + phoneNumber;
    }
}