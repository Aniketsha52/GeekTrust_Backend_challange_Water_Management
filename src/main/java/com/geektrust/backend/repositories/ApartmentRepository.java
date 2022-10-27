package com.geektrust.backend.repositories;

import com.geektrust.backend.entites.Apartment;

import java.util.*;

public class ApartmentRepository implements IApartmentRepository{
    private final Map<String, Apartment> apartmentMap;

    private Integer autoIncrement = 0;
    public ApartmentRepository(){
        apartmentMap = new HashMap<>();
    }
    public ApartmentRepository(Map<String,Apartment> apartmentMap){
        this.apartmentMap = apartmentMap;
        this.autoIncrement = apartmentMap.size();
    }

    @Override
    public Apartment save(Apartment entity){
        if(entity.getApartmentId() == null){
            autoIncrement++;
            Apartment A = new Apartment(Integer.toString(autoIncrement),entity.getApartmentType(), entity.getWaterRatio());
            apartmentMap.put(A.getApartmentId(),A);
            return A;
        }
        apartmentMap.put(entity.getApartmentId(), entity);
        return entity;
    }
    @Override
    public List<Apartment> findAll() {
        return new ArrayList<>(apartmentMap.values());
    }

    @Override
    public Optional<Apartment> findById(String id){
        return Optional.ofNullable(apartmentMap.get(id));
    }
}
