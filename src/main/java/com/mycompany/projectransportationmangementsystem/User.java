package com.mycompany.projectransportationmangementsystem;

import java.util.*;
public class User {
    private String username ;
    private String password;
    private String userType ;
    private String ID ;
    Scanner scanner = new Scanner(System.in);

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public User(String username, String password, String userType, String id) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.ID = id ;
    }

    public User() {

    }

    public void Login (){
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (authenticate(username, password)) {
            System.out.println("Login successful ");
        } else {
            System.out.println("Invalid");
        }
    }
    public void Register (){

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email= scanner.nextLine();

        System.out.print("Enter your birthday: ");
        int birthday= scanner.nextInt();

        System.out.print("Enter Gender: (m/f) ");
        char gender = scanner.next().charAt(0);

        System.out.print("Enter Phone number ");
        int number = scanner.nextInt();

    }
    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

}
