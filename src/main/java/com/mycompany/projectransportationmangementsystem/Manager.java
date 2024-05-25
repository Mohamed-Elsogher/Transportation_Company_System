/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectransportationmangementsystem;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Manager extends Employee {
    private List<Trip> trips;
    private List<Vehicle> vehicles;
    private List<Employee> employees;
    private List<Driver> drivers;
    private static final String TRIP_FILENAME = "trip.txt";
    private static final String VEHICLE_FILENAME = "vehicle.txt";
    private static final String EMPLOYEE_FILENAME = "employee.txt";
    
   
    
    public Manager(String name, String password, String Type, String ID) {
        super(name, password, Type , ID);
        this.trips = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.drivers = new ArrayList<>();

    }


    
    

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    public Vehicle createVehicle(Scanner scanner) {
        System.out.print("Enter vehicle type: ");
        String type = scanner.next();
        System.out.print("Enter vehicle capacity: ");
        int capacity = scanner.nextInt();
        System.out.print("Enter vehicle license plate: ");
        String licensePlate = scanner.next();

        Vehicle newVehicle = new Vehicle(type, capacity, licensePlate);
        vehicles.add(newVehicle);
        return newVehicle;
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }
    public boolean RemoveVehicle(Scanner scanner) {

        System.out.print("Enter vehicle license plate: ");
        String licensePlate = scanner.next();

        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getLicense().equals(licensePlate)) {
                vehicles.remove(i);
                return true;
            }
        }
        return false;
    }


    void addTrip(Trip trip) {
        trips.add(trip);
    }
    public Trip addTrip (Scanner scanner){

        System.out.print("The Trip from ");
        String start = scanner.next();

        System.out.println("destination ");
        String destination = scanner.next();

        System.out.println("Type of trip ");
        String Type = scanner.next();

        System.out.print("Number of stops");
        int stops = scanner.nextInt();

        System.out.print("availableSeats");
        int availableSeats = scanner.nextInt();

        System.out.println("Price ");
        double price = scanner.nextDouble();

        System.out.println("End");
        String end =scanner.next();

        System.out.println("vehicle ");
        String vehicle = scanner.next();

       return new Trip(start,destination,Type,stops,availableSeats,price,end);
    }

    public void cancelTrip(Trip trip) {
        trips.remove(trip);
    }

    public void assignDriver(Driver driver, Trip trip) {
        trip.setDriver(driver);
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder("Vehicles Report\n");

        for (Vehicle vehicle : vehicles) {
            report.append(vehicle.toString()).append("\n");
        }

        report.append("\nEmployees Report:\n");

        for (Employee employee : employees) {
            report.append("Name: ").append(employee.getName())
                    .append(", ID: ").append(employee.getID())
                    .append(", Type: ").append(employee.getType()).append("\n");
        }

        report.append("\nTrips Report:\n");
        for (Trip trip : trips) {
            report.append("Type: ").append(trip.getTicketType())
                    .append(", Start: ").append(trip.getStart())
                    .append(", Destination: ").append(trip.getDestination())
                    .append(", Price: ").append(trip.getPrice()).append("\n");
        }

        return report.toString();
    }

    public Trip selectTrip(Scanner scanner) {
        System.out.println("Available Trips:");
        for (int i = 0; i < trips.size(); i++) {
            System.out.println((i + 1) + ": " + trips.get(i).display());
        }
        System.out.print("Enter the number of the trip to cancel: ");
        int tripIndex = scanner.nextInt() - 1;
        if (tripIndex >= 0 && tripIndex < trips.size()) {
            return trips.get(tripIndex);
        } else {
            System.out.println("Invalid trip number.");
            return null;
        }
    }
    public List<Driver> getDrivers() {
        return drivers;
    }

 public String generateTripReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Trip Report:\n");
        try (BufferedReader reader = new BufferedReader(new FileReader(TRIP_FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                reportBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            return "Error reading trip file: " + e.getMessage();
        }
        return reportBuilder.toString();
    }

    public String generateVehicleReport() {
        return generateReportFromFile(VEHICLE_FILENAME, "Vehicle Report:");
    }

    public String generateEmployeeReport() {
        return generateReportFromFile(EMPLOYEE_FILENAME, "Employee Report:");
    }

    private String generateReportFromFile(String filename, String header) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(header).append("\n");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                reportBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            return "Error reading " + filename + " file: " + e.getMessage();
        }
        return reportBuilder.toString();
    }



    }









