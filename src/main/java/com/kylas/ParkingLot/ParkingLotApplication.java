package com.kylas.ParkingLot;
import com.kylas.ParkingLot.EntityService.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class ParkingLotApplication {

		public static void main(String[] args) throws IOException {
		SpringApplication.run(ParkingLotApplication.class, args);

		int choice;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome to Parking Software!!");

		ParkingLotService parkingLotService = new ParkingLotService();
			parkingLotService.createParkingLot();
			parkingLotService.showParking();

		VehicleService vehicleService = new VehicleService();
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
						vehicleService.acceptTypeofVehicle();
						if (parkingLotService.checkForVacancy(vehicleService)) {
							if (vehicleService.acceptNumberofVehicle()) {
								ticketService.parkVehicle(parkingLotService, vehicleService);
								ticketService.printTicket();
							}

						} else {
							System.out.println("No Vacancy For This Type of Vehicle Available");
						}
						parkingLotService.showParking();
						break;
					case 2:
						System.out.print("Enter Ticket Number :- ");
						int ticketNumber = Integer.parseInt(br.readLine());
						if (ticketService.checkValidityOfTicket(ticketNumber))
							ticketService.freeVehicle(parkingLotService, ticketNumber);
						else System.out.println("Invalid Ticket Number!!");
						break;
					case 3:
						parkingLotService.showParking();
						break;
					case 4:
						parkingLotService.showSelectedSlots(true);
						break;
					case 5:
						parkingLotService.showSelectedSlots(false);
						break;
					case 6:
						break;
					default:
						System.out.println("Invalid Input!!");
						break;
				}
			if (choice == 6) break;
			}catch (NumberFormatException | IOException numberFormatException){
				System.out.println("Please Select From Displayed Menu Only!!");
			}
		}
		System.out.print("ByeBye!");
	}

}
