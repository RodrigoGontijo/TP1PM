package com.company;

import Interface.ParkSpaceInterface;

import java.util.Date;


public class PNE implements ParkSpaceInterface {

    private Date exitTime;
    private Date entryTime;
    private Boolean isOccupied;
    private String level;
    private int numberPark;

    public PNE( Boolean isOccupied, String level, int numberPark) {
        this.numberPark = numberPark;
        this.isOccupied = isOccupied;
        this.level = level;
    }


    @Override
    public double valuePerHour() {
        return Constants.PNEVEHICLESPRICE;
    }

    @Override
    public int capacity() {
        return Constants.PNEVEHICLESCAPACITY;
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
        return level;
    }

    @Override
    public String getCode() {
        return level.concat(Constants.PNEVEHICLESCODE.concat(Integer.toString(numberPark)));
    }

    @Override
    public void setEntryTime(Date date) {
        this.entryTime = date;
    }

}
