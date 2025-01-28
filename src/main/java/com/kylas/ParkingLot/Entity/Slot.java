package com.kylas.ParkingLot.Entity;

public class Slot {
    private String slotId;
    private String slotType;
    private String vehicleNumber;
    private boolean isSlotVacant;

    public Slot(){
        this.slotType ="Car";
        this.vehicleNumber =null;
        this.isSlotVacant =true;
    }
    public Slot(String slot_id ,String slot_type){
        this.slotId =slot_id;
        this.slotType =slot_type;
        this.vehicleNumber =null;
        this.isSlotVacant =true;
    }
    public  boolean getSlotVacancy(){return this.isSlotVacant;}

    public String getSlotType() {
        return this.slotType;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    public boolean isSlotVacant() {
        return isSlotVacant;
    }

    public void setSlotVacant(boolean slotVacant) {
        this.isSlotVacant = slotVacant;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSlotId() {
        return slotId;
    }

    public void occupySlot(){
        this.isSlotVacant = false;
    }

}
