package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.Vehicle;

import java.util.List;

// responsible for interacting with vehicles and inventory tables
public class VehicleDaoMySqlImpl implements VehicleDao {
    @Override
    public List<Vehicle> findAllVehicles() {
        return List.of();
    }

    @Override
    public List<Vehicle> findAllAvailableVehicles() {
        return List.of();
    }

    @Override
    public List<Vehicle> findVehiclesByPriceRange(double min, double max) {
        return List.of();
    }

    @Override
    public List<Vehicle> findVehiclesByMakeModel(String make, String model) {
        return List.of();
    }

    @Override
    public List<Vehicle> findVehiclesByYear(int minYear, int maxYear) {
        return List.of();
    }

    @Override
    public List<Vehicle> findVehicleByColor(String color) {
        return List.of();
    }

    @Override
    public List<Vehicle> findVehicleByMileRange(int minOdom, int maxOdom) {
        return List.of();
    }

    @Override
    public List<Vehicle> findVehicleByVehicleType(String vehicleType) {
        return List.of();
    }

    @Override
    public Vehicle findVehicleByVIN(int vin) {
        return null;
    }

    @Override
    public void removeVehicleByVIN(int vin) {

    }

    @Override
    public void addVehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {

    }
}
