package com.geektrust.backend.commands;

import com.geektrust.backend.dtos.BillGenerationDto;
import com.geektrust.backend.entites.Apartment;
import com.geektrust.backend.entites.ApartmentType;
import com.geektrust.backend.entites.WaterType;
import com.geektrust.backend.exception.NoSuchCommandException;
import com.geektrust.backend.services.IAddGuestService;
import com.geektrust.backend.services.IApartmentService;
import com.geektrust.backend.services.IBillGenerationService;

import java.util.List;

public class BillCommand implements ICommand{
    private final IApartmentService apartmentService;
    private final IBillGenerationService billGenerationService;
    private final IAddGuestService guestService;


    public BillCommand(IApartmentService apartmentService, IBillGenerationService billGenerationService, IAddGuestService guestService) {
        this.apartmentService = apartmentService;
        this.billGenerationService = billGenerationService;
        this.guestService = guestService;
    }

    @Override
    public void execute(List<String> tokens)throws NoSuchCommandException {

        try {
            String name = tokens.get(0);

            List<Apartment> apartmentList = apartmentService.apartmentList();
            ApartmentType apartmentType = apartmentList.get(0).getApartmentType();
            String waterRatio = apartmentList.get(0).getWaterRatio();

            String[] waterRatioToarray = waterRatio.split(":");

            BillGenerationDto billGenerationDtoForAllotedWater = billGenerationService.BillForEveryMonthAllotedWater(apartmentType, Integer.parseInt(waterRatioToarray[0]), Integer.parseInt(waterRatioToarray[1]));

            BillGenerationDto billGenerationDtoForGuest = billGenerationService.BillForGuest(WaterType.tanker);

            double totalWater = (billGenerationDtoForAllotedWater.getWater().getTotalWater() + billGenerationDtoForGuest.getWater().getTotalWater());
            double totalWaterPrice = (billGenerationDtoForAllotedWater.getWater().getTotalPriceOfWater() + billGenerationDtoForGuest.getWater().getTotalPriceOfWater());
            System.out.println((int) totalWater + " " + (int)Math.ceil(totalWaterPrice));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
