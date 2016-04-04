import vehicles.*;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Auxiliary variables
        int i;
        String outputLine = null;
        String inputName = args[0];
        String outputName = args[1];
        PNE pne_aux;
        BigVehicles bigVehicle_aux;
        SmallVehicles smallVehicle_aux;
        Motorbikes motorbike_aux;
        String[] parts;
        String action;
        int lineHours;
        int lineMinutes;
        String plate;
        String vehicleType;

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
                parts = line.split(";|:");
                action = parts[0];
                lineHours = Integer.parseInt(parts[1]);
                lineMinutes = Integer.parseInt(parts[2]);
                plate = parts[3];
                vehicleType = parts[4];

                //Condition for entering vehicles
                outputLine = "LOTADO\n";
                if (action.equals("E"))
                {
                    //Search spots for especified vehicle type
                    switch (vehicleType)
                    {
                        case Constants.PNEVEHICLESCODE:
                            for (i = 0; i < Constants.FLOORQUANTITY; i++)
                            {
                                pne_aux = parkingLot.get(i).getEmptyPNESlot();
                                if (pne_aux != null)
                                {
                                    pne_aux.setIsOccupied(true, plate, lineHours, lineMinutes);
                                    outputLine = pne_aux.getCode() + "\n";
                                    break;
                                }
                            }
                            break;

                        case Constants.BIGVEHICLESCODE:
                            for (i = 0; i < Constants.FLOORQUANTITY; i++)
                            {
                                bigVehicle_aux = parkingLot.get(i).getEmptyBigVehicleSlot();

                                if (bigVehicle_aux != null)
                                {
                                    bigVehicle_aux.setIsOccupied(true, plate, lineHours, lineMinutes);
                                    outputLine = bigVehicle_aux.getCode() + "\n";
                                    break;
                                }
                            }
                            break;

                        case Constants.SMALLVEHICLESCODE:
                            smallVehicle_aux = null;
                            for (i = 0; i < Constants.FLOORQUANTITY; i++)
                            {
                                smallVehicle_aux = parkingLot.get(i).getEmptySmallVehicleSlot();

                                if (smallVehicle_aux != null)
                                {
                                    smallVehicle_aux.setIsOccupied(true, plate, lineHours, lineMinutes);
                                    outputLine = smallVehicle_aux.getCode() + "\n";
                                    break;
                                }
                            }
                            if(smallVehicle_aux == null)
                            {
                                for (i = 0; i < Constants.FLOORQUANTITY; i++)
                                {
                                    bigVehicle_aux = parkingLot.get(i).getEmptyBigVehicleSlot();

                                    if (bigVehicle_aux != null)
                                    {
                                        bigVehicle_aux.setIsOccupied(true, plate, lineHours, lineMinutes);
                                        outputLine = bigVehicle_aux.getCode() + "\n";
                                        break;
                                    }
                                }
                            }
                            break;

                        case Constants.MOTORBIKEVEHICLESCODE:
                            motorbike_aux = null;
                            for (i = 0; i < Constants.FLOORQUANTITY; i++)
                            {
                                motorbike_aux = parkingLot.get(i).getEmptyMotorBikeSlot();

                                if (motorbike_aux != null)
                                {
                                    motorbike_aux.setIsOccupied(true, plate, lineHours, lineMinutes);
                                    outputLine = motorbike_aux.getCode() + "\n";
                                    break;
                                }
                            }
                            if(motorbike_aux == null)
                            {
                                smallVehicle_aux = null;
                                for (i = 0; i < Constants.FLOORQUANTITY; i++)
                                {
                                    smallVehicle_aux = parkingLot.get(i).getEmptySmallVehicleSlot();

                                    if (smallVehicle_aux != null)
                                    {
                                        smallVehicle_aux.setIsOccupied(true, plate, lineHours, lineMinutes);
                                        outputLine = smallVehicle_aux.getCode() + "\n";
                                        break;
                                    }
                                }
                                if (smallVehicle_aux == null)
                                {
                                    for (i = 0; i < Constants.FLOORQUANTITY; i++)
                                    {
                                        bigVehicle_aux = parkingLot.get(i).getEmptyBigVehicleSlot();

                                        if (bigVehicle_aux != null)
                                        {
                                            bigVehicle_aux.setIsOccupied(true, plate, lineHours, lineMinutes);
                                            outputLine = bigVehicle_aux.getCode() + "\n";
                                            break;
                                        }
                                    }
                                }
                            }
                            break;
                    }
                }
                //Condition for leaving vehicles
                else
                {
                    switch (vehicleType)
                    {
                        case Constants.PNEVEHICLESCODE:
                            for (i = 0; i < Constants.FLOORQUANTITY; i++)
                            {
                                pne_aux = parkingLot.get(i).getPNE(plate);

                                if(pne_aux != null)
                                {
                                    outputLine = pne_aux.getVehicleCheckout(lineHours, lineMinutes);
                                    break;
                                }
                            }
                            break;

                        case Constants.BIGVEHICLESCODE:
                            for (i = 0; i < Constants.FLOORQUANTITY; i++)
                            {
                                bigVehicle_aux = parkingLot.get(i).getBigVehicle(plate);

                                if(bigVehicle_aux != null)
                                {
                                    outputLine = bigVehicle_aux.getVehicleCheckout(lineHours, lineMinutes);
                                    break;
                                }
                            }
                            break;

                        case Constants.SMALLVEHICLESCODE:
                            smallVehicle_aux = null;
                            for (i = 0; i < Constants.FLOORQUANTITY; i++)
                            {
                                smallVehicle_aux = parkingLot.get(i).getSmallVehicle(plate);

                                if(smallVehicle_aux != null)
                                {
                                    outputLine = smallVehicle_aux.getVehicleCheckout(lineHours, lineMinutes);
                                    break;
                                }
                            }
                            if(smallVehicle_aux == null){
                                for (i = 0; i < Constants.FLOORQUANTITY; i++)
                                {
                                    bigVehicle_aux = parkingLot.get(i).getBigVehicle(plate);

                                    if(bigVehicle_aux != null)
                                    {
                                        outputLine = bigVehicle_aux.getVehicleCheckout(lineHours, lineMinutes);
                                        break;
                                    }
                                }
                            }
                            break;

                        case Constants.MOTORBIKEVEHICLESCODE:
                            motorbike_aux = null;
                            for (i = 0; i < Constants.FLOORQUANTITY; i++)
                            {
                                motorbike_aux = parkingLot.get(i).getMotorBike(plate);

                                if(motorbike_aux != null)
                                {
                                    outputLine = motorbike_aux.getVehicleCheckout(lineHours, lineMinutes);
                                    break;
                                }
                            }
                            if(motorbike_aux == null){
                                smallVehicle_aux = null;
                                for (i = 0; i < Constants.FLOORQUANTITY; i++)
                                {
                                    smallVehicle_aux = parkingLot.get(i).getSmallVehicle(plate);

                                    if(smallVehicle_aux != null)
                                    {
                                        outputLine = smallVehicle_aux.getVehicleCheckout(lineHours, lineMinutes);
                                        break;
                                    }
                                }
                                if(smallVehicle_aux == null){
                                    for (i = 0; i < Constants.FLOORQUANTITY; i++)
                                    {
                                        bigVehicle_aux = parkingLot.get(i).getBigVehicle(plate);

                                        if(bigVehicle_aux != null)
                                        {
                                            outputLine = bigVehicle_aux.getVehicleCheckout(lineHours, lineMinutes);
                                            break;
                                        }
                                    }
                                }
                            }
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
