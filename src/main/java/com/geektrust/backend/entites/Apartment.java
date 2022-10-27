package com.geektrust.backend.entites;

import java.util.Objects;

public class Apartment {

    private final String ApartmentId;
    private final ApartmentType apartmentType;
    private final String waterRatio;

    public Apartment(String ApartmentId, ApartmentType apartmentType,String waterRatio) {
        this.ApartmentId = ApartmentId;
        this.apartmentType = apartmentType;
        this.waterRatio = waterRatio;
    }
    public Apartment(ApartmentType apartmentType,String waterRatio){
        this.ApartmentId = getApartmentId();
        this.apartmentType = apartmentType;
        this.waterRatio = waterRatio;
    }

    public String getApartmentId(){
        return ApartmentId;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }
    public String getWaterRatio(){
        return waterRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apartment)) return false;
        Apartment apartment = (Apartment) o;
        return getApartmentId().equals(apartment.getApartmentId()) && getApartmentType() == apartment.getApartmentType() && getWaterRatio().equals(apartment.getWaterRatio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getApartmentId(), getApartmentType(), getWaterRatio());
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "ApartmentId='" + ApartmentId + '\'' +
                ", apartmentType=" + apartmentType +
                ", waterRatio='" + waterRatio + '\'' +
                '}';
    }
}
