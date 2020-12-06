package comparator;
import model.Location;

import java.util.Comparator;

public class LocationComparatorRace implements Comparator<Location> {
    @Override
    public int compare(Location o1, Location o2) {
        return o1.getMainRace().compareTo(o2.getMainRace());
    }
}