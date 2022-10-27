package com.geektrust.backend.services;

import com.geektrust.backend.entites.Guest;
import com.geektrust.backend.entites.WaterType;
import com.geektrust.backend.exception.ApartmentNotFound;
import com.geektrust.backend.repositories.IGuestRepository;

import java.util.List;

public class AddGuestService implements IAddGuestService{
    private final IGuestRepository guestRepository;

    public AddGuestService(IGuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public Guest addGuest(String guests)throws ApartmentNotFound {
        Guest guest = new Guest(guests);
        return guestRepository.save(guest);
    }

    @Override
    public double totalWaterPriceForGuest(WaterType waterType){
        if (WaterType.tanker == waterType) {
            List<Guest> guestList = guestRepository.findAll();

            double totalGuest = 0;
            for (Guest g : guestList) {
                totalGuest += Integer.parseInt(g.getNoOfGuest());
            }
            double totalWater = totalGuest * 10 * 30;

            double waterPrice = 0;
            if (totalWater <= 500) {
                waterPrice = totalWater * 2;
            } else if (totalWater <= 1500) {
                waterPrice = 500 * 2 + (totalWater - 500) * 3;

            } else if (totalWater <= 3000) {
                waterPrice = 500 * 2 + 1000 * 3 + (totalWater - 1500) * 5;
            } else if (totalWater > 3000) {
                waterPrice = 500 * 2 + 1000 * 3 + 1500 * 5 + (totalWater - 3000) * 8;
            }
            return waterPrice;
        }
        return 0;
    }

    @Override
    public double totalWaterUsedByGuest(WaterType waterType){
        if (WaterType.tanker == waterType) {
            List<Guest> guestList = guestRepository.findAll();
            double totalGuest = 0;
            for (Guest g : guestList) {
                totalGuest = totalGuest + Integer.parseInt(g.getNoOfGuest());
            }
            double totalWater = totalGuest * 10 * 30;
            return totalWater;
        }
        return 0;
    }
}
