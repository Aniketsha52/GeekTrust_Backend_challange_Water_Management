package com.geektrust.backend.services;

import com.geektrust.backend.entites.Apartment;
import com.geektrust.backend.entites.ApartmentType;

import java.util.List;


public interface IApartmentService {
    public Apartment create(ApartmentType apartmentType, String waterRatio);
    public List<Apartment> apartmentList();

}
