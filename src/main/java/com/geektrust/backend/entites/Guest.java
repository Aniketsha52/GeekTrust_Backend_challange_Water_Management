package com.geektrust.backend.entites;

import java.util.Objects;

public class Guest {

    private final String guestId;
    private final String noOfGuest;

    public Guest(String guestId,String noOfGuest) {
        this.noOfGuest = noOfGuest;
        this.guestId = guestId;
    }
    public Guest(String noOfGuest){
        this.noOfGuest = noOfGuest;
        this.guestId= getGuestId();
    }

    public String getNoOfGuest() {
        return noOfGuest;
    }

    public String getGuestId() {
        return guestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest)) return false;
        Guest guest = (Guest) o;
        return getGuestId().equals(guest.getGuestId()) && getNoOfGuest().equals(guest.getNoOfGuest());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGuestId(), getNoOfGuest());
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestId='" + guestId + '\'' +
                ", noOfGuest=" + noOfGuest +
                '}';
    }
}
