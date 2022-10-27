package com.geektrust.backend.services;

import com.geektrust.backend.dtos.BillGenerationDto;
import com.geektrust.backend.entites.ApartmentType;
import com.geektrust.backend.entites.WaterType;

public interface IBillGenerationService {
    public BillGenerationDto BillForEveryMonthAllotedWater(ApartmentType apartmentType, int corporationWater, int borewellWater);
    public BillGenerationDto BillForGuest(WaterType waterType);
}
