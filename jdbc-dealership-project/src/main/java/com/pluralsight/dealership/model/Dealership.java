package com.pluralsight.dealership.model;

import java.util.ArrayList;

public class Dealership {
    // dealership fields
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Vehicle> inventory;

    //dealership constructor
    public Dealership(String name, String address, String phoneNumber, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventory = inventory;
    }

    // method to add vehicle
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    // returns inventory arraylist
    public ArrayList<Vehicle> getAllVehicles(){
        if(inventory.isEmpty()){
            System.out.println("No vehicles available at the moment.");
        }
        return inventory;
    }

    //filters vehicles by price
    public ArrayList<Vehicle> getVehiclesByPrice(int min, int max){
        ArrayList<Vehicle> filteredVehiclesByPrice = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                filteredVehiclesByPrice.add(vehicle);
            }
        }
        noMatchCaseHandling(filteredVehiclesByPrice);

        return filteredVehiclesByPrice; // Return the filtered list
    }
    // filters vehicles by make and model
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> filteredVehiclesByMakeModel = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                filteredVehiclesByMakeModel.add(vehicle);
            }
        }
        noMatchCaseHandling(filteredVehiclesByMakeModel);
        return filteredVehiclesByMakeModel;
    }

    // filters vehicles by year
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> filteredVehiclesByYear = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                filteredVehiclesByYear.add(vehicle);
            }
        }
        noMatchCaseHandling(filteredVehiclesByYear);

        return filteredVehiclesByYear;

    }

    // filters vehicles by colors
    public ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> filteredVehiclesByColor = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if(vehicle.getColor().equalsIgnoreCase(color)){
                filteredVehiclesByColor.add(vehicle);
            }
        }
        noMatchCaseHandling(filteredVehiclesByColor);

        return filteredVehiclesByColor;
    }

    // filters vehicles by odometer/mileage
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> filteredVehiclesByMileage = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                filteredVehiclesByMileage.add(vehicle);
            }
        }
        noMatchCaseHandling(filteredVehiclesByMileage);
        return filteredVehiclesByMileage;
    }

    // filters vehicles by type
    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> filteredVehiclesByType = new ArrayList<>();
        for(Vehicle vehicle : inventory) {
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                filteredVehiclesByType.add(vehicle);
            }
        }
        noMatchCaseHandling(filteredVehiclesByType);
        return filteredVehiclesByType;
    }

    // filters vehicles by vin
    public Vehicle findVehicleByVin(int vin){
        Vehicle vehicle = null;
        for(Vehicle v : inventory) {
            if(v.getVin() == vin) {
                vehicle = v;
            }
        }
        return vehicle;
    }

    // remove vehicle method
    public void removeVehicle(Vehicle v){

        inventory.remove(v);

    }

    // helper method if filters arrays are empty from other methods
    public void noMatchCaseHandling(ArrayList<Vehicle> vehicles){
        if(vehicles.toArray().length < 1) {
            System.out.println("No matching vehicles.");
        }
    }

    // to string override method for formatted arraylist printing
    @Override
    public String toString() {
        return String.format("Dealership: %s, Address: %s, Phone Number: %s \n Inventory: \n%s",
                name,address,phoneNumber,inventory);
    }

    // getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }
}
