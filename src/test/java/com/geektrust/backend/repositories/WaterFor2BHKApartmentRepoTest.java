package com.geektrust.backend.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterFor2BHKApartmentRepoTest {
    private WaterFor2BHKApartmentRepo waterFor2BHKApartmentRepo;
    @BeforeEach
    public void setup(){
          double croporationParLitWaterPrice = 1;
          double borewllPerLitPrice = 1.5;
          double OneMonthWater = 900;


        waterFor2BHKApartmentRepo = new WaterFor2BHKApartmentRepo();
    }

    @Test
    @DisplayName("This should return total water used By apartment")
   public void waterPrice_ByApartment_Alloted() {
       final int coreporationRatio = 1; final int borewallRatio = 2;
       double toatlRatio = coreporationRatio + borewallRatio;
       double expectedPrice = (900 * (coreporationRatio/toatlRatio)  * 1) + (900 * (borewallRatio/toatlRatio)  * 1.5);
       // System.out.println(expectedPrice);
       double actualPrice = waterFor2BHKApartmentRepo.waterPrice(coreporationRatio,borewallRatio);
        System.out.println(actualPrice);
       Assertions.assertEquals(expectedPrice,actualPrice);
    }

    @Test
    @DisplayName("This should return total water per month alloted")
   public void totalWaterFor2BHK_Alloted() {
        double expectedWater = 900;
        double actualWater = waterFor2BHKApartmentRepo.totalWaterFor2BHK();
        Assertions.assertEquals(expectedWater,actualWater);
    }
}