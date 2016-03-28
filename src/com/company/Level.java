package com.company;


import java.util.ArrayList;

public class Level {

    ArrayList<BigVehicles> bigVehicles;
    ArrayList<Motorbikes> motorbikes;
    ArrayList<SmallVehicles> smallVehicles;
    ArrayList<PNE> pnes;

    public Level() {
        this.bigVehicles = new ArrayList<BigVehicles>();
        this.motorbikes = new ArrayList<Motorbikes>();
        this.smallVehicles = new ArrayList<SmallVehicles>();
        this.pnes = new ArrayList<PNE>();
    }



}
