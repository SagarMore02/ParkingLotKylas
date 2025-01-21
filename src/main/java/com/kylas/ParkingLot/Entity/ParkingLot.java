package com.kylas.ParkingLot.Entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private String parkinglot_id;
    private List<Floor> floors;

    public ParkingLot(){
        this.parkinglot_id="Admin101";
        floors = new ArrayList<>();
    }

    public String getParkinglot_id(){
        return  this.parkinglot_id;
    }
    public void setParkinglot_id(String parkinglot_id){
        this.parkinglot_id=parkinglot_id;
    }
    public List<Floor> getListOfFloorsInParkingLot(){
        return floors;
    }


}
