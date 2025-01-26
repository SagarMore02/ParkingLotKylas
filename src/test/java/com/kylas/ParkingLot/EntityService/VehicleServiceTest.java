package com.kylas.ParkingLot.EntityService;

import com.kylas.ParkingLot.MyExceptions.InvalidChoiceException;
import com.kylas.ParkingLot.MyExceptions.VehicleAlreadyExistsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleServiceTest {
    @Test
    public void givenCorrectNumber_WhenValidityisCalled_ThenOutputShouldBeTrue(){
        //Given
        VehicleService vehicleService = new VehicleService();
        String number_of_vehicle = "MH14KH4694";

        //When
        boolean result = vehicleService.checkValidityOfNumber(number_of_vehicle);

        //Then
        assertTrue(result);
    }

    @Test
    public void givenWrongNumber_WhenValidityisCalled_ThenOutputShouldBeTrue1(){
        //Given
        VehicleService vehicleService = new VehicleService();
        String number_of_vehicle = "MH14KH46194";

        //When
        boolean result = vehicleService.checkValidityOfNumber(number_of_vehicle);

        //Then
        assertFalse(result);
    }

    @Test
    public void givenWrongNumber_WhenValidityisCalled_ThenOutputShouldBeTrue2(){
        //Given
        VehicleService vehicleService = new VehicleService();
        String number_of_vehicle = "MH14KH464";

        //When
        boolean result = vehicleService.checkValidityOfNumber(number_of_vehicle);

        //Then
        assertFalse(result);
    }

    @Test
    public void givenWrongNumber_WhenValidityisCalled_ThenOutputShouldBeTrue3(){
        //Given
        VehicleService vehicleService = new VehicleService();
        String number_of_vehicle = "1234KH12MH";

        //When
        boolean result = vehicleService.checkValidityOfNumber(number_of_vehicle);

        //Then
        assertFalse(result);
    }

    @Test
    public void givenVehicleService_WhenNumberOfVehicleIsEnteredFirstTime_ThenInputShouldBeAccepted()throws Exception{
        //Given
        VehicleService vehicleService = new VehicleService();
        String number_of_vehicle = "MH12KH4564";

        //When
        boolean result = vehicleService.acceptNumberofVehicle(number_of_vehicle);

        //Then
        assertTrue(result);
    }

    @Test
    public void givenVehicleService_WhenNumberOfVehicleIsEnteredSameSecondTime_ThenInputShouldBeAccepted()throws Exception{
        //Given
        VehicleService vehicleService = new VehicleService();
        String number_of_vehicle = "MH12KH4694";

        //When
        boolean result = vehicleService.acceptNumberofVehicle(number_of_vehicle);

        //Then
        assertThrows(VehicleAlreadyExistsException.class, () -> {
            vehicleService.acceptNumberofVehicle(number_of_vehicle);
        });
    }

    @Test
    public void givenVehicleService_WhenValidTypeOfVehicleIsEntered_ThenInputShouldBeAccepted(){
        //Given
        VehicleService vehicleService = new VehicleService();
        String type_of_vehicle = "Car";

        //When
        vehicleService.acceptTypeofVehicle(type_of_vehicle);

        //Then
        assertEquals("Car",vehicleService.getVehicleType());
    }


    @Test
    public void givenVehicleService_WhenValidTypeOfVehicleIsEntered_ThenInputShouldBeAccepted2(){
        //Given
        VehicleService vehicleService = new VehicleService();
        String type_of_vehicle = "Bike";

        //When
        vehicleService.acceptTypeofVehicle(type_of_vehicle);

        //Then
        assertEquals("Bike",vehicleService.getVehicleType());
    }

    @Test
    public void givenVehicleService_WhenInValidTypeOfVehicleIsEntered_ThenInputShouldBeAccepted1()throws Exception{
        //Given
        VehicleService vehicleService = new VehicleService();
        String type_of_vehicle = "Bik";

        //When
        //Then
        assertThrows(InvalidChoiceException.class,()->{
            vehicleService.acceptTypeofVehicle(type_of_vehicle);
        });
    }

    @Test
    public void givenVehicleService_WhenInValidTypeOfVehicleIsEntered_ThenInputShouldBeAccepted2()throws Exception{
        //Given
        VehicleService vehicleService = new VehicleService();
        String type_of_vehicle = "Turk";

        //When
        //Then
        assertThrows(InvalidChoiceException.class,()->{
            vehicleService.acceptTypeofVehicle(type_of_vehicle);
        });
    }
}