package de.packagingcalculator.model;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<CarierPricing> cariers;

    public Calculator(){
        cariers = new ArrayList<>(10);
        CarierPricing dhl = new CarierPricing("dhl");
        dhl.addPricing(new Pricing(150, 300, 600, 2000, 4.99));
        dhl.addPricing(new Pricing(600, 600, 1200, 5000, 5.99));
        dhl.addPricing(new Pricing(600, 600, 1200, 10000, 8.49));
        dhl.addPricing(new Pricing(600, 600, 1200, 315000, 16.49));
        cariers.add(dhl);
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Takes the according Parameters and returns the needed price
     * @param length one dimension in mm
     * @param height one dimension in mm
     * @param width one dimension in mm
     * @param weight the weight of the package in g
     * @return the price of the package in Euro
     */
    public double calcShippingCosts(String length, String height, String width, String weight){
        return calcShippingCostsMMg(Double.parseDouble(length), Double.parseDouble(height), Double.parseDouble(width), Integer.parseInt(weight));
    }

    public double calcShippingCostsMMg(double d1, double d2, double d3, int weight) {
        Pricing currentBest = null;

        for(CarierPricing carrier : cariers) {
            for(Pricing pricing : carrier.getPricings()) {
                if(pricing.fitsPackage(d1, d2, d3, weight)) {
                    if(currentBest == null || currentBest.getPrice() > pricing.getPrice()){
                        currentBest = pricing;
                    }
                }
            }
        }
        return currentBest.getPrice();
    }

    private class CarierPricing{
        private List<Pricing> prices;
        private String name;

        private CarierPricing(String name){
            throw new UnsupportedOperationException("Not yet implemented");
        }

        private void addPricing(Pricing p){
            prices.add(p);
        }

        private Iterable<Pricing> getPricings(){
            return prices;
        }
    }
}
