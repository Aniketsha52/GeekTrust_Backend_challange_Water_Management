package com.geektrust.backend.repositories;

import com.geektrust.backend.entites.Apartment;

import java.util.List;
import java.util.Optional;

public interface IApartmentRepository {
    public Apartment save(Apartment entity);
    public List<Apartment> findAll();
    public Optional<Apartment> findById(String id);
}
