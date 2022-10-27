package com.geektrust.backend.services;

import com.geektrust.backend.entites.Apartment;
import com.geektrust.backend.entites.ApartmentType;
import com.geektrust.backend.entites.Water;
import com.geektrust.backend.repositories.IApartmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("ApartmentService")
@ExtendWith(MockitoExtension.class)
class ApartmentServiceTest {
    @Mock
    private IApartmentRepository apartmentRepositoryMock;

    @InjectMocks
    private ApartmentService apartmentService;

    @Test
    @DisplayName("This method should create Apartment")
   public void create_the_Apartment() {
        ApartmentType apartmentType = ApartmentType.apartment_2BHK;
        String waterRatio = "1:2";
        Apartment expectedApartment = new Apartment("1", apartmentType, waterRatio);
        when(apartmentRepositoryMock.save(any(Apartment.class))).thenReturn(expectedApartment);

        Apartment actualApartment = apartmentService.create(apartmentType,waterRatio);
        Assertions.assertEquals(expectedApartment,actualApartment);

        verify(apartmentRepositoryMock,times(1)).save(any(Apartment.class));

    }

    @Test
    @DisplayName("This method should return list of apartment")
    public void findAll_TofindApartment(){

        List<Apartment> expectedApartmentList = new ArrayList<>(){
            {
               add( new Apartment("1",ApartmentType.apartment_2BHK,"1:2"));
            }

        };
        when(apartmentRepositoryMock.findAll()).thenReturn(expectedApartmentList);
        List<Apartment> actualApartmentList = apartmentService.apartmentList();
        Assertions.assertEquals(expectedApartmentList.size(),actualApartmentList.size());
        verify(apartmentRepositoryMock,times(1)).findAll();
    }

}