package Interface;

import java.util.Date;

public interface ParkInterface {
    int capacity = 0;
    public int valuePerHour();
    public int capacity();
    public int placesOccupied();
    public void setPlacesOccupied(int numberPlaces);
    public Date entryTime();
    public Date exitTime();
}
