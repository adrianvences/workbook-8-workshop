package com.pluralsight.dealership;

import com.pluralsight.dealership.model.Dealership;
import com.pluralsight.dealership.model.Vehicle;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    // Gets data from csv file and create a dealership along with inventory
    public Dealership getDealership(){
        ArrayList<Vehicle> inventory = new ArrayList<>();
        Dealership dealership = null;

        // finds file to read
        try {
            // Create a FileReader to read the contents of the "inventory.csv" file located in the "src/main/resources/Data" directory.
            FileReader fileReader = new FileReader("src/main/resources/Data/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // temporarily stores data from file.
            String input;

            // reads first line of dealership file
            if((input = bufferedReader.readLine()) != null) {
                String[] dealerShipInfo = input.split("\\|");
                if(dealerShipInfo.length != 3){
                    System.out.println("Invalid dealership format");
                    return null;
                }
                int id = 1;
                String name = dealerShipInfo[0];
                String address = dealerShipInfo[1];
                String phoneNumber = dealerShipInfo[2];

                // initialize the dealership object
                dealership = new Dealership(id,name, address,phoneNumber);
            } else {
                System.out.println("dealership file is empty");
                return null;
            }

            // reads each line of file after header
            while((input = bufferedReader.readLine()) != null){
                String[] vehicleData = input.split("\\|");
                int vin = Integer.parseInt(vehicleData[0]);
                int year = Integer.parseInt(vehicleData[1]);
                String make = vehicleData[2];
                String model = vehicleData[3];
                String vehicleType = vehicleData[4];
                String color = vehicleData[5];
                int odometer = Integer.parseInt(vehicleData[6]);
                double price = Double.parseDouble(vehicleData[7]);

                // initialize each vehicle object
                Vehicle vehicle = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
                // adds vehicle object to inventory
                inventory.add(vehicle);

            }
            // closes reader to prevent memory leaks
            bufferedReader.close();
            // returns dealership that other methods can use.
            return dealership;
        } catch (Exception e) {
            System.out.println("error reading file");
            e.printStackTrace();
        }

        return dealership;
    }


}
