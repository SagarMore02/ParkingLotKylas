package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.Entity.Vehicle;
import com.kylas.ParkingLot.MyExceptions.InvalidChoiceException;
import com.kylas.ParkingLot.MyExceptions.VehicleAlreadyExistsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VehicleService {
    private Vehicle vehicle ;
    public VehicleService(){
        vehicle=new Vehicle();
    }
    public String getVehicle_number(){
        return  vehicle.getVehicle_number();
    }
    public String getVehicleType(){
        return vehicle.getVehicle_type();
    }



    public void acceptTypeofVehicle(String type_of_vehicle){
        try {
            if(type_of_vehicle.equals("Car") || type_of_vehicle.equals("Bike") || type_of_vehicle.equals("Truck"))
                this.vehicle.setVehicleType(type_of_vehicle);
            else
                throw new InvalidChoiceException("Selection of Invalid Type Entry");

        }catch (InvalidChoiceException invalidChoiceException) {
            System.out.println(invalidChoiceException.getMessage());
            System.out.println("Please Enter From Menu Only!!");
            throw new InvalidChoiceException(invalidChoiceException.getMessage());
            //acceptTypeofVehicle(type_of_vehicle);
        }catch (NumberFormatException numberFormatException){
            System.out.println("Please Select From Displayed Menu Only!!");
            //acceptTypeofVehicle();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean acceptNumberofVehicle(String number_of_vehicle)throws Exception{
        Vehicle checkVehicle=null;
        if(!checkValidityOfNumber(number_of_vehicle))return false;
        try {
            checkVehicle = Vehicle.getListOfVehicles()
                    .stream()
                    .filter(vehicle1 -> vehicle1.getVehicle_number().equals(number_of_vehicle))
                    .findFirst()
                    .orElse(null);

            if(checkVehicle!=null) throw new VehicleAlreadyExistsException("The number you are trying to enter is already parked try unparking vehicle!!");

            Vehicle.getListOfVehicles().add(this.vehicle);
            this.vehicle.setVehicleNumber(number_of_vehicle);
            return true;

        } catch (VehicleAlreadyExistsException vehicleAlreadyExistsException) {
            throw new VehicleAlreadyExistsException(vehicleAlreadyExistsException.getMessage());//System.out.println(vehicleAlreadyExistsException.getMessage());
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

     public boolean checkValidityOfNumber(String number_of_vehicle) {
        if(number_of_vehicle.length() != 10)return false;
        if(Character.isLetter(number_of_vehicle.charAt(0)) && Character.isLetter(number_of_vehicle.charAt(1))) {
            if (Character.isDigit(number_of_vehicle.charAt(2)) && Character.isDigit(number_of_vehicle.charAt(3))) {
                if (Character.isLetter(number_of_vehicle.charAt(4)) && Character.isLetter(number_of_vehicle.charAt(5))) {
                    for (int lastFourDigit = 6; lastFourDigit < 10; lastFourDigit++) {
                        if (!Character.isDigit(number_of_vehicle.charAt(lastFourDigit))) {
                            return false;
                        }
                    }
                } else return false;
            } else return false;
        }else return false;
        return true;
    }
}
