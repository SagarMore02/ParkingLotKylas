package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.Entity.Slot;
import com.kylas.ParkingLot.Entity.Ticket;

public class TicketService {
    Ticket ticket;
    public TicketService(){
        ticket = new Ticket();
    }

    public String getSlotID() {
        return ticket.getSlotID();
    }

    public String getFloorID() {
        return ticket.getFloorID();
    }

    public String getVehicleNumber() {
        return ticket.getVehicleNumber();
    }

    public int getTicketID() {
        return ticket.getTicketID();
    }


    public void parkVehicle(ParkingLotService parkinglot_service, VehicleService vehicleService) {
        SlotService slotService = new SlotService();
        Slot vacnatSlot = slotService.getSlot();
        vacnatSlot= parkinglot_service
                .getFloorsInParkingLot()
                .stream()
                .flatMap(floor -> floor.getSlots().stream())
                .filter(slot1 -> slot1.getSlot_type().equals(vehicleService.getVehicleType()))
                .filter(Slot::getSlotVacancy)
                .findFirst()
                .orElse(null);
        slotService.parkAtSlot(vacnatSlot,vehicleService);
        createTicket(vacnatSlot,vehicleService);
    }

    public boolean checkValidityOfTicket(int ticketNumber) {
        return Ticket.getList_of_issued_tickets()
                .stream()
                .anyMatch(ticket -> ticket.getTicketID() == ticketNumber);
    }


    public void createTicket(Slot slot,VehicleService vehicleService) {
        this.ticket = new Ticket(slot.getSlot_id(),slot.getSlot_id().charAt(0)+"",vehicleService.getVehicle_number());
        Ticket.getList_of_issued_tickets().add(this.ticket);
    }

    public void printTicket(){
        System.out.println("Your Ticket Number is   : "+this.getTicketID());
        System.out.println("Your Vehicle Number is  : "+this.getVehicleNumber());
        System.out.println("Vehicle Parked on Floor : "+this.getFloorID());
        System.out.println("Vehicle Parked on Slot  : "+this.getSlotID());
    }

    public void freeVehicle(ParkingLotService parkingLotService,int ticketNumber) {

            this.ticket = Ticket.getList_of_issued_tickets()
                            .stream()
                            .filter(ticket -> ticket.getTicketID() == ticketNumber)
                            .findFirst()
                            .orElse(null);


            Slot slot = parkingLotService
                                .getFloorsInParkingLot()
                                .stream()
                                .flatMap(floor -> floor.getSlots().stream())
                                .filter(slot1 -> !slot1.getSlotVacancy())
                                .filter(slot1 -> slot1.getVehicle_number()!=null)
                                .filter(slot1 -> slot1.getVehicle_number().equals(this.getVehicleNumber()))
                                .findFirst()
                                .orElse(null);
            SlotService slotService = new SlotService();

            System.out.println("Exiting Vehicle Details: ");
            printTicket();
            slotService.freeSlot(slot);
            freeTicket();
    }

    public void freeTicket(){
        Ticket.getList_of_issued_tickets().remove(this.ticket);
        this.ticket.setTicket_id(null);
        this.ticket.setFloorId(null);
        this.ticket.setSlotId(null);
        this.ticket.setVehicleNumber(null);

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
