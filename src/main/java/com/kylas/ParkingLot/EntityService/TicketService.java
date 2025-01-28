package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.Entity.Slot;
import com.kylas.ParkingLot.Entity.Ticket;

public class TicketService {
    Ticket ticket;
    public TicketService(){
        ticket = new Ticket();
    }

    public void printTicket(Ticket ticket){
        System.out.println("Your Ticket Number is   : "+ticket.getTicketID());
        System.out.println("Your Vehicle Number is  : "+ticket.getVehicleNumber());
        System.out.println("Vehicle Parked on Floor : "+ticket.getFloorID());
        System.out.println("Vehicle Parked on Slot  : "+ticket.getSlotID());
    }

    public void freeTicket(Ticket ticket){
        ticket.setTicketId(null);
        ticket.setFloorId(null);
        ticket.setSlotId(null);
        ticket.setVehicleNumber(null);
    }

    public Slot getSlotWhereVehicleIsParked(ParkingLotService parkingLotService, Ticket ticket) {
        Slot slot = parkingLotService
                .getFloorsInParkingLot()
                .stream()
                .flatMap(floor -> floor.getSlots().stream())
                .filter(slot1 -> !slot1.getSlotVacancy())
                .filter(slot1 -> slot1.getVehicleNumber()!=null)
                .filter(slot1 -> slot1.getVehicleNumber().equals(ticket.getVehicleNumber()))
                .findFirst()
                .orElse(null);
        return slot;
    }
}
















//        Floor floor_of_slot = parkinglot_service.getFloorsInParkingLot().stream()
//                .filter(floor -> floor.getSlots().stream()
//                        .anyMatch(slot -> slot.getSlot_id() == vacant_slot.getSlot_id())) // Check if the floor contains the vacant slot
//                .findFirst()
//                .orElse(null);
//        if(floor_of_slot!=null){

//            this.ticket.slot_id = vacant_slot.slot_id;
//            this.ticket.floor_id=floor_of_slot.getFloor_id();
//            this.ticket.vehicle_id = vehicleService.getVehicle_number());
//            ticketService.add(storingTicket);
//            //vacant_slot.parkAtSlot();
//            showTicket(storingTicket);
//
//        }else System.out.println("Problem!!");
//   }
