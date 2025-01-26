package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.Entity.Floor;
import com.kylas.ParkingLot.Entity.ParkingLot;
import com.kylas.ParkingLot.Entity.Slot;
import com.kylas.ParkingLot.MyExceptions.InvalidChoiceException;
import com.kylas.ParkingLot.MyExceptions.NumberCannotBeLessThanOneException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotService{

    List<SlotService> list_of_slots;
    FloorService floor_service;
    ParkingLot parkinglot;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //Constructor
    public ParkingLotService(){
    parkinglot = new ParkingLot();
    floor_service = new FloorService();
    }

    public int acceptInt() {
        int number_check;
        while (true) {
            try {
                number_check = Integer.parseInt(br.readLine());
                if (number_check<1)throw  new NumberCannotBeLessThanOneException("Minimum Value Should Be One!!");
                break;
            }catch(NumberCannotBeLessThanOneException numberCannotBeLessThanOneException) {
                System.out.println(numberCannotBeLessThanOneException.getMessage());
                System.out.println("Please Re-enter Number!!");
            }catch (NumberFormatException numberFormatException){
                System.out.println("Cannot Accept this format as Number of Floors "+numberFormatException.getMessage());
                System.out.println("Please Re-enter Number in Integer Format Only!!!!");
//            }catch (IOException ioException){
//
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        return number_check;


    }


    //Creation
    public void createParkingLot(int floors,int slots) {
            //System.out.print("Please Enter Number of Floors :- ");
            int number_of_floors= floors;//acceptInt();

            new ParkingLotService();

            for (int floor_number = 0; floor_number < number_of_floors; floor_number++) {

                //System.out.print("Please Enter Number of Slots For Your floor " + (floor_number + 1) + " : ");


                int number_of_slots = slots;//acceptInt();


                list_of_slots = new ArrayList<>();

                for (int slot_number = 0; slot_number < number_of_slots; slot_number++) {
                    String slotno = ((char) (64 + floor_number + 1) + "") + (slot_number + 1);
                    String slot_type;

                    while (true) {
                        int choice=-1;
                        while(true) {
                            try {
                                System.out.println("Enter Type To Set For Slot:- ");
                                System.out.println("1. Car Slot");
                                System.out.println("2. Truck Slot");
                                System.out.println("3. Bike Slot");
                                choice = slot_number+1;//acceptInt();
                                if (choice > 3) throw new InvalidChoiceException("Selection of Invalid Type Entry");
                                break;
                            } catch (InvalidChoiceException invalidChoiceException) {
                                System.out.println(invalidChoiceException.getMessage());
                                System.out.println("Please Select Number From Menu Only!!");
                            }
                        }
                        switch (choice) {
                            case 1:
                                slot_type = "Car";
                                break;
                            case 2:
                                slot_type = "Truck";
                                break;
                            case 3:
                                slot_type = "Bike";
                                break;
                            default:
                                System.out.println("Invalid Choice Please Try Again!!");
                                continue;
                        }
                        break;

                    }
                    list_of_slots.add(new SlotService(slotno, slot_type));
                }

                floor_service.addSlotsOfFloor((char) (64 + floor_number + 1) + "", list_of_slots);
                this.addFloorInParkingLot(floor_service.getFloor());
            }
    }
    public void addFloorInParkingLot(Floor new_floor){

        parkinglot.getListOfFloorsInParkingLot().add(new_floor);
    }

    public List<Floor> getFloorsInParkingLot(){
        return parkinglot.getListOfFloorsInParkingLot();
    }

    public boolean checkForVacancy( VehicleService vehicleService){
        Slot vacant_slot = this
                .getFloorsInParkingLot()
                .stream()
                .flatMap(floor -> floor.getSlots().stream()).filter(slot1 -> slot1.getSlot_type().equals(vehicleService.getVehicleType()))
                .filter(Slot::getSlotVacancy)
                .findFirst()
                .orElse(null);

        if(vacant_slot!=null)return true;
        return false;
    }

    public void showParking(){
        System.out.print("Parkings:-\n");
        System.out.println("|Floor\t|SlotID\t|Type\t|IsVacant|");
        for(Floor floor: this.getFloorsInParkingLot()){
            for(Slot slot : floor.getSlots()){
                System.out.print("|  "+floor.getFloor_id()+"  \t|  "+slot.getSlot_id()+"   | "+ slot.getSlot_type() +"\t|\t"+ slot.isIs_slot_vacant() +" |\t\n");
            }
            System.out.print("\n");

        }
    }

    public void showSelectedSlots(boolean vacancy){
        System.out.print("Parkings:-\n");
        System.out.println("|Floor\t|SlotID\t|Type\t|IsVacant|");
        boolean if_result_empty=true;
        for(Floor floor: this.getFloorsInParkingLot()){
            for(Slot slot : floor.getSlots()) {
                if (slot.getSlotVacancy() == vacancy) {
                    if_result_empty=false;
                    System.out.print("|  " + floor.getFloor_id() + "  \t|  " + slot.getSlot_id() + "   | " + slot.getSlot_type() + "\t|\t" + slot.isIs_slot_vacant() + " |\t\n");

                }
            }
            System.out.print("\n");

        }
        if(if_result_empty) System.out.println("No Data to Display!!!\n");
    }


}
