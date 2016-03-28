package Interface;

import java.util.Date;

public interface ParkSpaceInterface {
    public double valuePerHour();
    public int capacity();
    public boolean isOccupied();
    public void setIsOccupied(Boolean isOccupied);
    public Date getEntryTime();
    public Date getExitTime();
    public void setExitTime(Date date);
    public String getLevel();
    public String getCode();
    public void setEntryTime(Date date);
}
