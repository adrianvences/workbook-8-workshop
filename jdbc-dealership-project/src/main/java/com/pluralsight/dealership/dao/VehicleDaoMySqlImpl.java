package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.Vehicle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// responsible for interacting with vehicles and inventory tables
public class VehicleDaoMySqlImpl implements VehicleDao {

    private DataSource dataSource;

    public VehicleDaoMySqlImpl(DataSource dataSource) {this.dataSource = dataSource;};

    @Override
    public List<Vehicle> findAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement findAllVehicles = connection.prepareStatement("""
                    SELECT make,model,year,color,odometer,price,vin,vehicleType, sold
                    FROM vehicles
                    ORDER BY price;
                    """);
            ResultSet rs = findAllVehicles.executeQuery();
            while(rs.next()) {
                String make = rs.getString("make");
                String model = rs.getString("model");
                int year = rs.getInt("year");
                String color = rs.getString("color");
                int odometer = rs.getInt("odometer");
                double price = rs.getDouble("price");
                String vin = rs.getString("vin");
                boolean sold = rs.getBoolean("sold");
                String vehicleType = rs.getString("vehicleType");

                if(!sold) {
                    vehicles.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vehicles;
    }

    @Override
    public List<Vehicle> findAllAvailableVehicles() {
        return List.of();
    }

    @Override
    public List<Vehicle> findVehiclesByPriceRange(double minPrice, double maxPrice) {

        List<Vehicle> vehicles = new ArrayList<>();

        String query = """
                SELECT * 
                FROM vehicles
                WHERE price BETWEEN ? AND ?
                """;

        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(query);
            ps.setDouble(1, minPrice);
            ps.setDouble(2, maxPrice);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String make = rs.getString("make");
                String model = rs.getString("model");
                int year = rs.getInt("year");
                String color = rs.getString("color");
                int odometer = rs.getInt("odometer");
                double price = rs.getDouble("price");
                String vin = rs.getString("vin");
                boolean sold = rs.getBoolean("sold");
                String vehicleType = rs.getString("vehicleType");
                vehicles.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return vehicles;
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
