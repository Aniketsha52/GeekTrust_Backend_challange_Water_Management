package com.geektrust.backend.repositories;

import com.geektrust.backend.entites.Apartment;
import com.geektrust.backend.entites.ApartmentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentRepositoryTest {
    private ApartmentRepository apartmentRepository;

    @BeforeEach
   public void setup() {
        Map<String, Apartment> apartmentMap = new HashMap<String, Apartment>() {
            {
                put("1", new Apartment("1", ApartmentType.apartment_2BHK,"2:1"));
                put("2", new Apartment("2",ApartmentType.apartment_3BHK,"1:2"));
            }
        };
        apartmentRepository = new ApartmentRepository(apartmentMap);
    }

    @Test
    @DisplayName("This method should save the apartment")
   public void save_Apartment() {
        ApartmentType apartmentType = ApartmentType.apartment_2BHK;
        String waterRatio = "1:2";
        Apartment expectedApartment = new Apartment("3",ApartmentType.apartment_2BHK,"1:2");

        Apartment apartment1 = new Apartment(apartmentType,waterRatio);

        Apartment actualApartment = apartmentRepository.save(apartment1);
        Assertions.assertEquals(expectedApartment,actualApartment);
    }

    @Test
    @DisplayName("This method return the list of Apartment")
   public void findApartment() {
        int expectedSize = 2;
        List<Apartment> actualSize = apartmentRepository.findAll();
        Assertions.assertEquals(expectedSize,actualSize.size());
    }
}