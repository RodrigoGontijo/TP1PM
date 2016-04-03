package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        int i;
        String outputLine;
        String inputName = args[0];
        String outputName = args[1];
        PNE pne_aux;
        BigVehicles bigVehicle_aux;
        SmallVehicles smallVehicle_aux;
        Motorbikes motorbike_aux;

        //Setup
        ArrayList<ParkingFloor> parkingLot = new ArrayList<ParkingFloor>();
        for(i = 1; i <= Constants.FLOORQUANTITY; i++)
        {
            ParkingFloor newFloor = new ParkingFloor(i);
            parkingLot.add(newFloor);
        }

        //Try reading files.
        String line = null;
        try {
            FileReader fileReader = new FileReader(inputName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            PrintWriter writer = new PrintWriter(outputName, "UTF-8");

            //Logic Loop
            while((line = bufferedReader.readLine()) != null) {

                //Split line for informations
                String[] parts = line.split(";|:");
                String action = parts[0];
                int hours = Integer.parseInt(parts[1]);
                int minutes = Integer.parseInt(parts[2]);
                String plate = parts[3];
                String vehicleType = parts[4];

                //Format calendar times
                Calendar lineTime = Calendar.getInstance();
                lineTime.set(0, 0, 0, hours, minutes);

                outputLine = "Under Development\n";
                if (action.equals("E")) {
                    switch (vehicleType) {
                        case Constants.PNEVEHICLESCODE:
                            for (i = 0; i < Constants.FLOORQUANTITY; i++)
                            {
                                pne_aux = parkingLot.get(i).getEmptyPNESlot();
                                if (pne_aux != null) {
                                    pne_aux.setIsOccupied(true, plate);
                                    pne_aux.setEntryTime(lineTime);
                                    outputLine = pne_aux.getCode() + "\n";
                                    break;
                                }
                            }
                            break;

                        case Constants.BIGVEHICLESCODE:
                            for (i = 0; i < Constants.FLOORQUANTITY; i++) {
                                bigVehicle_aux = parkingLot.get(i).getEmptyBigVehicleSlot();

                                if (bigVehicle_aux != null) {
                                    bigVehicle_aux.setIsOccupied(true, plate);
                                    bigVehicle_aux.setEntryTime(lineTime);
                                    outputLine = bigVehicle_aux.getCode() + "\n";
                                    break;
                                }
                            }
                            break;

                        case Constants.SMALLVEHICLESCODE:
                            smallVehicle_aux = null;
                            for (i = 0; i < Constants.FLOORQUANTITY; i++) {
                                smallVehicle_aux = parkingLot.get(i).getEmptySmallVehicleSlot();

                                if (smallVehicle_aux != null) {
                                    smallVehicle_aux.setIsOccupied(true, plate);
                                    smallVehicle_aux.setEntryTime(lineTime);
                                    outputLine = smallVehicle_aux.getCode() + "\n";
                                    break;
                                }
                            }
                            if(smallVehicle_aux == null){
                                for (i = 0; i < Constants.FLOORQUANTITY; i++) {
                                    bigVehicle_aux = parkingLot.get(i).getEmptyBigVehicleSlot();

                                    if (bigVehicle_aux != null) {
                                        bigVehicle_aux.setIsOccupied(true, plate);
                                        bigVehicle_aux.setEntryTime(lineTime);
                                        outputLine = bigVehicle_aux.getCode() + "\n";
                                        break;
                                    }
                                }
                            }
                            break;

                        case Constants.MOTORBIKEVEHICLESCODE:
                            motorbike_aux = null;
                            for (i = 0; i < Constants.FLOORQUANTITY; i++) {
                                motorbike_aux = parkingLot.get(i).getEmptyMotorBikeSlot();

                                if (motorbike_aux != null) {
                                    motorbike_aux.setIsOccupied(true, plate);
                                    motorbike_aux.setEntryTime(lineTime);
                                    outputLine = motorbike_aux.getCode() + "\n";
                                    break;
                                }
                            }
                            if(motorbike_aux == null) {
                                smallVehicle_aux = null;
                                for (i = 0; i < Constants.FLOORQUANTITY; i++) {
                                    smallVehicle_aux = parkingLot.get(i).getEmptySmallVehicleSlot();

                                    if (smallVehicle_aux != null) {
                                        smallVehicle_aux.setIsOccupied(true, plate);
                                        smallVehicle_aux.setEntryTime(lineTime);
                                        outputLine = smallVehicle_aux.getCode() + "\n";
                                        break;
                                    }
                                }
                                if (smallVehicle_aux == null) {
                                    for (i = 0; i < Constants.FLOORQUANTITY; i++) {
                                        bigVehicle_aux = parkingLot.get(i).getEmptyBigVehicleSlot();

                                        if (bigVehicle_aux != null) {
                                            bigVehicle_aux.setIsOccupied(true, plate);
                                            bigVehicle_aux.setEntryTime(lineTime);
                                            outputLine = bigVehicle_aux.getCode() + "\n";
                                            break;
                                        }
                                    }
                                }
                            }
                            break;
                    }
                } else {
                    switch (vehicleType) {
                        case Constants.PNEVEHICLESCODE:
                            break;
                        case Constants.BIGVEHICLESCODE:
                            break;
                        case Constants.SMALLVEHICLESCODE:
                            break;
                        case Constants.MOTORBIKEVEHICLESCODE:
                            break;
                    }
                }
                writer.write(outputLine);
            }

            //Close IO files
            bufferedReader.close();
            writer.close();
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
