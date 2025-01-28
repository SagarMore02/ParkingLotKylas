package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.Entity.Floor;
import com.kylas.ParkingLot.Entity.Slot;

import java.util.List;

public class FloorService {
    private Floor floor;
    public FloorService(){
        floor = new Floor();
    }

    public void addSlotsOfFloor(String floorId,List<Slot> listOfSlots){
        floor = new Floor(floorId,listOfSlots);
    }
    public Floor getFloor(){
        return floor;
    }
}
