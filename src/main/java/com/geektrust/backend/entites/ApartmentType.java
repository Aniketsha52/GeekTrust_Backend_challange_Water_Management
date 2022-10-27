package com.geektrust.backend.entites;

public enum ApartmentType {
    apartment_2BHK(3),
    apartment_3BHK(5);


    private Integer person;

    ApartmentType(int person){
        this.person = person;
    }
    public Integer getPerson(){
        return person;
    }
}
