package de.packagingcalculator.model;

import java.util.List;

public class Calculator {
    private List<CarierPricing> cariers;

    public Calculator(){
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
    double calcShippingCosts(String length, String height, String width, String weight){
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private class CarierPricing{
        private List<Pricing> prices;
        private String name;

        private CarierPricing(String name){
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }
}
