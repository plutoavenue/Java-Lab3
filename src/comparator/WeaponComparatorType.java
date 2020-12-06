package comparator;
import model.Location;
import model.Weapon;

import java.util.Comparator;

public class WeaponComparatorType implements Comparator<Weapon>  {
    @Override
    public int compare(Weapon o1, Weapon o2) {
        return o1.getType().compareTo(o2.getType());
    }
}