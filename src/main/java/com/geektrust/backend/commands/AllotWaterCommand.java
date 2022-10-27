package com.geektrust.backend.commands;

import com.geektrust.backend.entites.Apartment;
import com.geektrust.backend.entites.ApartmentType;
import com.geektrust.backend.exception.ApartmentNotFound;
import com.geektrust.backend.exception.NoSuchCommandException;
import com.geektrust.backend.exception.WaterRatioNotFound;
import com.geektrust.backend.services.IApartmentService;

import java.util.List;

public class AllotWaterCommand implements ICommand{
   private final IApartmentService apartmentService;

    public AllotWaterCommand(IApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }


    @Override
    public void execute(List<String> tokens)throws NoSuchCommandException, ApartmentNotFound , WaterRatioNotFound {

        try {

            String name = tokens.get(0);
            String apartmentNo = tokens.get(1);
            String waterRatio = tokens.get(2);
            ApartmentType apartmentType = null;
            if (apartmentNo.equals("2")) {
                apartmentType = ApartmentType.apartment_2BHK;
            }
            if (apartmentNo.equals("3")) {
                apartmentType = ApartmentType.apartment_3BHK;
            }
            Apartment apartment = apartmentService.create(apartmentType, waterRatio);
           // System.out.println(apartment);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }


    }
}
