package com.geektrust.backend.exception;

public class NoSuchCommandException extends RuntimeException{
    public NoSuchCommandException(){
        super();
    }
    public NoSuchCommandException(String msg){
        super(msg);
    }
}
