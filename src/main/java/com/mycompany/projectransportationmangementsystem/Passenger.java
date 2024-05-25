/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectransportationmangementsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Passenger extends User {
    private String name;
    private String ID;
    private String ticketType;
    private String tripDetails;
    private ArrayList<Trip> bookedTrips;
    private List<Trip> SelectTrips;

    Passenger() {
      
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

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTripDetails() {
        return tripDetails;
    }

    public void setTripDetails(String tripDetails) {
        this.tripDetails = tripDetails;
    }

    public Passenger(String username, String password,String name, String ID, String ticketType, String tripDetails,int id) {
        super(username, password, "Passenger" , ID);
        this.name = name;
        this.ID = ID;
        this.ticketType = ticketType;
        this.tripDetails = tripDetails;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", tripDetails='" + tripDetails + '\'' +
                '}';
    }
    public void bookedTrips(Trip trip) {
        bookedTrips.add(trip);
        saveBookedTrip(trip);
    }
    private void saveBookedTrip(Trip trip) {
        try (FileWriter writer = new FileWriter("booked_trip.txt", true)) {
            writer.write(trip.display() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } }
    public void reviewTickets() {
        if (bookedTrips.isEmpty()) {
            System.out.println("No tickets booked.");
        } else {
            for (Trip trip : bookedTrips) {
                System.out.println("Booked Trip: " + trip.display());
            }
        }
    }
    public void cancelTrip(Trip trip) {
        bookedTrips.remove(trip);
         saveAllBookedTrips();
    }
    public void addTrip(Trip trip) {
        bookedTrips.add(trip);
        
    }
     private void saveAllBookedTrips() {
        try (FileWriter writer = new FileWriter("booked_trip.txt", false)) {
            for (Trip t : bookedTrips) {
                writer.write(t.display() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
     private List<Trip> readBookedTripsFromFile() {
        List<Trip> trips = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("booked_trip.txt"))) {
            trips = reader.lines()
                    .map(line -> {
                        
                        String[] details = line.split(", ");
                        
                        return new Trip(details[0], details[1], details[2], Integer.parseInt(details[3]), Integer.parseInt(details[4]), Double.parseDouble(details[5]), details[6]);
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trips;
    }







}

