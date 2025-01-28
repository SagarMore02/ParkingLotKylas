package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.Entity.Slot;
import com.kylas.ParkingLot.Entity.Vehicle;

public class SlotService {
    private Slot slot;
    public SlotService(){
            slot = new Slot();
    }

    public void parkAtSlot(Slot vacantSlot, Vehicle vehicle){
        vacantSlot.setVehicleNumber(vehicle.getVehicleNumber());
        vacantSlot.occupySlot();
    }

    public void freeSlot(Slot slot_to_free) {
        slot_to_free.setSlotVacant(true);
        slot_to_free.setVehicleNumber(null);
    }
}
