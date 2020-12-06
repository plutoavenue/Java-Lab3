package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import comparator.*;

public class Main {


    static List<Weapon> sortByLevel(List<Weapon> weapons){
        weapons.sort(new WeaponComparatorLevel());
        return weapons;
    }

    static List<Weapon> sortByLevelAndDamages(List<Weapon> weapons){
        Comparator<Weapon> tcomp = new WeaponComparatorLevel().thenComparing(new WeaponComparatorDamages());
        weapons.sort(tcomp);
        return weapons;
    }
    static List<Weapon> sortByLevelAndDamagesAndType(List<Weapon> weapons){
        Comparator<Weapon> tcomp = new WeaponComparatorLevel().thenComparing(new WeaponComparatorDamages())
                .thenComparing(new WeaponComparatorType());
        weapons.sort(tcomp);
        return weapons;
    }
    static List<Weapon> sortByCompareToWeapon(List<Weapon> weapons){
        weapons.sort(Weapon::compareTo);
        return weapons;
    }



    static List<Location> sortByEnteringLevel(List<Location> locations){
        locations.sort(new LocationComparatorEL());
        return locations;
    }

    static List<Location> sortByEnteringLevelAndMainRace(List<Location> locations){
        Comparator<Location> tcomp = new LocationComparatorEL().thenComparing(new LocationComparatorRace());
        locations.sort(tcomp);
        return locations;
    }

    static List<Location> sortByCompareToLoc(List<Location> locations){
        locations.sort(Location::compareTo);
        return locations;
    }



    public static void main(String[] args) {

        List<Weapon> DimitrysArmory = Arrays.asList(
                new Weapon.Builder()
                        .withType(Weapon.Type.BLADED)
                        .withLevel(3)
                        .build(),
                new Weapon(Weapon.Type.FIREARM, "Ki", 37, 5),
                new Weapon(Weapon.Type.IMPACT, "Seven", 25, 5),
                new Weapon(Weapon.Type.FIREARM, "Evil", 10)
        );
        System.out.println("Sorted list of Dimitrys weapons:");
        sortByCompareToWeapon(DimitrysArmory).forEach(a -> System.out.println("\t" + a));


        List<Weapon> RizersArmory = Arrays.asList(
                new Weapon(Weapon.Type.FLAMETHROWER, "Smth", 37, 5),
                new Weapon(Weapon.Type.EXPLOSIVE, "C4", 1000, 40),
                new Weapon(Weapon.Type.FIREARM, "AK-47", 25, 5),
                new Weapon(Weapon.Type.BLADED, "Swoe", 170)
        );

        System.out.println("Sorted list of Rizers weapons (by levels):");
        sortByLevel(RizersArmory).forEach(a -> System.out.println("\t" + a));

        List<Weapon> RizersSecondArmory = Arrays.asList(
                new Weapon(Weapon.Type.FLAMETHROWER, "Empar", 140, 14),
                new Weapon(Weapon.Type.FIREARM, "Manchier", 40, 5),
                new Weapon(Weapon.Type.EXPLOSIVE, "C4", 1000, 40),
                new Weapon(Weapon.Type.FIREARM, "AK-47", 25, 5),
                new Weapon(Weapon.Type.BLADED, "Stillet", 10)
        );

        System.out.println("Sorted list of Rizers second weapons (by levels ans damages):");
        sortByLevelAndDamages(RizersSecondArmory).forEach(a -> System.out.println("\t" + a));

        List<Weapon> EchoArmory = Arrays.asList(
                new Weapon.Builder()
                        .withType(Weapon.Type.BLADED)
                        .withLevel(3)
                        .build(),
                new Weapon(Weapon.Type.FIREARM, "Eliza", 37, 5),
                new Weapon(Weapon.Type.IMPACT, "SevenII", 25, 5),
                new Weapon(Weapon.Type.FIREARM, "Cora", 10),
                new Weapon(Weapon.Type.FLAMETHROWER, "Widaz", 140, 14),
                new Weapon(Weapon.Type.FIREARM, "ManchierII", 40, 5),
                new Weapon(Weapon.Type.FLAMETHROWER, "Pieche", 37, 5),
                new Weapon(Weapon.Type.EXPLOSIVE, "C1", 800, 38),
                new Weapon(Weapon.Type.FIREARM, "AK-47", 25, 5),
                new Weapon(Weapon.Type.BLADED, "HRwoe", 170)
        );

        System.out.println("Sorted list of Echos weapons (by levels, damages and type):");
        sortByLevelAndDamagesAndType(EchoArmory).forEach(a -> System.out.println("\t" + a));

        List<Weapon> Weapons = new ArrayList<Weapon>();
        Weapons.addAll(DimitrysArmory);
        Weapons.addAll(RizersArmory);
        Weapons.addAll(RizersSecondArmory);
        Weapons.addAll(EchoArmory);
        System.out.println("List of all commands weapons:");
        Weapons.forEach(a -> System.out.println("\t" + a));

        System.out.println("\n\n1)Sorted list of all commands weapons:");
        Weapons.stream().sorted().forEach(System.out::println);

        System.out.println("\n\n2)List of weapons whose names start with \'S\':");
        Weapons.stream().filter((a) -> a.getName().startsWith("S")).forEach(System.out::println);

        int countOfWeapons = (int)Weapons.stream().filter( a -> a instanceof Weapon).count();
        System.out.println("\n\n3)Count of Weapons in list : " + countOfWeapons);
    }
}