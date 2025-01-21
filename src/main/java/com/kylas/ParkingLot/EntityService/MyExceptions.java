package com.kylas.ParkingLot.EntityService;

public class MyExceptions extends Exception{
    public MyExceptions(String message){
        super(message);
    }
}
class NumberCannotBeLessThanOneException extends  Exception{
    public NumberCannotBeLessThanOneException(String message){
        super(message);
    }
}
class InvalidChoiceException extends Exception{
    public InvalidChoiceException(String message){
        super();
    }
}