package com.geektrust.backend.repositories;

import com.geektrust.backend.entites.Guest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuestRepository implements IGuestRepository{
    private final Map<String,Guest> guestMap;

    private Integer autoIncrement = 0;

    public GuestRepository(){
        this.guestMap = new HashMap<>();
    }

    public GuestRepository(Map<String, Guest> guestMap) {
        this.guestMap = guestMap;
        this.autoIncrement = guestMap.size();
    }


    @Override
    public Guest save(Guest guest) {
       if(guest.getGuestId() == null) {
           autoIncrement++;
           Guest g = new Guest(Integer.toString(autoIncrement), guest.getNoOfGuest());
            guestMap.put(g.getGuestId(),g);
            return g;
       }
       guestMap.put(guest.getGuestId(),guest);
       return guest;
    }


    @Override
    public List<Guest> findAll() {
        return new ArrayList<>(guestMap.values());

    }
}
