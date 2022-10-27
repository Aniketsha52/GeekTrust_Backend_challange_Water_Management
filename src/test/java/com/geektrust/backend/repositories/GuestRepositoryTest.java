package com.geektrust.backend.repositories;

import com.geektrust.backend.entites.Guest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GuestRepositoryTest {
    private  GuestRepository guestRepository;

    @BeforeEach
    void setUp(){

        Map<String,Guest> guestMap = new HashMap<String,Guest>(){
            {
                put("1",new Guest("1","2"));
                put("2",new Guest("2","3"));
            }

        };
        guestRepository = new GuestRepository(guestMap);
    }

    @Test
    @DisplayName("This should save the all new guests")
    public void saveGuest_addNewGuest(){
        final Guest guest = new Guest("2");
        Guest expectedGuest = new Guest("3","2");

        Guest actualGuest = guestRepository.save(guest);
        //System.out.println(actualGuest);
        Assertions.assertEquals(expectedGuest,actualGuest);
    }

    @Test
    @DisplayName("find all method should return all guest")
    public void findGuest_ALlGuest(){
         Integer expectedGuestSize = 2;
       List<Guest> actualGuestSize= guestRepository.findAll();
       Assertions.assertEquals(expectedGuestSize,actualGuestSize.size());
    }


}