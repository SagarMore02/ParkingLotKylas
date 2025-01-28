package com.kylas.ParkingLot.Entity;

import com.kylas.ParkingLot.MyExceptions.InvalidVehicleNumberException;
import com.kylas.ParkingLot.MyExceptions.InvalidVehicleTypeException;

public class Vehicle {
    private String vehicleType;
    private String vehicleNumber;
    public Vehicle(String vehicleType,String vehicleNumber){
        this.vehicleType=vehicleType;
        this.vehicleNumber=vehicleNumber;
        validateNumber();
        validateType();
    }

    private void validateType() {
        if(vehicleType.equals("Car")||vehicleType.equals("Bike")||vehicleType.equals("Truck"))return;
        throw new InvalidVehicleTypeException("The Vehicle Type You Entered is Invalid");
    }

    public void validateNumber(){
        if(vehicleNumber.length() != 10)throw new InvalidVehicleNumberException("Vehicle Number Count Cannot Be Less Than 10");
        if(Character.isLetter(vehicleNumber.charAt(0)) && Character.isLetter(vehicleNumber.charAt(1))) {
            if (Character.isDigit(vehicleNumber.charAt(2)) && Character.isDigit(vehicleNumber.charAt(3))) {
                if (Character.isLetter(vehicleNumber.charAt(4)) && Character.isLetter(vehicleNumber.charAt(5))) {
                    for (int lastFourDigit = 6; lastFourDigit < 10; lastFourDigit++) {
                        if (!Character.isDigit(vehicleNumber.charAt(lastFourDigit))) {
                            throw new InvalidVehicleNumberException("Invalid Vehicle Number");
                        }
                    }
                } else throw new InvalidVehicleNumberException("Invalid Vehicle Number");;
            } else throw new InvalidVehicleNumberException("Invalid Vehicle Number");;
        }else throw new InvalidVehicleNumberException("Invalid Vehicle Number");
    }
    public String getVehicleNumber(){
        return this.vehicleNumber;
    }
    public void setVehicleType(String typeofvehicle) {
        this.vehicleType = typeofvehicle;
    }
    public String getVehicleType(){
        return this.vehicleType;
    }
//    public void setVehicleNumber(String numberofvehicle) {
//        this.vehicleNumber =numberofvehicle;
//    }
}
