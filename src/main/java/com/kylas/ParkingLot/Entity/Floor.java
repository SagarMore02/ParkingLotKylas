package com.kylas.ParkingLot.Entity;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private   String floor_id;
    //Change Access Specifier Later
    private List<Slot> slots ;

    public Floor(){
        this.floor_id=null;
        slots=new ArrayList<>();
    }
    public Floor(String floor_id, List<Slot> slots){
        this.floor_id=floor_id;
        this.slots=slots;
    }
    public List<Slot> getSlots(){
        return slots;
    }
    public String getFloor_id(){
        return floor_id;
    }
}


