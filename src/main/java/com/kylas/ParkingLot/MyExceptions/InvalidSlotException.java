package com.kylas.ParkingLot.MyExceptions;

public class InvalidSlotException extends RuntimeException {
    public InvalidSlotException(String message) {
        super(message);
    }
}
