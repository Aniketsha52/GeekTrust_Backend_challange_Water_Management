package com.geektrust.backend.repositories;

import com.geektrust.backend.entites.Guest;

import java.util.ArrayList;
import java.util.List;

public interface IGuestRepository {
    public Guest save(Guest guest);
    public List<Guest> findAll();
}
