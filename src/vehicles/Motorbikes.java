package vehicles;

import Interface.ParkSpaceInterface;


public class Motorbikes implements ParkSpaceInterface {

    private int hours;
    private int minutes;
    private Boolean isOccupied;
    private String level;
    private int numberPark;
    private String plateNumber;

    public Motorbikes(String level, int numberPark) {
        this.numberPark = numberPark;
        this.isOccupied = false;
        this.level = level;
    }

    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    @Override
    public void setIsOccupied(Boolean isOccupied, String plate, int hours, int minutes) {
        this.isOccupied = isOccupied;
        this.plateNumber = plate;
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public String getPlateNumber() { return plateNumber; }

    @Override
    public double getPrice(int hours, int minutes) {
        return (hours*Constants.MOTORBIKEVEHICLESPRICE + minutes*Constants.MOTORBIKEVEHICLESPRICE/60);
    }


    public String getVehicleCheckout(int exitHours, int exitMinutes){
        int hours = exitHours - this.hours;
        int minutes = exitMinutes - this.minutes;
        if(minutes < 0){
            hours --;
            minutes = minutes + 60;
        }
        double price = this.getPrice(hours, minutes);

        this.setIsOccupied(false, null, 0, 0);

        return Constants.MOTORBIKEVEHICLESCODE+";" + String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ";" + String.format("%.2f", price) + "\n";
    }

    @Override
    public String getCode() {
        return level.concat(Constants.MOTORBIKEVEHICLESCODE.concat(Integer.toString(numberPark)));
    }

}
