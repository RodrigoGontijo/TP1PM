package com.company;

import Interface.ParkSpaceInterface;

import java.util.Calendar;
import java.util.Date;


public class BigVehicles implements ParkSpaceInterface {

    private Calendar exitTime;
    private Calendar entryTime;
    private Boolean isOccupied;
    private String level;
    private String plateNumber;
    private int numberPark;

    public BigVehicles(String level, int numberPark) {
        this.numberPark = numberPark;
        this.level = level;
        this.isOccupied = false;
    }

    @Override
    public String getPlateNumber(){
        return this.plateNumber;
    }

    @Override
    public double valuePerHour() {
        return Constants.BIGVEHICLESPRICE;
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
        return level;
    }

    @Override
    public String getCode() {
        return level.concat(Constants.BIGVEHICLESCODE.concat(Integer.toString(numberPark)));
    }

    @Override
    public void setEntryTime(Calendar date) {
        this.entryTime = date;
    }

}
