package com.geektrust.backend.exception;

public class ApartmentNotFound extends RuntimeException{
    public ApartmentNotFound(){
        super();
    }
    public ApartmentNotFound(String msg){
        super(msg);
    }
}
