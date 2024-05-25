/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectransportationmangementsystem;

import java.util.ArrayList;
import java.util.List;
public class Driver extends Employee{
    String name;
    String id ;
    private List<Trip> assignedTrips;
    public Driver(String username, String password, String userType, String name, String ID, String type, int id) {
        super(username, password, userType, name, ID, type );
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public List<Trip> getAssignedTrips() {
        return assignedTrips;
    }
    public void accessBasicInfo() {

    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", scanner=" + scanner +
                '}';
    }
}
