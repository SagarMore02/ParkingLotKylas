package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.Entity.Slot;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SlotServiceTest {
    @Test
    public void givenVehicleservice_WhenParked_ThenSlotVacantShouldBeFalse(){
        //Given
        Slot slot = new Slot("A1","Car");
        SlotService slotService = new SlotService();
        VehicleService vehicleService = new VehicleService();
        String number_of_vehicle = "MH14KH4694";
        String type_of_vehicle = "Bike";
        vehicleService.acceptTypeofVehicle(type_of_vehicle);
        vehicleService.checkValidityOfNumber(number_of_vehicle);

        //When
        slotService.parkAtSlot(slot,vehicleService);

        //Then
        assertFalse(slot.isIs_slot_vacant());
    }

    @Test
    public void givenVehicleservice_WhenFreed_ThenSlotVacantShouldBeTrue() {
        //Given
        Slot slot = new Slot("A1","Car");
        SlotService slotService = new SlotService();
        VehicleService vehicleService = new VehicleService();
        String number_of_vehicle = "MH14KH4694";
        String type_of_vehicle = "Bike";
        vehicleService.acceptTypeofVehicle(type_of_vehicle);
        vehicleService.checkValidityOfNumber(number_of_vehicle);
        slotService.parkAtSlot(slot,vehicleService);
        
        //When
        slotService.freeSlot(slot);
        
        //Then
        assertTrue(slot.isIs_slot_vacant());
    }
}