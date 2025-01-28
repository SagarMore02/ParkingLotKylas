package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.Entity.Slot;
import com.kylas.ParkingLot.Entity.Vehicle;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ReactiveHttpOutputMessage;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;
class ParkingLotServiceTest {
    ParkingLotService parkingLotService = new ParkingLotService(2,3);
    @Test
    public void givenVehicle_WhenGetVacantSlot_ThenShouldGetFirstVacantSlot(){
        //Given
        Vehicle vehicle = new Vehicle("Car","MH14KH4694");

        //When
        Slot slot = parkingLotService.getVacantSlotToPark(vehicle).getSlot();

        //Then
        Assertions.assertThat(slot.getSlotVacancy()).isEqualTo(true);
    }

    @Test
    public void givenVehicle_WhenGetVacantSlot_ThenShouldGetFirstVacantSlotWithSameType(){
        //Given
        Vehicle vehicle = new Vehicle("Car","MH14KH4694");

        //When
        Slot slot = parkingLotService.getVacantSlotToPark(vehicle).getSlot();

        //Then
        Assertions.assertThat(slot.getSlotType()).isEqualTo("Car");
    }
}