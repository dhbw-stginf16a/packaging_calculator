package de.packagingcalculator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that can hold all carrier information and get the cheapest price for every carrier.
 */
public class Calculator {
    private List<CarrierPricing> cariers;

    /**
     * Initializes a instance via code.
     */
    @Deprecated
    public Calculator(){
        cariers = new ArrayList<>(10);

        //init dhl as a carrier
        CarrierPricing dhl = new CarrierPricing("dhl");
        dhl.addPricing(new Pricing(150, 300, 600, 2000, 4.99));
        dhl.addPricing(new Pricing(600, 600, 1200, 5000, 5.99));
        dhl.addPricing(new Pricing(600, 600, 1200, 10000, 8.49));
        dhl.addPricing(new Pricing(600, 600, 1200, 31500, 16.49));
        cariers.add(dhl);
    }

    /**
     * Takes the according Parameters and returns the cheapest price
     * @param length one dimension in mm
     * @param height one dimension in mm
     * @param width one dimension in mm
     * @param weight the weight of the package in g
     * @return the price of the package in Euro
     */
    public double calcShippingCosts(String length, String height, String width, String weight){
        return calcShippingCostsMMg(Double.parseDouble(length), Double.parseDouble(height), Double.parseDouble(width), Integer.parseInt(weight));
    }

    /**
     * Takes the according Parameters and returns the cheapest price
     *
     * @param d1     one dimension in mm
     * @param d2     one dimension in mm
     * @param d3     one dimension in mm
     * @param weight the weight of the package in g
     * @return the price of the package in Euro
     */
    public double calcShippingCostsMMg(double d1, double d2, double d3, int weight) {
        Pricing currentBest = null;

        for (CarrierPricing carrier : cariers) {
            for(Pricing pricing : carrier.getPricings()) {
                if(pricing.fitsPackage(d1, d2, d3, weight)) {
                    if(currentBest == null || currentBest.getPrice() > pricing.getPrice()){
                        currentBest = pricing;
                    }
                }
            }
        }
        return (currentBest != null) ? currentBest.getPrice() : -1;
    }

    /**
     * A instance of this is able to hold all price categories of one carrier.
     */
    private class CarrierPricing {
        private List<Pricing> prices;
        private String name;

        /**
         * Generates a instance of CarrierPricing for the given carrier name.
         * <p>
         * The pricing list will be empty and could be filled via {@link CarrierPricing#addPricing(Pricing)}
         *
         * @param name The name of Carrier
         */
        private CarrierPricing(String name){
            this.name = name;
            prices = new ArrayList<>(10);
        }

        /**
         * Adds a Pricing categorie to this carrier
         * @param p the Pricing categorie to add
         */
        private void addPricing(Pricing p){
            prices.add(p);
        }

        /**
         * Returns a Iterable over the list of pricing's.
         * @return {@link Iterable<Pricing>} that holds all pricing's added to this object
         */
        private Iterable<Pricing> getPricings(){
            return prices;
        }

        private String getName() {
            return name;
        }
    }
}
