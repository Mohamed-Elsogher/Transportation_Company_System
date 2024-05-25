/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectransportationmangementsystem;

public class Employee extends User{
    private String name;
    private String password;
    private String ID;
    private String Type;

    public Employee(String username, String password, String userType, String name, String ID, String type) {
        super(username, password, userType, ID);
        this.name = name;
        this.ID = ID;
        this.Type = type;
    }
    public Employee(String name, String password, String type, String id) {
        this.name = name;
        this.ID = ID;
        this.Type = type;
        this.ID = id ;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }



}
