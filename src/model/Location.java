package model;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Location implements Comparable<Location> {

    @Override
    public int compareTo(Location o) {
        if (enteringLevel == o.enteringLevel) {
            if (kingdom.length() == o.getKingdom().length()) {
                if (partName.length() == o.getPartName().length()) {
                        return partName.compareTo(o.getPartName());
                    }
                    return partName.length() - o.getPartName().length();
            }
            return kingdom.length() - o.getKingdom().length();
        }
        return enteringLevel - o.getEnteringLevel();
    }


    public enum Race {
        ELVES, DRAGONS, WEREWOLVES, WITCHES, DEMONS, ANGELS, MERMAIDS;
    }

    protected  String partName;
    protected  String kingdom;
    protected  Race mainRace;
    protected  int enteringLevel;

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public Race getMainRace() {
        return mainRace;
    }

    public void setMainRace(Race mainRace) {
        this.mainRace = mainRace;
    }

    public int getEnteringLevel() {
        return enteringLevel;
    }

    public void setEnteringLevel(int enteringLevel) {
        this.enteringLevel = enteringLevel;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return enteringLevel == location.enteringLevel &&
                Objects.equals(partName, location.partName) &&
                Objects.equals(kingdom, location.kingdom) &&
                mainRace == location.mainRace;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partName.toLowerCase(), kingdom.toLowerCase(), mainRace, enteringLevel);
    }


    public static class Builder {
        private Location newLocation = new Location();

        public Builder() {
            newLocation = new Location();
        }

        public Builder withMainRace(Race mainRace){
            newLocation.mainRace = mainRace;
            return this;
        }

        public Builder withPartName(String partName){
            newLocation.partName = partName;
            return this;
        }

        public Builder withKingdom(String kingdom){
            newLocation.kingdom = kingdom;
            return this;
        }

        public Builder withEnteringLevel(int enteringLevel){
            newLocation.enteringLevel = enteringLevel;
            return this;
        }


        public Location build(){
            return newLocation;
        }
    }

    @Override
    public String toString() {
        return "Location{" +
                ", partName = '" + partName + '\'' +
                ", kingdom = '" + kingdom + '\'' +
                ", mainRace = '" + mainRace + '\'' +
                ", enteringLevel = " + enteringLevel +
                '}';
    }
    public Location fromString(String input) {
        Location newObj = new Location();
        input = input.replaceAll("Location", "");
        input = input.replaceAll("[\\{}]", "");
        input = input.replaceAll("\'", "");

        System.out.println(input);
        String partName = input.substring(input.indexOf("partName = ")+11, input.indexOf(","));
        input = input.split(partName+", ")[1];

        String kingdom = input.substring(input.indexOf("kingdom = ")+10, input.indexOf(","));
        input = input.split(kingdom+", ")[1];

        String mainRace = input.substring(input.indexOf("mainRace = ")+11, input.indexOf(","));
        input = input.split(mainRace+ ", ")[1];


        int enteringLevel = Integer.parseInt(input.substring(input.indexOf("enteringLevel = ")+16, input.length()));

        newObj.partName = partName;
        newObj.kingdom = kingdom;
        newObj.mainRace = Race.valueOf(mainRace);
        newObj.enteringLevel = enteringLevel;

        return newObj;
    }
}