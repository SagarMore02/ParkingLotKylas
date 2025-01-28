package com.kylas.ParkingLot.Entity;

public class VacantSlotFloor {
    private Slot slot;
    private Floor floor;
    public VacantSlotFloor(Slot slot, Floor floor){
        this.slot=slot;
        this.floor=floor;
    }

    public Floor getFloor() {
        return floor;
    }

    public Slot getSlot() {
        return slot;
    }
}
