package comparator;

import model.Location;

import java.util.Comparator;

public class LocationComparatorEL implements Comparator<Location> {
   @Override
   public int compare(Location o1, Location o2) {
       if (o1.getEnteringLevel()>o2.getEnteringLevel())
           return 1;
       else if (o1.getEnteringLevel()==o2.getEnteringLevel())
           return  0;
       else return -1;
   }
}
