package com.company;

import Interface.ParkSpaceInterface;

import java.util.Calendar;
import java.util.Date;


public class SmallVehicles implements ParkSpaceInterface {

    private Calendar exitTime;
    private Calendar entryTime;
    private Boolean isOccupied;
    private String level;
    private String plateNumber;
    private int numberPark;

    public SmallVehicles(String level, int numberPark) {
        this.numberPark = numberPark;
        this.isOccupied = false;
        this.level = level;
    }


    @Override
    public double valuePerHour() {
        return Constants.SMALLVEHICLESPRICE;
    }

    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    @Override
    public void setIsOccupied(Boolean isOccupied, String plate) {
        this.isOccupied = isOccupied;
        this.plateNumber = plate;
    }

    @Override
    public String getPlateNumber() { return plateNumber; }

    @Override
    public Calendar getEntryTime() {
        return entryTime;
    }

    @Override
    public Calendar getExitTime() {
        return exitTime;
    }


    @Override
    public void setExitTime(Calendar exitTime) {
        this.exitTime = exitTime;
    }

    @Override
    public String getLevel() {
        return this.level;
    }

    @Override
    public String getCode() {
        return level.concat(Constants.SMALLVEHICLESCODE.concat(Integer.toString(numberPark)));
    }

    @Override
    public void setEntryTime(Calendar date) {
        this.entryTime = date;
    }

}
