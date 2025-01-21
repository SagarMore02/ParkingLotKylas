package com.kylas.ParkingLot.Entity;

public class Slot {
    private String slot_id;
    private String slot_type;
    private String vehicle_number;
    private boolean is_slot_vacant;

    public Slot(){
        this.slot_type="Car";
        this.vehicle_number=null;
        this.is_slot_vacant=true;
    }
    public Slot(String slot_id ,String slot_type){
        this.slot_id=slot_id;
        this.slot_type=slot_type;
        this.vehicle_number=null;
        this.is_slot_vacant=true;
    }
    public  boolean getSlotVacancy(){return this.is_slot_vacant;}

    public String getSlot_type() {
        return this.slot_type;
    }

    public void setSlot_type(String slot_type) {
        this.slot_type = slot_type;
    }

    public boolean isIs_slot_vacant() {
        return is_slot_vacant;
    }

    public void setIs_slot_vacant(boolean is_slot_vacant) {
        this.is_slot_vacant = is_slot_vacant;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public String getSlot_id() {
        return slot_id;
    }

    public void occupySlot(){
        this.is_slot_vacant = false;
    }

}
