package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.Entity.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotService{
    int floors;
    int slots;
    List<Slot> listOfSlots;
    FloorService floorService;
    ParkingLot parkinglot;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //Constructor
    public ParkingLotService(int floors,int slots){
    parkinglot = new ParkingLot();
    floorService = new FloorService();
    this.floors=floors;
    this.slots=slots;
    createParkingLot();
    }

    public void createParkingLot() {
            int number_of_floors= floors;
            for (int floorNumber = 0; floorNumber < number_of_floors; floorNumber++) {
                listOfSlots = new ArrayList<>();
                for (int slotNumber = 0; slotNumber < slots; slotNumber++) {
                    String slotno = ((char) (64 + floorNumber + 1) + "") + (slotNumber + 1);
                    String slotType;
                    int choice;
                    choice = slotNumber+1;//acceptInt();
                    switch (choice) {
                            case 1:
                                slotType = "Car";
                                break;
                            case 2:
                                slotType = "Truck";
                                break;
                            case 3:
                                slotType = "Bike";
                                break;
                            default:
                                System.out.println("Invalid Choice Please Try Again!!");
                                continue;
                        }
                    listOfSlots.add(new Slot(slotno, slotType));
                }

                floorService.addSlotsOfFloor((char) (64 + floorNumber + 1) + "", listOfSlots);
                this.addFloorInParkingLot(floorService.getFloor());
            }
    }
    public void addFloorInParkingLot(Floor newFloor){
        parkinglot.getListOfFloorsInParkingLot().add(newFloor);
    }

    public List<Floor> getFloorsInParkingLot(){
        return parkinglot.getListOfFloorsInParkingLot();
    }

    public VacantSlotFloor getVacantSlotToPark(Vehicle vehicle){
        VacantSlotFloor vacantSlotFloor;
        for(Floor floor:this.getFloorsInParkingLot()){
            for(Slot slot:floor.getSlots()){
                if(slot.isSlotVacant()&&slot.getSlotType().equals(vehicle.getVehicleType())){
                    vacantSlotFloor= new VacantSlotFloor(slot,floor);
                    return vacantSlotFloor;
                }
            }
        }
        return null;
    }

    public void showParking(){
        System.out.print("Parkings:-\n");
        System.out.println("|Floor\t|SlotID\t|Type\t|IsVacant|");
        for(Floor floor: this.getFloorsInParkingLot()){
            for(Slot slot : floor.getSlots()){
                System.out.print("|  "+floor.getFloor_id()+"  \t|  "+slot.getSlotId()+"   | "+ slot.getSlotType() +"\t|\t"+ slot.isSlotVacant() +" |\t\n");
            }
            System.out.print("\n");

        }
    }

    public void showSelectedSlots(boolean vacancy){
        System.out.print("Parkings:-\n");
        System.out.println("|Floor\t|SlotID\t|Type\t|IsVacant|");
        boolean ifResultEmpty=true;
        for(Floor floor: this.getFloorsInParkingLot()){
            for(Slot slot : floor.getSlots()) {
                if (slot.getSlotVacancy() == vacancy) {
                    ifResultEmpty=false;
                    System.out.print("|  " + floor.getFloor_id() + "  \t|  " + slot.getSlotId() + "   | " + slot.getSlotType() + "\t|\t" + slot.isSlotVacant() + " |\t\n");

                }
            }
            System.out.print("\n");

        }
        if(ifResultEmpty) System.out.println("No Data to Display!!!\n");
    }


}
