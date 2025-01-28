package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.Entity.Slot;
import com.kylas.ParkingLot.Entity.Vehicle;
import org.assertj.core.api.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class SlotServiceTest {
    SlotService slotService = new SlotService();
    Vehicle vehicle;
    Slot slot;
    @Test
    public void givenVacantSlot_WhenVehicleParkedAtSlot_ThenSlotShouldBeOccupied(){
        //Given
         slot = new Slot("TestSlot","Car");
         vehicle = new Vehicle("Car","MH14KH4694");

        //When
        slotService.parkAtSlot(slot,vehicle);

        //Then
        Assertions.assertThat(slot.getSlotVacancy()).isEqualTo(false);
    }

    @Test
    public void givenOccupiedSlot_WhenUnparked_ThenSlotShouldBeFreed(){
        //Given
        slot = new Slot("TestSlot","Car");
        vehicle = new Vehicle("Car","MH14KH4694");
        slotService.parkAtSlot(slot,vehicle);

        //When
        slotService.freeSlot(slot);

        //Then
        Assertions.assertThat(slot.getSlotVacancy()).isEqualTo(true);
    }

}