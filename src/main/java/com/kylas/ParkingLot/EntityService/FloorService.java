package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.Entity.Floor;
import com.kylas.ParkingLot.Entity.Slot;

import java.util.ArrayList;
import java.util.List;

public class FloorService {
    private Floor floor;
    public FloorService(){
        floor = new Floor();
    }

    public void addSlotsOfFloor(String floor_id,List<SlotService> list_of_slots_service){
        List<Slot> list_of_slots = new ArrayList<>();
        for(SlotService slotService : list_of_slots_service){
                list_of_slots.add(slotService.getSlot());
        }
        floor = new Floor(floor_id,list_of_slots);      //(char)(64+floor_number+1)+"",list_of_slots){
    }

    public Floor getFloor(){
        return floor;
    }
}
