package com.kylas.ParkingLot.MyExceptions;

public class NoSlotFreeException extends RuntimeException {
    public NoSlotFreeException(String message) {
        super(message);
    }
}
