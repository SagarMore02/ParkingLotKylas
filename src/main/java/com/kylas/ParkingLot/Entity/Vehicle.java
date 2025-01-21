package com.kylas.ParkingLot.Entity;

import java.util.ArrayList;
import java.util.List;
public class Vehicle {
    private int vehicle_id;
    static int vehicle_count=0;
    private String vehicle_type;
    private String vehicle_number;
    private static List<Vehicle> list_of_vehicles = new ArrayList<>();
    public Vehicle(){
        vehicle_count++;
        vehicle_id=vehicle_count;
    }
    public static List<Vehicle> getListOfVehicles() {
        return list_of_vehicles;
    }

    public String getVehicle_number(){
        return this.vehicle_number;
    }

    public void setVehicleType(String typeofvehicle) {
        this.vehicle_type = typeofvehicle;
    }
    public String getVehicle_type(){
        return this.vehicle_type;
    }
    public void setVehicleNumber(String numberofvehicle) {
        this.vehicle_number=numberofvehicle;
    }
}
