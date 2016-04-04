package Interface;

import java.util.Calendar;

public interface ParkSpaceInterface {

    public boolean isOccupied();
    public void setIsOccupied(Boolean isOccupied, String plateNumber, int hours, int minutes);

    public String getVehicleCheckout(int hours, int minutes);

    public double getPrice(int hours, int minutes);

    public String getPlateNumber();
    public String getCode();
}
