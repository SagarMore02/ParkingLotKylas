package com.kylas.ParkingLot.Entity;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    static int count_id=0;
    private Integer ticket_id=0;
    private String slot_id;
    private String floor_id;
    private String vehicle_number;
    static List<Ticket> list_of_issued_tickets = new ArrayList<>();
    public Ticket(){
    }
    public Ticket(String slot_id, String floor_id, String vehicle_number){
        count_id++;
        this.ticket_id=count_id;
        this.slot_id=slot_id;
        this.floor_id=floor_id;
        this.vehicle_number=vehicle_number;
    }

    public static List<Ticket> getList_of_issued_tickets(){
        return list_of_issued_tickets;
    }

    public static void setList_of_issued_tickets(Ticket ticket){
        list_of_issued_tickets.add(ticket);
    }

    public void setTicket_id(Integer ticket_id){
        this.ticket_id = ticket_id;
    }

    public String getSlotID() {
        return slot_id;
    }

    public String getFloorID() {
        return floor_id;
    }

    public String getVehicleNumber() {
        return vehicle_number;
    }

    public int getTicketID() {
        return ticket_id;
    }

    public void setSlotId(String slotId) {
        this.slot_id=slotId;
    }

    public void setFloorId(String c) {
        this.floor_id=c;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicle_number=vehicleNumber;
    }
}
