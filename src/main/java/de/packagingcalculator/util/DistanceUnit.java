package de.packagingcalculator.util;

public enum DistanceUnit {
    MM(1.0),
    M(1000.0),
    CM(10.0),
    DM(100.0);

    private final double conversion;

    DistanceUnit(double conversion) {
        this.conversion = conversion;
    }

    public static DistanceUnit getBase() {
        return MM;
    }

    public double getConversion() {
        return conversion;
    }
}
