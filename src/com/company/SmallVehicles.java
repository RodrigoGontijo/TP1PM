package com.company;

import Interface.ParkInterface;

import java.util.Date;


public class SmallVehicles implements ParkInterface{


    @Override
    public int valuePerHour() {
        return 0;
    }

    @Override
    public int capacity() {
        return 0;
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
