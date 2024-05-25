/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectransportationmangementsystem;

import java.util.Scanner;
public class Vehicle {
    private String type;
    private int capacity;
    private int nbOfPeople;
    private String license;

    public Vehicle(String type, int capacity, String license) {
        this.type = type;
        this.capacity = capacity;
        this.license = license;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public boolean isFull() {
        if (capacity == nbOfPeople) {
            System.out.println("vehicle is full");
        }
        return true;
    }




}
