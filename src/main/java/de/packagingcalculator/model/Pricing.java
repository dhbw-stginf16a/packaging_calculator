package de.packagingcalculator.model;

import java.util.Arrays;

/**
 * This can hold all information related to a Pricing category
 */
public class Pricing {
    private double[] dimensions;
    private int weight; //in gramm
    private double price; //in €

    /**
     * Generates a Pricing with the according values
     *
     * @param d1 one dimension in mm
     * @param d2 one dimension in mm
     * @param d3 one dimension in mm
     * @param w the weight in g
     * @param p the price of this category
     */
    public Pricing(double d1, double d2, double d3, int w, double p){
        dimensions = new double[3];
        dimensions[0] = d1;
        dimensions[1] = d2;
        dimensions[2] = d3;
        Arrays.sort(dimensions);

        weight = w;
        price = p;
    }

    /**
     * Checks the given package size against the requirements of this pricing category
     *
     * @param d1 one dimension in mm
     * @param d2 one dimension in mm
     * @param d3 one dimension in mm
     * @param w  the weight in g
     * @return true if the passed size fits, else false
     */
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
