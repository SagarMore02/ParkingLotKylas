package com.kylas.ParkingLot.MyExceptions;

public class InvalidVehicleNumberException extends RuntimeException {
    public InvalidVehicleNumberException(String message) {
        super(message);
    }
}
