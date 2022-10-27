package com.geektrust.backend.exception;

public class WaterRatioNotFound extends RuntimeException{
    public WaterRatioNotFound(){
        super();
    }
    public WaterRatioNotFound(String msg){
        super(msg);
    }
}
