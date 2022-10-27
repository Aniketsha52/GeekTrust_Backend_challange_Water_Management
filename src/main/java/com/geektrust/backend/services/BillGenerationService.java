package com.geektrust.backend.services;

import com.geektrust.backend.dtos.BillGenerationDto;
import com.geektrust.backend.entites.ApartmentType;
import com.geektrust.backend.entites.Water;
import com.geektrust.backend.entites.WaterType;
import com.geektrust.backend.repositories.IWaterFor2BHKApartmentRepo;
import com.geektrust.backend.repositories.IWaterFor3BHKApartmentRepo;

public class BillGenerationService implements IBillGenerationService{
    private final IWaterFor2BHKApartmentRepo waterFor2BHKApartmentRepo;
    private final IWaterFor3BHKApartmentRepo waterFor3BHKApartmentRepo;
    private final IAddGuestService addGuestService;

    public BillGenerationService(IWaterFor2BHKApartmentRepo waterFor2BHKApartmentRepo, IWaterFor3BHKApartmentRepo waterFor3BHKApartmentRepo, IAddGuestService addGuestService) {
        this.waterFor2BHKApartmentRepo = waterFor2BHKApartmentRepo;
        this.waterFor3BHKApartmentRepo = waterFor3BHKApartmentRepo;
        this.addGuestService = addGuestService;
    }


    @Override
    public BillGenerationDto BillForEveryMonthAllotedWater(ApartmentType apartmentType, int corporationWater, int borewellWater){
        double totalWaterAllotedPrice = 0;
        double totalAllotedWater = 0;
        if (ApartmentType.apartment_2BHK == apartmentType){
            totalWaterAllotedPrice = waterFor2BHKApartmentRepo.waterPrice(corporationWater,borewellWater);
            totalAllotedWater = waterFor2BHKApartmentRepo.totalWaterFor2BHK();
        }
        if (ApartmentType.apartment_3BHK == apartmentType){
            totalWaterAllotedPrice = waterFor3BHKApartmentRepo.waterPrice(corporationWater,borewellWater);
            totalAllotedWater = waterFor3BHKApartmentRepo.totalWaterFor3BHK();
        }

        Water water = new Water(totalAllotedWater ,totalWaterAllotedPrice );

        return new BillGenerationDto(water);

    }

    @Override
    public BillGenerationDto BillForGuest(WaterType waterType){
        double totalWaterUsedByGuest = 0;
        double totalPriceForUsedWater = 0;

        totalWaterUsedByGuest = addGuestService.totalWaterUsedByGuest(waterType);
        totalPriceForUsedWater = addGuestService.totalWaterPriceForGuest(waterType);

        Water water = new Water(totalWaterUsedByGuest,totalPriceForUsedWater);
        return new BillGenerationDto(water);
    }
}
