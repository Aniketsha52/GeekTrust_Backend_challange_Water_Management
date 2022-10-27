package com.geektrust.backend.services;

import com.geektrust.backend.entites.Guest;
import com.geektrust.backend.entites.WaterType;
import com.geektrust.backend.repositories.IGuestRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("AddGuestService Test")
@ExtendWith(MockitoExtension.class)
class AddGuestServiceTest {
    @Mock
    private IGuestRepository guestRepositoryMock;

    @InjectMocks
    private AddGuestService addGuestService;



    @Test
    @DisplayName("This should add guest")
   public void addGuest_ServiceToaddGuests() {
        Guest expectedGuest = new Guest("1","3");
        when(guestRepositoryMock.save(any(Guest.class))).thenReturn(expectedGuest);
        Guest actualGuest = addGuestService.addGuest("3");
        Assertions.assertEquals(expectedGuest,actualGuest);
        verify(guestRepositoryMock,times(1)).save(any(Guest.class));
    }


    @Test
    @DisplayName("This should give price of water used by Guests")
   public void totalWaterPriceForGuest() {

        List<Guest> guestList = new ArrayList<Guest>(){
            {
                add(new Guest("1", "3"));
                add(new Guest("2", "2"));
            }
        };

        when(guestRepositoryMock.findAll()).thenReturn(guestList);

        double expectedPrice = 4000;
        double actualPrice = addGuestService.totalWaterPriceForGuest(WaterType.tanker);
        Assertions.assertEquals(expectedPrice,actualPrice);
       // System.out.println(actualPrice);
        verify(guestRepositoryMock,times(1)).findAll();


    }

    @DisplayName("This should return water used by guest")
    @Test
   public void totalWaterUsedByGuest() {

        List<Guest> guestList = new ArrayList<Guest>(){
            {
                add(new Guest("1", "2"));
                add(new Guest("2", "3"));
            }
        };

        when(guestRepositoryMock.findAll()).thenReturn(guestList);

        double expectedWater = 1500;
        double actualWater = addGuestService.totalWaterUsedByGuest(WaterType.tanker);
        Assertions.assertEquals(expectedWater,actualWater);
       // System.out.println(actualWater);
        verify(guestRepositoryMock,times(1)).findAll();
    }
}