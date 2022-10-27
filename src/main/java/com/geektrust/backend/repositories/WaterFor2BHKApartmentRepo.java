package com.geektrust.backend.repositories;

import com.geektrust.backend.entites.Water;

public class WaterFor2BHKApartmentRepo implements IWaterFor2BHKApartmentRepo {
    private final double croporationParLitWaterPrice;
    private final double borewllPerLitPrice;
    private final double OneMonthWater;






    public WaterFor2BHKApartmentRepo() {
        this.croporationParLitWaterPrice = 1;
        this.borewllPerLitPrice = 1.5;
       this.OneMonthWater = 900;

    }

    public double waterPrice(int croporationRatio,int borewllWaterRatio){
        double totalWaterRatio = croporationRatio + borewllWaterRatio;
        double corporationTotalPrice =  OneMonthWater *(croporationRatio / totalWaterRatio) *  croporationParLitWaterPrice;
        double borewellTotalPrice = OneMonthWater * (borewllWaterRatio / totalWaterRatio) *  borewllPerLitPrice;
        return corporationTotalPrice + borewellTotalPrice;
    }
    public double totalWaterFor2BHK(){
        return OneMonthWater;
    }
}
