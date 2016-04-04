package vehicles;

import java.util.ArrayList;

public class ParkingFloor {

    public ArrayList<SmallVehicles> smallVehiclesSpaces;
    public ArrayList<BigVehicles> bigVehiclesSpaces;
    public ArrayList<PNE> pneSpaces;
    public ArrayList<Motorbikes> motorBikesSpaces;

    //Create ParkingFloor and its parking slots using Constants data
    public ParkingFloor(int level)
    {
        String labelLevel = "N";
        int iterator;

        this.smallVehiclesSpaces = new ArrayList<SmallVehicles>();
        for(iterator = 1; iterator <= Constants.SMALLVEHICLESCAPACITY; iterator++)
        {
            SmallVehicles object = new SmallVehicles(labelLevel.concat(Integer.toString(level)),iterator);
            this.smallVehiclesSpaces.add(object);
        }

        this.bigVehiclesSpaces = new ArrayList<BigVehicles>();
        for(iterator = 1; iterator <= Constants.BIGVEHICLESCAPACITY; iterator++)
        {
            BigVehicles object = new BigVehicles(labelLevel.concat(Integer.toString(level)),iterator);
            this.bigVehiclesSpaces.add(object);
        }

        this.pneSpaces = new ArrayList<PNE>();
        for(iterator = 1; iterator <= Constants.PNEVEHICLESCAPACITY; iterator++)
        {
            PNE object = new PNE(labelLevel.concat(Integer.toString(level)),iterator);
            this.pneSpaces.add(object);
        }

        this.motorBikesSpaces = new ArrayList<Motorbikes>();
        for(iterator = 1; iterator <= Constants.MOTORBIKEVEHICLESCAPACITY; iterator++)
        {
            Motorbikes object = new Motorbikes(labelLevel.concat(Integer.toString(level)),iterator);
            this.motorBikesSpaces.add(object);
        }
    }

    public PNE getEmptyPNESlot(){
        for(PNE slot : pneSpaces){
            if(!slot.isOccupied()){
                return slot;
            }
        }
        return null;
    }

    public BigVehicles getEmptyBigVehicleSlot(){
        for(BigVehicles slot : bigVehiclesSpaces){
            if(!slot.isOccupied()){
                return slot;
            }
        }
        return null;
    }

    public SmallVehicles getEmptySmallVehicleSlot(){
        for(SmallVehicles slot : smallVehiclesSpaces){
            if(!slot.isOccupied()){
                return slot;
            }
        }
        return null;
    }

    public Motorbikes getEmptyMotorBikeSlot(){
        for(Motorbikes slot : motorBikesSpaces){
            if(!slot.isOccupied()){
                return slot;
            }
        }
        return null;
    }

    public PNE getPNE(String plateNumber){
        for(PNE slot : pneSpaces){
            if(slot.getPlateNumber().equals(plateNumber)){
                return slot;
            }
        }
        return null;
    }

    public BigVehicles getBigVehicle(String plateNumber){
        for(BigVehicles slot : bigVehiclesSpaces){
            if(slot.getPlateNumber().equals(plateNumber)){
                return slot;
            }
        }
        return null;
    }

    public SmallVehicles getSmallVehicle(String plateNumber){
        for(SmallVehicles slot : smallVehiclesSpaces){
            if(slot.getPlateNumber().equals(plateNumber)){
                return slot;
            }
        }
        return null;
    }

    public Motorbikes getMotorBike(String plateNumber){
        for(Motorbikes slot : motorBikesSpaces){
            if(slot.getPlateNumber().equals(plateNumber)){
                return slot;
            }
        }
        return null;
    }

}
