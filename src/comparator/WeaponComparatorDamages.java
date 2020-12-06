package comparator;

import model.Weapon;

import java.util.Comparator;

public class WeaponComparatorDamages implements Comparator<Weapon> {
    @Override
    public int compare(Weapon o1, Weapon o2) {
        if (o1.getDamages() > o2.getDamages())
            return 1;
        else if (o1.getDamages() == o2.getDamages())
            return 0;
        else return -1;
    }
}
