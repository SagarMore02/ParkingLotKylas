package com.kylas.ParkingLot;
import com.kylas.ParkingLot.Entity.*;
import com.kylas.ParkingLot.EntityService.*;

import com.kylas.ParkingLot.MyExceptions.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ParkingLotApplication {
		public static void main(String[] args) throws Exception {
			SpringApplication.run(ParkingLotApplication.class, args);
			Map<String,Vehicle> list_of_vehicles = new HashMap<>();
			Map<String,Ticket> list_of_issued_tickets = new HashMap<>();


			Ticket ticket;
			Vehicle vehicle;
			VacantSlotFloor vacantSlotFloor;
			int choice;
			SlotService slotService = new SlotService();

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Welcome to Parking Software!!");
			System.out.print("Enter Number of floors:- ");
			int floors=Integer.parseInt(br.readLine());
			System.out.print("Enter Number of Slots:- ");
			int slots=Integer.parseInt(br.readLine());
			ParkingLotService parkingLotService = new ParkingLotService(floors,slots);
			parkingLotService.showParking();

			TicketService ticketService = new TicketService();

			while(true) {

				System.out.println("Please Select Option Of Your Choice");

				System.out.println("1. To Park A Vehicle");
				System.out.println("2. To Unpark A Vehicle");
				System.out.println("3. To Show All Slots");
				System.out.println("4. To Show All Available Slots");
				System.out.println("5. To Show All Occupied Slots");
				System.out.println("6. To Exit The Application");
				try {
					choice = Integer.parseInt(br.readLine());
					switch (choice) {
						case 1:
							System.out.print("Enter Type Of Vehicle:- ");
							String typeOfVehicle = br.readLine();

							System.out.print("Enter Number Of Vehicle:- ");
							String vehicleNumber = br.readLine();

							vehicle = new Vehicle(typeOfVehicle,vehicleNumber);
							vacantSlotFloor = parkingLotService.getVacantSlotToPark(vehicle);

							if(vacantSlotFloor==null){
								throw new NoSlotFreeException("No Slot Free For This Type Of Vehicle");
							}
							if(!list_of_vehicles.containsKey(vehicle.getVehicleNumber())){//To Check If Vehicle Already Exists in system
									slotService.parkAtSlot(vacantSlotFloor.getSlot(),vehicle);
									ticket=new Ticket(vacantSlotFloor.getSlot().getSlotId(),vacantSlotFloor.getFloor().getFloor_id(),vehicle.getVehicleNumber());
									ticketService.printTicket(ticket);
									list_of_vehicles.put(vehicle.getVehicleNumber(),vehicle);
									list_of_issued_tickets.put(vehicle.getVehicleNumber(),ticket);
									parkingLotService.showParking();
							}else{
								System.out.println("Vehicle Already Exists Try Checking Out Vehicle First!!");
							}
							break;
						case 2:
							System.out.print("Enter Vehicle Number :- ");
							String vehicleNumberToExit = br.readLine();
							if (list_of_issued_tickets.containsKey(vehicleNumberToExit)){

								ticket=list_of_issued_tickets.get(vehicleNumberToExit);
								Slot slot = ticketService.getSlotWhereVehicleIsParked(parkingLotService, ticket);

								if(slot==null)throw new InvalidSlotException("Invalid Slot");

								slotService.freeSlot(slot);
								ticketService.freeTicket(ticket);
								list_of_vehicles.remove(vehicleNumberToExit);
								list_of_issued_tickets.remove(vehicleNumberToExit);
							}
							else System.out.println("Invalid Ticket Number!!");
							break;
						case 3:
							parkingLotService.showParking();
							break;
						case 4:
							//True : Gives Where Vacancy Is Available
							parkingLotService.showSelectedSlots(true);
							break;
						case 5:
							//False : Gives Slots Where Vacancy Is Filled
							parkingLotService.showSelectedSlots(false);
							break;
						case 6:
							break;
						default:
							System.out.println("Invalid Input!!");
							break;
					}
				if (choice == 6) break;
				}catch (InvalidVehicleTypeException invalidVehicleTypeException){
					System.out.println(invalidVehicleTypeException.getMessage());
				}
				catch (InvalidVehicleNumberException invalidVehicleNumberException){
					System.out.println(invalidVehicleNumberException.getMessage());
				}
				catch (VehicleAlreadyExistsException vehicleAlreadyExistsException) {
					System.out.println(vehicleAlreadyExistsException.getMessage());
				}
				catch (NumberFormatException | IOException numberFormatException){
					System.out.println("Please Select From Displayed Menu Only!!");
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			System.out.print("ByeBye!");
		}

}
