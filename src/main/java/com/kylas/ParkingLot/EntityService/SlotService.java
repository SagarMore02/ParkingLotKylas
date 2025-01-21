package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.Entity.Slot;

public class SlotService {
    private Slot slot;
    public SlotService(){
            slot = new Slot();
    }
    public SlotService(String slot_id , String slotType){
        slot = new Slot(slot_id,slotType);
    }
    public Slot getSlot(){
        return slot;
    }

    public void parkAtSlot(Slot vacantSlot,VehicleService vehicleService){
        vacantSlot.setVehicle_number(vehicleService.getVehicle_number());
        vacantSlot.occupySlot();
    }

    public void freeSlot(Slot slot_to_free) {
        slot_to_free.setIs_slot_vacant(true);
        slot_to_free.setVehicle_number(null);
    }
}
