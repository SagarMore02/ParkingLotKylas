package com.kylas.ParkingLot.Entity;

public class Ticket {
    static int countId =0;
    private Integer ticketId =0;
    private String slotId;
    private String floorId;
    private String vehicleNumber;

    public Ticket(){
    }
    public Ticket(String slot_id, String floorId, String vehicleNumber){
        countId++;
        this.ticketId = countId;
        this.slotId =slot_id;
        this.floorId =floorId;
        this.vehicleNumber =vehicleNumber;
    }

    public void setTicketId(Integer ticketId){
        this.ticketId = ticketId;
    }

    public String getSlotID() {
        return slotId;
    }

    public String getFloorID() {
        return floorId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getTicketID() {
        return ticketId;
    }

    public void setSlotId(String slotId) {
        this.slotId =slotId;
    }

    public void setFloorId(String c) {
        this.floorId =c;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber =vehicleNumber;
    }
}
