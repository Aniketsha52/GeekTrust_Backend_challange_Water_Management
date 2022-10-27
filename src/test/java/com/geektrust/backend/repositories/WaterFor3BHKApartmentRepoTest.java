package com.geektrust.backend.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterFor3BHKApartmentRepoTest {
    private WaterFor3BHKApartmentRepo waterFor3BHKApartmentRepo;
    @BeforeEach
   public void setup(){
        double croporationParLitWaterPrice = 1;
        double borewllPerLitPrice = 1.5;
        double OneMonthWater = 1500;


        waterFor3BHKApartmentRepo = new WaterFor3BHKApartmentRepo();
    }

    @Test
    @DisplayName("This should return total water price for 3BHK apartment")
   public void waterPrice_ForApartment() {
        final int coreporationRatio = 2; final int borewallRatio = 1;
        double toatlRatio = coreporationRatio + borewallRatio;
        double expectedPrice = (1500 * (coreporationRatio/toatlRatio)  * 1) + (1500 * (borewallRatio/toatlRatio)  * 1.5);
        //System.out.println(expectedPrice);
        double actualPrice = waterFor3BHKApartmentRepo.waterPrice(coreporationRatio,borewallRatio);
        Assertions.assertEquals(expectedPrice,actualPrice);
    }

    @Test
    @DisplayName("This should Give the total water every month consumed by 3BHK Apartment")
   public void totalWaterFor3BHK_ForApartment() {
        double expectedWater = 1500;
        double actualWater = waterFor3BHKApartmentRepo.totalWaterFor3BHK();
        Assertions.assertEquals(expectedWater,actualWater);
    }
}