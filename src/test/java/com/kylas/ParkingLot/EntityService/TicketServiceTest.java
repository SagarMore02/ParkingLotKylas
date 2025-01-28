package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.Entity.Slot;
import com.kylas.ParkingLot.Entity.Ticket;
import com.kylas.ParkingLot.Entity.VacantSlotFloor;
import com.kylas.ParkingLot.Entity.Vehicle;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
class TicketServiceTest {
    @Mock
    ParkingLotService parkingLotService = new ParkingLotService(2,3);
    SlotService slotService = new SlotService();
    Slot slotWhereVehicleIsParked;
    Ticket ticket;
    Vehicle vehicle;
    VacantSlotFloor vacantSlotFloorslot;

    public void setMockVariables(String vehicleType,String vehicleNumber){
        vehicle = new Vehicle(vehicleType, vehicleNumber);
        vacantSlotFloorslot = parkingLotService.getVacantSlotToPark(vehicle);
        slotWhereVehicleIsParked = vacantSlotFloorslot.getSlot();
        slotService.parkAtSlot(vacantSlotFloorslot.getSlot(),vehicle);
        ticket = new Ticket(vacantSlotFloorslot.getSlot().getSlotId(),vacantSlotFloorslot.getFloor().getFloor_id(),vehicle.getVehicleNumber());
    }

    @Test
    public void givenTicket_WhengetSlotWhereVehicleIsParked_ThenShouldGetSlotWhereVehicleParked() {
        //Given
        setMockVariables("Car","MH12KH46934");

        //When
        Slot testReturnedSlot = new TicketService().getSlotWhereVehicleIsParked(parkingLotService,ticket);

        //Then
        Assertions.assertThat(testReturnedSlot).isEqualTo(slotWhereVehicleIsParked);

    }
}