package com.geektrust.backend.dtos;

import com.geektrust.backend.entites.Apartment;
import com.geektrust.backend.entites.Water;

public class BillGenerationDto {

    private final Water water;

    public BillGenerationDto( Water water) {
        this.water = water;
    }


    public Water getWater() {
        return water;
    }

    @Override
    public String toString() {
        return "BillGenerationDto{" +
                "totalWater=" +  water.getTotalWater() +
                "totalWaterPrice=" +  water.getTotalPriceOfWater() +
                '}';
    }
}
