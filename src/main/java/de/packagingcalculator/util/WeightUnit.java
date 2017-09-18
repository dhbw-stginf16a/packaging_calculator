package de.packagingcalculator.util;

public enum WeightUnit {
    G(1.0),
    KG(1000.0);

    private final double conversion;

    WeightUnit(double conversion) {
        this.conversion = conversion;
    }

    public static WeightUnit getBase() {
        return G;
    }

    public double getConversion() {
        return conversion;
    }
}
