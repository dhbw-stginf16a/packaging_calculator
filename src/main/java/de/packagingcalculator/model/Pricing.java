package de.packagingcalculator.model;

import java.util.Arrays;

public class Pricing {
    private double[] dimensions;
    private int weight; //in gramm
    private double price; //in €

    public Pricing(double d1, double d2, double d3, int w, double p){
        dimensions[0] = d1;
        dimensions[1] = d2;
        dimensions[2] = d3;
        Arrays.sort(dimensions);

        weight = w;
        price = p;
    }

    boolean fitsPackage(double d1, double d2, double d3, int w){
        boolean fits = false;

        double[] packageDim = new double[3];
        packageDim[0] = d1;
        packageDim[1] = d2;
        packageDim[2] = d3;
        Arrays.sort(packageDim);

        if(packageDim[0] <= dimensions[0] &&
                packageDim[1] <= dimensions[1] &&
                packageDim[2] <= dimensions[2] &&
                w <= weight) {
            fits = true;
        }

        return fits;
    }

    public double getPrice() {
        return price;
    }
}
