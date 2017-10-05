package de.packagingcalculator.util;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Immutable object for representing distances.
 */
public final class Distance implements Comparable<Distance> {

    private double distance;

    private Distance(double distance) {
        this.distance = distance;
    }

    /**
     * Parse new {@link Distance} object from double value and a Unit given by a {@link DistanceUnit} object.
     *
     * @param distance Distance value.
     * @param unit     Value unit
     * @return New distance object.
     */
    public static Distance parse(double distance, DistanceUnit unit) {
        return new Distance(distance * unit.getConversion());
    }

    /**
     * Parse new {@link DistanceUnit} from String.
     *
     * @param distance String of the form (10.0[mm,cm,dm,m])
     * @return New distance object
     */
    public static Distance parse(String distance) {
        throw new NotImplementedException();
        // TODO: 18.09.2017 Implementation needed
    }

    //Add

    public static Distance add(Distance distanceA, Distance distanceB) {
        return new Distance(distanceA.distance + distanceB.distance);
    }

    public static Distance subtract(Distance distanceA, Distance distanceB) {
        return new Distance(distanceA.distance - distanceB.distance);
    }

    //Substract

    /**
     * Add two distances.
     *
     * @param distance Distance to add.
     * @return Resulting distance.
     */
    public Distance add(Distance distance) {
        return add(this, distance);
    }

    /**
     * Subtract two distances
     *
     * @param distance Distance to subtract
     * @return Resulting distance
     */
    public Distance subtract(Distance distance) {
        return subtract(this, distance);
    }

    @Override
    public int compareTo(Distance distance) {
        return (distance.distance == this.distance) ? 0 : ((distance.distance > this.distance) ? -1 : 1);
    }

    /**
     * Returns distance as double value in respect to a given unit.
     *
     * @param unit Unit of requested value.
     * @return Value adjusted for given Unit
     */
    public double getDistance(DistanceUnit unit) {
        return this.distance / unit.getConversion();
    }

    /**
     * Returns distance as double in mm.
     *
     * @return Distance in mm.
     */
    public double getDistance() {
        return this.distance;
    }
}
