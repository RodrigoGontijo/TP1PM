package com.company;

import Interface.ParkSpaceInterface;

import java.util.Date;


public class SmallVehicles implements ParkSpaceInterface {

    private Date exitTime;
    private Date entryTime;
    private Boolean isOccupied;
    private String level;
    private int numberPark;

    public SmallVehicles(Boolean isOccupied, String level, int numberPark) {
        this.numberPark = numberPark;
        this.isOccupied = isOccupied;
        this.level = level;
    }


    @Override
    public double valuePerHour() {
        return Constants.SMALLVEHICLESPRICE;
    }

    @Override
    public int capacity() {
        return Constants.SMALLVEHICLESCAPACITY;
    }

    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    @Override
    public void setIsOccupied(Boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    @Override
    public Date getEntryTime() {
        return entryTime;
    }

    @Override
    public Date getExitTime() {
        return exitTime;
    }


    @Override
    public void setExitTime(Date exitTime) {
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
    public void setEntryTime(Date date) {
        this.entryTime = date;
    }

}
