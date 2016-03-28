package com.company;


import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int iterator;
        String labelLevel = "N";

        ArrayList<SmallVehicles> smallVehiclesCollection = new ArrayList<SmallVehicles>();
        ArrayList<BigVehicles> bigVehiclesCollection = new ArrayList<BigVehicles>();
        ArrayList<PNE> PNEVehiclesCollection = new ArrayList<PNE>();
        ArrayList<Motorbikes> motorbikesVehiclesCollection = new ArrayList<Motorbikes>();

        for (int level = 1; level <= Constants.LEVELQUANTITY; level++) {

            //Add all park spaces SmallVehicles
            for(iterator = 1; iterator<=Constants.SMALLVEHICLESCAPACITY; iterator++){
                SmallVehicles object = new SmallVehicles(false,labelLevel.concat(Integer.toString(level)),iterator);
                smallVehiclesCollection.add(object);

            }

            //Add all park spaces BigVehicles
            for(iterator = 1; iterator<=Constants.BIGVEHICLESCAPACITY; iterator++){
                BigVehicles object = new BigVehicles(false,labelLevel.concat(Integer.toString(level)),iterator);
                bigVehiclesCollection.add(object);

            }

            //Add all park spaces MotorBikeVehicles
            for(iterator = 1; iterator<=Constants.MOTORBIKEVEHICLESCAPACITY; iterator++){
                Motorbikes object = new Motorbikes(false,labelLevel.concat(Integer.toString(level)),iterator);
                motorbikesVehiclesCollection.add(object);

            }


            //Add all park spaces PNEVehicles
            for(iterator = 1; iterator<=Constants.PNEVEHICLESCAPACITY; iterator++){
                PNE object = new PNE(false,labelLevel.concat(Integer.toString(level)),iterator);
                PNEVehiclesCollection.add(object);

            }

        }


        for (String argument : args) {
            if(args.length > 0) {
                File file = new File(args[0]);
                System.out.println(file.toString());
            }
        }


    }
}
