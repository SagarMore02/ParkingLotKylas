package com.kylas.ParkingLot.EntityService;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotServiceTest {

    @Test
    void givenVehicleService_whenVacantSlotsAvailable_ShouldGIveTrue() throws IOException {
        //Given
        ParkingLotService parkingLotService = new ParkingLotService();
        parkingLotService.createParkingLot(2,3);
        VehicleService vehicleService = new VehicleService();
        vehicleService.acceptTypeofVehicle("Car");

        //When
        boolean result = parkingLotService.checkForVacancy(vehicleService);

        //Then
        assertTrue(result);
    }

    @Test
    void givenVehicleService_whenVacantSlotsUnavailable_ShouldGIveTrue() throws IOException {
        //Given
        ParkingLotService parkingLotService = new ParkingLotService();
        parkingLotService.createParkingLot(0,3);
        VehicleService vehicleService = new VehicleService();
        vehicleService.acceptTypeofVehicle("Car");

        //When
        boolean result = parkingLotService.checkForVacancy(vehicleService);

        //Then
        assertFalse(result);
    }
}