package comparator;

import model.Weapon;

import java.util.Comparator;

public class WeaponComparatorLevel implements Comparator<Weapon> {
    @Override
    public int compare(Weapon o1, Weapon o2) {
        if (o1.getLevel() > o2.getLevel())
            return 1;
        else if (o1.getLevel() == o2.getLevel())
            return 0;
        else return -1;
    }
}
