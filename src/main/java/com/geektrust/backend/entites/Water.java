package com.geektrust.backend.entites;

public class Water {
    private final double totalWater;

    private final double totalPriceOfWater;
    private final WaterType waterType;

    public Water(double totalWater, double totalPriceOfWater, WaterType waterType) {
        this.totalWater = totalWater;
        this.totalPriceOfWater = totalPriceOfWater;
        this.waterType = waterType;
    }
    public Water(double totalWater,double totalPriceOfWater){
        this.totalWater = totalWater;
        this.totalPriceOfWater = totalPriceOfWater;
        this.waterType = getWaterType();
    }

    public double getTotalPriceOfWater() {
        return totalPriceOfWater;
    }

    public double getTotalWater() {
        return totalWater;
    }

    public WaterType getWaterType() {
        return waterType;
    }
}
