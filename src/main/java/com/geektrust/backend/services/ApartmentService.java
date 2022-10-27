package com.geektrust.backend.services;

import com.geektrust.backend.entites.Apartment;
import com.geektrust.backend.entites.ApartmentType;
import com.geektrust.backend.entites.Guest;
import com.geektrust.backend.exception.ApartmentNotFound;
import com.geektrust.backend.repositories.IApartmentRepository;

import java.util.List;

public class ApartmentService implements IApartmentService{
    private final IApartmentRepository apartmentRepository;

    public ApartmentService(IApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public Apartment create(ApartmentType apartmentType, String waterRatio) {
        Apartment apartment = new Apartment(apartmentType,waterRatio);
        return apartmentRepository.save(apartment);
    }

    @Override
    public List<Apartment> apartmentList()throws ApartmentNotFound {

        return apartmentRepository.findAll();
    }
}
