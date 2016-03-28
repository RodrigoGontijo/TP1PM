package com.company;

import Interface.ParkInterface;

import java.util.Date;


public class BigVehicles implements ParkInterface {
    int capacity;
    int placesOccupied;
    float valuePerHour;




    @Override
    public int valuePerHour() {
        return 0;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int placesOccupied() {
        return 0;
    }

    @Override
    public void setPlacesOccupied(int numberPlaces) {

    }

    @Override
    public Date entryTime() {
        return null;
    }

    @Override
    public Date exitTime() {
        return null;
    }
}
