package com.geektrust.backend.services;

import com.geektrust.backend.entites.Guest;
import com.geektrust.backend.entites.WaterType;

public interface IAddGuestService {
    public Guest addGuest(String guests);
    public double totalWaterPriceForGuest(WaterType waterType);
    public double totalWaterUsedByGuest(WaterType waterType);
}
