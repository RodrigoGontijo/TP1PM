package Interface;

import java.util.Calendar;

public interface ParkSpaceInterface {
    public double valuePerHour();
    public boolean isOccupied();
    public void setIsOccupied(Boolean isOccupied, String plateNumber);

    public Calendar getEntryTime();
    public Calendar getExitTime();
    public void setExitTime(Calendar date);
    public void setEntryTime(Calendar date);
    public String getPlateNumber();
    public String getCode();
    public String getLevel();
}
