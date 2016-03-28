package com.company;

import Interface.ParkInterface;

import java.util.Date;

/**
 * Created by rodri on 26/03/2016.
 */
public class PNE implements ParkInterface {


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
    public Date entryTime() {
        return null;
    }

    @Override
    public Date exitTime() {
        return null;
    }
}
