package com.kylas.ParkingLot.MyExceptions;

public class InvalidVehicleTypeException extends RuntimeException {
    public InvalidVehicleTypeException(String message) {
        super(message);
    }
}
