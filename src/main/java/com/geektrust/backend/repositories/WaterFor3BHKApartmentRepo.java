package com.geektrust.backend.repositories;

public class WaterFor3BHKApartmentRepo implements IWaterFor3BHKApartmentRepo{
    private final double croporationParLitWaterPrice;
    private final double borewllPerLitPrice;
    private final double OneMonthWater;




    public WaterFor3BHKApartmentRepo() {
        this.croporationParLitWaterPrice = 1;
        this.borewllPerLitPrice = 1.5;
        this.OneMonthWater = 1500;

    }

    @Override
    public double waterPrice(int croporationRatio,int borewllWaterRatio){
        double totalWaterRatio = croporationRatio + borewllWaterRatio;
        double corporationTotalPrice =  OneMonthWater *(croporationRatio / totalWaterRatio) *  croporationParLitWaterPrice;
        double borewellTotalPrice = OneMonthWater * (borewllWaterRatio / totalWaterRatio) *  borewllPerLitPrice;
        return corporationTotalPrice + borewellTotalPrice;
    }

    @Override
    public double totalWaterFor3BHK() {
        return OneMonthWater;
    }
}
