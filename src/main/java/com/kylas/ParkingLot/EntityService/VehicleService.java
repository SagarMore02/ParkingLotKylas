package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.Entity.Vehicle;

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



    public void acceptTypeofVehicle()throws IOException{
        int vehicletypenumber=-1;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Number To Select Type Of Vehicle:\n1. Car\n2.Truck\n3. Bike");
            vehicletypenumber = Integer.parseInt(br.readLine());
            if(vehicletypenumber>3 || vehicletypenumber<1) throw new InvalidChoiceException("Selection of Invalid Type Entry");
            switch (vehicletypenumber) {
                case 1:
                    this.vehicle.setVehicleType("Car");
                    break;
                case 2:
                    this.vehicle.setVehicleType("Truck");
                    break;
                case 3:
                    this.vehicle.setVehicleType("Bike");
                    break;
                default:
                    System.out.println("Invalid Input!!!");
            }
        }catch (NumberFormatException numberFormatException){
            System.out.println("Please Select From Displayed Menu Only!!");
            acceptTypeofVehicle();
        }catch (InvalidChoiceException invalidChoiceException) {
            System.out.println(invalidChoiceException.getMessage());
            System.out.println("Please Select Number From Menu Only!!");
            acceptTypeofVehicle();
        }
    }

    public boolean acceptNumberofVehicle()throws IOException{
        System.out.print("Enter Number Of Your Car :- ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numberofvehicle = br.readLine();

        Vehicle checkVehicle = Vehicle.getListOfVehicles()
                                                .stream()
                                                .filter(vehicle1 -> vehicle1.getVehicle_number()==this.vehicle.getVehicle_number())
                                                .findFirst()
                                                .orElse(null);
        if(checkVehicle==null){
            Vehicle.getListOfVehicles().add(this.vehicle);
            this.vehicle.setVehicleNumber(numberofvehicle);
            return true;
        }
        else System.out.println("Same Number Vehicle Already Exists!!");
        return false;
    }
}
