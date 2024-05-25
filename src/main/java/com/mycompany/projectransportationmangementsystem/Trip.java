/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectransportationmangementsystem;

public class Trip {
    private String start; // نقطه البدايه
    private String destination; // المسافه
    private String TicketType; // ذهاب ولا ذهاب وعوده
    private int NumberOfStops; // المناطق ال هيقف فيها
    private int availableSeats; // الاماكن الموجوده
    private double price; // السعر
    private String end; // نقط النهايه
    Passenger passenger;
    Vehicle vehicle;
    private Driver assignedDriver;


    public Trip( String start, String destination, String TicketType, int stops, int availableSeats, double price , String end) {

        this.start = start;
        this.destination = destination;
        this.TicketType = TicketType;
        this.NumberOfStops = stops;
        this.availableSeats = availableSeats;
        this.price = price;
        this.end = end;
        this.passenger = passenger;
        this.vehicle = vehicle;
    }
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTicketType() {
        return TicketType;
    }

    public void setTicketType(String TicketType) {
        this.TicketType = TicketType;
    }

    public int getStops() {
        return NumberOfStops;
    }

    public void setStops(int stops) {
        this.NumberOfStops = stops;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String display() {
        return "Trip{" +
                "start='" + start + '\'' +
                ", destination='" + destination + '\'' +
                ", TicketType='" + TicketType + '\'' +
                ", stops=" + NumberOfStops +
                ", availableSeats=" + availableSeats +
                ", price=" + price +
                ", end='" + end + '\'' +
                '}';
    }
    public void setDriver(Driver driver) {
        this.assignedDriver = driver;
    }
public Object[] toArray() {
        return new Object[]{start, end, destination, };
    }
}
